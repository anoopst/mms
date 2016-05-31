package com.dv.mms.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.dao.PODao;
import com.dv.mms.app.domain.master.MmPodetail;
import com.dv.mms.app.domain.master.MmPoheader;
import com.dv.mms.app.domain.master.MmReqdetail;
import com.dv.mms.app.domain.master.MmReqheader;
import com.dv.mms.app.domain.master.MmVendor;
import com.dv.mms.app.utils.BeanUtil;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.PODetail;
import com.dv.mms.app.web.form.POHeader;
import com.dv.mms.app.web.form.RequestDetail;
import com.dv.mms.app.web.form.RequestHeader;
import com.dv.mms.app.web.form.VendorForm;

@Transactional
public class POServiceImpl implements POService {
	
	private RequestService requestService;
	private VendorService vendorService;	
	private PODao poDao;
	

	public PODao getPoDao() {
		return poDao;
	}

	public void setPoDao(PODao poDao) {
		this.poDao = poDao;
	}

	public POHeader preparePO(Integer reqId) {
		POHeader poHeader = new POHeader();		
		RequestHeader reqHeader = requestService.getRequest(reqId);
		poHeader.setPoDate(new Date());
		poHeader.setReqHeader(reqHeader);
		List<PODetail> list = new ArrayList<PODetail>();
		Integer pdNo=-1;
		for(RequestDetail reqDetail: reqHeader.getRequestDetail()) {
			PODetail poDetail = new PODetail();
			poDetail.setPdNo(pdNo);
			poDetail.setItem(reqDetail.getItem());
			double qty = reqDetail.getQty() - reqDetail.getPoQty();
			poDetail.setPoQty(qty);			
			poDetail.setReqQty(qty);
			
			list.add(poDetail);
		}
		poHeader.setPoDetails(list);
		return poHeader;
	}

	@Autowired 
	public POServiceImpl(RequestService requestService,VendorService vendorService,PODao poDao) {
		super();
		this.requestService = requestService;
		this.vendorService = vendorService;
		this.poDao = poDao;
	}

	public POHeader getPO(Integer poId) {
		MmPoheader mmPOHeader = poDao.getPO(poId);
		POHeader poHeader = BeanUtil.getPOHeader(mmPOHeader);
		return poHeader;
	}

	public VendorService getVendorService() {
		return vendorService;
	}

	public void setVendorService(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}

	public POHeader addPO(POHeader poHeader) {
		poHeader.setStatus(Constants.REQUEST_PO_RAISED);
		MmPoheader mmPOHeader = BeanUtil.getPOHeaderForDao(poHeader);		
		MmReqheader mmReqheader = requestService.getMmRequest(poHeader.getReqHeader().getRequestId());
		boolean pendingPO = false;
		
		//check for the items requested and items in po
		for(Iterator iterator = mmReqheader.getMmReqdetails().iterator();iterator.hasNext();) {
			MmReqdetail mmReqDetail = (MmReqdetail)iterator.next();			
			for(Iterator poIterator = mmPOHeader.getMmPodetails().iterator();poIterator.hasNext();) {
				 MmPodetail mmPODetail = (MmPodetail) poIterator.next();
				 // System.out.println("req Item id "+mmReqDetail.getMmItem().getId()+" po Item id "+mmPODetail.getMmItem().getId());				 
				 if(mmReqDetail.getMmItem().getId().equals(mmPODetail.getMmItem().getId())) {					 
					 double qty = mmReqDetail.getPoQty() + mmPODetail.getPoQty();
					 mmReqDetail.setPoQty(qty);		
					 mmPODetail.setPoAmt(mmPODetail.getPoQty() * mmPODetail.getPoRate());					
					 System.out.println(mmPODetail.getPoDesc());
					 break;
				 }
			 
			}
		}

		for(Iterator iterator1 = mmReqheader.getMmReqdetails().iterator();iterator1.hasNext();) {
			MmReqdetail mmReqDetail = (MmReqdetail)iterator1.next();			
			Double requested = mmReqDetail.getRdQty() - mmReqDetail.getPoQty();			
			if(requested.intValue() != 0) {
				 pendingPO = true;			
				 break;
			}
		}

		if(pendingPO) {
			// if items req = items in po & item.qty = po.qty - status is po raised
			mmReqheader.setStatus(Constants.REQUEST_PENDING_PO);
		}
		else {
			//else status is po pending and update mmreqdetail.poqty
			mmReqheader.setStatus(Constants.REQUEST_PO_RAISED);	
		}
		
		poDao.save(mmPOHeader);
		requestService.modifyRequest(mmReqheader);
		
		POHeader po = getPO(mmPOHeader.getPoNo());
		//System.out.println("PONO" + po.getPoNo());
		return po;
	}

	public void summarize(POHeader poHeader) {
		Date poDate = poHeader.getPoDate();
		poHeader.setPoDate(poDate);
		VendorForm vendor = vendorService.getVendor(poHeader.getVendor().getId());
		List<PODetail> poDetailList = new ArrayList<PODetail>();
		for(PODetail poDetail: poHeader.getPoDetails()) {
			if(poDetail.getPoQty()!=0)
				poDetailList.add(poDetail);
		}
		poHeader.setVendor(vendor);
		poHeader.setPoDetails(poDetailList);
	}

	public List getPOList(List status) {
		List<MmPoheader> mmPOList = poDao.getList(status);
		List<POHeader> poList = new ArrayList<POHeader>();
		for(MmPoheader mmPOHeader: mmPOList) {
			POHeader poHeader = BeanUtil.getPOHeader(mmPOHeader);
			poList.add(poHeader);
		}
		return poList;
	}
	
	public List getPOList(POHeader poHeader,List status) {
		MmPoheader mmPOHeader = new MmPoheader();
		mmPOHeader.setPoNo(poHeader.getPoNo());
		MmVendor mmVendor = new MmVendor(); 
		BeanUtils.copyProperties(poHeader.getVendor(), mmVendor);
		mmPOHeader.setMmVendor(mmVendor);
		List<MmPoheader> mmPOList = poDao.getList(mmPOHeader,status);
		List<POHeader> poList = new ArrayList<POHeader>();
		for(MmPoheader mmPO: mmPOList) {
			POHeader po = BeanUtil.getPOHeader(mmPO);
			poList.add(po);
		}
		return poList;
	}

	public MmPoheader getMmPO(Integer poNo) {
		MmPoheader mmPOHeader = poDao.getPO(poNo);
		return mmPOHeader;
	}

	public void modifyPO(MmPoheader mmPOHeader) {
		poDao.modifyRequest(mmPOHeader);		
	}

}
