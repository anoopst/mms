package com.dv.mms.app.dao;

import java.util.List;

import com.dv.mms.app.domain.master.MmPoheader;

public interface PODao {
	
	public void save(MmPoheader mmPOHeader);

	public List getList(List status);
	public List getList(MmPoheader mmPOHeader,List status);
	public MmPoheader getPO(Integer poId);

	public void modifyRequest(MmPoheader mmPOHeader);

}
