package com.dv.mms.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.dao.GoodsDao;
import com.dv.mms.app.domain.master.MmGoodsissuedetail;
import com.dv.mms.app.domain.master.MmGoodsissueheader;
import com.dv.mms.app.domain.master.MmGoodsreceiptdetail;
import com.dv.mms.app.domain.master.MmGoodsreceiptheader;
import com.dv.mms.app.domain.master.MmItem;
import com.dv.mms.app.domain.master.MmPodetail;
import com.dv.mms.app.domain.master.MmPoheader;
import com.dv.mms.app.utils.BeanUtil;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.GoodsIssueDetail;
import com.dv.mms.app.web.form.GoodsIssueHeader;
import com.dv.mms.app.web.form.GoodsReceiptDetail;
import com.dv.mms.app.web.form.GoodsReceiptHeader;
import com.dv.mms.app.web.form.ItemForm;
import com.dv.mms.app.web.form.PODetail;
import com.dv.mms.app.web.form.POHeader;

@Transactional
public class GoodsServiceImpl implements GoodsService {
	
	private GoodsDao goodsDao;
	private POService poService;

	@Autowired
	public GoodsServiceImpl(GoodsDao goodsDao, POService poService) {		
		this.goodsDao = goodsDao;
		this.poService = poService;
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public POService getPoService() {
		return poService;
	}

	public void setPoService(POService poService) {
		this.poService = poService;
	}

	public GoodsReceiptHeader prepareReceipt(Integer poId) {
		GoodsReceiptHeader grHeader = new GoodsReceiptHeader();
		POHeader poHeader = poService.getPO(poId);
		grHeader.setGrDate(new Date());
		grHeader.setPoHeader(poHeader);
		List<PODetail> list = poHeader.getPoDetails();
		List<GoodsReceiptDetail> grDetails = new ArrayList<GoodsReceiptDetail>();
		for(PODetail poDetail:list) {			
			GoodsReceiptDetail grDetail = new GoodsReceiptDetail();			
			grDetail.setGrHeader(grHeader);
			grDetail.setItem(poDetail.getItem());
			double qty = poDetail.getPoQty() - poDetail.getGrQty();
			grDetail.setPoQty(qty);
			grDetail.setGrdQty(qty);
			grDetails.add(grDetail);
		}
		grHeader.setGrDetails(grDetails);
		return grHeader;
	}

	public GoodsReceiptHeader addGR1(GoodsReceiptHeader grHeader) {
		// get mmPO & mmGR from beanutil/dao
		MmGoodsreceiptheader mmGRheader = BeanUtil.getGRHeaderforDao(grHeader);
		MmPoheader mmPOHeader = poService.getMmPO(grHeader.getPoHeader().getPoNo());
		Set<MmPodetail> mmPODetails = mmPOHeader.getMmPodetails();
		Set<MmGoodsreceiptdetail> mmGRdetails = mmGRheader.getMmGoodsreceiptdetails(); 
		// compare and sum the mmPO.grqty
		for(MmPodetail mmPODetail:mmPODetails) {
			for(MmGoodsreceiptdetail mmGRdetail: mmGRdetails) {
				if(mmPODetail.getMmItem().getId().equals(mmGRdetail.getMmItem().getId())) {
					double qty = mmPODetail.getGrQty() + mmGRdetail.getGrhQty();
					mmPODetail.setGrQty(qty);
					// update stock
					if(grHeader.getPoHeader().getType().equals("Normal") && mmGRdetail.getGrhQty() > 0) {
						MmItem mmItem = mmPODetail.getMmItem();
						double stock = mmItem.getStock() + mmGRdetail.getGrhQty();
						mmItem.setStock(stock);
						mmGRdetail.setMmItem(mmItem);
					}
				}				
			}
			
		}
		// store in db
		//poService.modifyPO(mmPOHeader);
		mmGRheader.setMmPoheader(mmPOHeader);		
		goodsDao.save(mmGRheader);
		return null;
	}
	
	public GoodsReceiptHeader addGR(GoodsReceiptHeader grHeader) {
		// get mmPO & mmGR from beanutil/dao		
		POHeader poHeader = poService.getPO(grHeader.getPoHeader().getPoNo());
		List<PODetail> poDetails = poHeader.getPoDetails();
		List<GoodsReceiptDetail> grDetails = grHeader.getGrDetails(); 
		// compare and sum the mmPO.grqty
		for(PODetail poDetail:poDetails) {
			for(GoodsReceiptDetail grDetail: grDetails) {
				if(poDetail.getItem().getId().equals(grDetail.getItem().getId())) {
					double qty = poDetail.getGrQty() + grDetail.getGrdQty();					
					poDetail.setGrQty(qty);
					double giQty = poDetail.getGiQty() + grDetail.getGrdQty();
					poDetail.setGiQty(giQty);
					// update stock
					ItemForm item = poDetail.getItem();
					if(poHeader.getType().equals("Normal") && grDetail.getGrdQty() > 0) {						
						double stock = item.getStock() + grDetail.getGrdQty();
						item.setStock(stock);						
					}
					grDetail.setItem(item);
				}				
			}
			
		}
		grHeader.setGrDate(new Date());
		//poService.modifyPO(mmPOHeader);
		grHeader.setPoHeader(poHeader);
		// check for pending items in PO, if there are no pending items mark po as complete
		boolean complete = true;
		for(PODetail poDetail: poHeader.getPoDetails()) {			
				if(poDetail.getPoQty()-poDetail.getGrQty()!=0) {
					complete=false;
					break;
				}
		}
		if(complete)
			poHeader.setStatus(Constants.PO_COMPLETE);
		MmGoodsreceiptheader mmGRheader = BeanUtil.getGRHeaderforDao(grHeader);				
		// store in db
		goodsDao.save(mmGRheader);
		return null;
	}

	public void summarize(GoodsReceiptHeader grHeader) {
		Date grDate = grHeader.getGrDate();
		grHeader.setGrDate(grDate);
		POHeader poHeader = poService.getPO(grHeader.getPoHeader().getPoNo());
		grHeader.setPoHeader(poHeader);
		List<GoodsReceiptDetail> grDetailList = new ArrayList<GoodsReceiptDetail>();
		for(GoodsReceiptDetail grDetail: grHeader.getGrDetails()) {
			if(grDetail.getGrdQty()!=0)
				grDetailList.add(grDetail);
		}
		
		grHeader.setGrDetails(grDetailList);
		
	}

	public Integer addGIRequest(GoodsIssueHeader giHead) {
		MmGoodsissueheader mmGIHeader = BeanUtil.getMmGIHeader(giHead);		
		Integer gihNo = goodsDao.addGI(mmGIHeader);
		return gihNo;
	}

	public GoodsIssueHeader getGIRequest(Integer gihNo) {
		MmGoodsissueheader mmGIHeader = goodsDao.getGI(gihNo);
		GoodsIssueHeader giHead = BeanUtil.getGIHeader(mmGIHeader);
		List<GoodsIssueDetail> giDetails = new ArrayList<GoodsIssueDetail>();
		Set<MmGoodsissuedetail> set = mmGIHeader.getMmGoodsissuedetails();
		for(MmGoodsissuedetail mmGIDetail: set) {
			GoodsIssueDetail giDetail = BeanUtil.getGIDetail(mmGIDetail);
			giDetails.add(giDetail);
		}
		giHead.setGiDetails(giDetails);
		return giHead;
	}

	public GoodsIssueDetail getGIItem(Integer gihNo, Integer itemId) {
		MmGoodsissuedetail mmGIDetail = goodsDao.getGIItem(gihNo, itemId);
		GoodsIssueDetail giDetail = BeanUtil.getGIDetail(mmGIDetail);
		return giDetail;
	}

	public void addGIItem(Integer gihNo, GoodsIssueDetail giDetail) {
		MmGoodsissuedetail mmGIDetail = BeanUtil.getMmGIDetail(giDetail);
		goodsDao.addGID(mmGIDetail);
		
	}

	public void modifyGI(GoodsIssueHeader giHead) {		
		
	}

	public void issue(GoodsIssueHeader giHead) {
		List<GoodsIssueDetail> giList = giHead.getGiDetails();
		Set<MmGoodsissuedetail> mmGIDetails = new HashSet();
		MmGoodsissueheader mmGIHead = BeanUtil.getMmGIHeader(giHead);
		for(GoodsIssueDetail giDetail: giList) {			 
			ItemForm item = giDetail.getItem();
			double newStock = item.getStock() - giDetail.getGidQty();
			System.out.println("New Stock: "+item.getName()+": "+item.getStock()+" - "+giDetail.getGidQty()+" = "+newStock);
			item.setStock(newStock);
			MmGoodsissuedetail mmGIDetail = BeanUtil.getMmGIDetail(giDetail);
			mmGIDetails.add(mmGIDetail);
		}
		mmGIHead.setMmGoodsissuedetails(mmGIDetails);
		goodsDao.issue(mmGIHead);
		
	}

	public List<GoodsReceiptHeader> getReceiptsForItem(Integer itemId,
			Integer records) {
		List<MmGoodsreceiptheader> mmGRHeaders = goodsDao.getReceiptsForItem(itemId, records);
		List<GoodsReceiptHeader> grHeaders = new ArrayList<GoodsReceiptHeader>();
		for(MmGoodsreceiptheader mmGRHeader: mmGRHeaders) {			
			GoodsReceiptHeader header = BeanUtil.getGRHeader(mmGRHeader);
			grHeaders.add(header);
			/*List<GoodsReceiptDetail> details = new ArrayList<GoodsReceiptDetail>();
			for(GoodsReceiptDetail detail: header.getGrDetails()) {
				if(detail.getItem().getId().equals(itemId))
					details.add(detail);
			}
			*/
		}
		return grHeaders;
	}

}
