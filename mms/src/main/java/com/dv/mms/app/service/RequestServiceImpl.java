package com.dv.mms.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.dao.RequestDao;
import com.dv.mms.app.domain.master.MmReqdetail;
import com.dv.mms.app.domain.master.MmReqheader;
import com.dv.mms.app.utils.BeanUtil;
import com.dv.mms.app.web.form.RequestDetail;
import com.dv.mms.app.web.form.RequestHeader;

@Transactional
public class RequestServiceImpl implements RequestService {
	
	private RequestDao requestDao;

	@Autowired
	public RequestServiceImpl(RequestDao requestDao) {
		super();
		this.requestDao = requestDao;
	}

	public RequestServiceImpl() {
		super();
	}

	public Integer addRequest(RequestHeader reqHead) {
		MmReqheader mmReqHeader = BeanUtil.getMmReqHeader(reqHead);		
		Integer reqId = requestDao.addRequest(mmReqHeader);
		return reqId;
	}

	public void addRequestItem(Integer reqHead, RequestDetail reqDetail) {
		MmReqdetail mmReqDetail = BeanUtil.getMmReqDetail(reqDetail);
		requestDao.addRequestItem(reqHead, mmReqDetail);
	}

	public void modifyRequestItem(Integer reqHead, RequestDetail reqDetail) {
		

	}

	public void delRequestItem(Integer reqHead, Integer reqDetail) {
		// TODO Auto-generated method stub

	}

	public void modifyRequest(RequestHeader reqHead) {
		MmReqheader mmReqHead = BeanUtil.getMmReqHeader(reqHead); 
		requestDao.modifyRequest(mmReqHead);

	}

	public RequestHeader getRequest(Integer reqHeadId) {
		MmReqheader mmReqHeader = requestDao.getRequest(reqHeadId);
		RequestHeader reqHeader = BeanUtil.getReqHeader(mmReqHeader);
		List<RequestDetail> reqList = new ArrayList<RequestDetail>();
		Set set = mmReqHeader.getMmReqdetails();
		if (set != null) {
			List list = Arrays.asList(set.toArray());
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				MmReqdetail mmReqDetail = (MmReqdetail) iterator.next();
				RequestDetail reqDetail = BeanUtil.getReqDetail(mmReqDetail);
				reqDetail.setReqHeader(reqHeader);
				reqList.add(reqDetail);
			}
			reqHeader.setRequestDetail(reqList);
		}		
		return reqHeader;
	}

	public MmReqheader getMmRequest(Integer reqHeadId) {
		MmReqheader mmReqHeader = requestDao.getRequest(reqHeadId);
		return mmReqHeader;
	}

	public void modifyRequest(MmReqheader mmReqheader) {
		requestDao.modifyRequest(mmReqheader);		
	}

	public RequestDetail getRequestItem(Integer reqHead, Integer itemId) {
		MmReqdetail mmReqDetail = requestDao.getRequestItem(reqHead, itemId);
		RequestDetail reqDetail = BeanUtil.getReqDetail(mmReqDetail);
		return reqDetail;
	}

	public List<RequestHeader> getRequestsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public RequestDao getRequestDao() {
		return requestDao;
	}

	public void setRequestDao(RequestDao requestDao) {
		this.requestDao = requestDao;
	}

	public List getRequestList(String status) {
		List<MmReqheader> mmReqList = requestDao.getRequestsByStatus(status);
		List<RequestHeader> reqList = new ArrayList<RequestHeader>();
		for(MmReqheader mmHeader: mmReqList) {
			RequestHeader header = BeanUtil.getReqHeader(mmHeader);
			reqList.add(header);
		}
		return reqList;
	}

	public List getRequestList(List status) {
		List<MmReqheader> mmReqList = requestDao.getRequestsByStatus(status);
		List<RequestHeader> reqList = new ArrayList<RequestHeader>();
		for(MmReqheader mmHeader: mmReqList) {
			RequestHeader header = BeanUtil.getReqHeader(mmHeader);
			reqList.add(header);
		}
		return reqList;		
	}

}
