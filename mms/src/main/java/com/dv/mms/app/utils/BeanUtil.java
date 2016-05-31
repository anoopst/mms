package com.dv.mms.app.utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmBrand;
import com.dv.mms.app.domain.master.MmCategory;
import com.dv.mms.app.domain.master.MmDimension;
import com.dv.mms.app.domain.master.MmGoodsissuedetail;
import com.dv.mms.app.domain.master.MmGoodsissueheader;
import com.dv.mms.app.domain.master.MmGoodsreceiptdetail;
import com.dv.mms.app.domain.master.MmGoodsreceiptheader;
import com.dv.mms.app.domain.master.MmHeading;
import com.dv.mms.app.domain.master.MmItem;
import com.dv.mms.app.domain.master.MmModel;
import com.dv.mms.app.domain.master.MmPodetail;
import com.dv.mms.app.domain.master.MmPoheader;
import com.dv.mms.app.domain.master.MmReqdetail;
import com.dv.mms.app.domain.master.MmReqheader;
import com.dv.mms.app.domain.master.MmSubheading;
import com.dv.mms.app.domain.master.MmUom;
import com.dv.mms.app.domain.master.MmUser;
import com.dv.mms.app.domain.master.MmVehicle;
import com.dv.mms.app.domain.master.MmVendor;
import com.dv.mms.app.web.form.ConfigItem;
import com.dv.mms.app.web.form.GoodsIssueDetail;
import com.dv.mms.app.web.form.GoodsIssueHeader;
import com.dv.mms.app.web.form.GoodsReceiptDetail;
import com.dv.mms.app.web.form.GoodsReceiptHeader;
import com.dv.mms.app.web.form.ItemForm;
import com.dv.mms.app.web.form.PODetail;
import com.dv.mms.app.web.form.POHeader;
import com.dv.mms.app.web.form.RequestDetail;
import com.dv.mms.app.web.form.RequestHeader;
import com.dv.mms.app.web.form.UserForm;
import com.dv.mms.app.web.form.VehicleForm;
import com.dv.mms.app.web.form.VendorForm;
@Transactional
public class BeanUtil {

	public static Object getItemConfigForDao(Class clazz, ConfigItem config) {
		Object object = null;
		try {
			Constructor ctor = clazz.getDeclaredConstructor(Integer.class,
					String.class);
			Object params[] = new Object[2];
			System.out.println("BeanUtil -> " + config.getId() + " "
					+ config.getName());
			params[0] = config.getId();
			params[1] = config.getName();
			object = BeanUtils.instantiateClass(ctor, params);
		} catch (NoSuchMethodException nsme) {
			nsme.printStackTrace();
		}

		return object;
	}

	public static MmItem getItemForDao(ItemForm item) {
		MmItem mmItem = new MmItem();
		
		MmBrand brand = (MmBrand) getItemConfigForDao(MmBrand.class,
				item.getMmBrand());
		MmDimension dimension = (MmDimension) getItemConfigForDao(
				MmDimension.class, item.getMmDimension());
		MmHeading heading = (MmHeading) getItemConfigForDao(MmHeading.class,
				item.getMmHeading());
		MmSubheading subheading = (MmSubheading) getItemConfigForDao(
				MmSubheading.class, item.getMmSubheading());
		MmModel model = (MmModel) getItemConfigForDao(MmModel.class,
				item.getMmModel());
		MmUom uom = (MmUom) getItemConfigForDao(MmUom.class, item.getMmUom());
		MmCategory category = (MmCategory)getItemConfigForDao(MmCategory.class,item.getMmCategory());

		mmItem.setId(item.getId());
		mmItem.setName(item.getName());
		mmItem.setMmBrand(brand);
		mmItem.setMmDimension(dimension);
		mmItem.setMmHeading(heading);
		mmItem.setMmSubheading(subheading);
		mmItem.setMmModel(model);
		mmItem.setMmUom(uom);
		mmItem.setMmCategory(category);
		mmItem.setStock(item.getStock());
		mmItem.setRate(item.getRate());
		mmItem.setRol(item.getRol());
		return mmItem;
	}

	public static void setItem(MmItem src, ItemForm dest) {

		ConfigItem brand = new ConfigItem();
		ConfigItem dimension = new ConfigItem();
		ConfigItem heading = new ConfigItem();
		ConfigItem subheading = new ConfigItem();
		ConfigItem model = new ConfigItem();
		ConfigItem uom = new ConfigItem();
		ConfigItem category = new ConfigItem();

		if(src.getMmBrand()!=null)
			BeanUtils.copyProperties(src.getMmBrand(), brand);
		if(src.getMmDimension()!=null)
			BeanUtils.copyProperties(src.getMmDimension(), dimension);
		if(src.getMmHeading()!=null)
			BeanUtils.copyProperties(src.getMmHeading(), heading);
		if(src.getMmSubheading()!=null)
			BeanUtils.copyProperties(src.getMmSubheading(), subheading);
		if(src.getMmModel()!=null)
			BeanUtils.copyProperties(src.getMmModel(), model);
		if(src.getMmUom()!=null)
			BeanUtils.copyProperties(src.getMmUom(), uom);
		if(src.getMmCategory()!=null)
			BeanUtils.copyProperties(src.getMmCategory(),category);

		dest.setId(src.getId());
		dest.setName(src.getName());
		dest.setMmBrand(brand);
		dest.setMmDimension(dimension);
		dest.setMmHeading(heading);
		dest.setMmSubheading(subheading);
		dest.setMmModel(model);
		dest.setMmUom(uom);
		dest.setMmCategory(category);
		dest.setRate(src.getRate());
		dest.setRol(src.getRol());
		dest.setStock(src.getStock());		

	}

	public static RequestHeader getReqHeader(MmReqheader mmReqHeader) {		
		RequestHeader requestHeader = new RequestHeader();
		//List<RequestDetail> reqList = new ArrayList<RequestDetail>();
		requestHeader.setRequestId(mmReqHeader.getRhNo());
//		MmUser mmUser = ;
//		System.out.println("getReqHead "+mmUser.getId()+" "+mmUser.getName());
		UserForm userForm = new UserForm();		
		BeanUtils.copyProperties(mmReqHeader.getRequestor(),userForm);
		requestHeader.setRequestor(userForm);
		requestHeader.setRequestDate(mmReqHeader.getRhDate());
		/*Set set = mmReqHeader.getMmReqdetails();
		if (set != null) {
			List list = Arrays.asList(set.toArray());
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				MmReqdetail mmReqDetail = (MmReqdetail) iterator.next();
				RequestDetail reqDetail = getReqDetail(mmReqDetail);
				reqDetail.setReqHeader(requestHeader);
				reqList.add(reqDetail);
			}

		}
		requestHeader.setRequestDetail(reqList);*/
		requestHeader.setStatus(mmReqHeader.getStatus());
		return requestHeader;

	}

	public static RequestDetail getReqDetail(MmReqdetail mmReqDetail) {
		
		RequestDetail reqDetail = new RequestDetail();
		ItemForm itemForm = new ItemForm();
		setItem(mmReqDetail.getMmItem(),itemForm);
		RequestHeader reqHead= getReqHeader(mmReqDetail.getMmReqheader());
		
		reqDetail.setRdNo(mmReqDetail.getRdNo());
		reqDetail.setQty(mmReqDetail.getRdQty());
		reqDetail.setPoQty(mmReqDetail.getPoQty());
		reqDetail.setItem(itemForm);
		reqDetail.setReqHeader(reqHead);
		
		return reqDetail;
	}

	public static MmReqheader getMmReqHeader(RequestHeader reqHead) {
		MmReqheader mmReqHeader = new MmReqheader();
		mmReqHeader.setRhDate(reqHead.getRequestDate());
		mmReqHeader.setStatus(reqHead.getStatus());
		
		MmUser mmUser = new MmUser();
		BeanUtils.copyProperties(reqHead.getRequestor(),mmUser);
		mmReqHeader.setRequestor(mmUser);
		mmReqHeader.setRhNo(reqHead.getRequestId());
		
		return mmReqHeader;
	}

	public static MmReqdetail getMmReqDetail(RequestDetail reqDetail) {
		MmReqdetail mmReqDetail = new MmReqdetail();
		MmItem mmItem = getItemForDao(reqDetail.getItem());
		MmReqheader mmReqHeader = getMmReqHeader(reqDetail.getReqHeader());
		
		mmReqDetail.setRdNo(reqDetail.getRdNo());
		mmReqDetail.setRdQty(reqDetail.getQty());
		mmReqDetail.setMmItem(mmItem);
		mmReqDetail.setMmReqheader(mmReqHeader);
	
		return mmReqDetail;
	}
	
	public static MmPoheader getPOHeaderForDao(POHeader poHeader) {
		MmPoheader mmPOHeader = new MmPoheader();
		
		mmPOHeader.setPoDate(new Date());
		
		if(poHeader.getPoNo()!=null && poHeader.getPoNo()!=0)
			mmPOHeader.setPoNo(poHeader.getPoNo());
		else
			mmPOHeader.setPoNo(-1);
		
		
		MmReqheader mmReqheader = getMmReqHeader(poHeader.getReqHeader());
		mmPOHeader.setMmReqheader(mmReqheader);
				
		MmVendor mmVendor = new MmVendor();
		BeanUtils.copyProperties(poHeader.getVendor(), mmVendor);
		mmPOHeader.setMmVendor(mmVendor);
		
		Set mmPodetails = new HashSet();
		for(PODetail poDetail:poHeader.getPoDetails()) {
			MmPodetail mmPODetail = getPODetailForDao(mmPOHeader,poDetail);
			mmPodetails.add(mmPODetail);
		}
		mmPOHeader.setMmPodetails(mmPodetails);
		mmPOHeader.setPoStatus(poHeader.getStatus());
		mmPOHeader.setPoType(poHeader.getType());
		return mmPOHeader;
	}
	
	public static MmPodetail getPODetailForDao(MmPoheader mmPOHeader,PODetail poDetail) {
		MmPodetail mmPODetail = new MmPodetail();
		
		if(poDetail.getPdNo()!=null && poDetail.getPdNo()!=0)
			mmPODetail.setPdNo(poDetail.getPdNo());
		else
			mmPODetail.setPdNo(-1);
		
		mmPODetail.setMmPoheader(mmPOHeader);
		
		MmItem mmItem = new MmItem();
		mmItem.setId(poDetail.getItem().getId());
		mmItem.setName(poDetail.getItem().getName());
	
		mmPODetail.setMmItem(mmItem);
		
		mmPODetail.setPoQty(poDetail.getPoQty());
		mmPODetail.setGrQty(poDetail.getGrQty());
		mmPODetail.setGiQty(poDetail.getGiQty());
		mmPODetail.setPoRate(poDetail.getPoRate());
		mmPODetail.setPoAmt(poDetail.getPoAmt());
		mmPODetail.setPoDesc(poDetail.getPoDesc());		
		return mmPODetail;
	}

	public static POHeader getPOHeader(MmPoheader mmPOHeader) {
		POHeader poHeader = new POHeader();
		poHeader.setPoDate(mmPOHeader.getPoDate());
		poHeader.setPoNo(mmPOHeader.getPoNo());
		poHeader.setStatus(mmPOHeader.getPoStatus());
		VendorForm vendor = new VendorForm(); 
		BeanUtils.copyProperties(mmPOHeader.getMmVendor(),vendor);		
		poHeader.setVendor(vendor);
		List<PODetail> poDetails = new ArrayList<PODetail>();
		for(Iterator iterator = mmPOHeader.getMmPodetails().iterator();iterator.hasNext();) {
			PODetail poDetail = getPODetail(poHeader,(MmPodetail)iterator.next());
			poDetails.add(poDetail);
		}
		poHeader.setPoDetails(poDetails);
		poHeader.setType(mmPOHeader.getPoType());
		RequestHeader reqHeader = getReqHeader(mmPOHeader.getMmReqheader());
		poHeader.setReqHeader(reqHeader);
		return poHeader;
	}
	
	public static PODetail getPODetail(POHeader poHeader,MmPodetail mmPodetail) {
		PODetail poDetail = new PODetail();
		poDetail.setPdNo(mmPodetail.getPdNo());
		poDetail.setPoQty(mmPodetail.getPoQty());
		poDetail.setPoHeader(poHeader);
		poDetail.setPoRate(mmPodetail.getPoRate());
		poDetail.setPoAmt(mmPodetail.getPoAmt());
		ItemForm item = new ItemForm();
		setItem(mmPodetail.getMmItem(),item);
		poDetail.setItem(item);
		poDetail.setGrQty(mmPodetail.getGrQty());
		poDetail.setGiQty(mmPodetail.getGiQty());
		
		poDetail.setPoDesc(mmPodetail.getPoDesc());
		return poDetail;
	}

	public static MmGoodsreceiptheader getGRHeaderforDao(
			GoodsReceiptHeader grHeader) {
		MmGoodsreceiptheader mmGRHeader  = new MmGoodsreceiptheader();
		System.out.println("debug 1");
		MmPoheader mmPoheader = getPOHeaderForDao(grHeader.getPoHeader());
		mmGRHeader.setGrhDate(grHeader.getGrDate());
		List<PODetail> poList = grHeader.getPoHeader().getPoDetails();
		Set<MmPodetail> poDetails = new HashSet();
		for(PODetail poDetail: poList) {
			MmPodetail mmPodetail = getPODetailForDao(mmPoheader,poDetail);
			poDetails.add(mmPodetail);
		}
		System.out.println("debug 2");
		mmPoheader.setMmPodetails(poDetails);
		mmGRHeader.setGrhDate(grHeader.getGrDate());
		mmGRHeader.setGrhNo(grHeader.getGrNo());
		mmGRHeader.setMmPoheader(mmPoheader);
		List<GoodsReceiptDetail> list = grHeader.getGrDetails();
		Set<MmGoodsreceiptdetail> grDetails = new HashSet<MmGoodsreceiptdetail>();
		for(GoodsReceiptDetail grDetail: list) {
			MmGoodsreceiptdetail mmGRDetail = new MmGoodsreceiptdetail();
			mmGRDetail.setGrdNo(grDetail.getGrdNo());
			mmGRDetail.setMmGoodsreceiptheader(mmGRHeader);
			mmGRDetail.setGrhQty(grDetail.getGrdQty());
			MmItem mmItem = getItemForDao(grDetail.getItem());
			mmGRDetail.setMmItem(mmItem);
			System.out.println("stock "+mmItem.getId()+" "+mmItem.getStock());
			grDetails.add(mmGRDetail);
		}
		System.out.println("debug 3");
		mmGRHeader.setMmGoodsreceiptdetails(grDetails);
		return mmGRHeader;
	}

	public static MmGoodsissueheader getMmGIHeader(GoodsIssueHeader giHead) {
		MmGoodsissueheader mmGIHeader = new MmGoodsissueheader();
		mmGIHeader.setGihDate(giHead.getGihDate());
		mmGIHeader.setGihNo(giHead.getGihNo());
		MmUser mmUser = new MmUser();
		BeanUtils.copyProperties(giHead.getUser(),mmUser);
		mmGIHeader.setMmUser(mmUser);
		MmVehicle mmVehicle = new MmVehicle();
		BeanUtils.copyProperties(giHead.getVehicle(),mmVehicle);
		mmGIHeader.setMmVehicle(mmVehicle);
		mmGIHeader.setStatus(giHead.getStatus());
		return mmGIHeader;
	}
	
	public static MmGoodsissuedetail getMmGIDetail(GoodsIssueDetail giDetail) {
		MmGoodsissuedetail mmGIDetail = new MmGoodsissuedetail();
		MmItem mmItem = getItemForDao(giDetail.getItem());
		MmGoodsissueheader mmGIHeader = getMmGIHeader(giDetail.getGiHeader());
		System.out.println("GIHeader "+mmGIHeader.getGihNo()+" "+mmGIHeader.getGihDate());
		mmGIDetail.setGidNo(giDetail.getGidNo());
		mmGIDetail.setGidQty(giDetail.getGidQty());
		mmGIDetail.setMmGoodsissueheader(mmGIHeader);
		mmGIDetail.setMmItem(mmItem);
			
		return mmGIDetail;
	}

	public static GoodsIssueHeader getGIHeader(MmGoodsissueheader mmGIHeader) {
		GoodsIssueHeader giHeader = new GoodsIssueHeader();
		giHeader.setGihNo(mmGIHeader.getGihNo());
		giHeader.setGihDate(mmGIHeader.getGihDate());
		giHeader.setStatus(mmGIHeader.getStatus());
		UserForm user = new UserForm();
		BeanUtils.copyProperties(mmGIHeader.getMmUser(),user);
		giHeader.setUser(user);
		VehicleForm vehicle = new VehicleForm();
		BeanUtils.copyProperties(mmGIHeader.getMmVehicle(),vehicle);
		giHeader.setVehicle(vehicle);
		return giHeader;
	}

	public static GoodsIssueDetail getGIDetail(MmGoodsissuedetail mmGIDetail) {
		GoodsIssueDetail giDetail = new GoodsIssueDetail();
		ItemForm item = new ItemForm();
		setItem(mmGIDetail.getMmItem(),item);
		GoodsIssueHeader giHeader = getGIHeader(mmGIDetail.getMmGoodsissueheader());
		
		giDetail.setGidNo(mmGIDetail.getGidNo());
		giDetail.setGidQty(mmGIDetail.getGidQty());
		giDetail.setItem(item);
		giDetail.setGiHeader(giHeader);
		
		return giDetail;
	}

	public static GoodsReceiptHeader getGRHeader(MmGoodsreceiptheader mmGRHeader) {
		GoodsReceiptHeader grHeader = new GoodsReceiptHeader();
		grHeader.setGrDate(mmGRHeader.getGrhDate());
		grHeader.setGrNo(mmGRHeader.getGrhNo());
		POHeader poHeader = getPOHeader(mmGRHeader.getMmPoheader());
		grHeader.setPoHeader(poHeader);
		List<GoodsReceiptDetail> grDetails = new ArrayList<GoodsReceiptDetail>();
		Set<MmGoodsreceiptdetail> mmGRDetails = mmGRHeader.getMmGoodsreceiptdetails();
		for(MmGoodsreceiptdetail mmGRDetail: mmGRDetails) {
			GoodsReceiptDetail grDetail = getGRDetail(mmGRDetail,grHeader);
			grDetails.add(grDetail);
		}
		grHeader.setGrDetails(grDetails);
		return grHeader;
	}

	private static GoodsReceiptDetail getGRDetail(MmGoodsreceiptdetail mmGRDetail,GoodsReceiptHeader grHeader) {
		GoodsReceiptDetail grDetail = new GoodsReceiptDetail();
		grDetail.setGrdNo(mmGRDetail.getGrdNo());
		grDetail.setGrdQty(mmGRDetail.getGrhQty());
		ItemForm item = new ItemForm();
		setItem(mmGRDetail.getMmItem(),item);
		grDetail.setItem(item);
		grDetail.setGrHeader(grHeader);
		return grDetail;
	}
}
