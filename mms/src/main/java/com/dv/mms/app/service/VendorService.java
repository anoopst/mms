package com.dv.mms.app.service;

import java.util.List;

import com.dv.mms.app.web.form.VendorForm;

public interface VendorService {
	
	void addVendor(VendorForm vendor);
	List<VendorForm> getVendorList(String name);
	VendorForm getVendor(Integer id);
	void modifyVendor(VendorForm vendor);

}
