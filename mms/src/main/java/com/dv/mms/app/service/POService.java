package com.dv.mms.app.service;

import java.util.List;

import com.dv.mms.app.domain.master.MmPoheader;
import com.dv.mms.app.web.form.POHeader;

public interface POService {

	POHeader preparePO(Integer reqId);
	POHeader addPO(POHeader poHeader);
	void summarize(POHeader poHeader);
	List getPOList(POHeader poHeader,List status);
	List getPOList(List status);
	POHeader getPO(Integer poId);
	MmPoheader getMmPO(Integer poNo);
	void modifyPO(MmPoheader mmPOHeader);
}
