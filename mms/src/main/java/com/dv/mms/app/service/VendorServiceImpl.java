package com.dv.mms.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.dao.VendorDao;
import com.dv.mms.app.domain.master.MmVendor;
import com.dv.mms.app.web.form.VendorForm;

@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	public VendorServiceImpl(VendorDao vendorDao) {
		this.vendorDao = vendorDao;
	}

	private VendorDao vendorDao;

	public void addVendor(VendorForm vendor) {

		MmVendor mmVendor = new MmVendor();
		//BeanUtils.copyProperties(vendor, mmVendor,new String[]{"mmPoheaders"});
		mmVendor.setId(vendor.getId());
		mmVendor.setName(vendor.getName());
		mmVendor.setAdd1(vendor.getAdd1());
		mmVendor.setAdd2(vendor.getAdd2());
		mmVendor.setAdd3(vendor.getAdd3());
		mmVendor.setAdd4(vendor.getAdd4());
		mmVendor.setVenType(vendor.getVenType());
		vendorDao.addVendor(mmVendor);

	}

	public List<VendorForm> getVendorList(String name) {

		List<MmVendor> vendorList = vendorDao.getVendorList(name);
		List<VendorForm> vendorFormList = new ArrayList<VendorForm>();
		for (MmVendor vendor : vendorList) {
			VendorForm vendorForm = new VendorForm();
			BeanUtils.copyProperties(vendor, vendorForm);
			vendorFormList.add(vendorForm);
		}
		System.out.println("Service List Size "+vendorFormList.size());
		return vendorFormList;
	}

	public VendorForm getVendor(Integer id) {

		MmVendor mmVendor = vendorDao.getVendor(id);
		VendorForm vendor = new VendorForm();

		if (mmVendor != null)
			BeanUtils.copyProperties(mmVendor, vendor);

		return vendor;
	}

	public void modifyVendor(VendorForm vendor) {

		MmVendor mmVendor = new MmVendor();
		BeanUtils.copyProperties(vendor, mmVendor);

		vendorDao.modifyVendor(mmVendor);

	}

	public VendorDao getVendorDao() {
		return vendorDao;
	}

	public void setVendorDao(VendorDao vendorDao) {
		this.vendorDao = vendorDao;
	}

}
