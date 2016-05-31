package com.dv.mms.app.dao;

import java.util.List;

import com.dv.mms.app.domain.master.MmReqdetail;
import com.dv.mms.app.domain.master.MmReqheader;

public interface RequestDao {
	
	Integer addRequest(MmReqheader mmReqHead);

	void addRequestItem(Integer mmReqHead, MmReqdetail mmReqDetail);

	void modifyRequestItem(Integer mmReqHead, MmReqdetail reqDetail);
	
	void delRequestItem(Integer mmReqHead, Integer mmReqDetail);

	void modifyRequest(MmReqheader mmReqHead);

	MmReqheader getRequest(Integer mmReqHead);
	
	MmReqdetail getRequestItem(Integer mmReqHead, Integer itemId);

	List<MmReqheader> getRequestsByStatus(String status);

	List<MmReqheader> getRequestsByStatus(List status);

}
