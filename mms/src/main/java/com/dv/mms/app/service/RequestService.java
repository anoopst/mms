package com.dv.mms.app.service;

import java.util.List;

import com.dv.mms.app.domain.master.MmReqheader;
import com.dv.mms.app.web.form.RequestDetail;
import com.dv.mms.app.web.form.RequestHeader;

public interface RequestService {

	Integer addRequest(RequestHeader reqHead);	
	void modifyRequest(MmReqheader mmReqheader);
	void addRequestItem(Integer reqHead, RequestDetail reqDetail);	
	void modifyRequestItem(Integer reqHead, RequestDetail reqDetail);	
	void delRequestItem(Integer reqHead, Integer reqDetail);
	void modifyRequest(RequestHeader reqHead);
	RequestHeader getRequest(Integer reqHeadId);	
	MmReqheader getMmRequest(Integer reqHeadId);	
	RequestDetail getRequestItem(Integer reqHead, Integer itemId);
	List<RequestHeader> getRequestsByStatus(String status);
	List getRequestList(String status);
	List getRequestList(List status);
}
