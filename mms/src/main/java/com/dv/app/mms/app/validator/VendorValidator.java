package com.dv.app.mms.app.validator;

import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;

import com.dv.mms.app.web.form.VendorForm;

public class VendorValidator {

	public void validate(VendorForm vendor, List<VendorForm> list,
			BindingResult result) {
		for(VendorForm vendorForm:list) {
			if(vendor.getName().equalsIgnoreCase(vendorForm.getName()) && vendor.getAdd1().equalsIgnoreCase(vendorForm.getAdd1())) {
				result.rejectValue("name", "vendor.exists");
				break;
			}
		}
		
	}

	public void validate(Map<String, Object> map, BindingResult result) {
		List<VendorForm> list = (List<VendorForm>)map.get("list");
		VendorForm vendor = (VendorForm)map.get("vendor");
		for(VendorForm vendorForm:list) {
			if(vendor.getName().equalsIgnoreCase(vendorForm.getName()) && vendor.getAdd1().equalsIgnoreCase(vendorForm.getAdd1())) {
				result.rejectValue("name", "vendor.exists");
				break;
			}
		}
		
	}

}
