package com.dv.mms.app.dao;

import java.util.List;

import com.dv.mms.app.domain.master.MmVendor;

public interface VendorDao {

	void addVendor(MmVendor vendor);
	List<MmVendor> getVendorList(String name);
	MmVendor getVendor(Integer id);
	void modifyVendor(MmVendor vendor);
}
