package com.dv.app.mms.app.validator;

import java.util.Iterator;
import java.util.List;

import org.springframework.validation.Errors;

import com.dv.mms.app.web.form.PODetail;
import com.dv.mms.app.web.form.POHeader;
import com.dv.mms.app.web.form.VendorForm;

public class POValidator {

	public void Validate(POHeader poHeader, Errors errors) {

		VendorForm vendor = poHeader.getVendor();
		List<PODetail> poDetails = poHeader.getPoDetails();		
		Iterator<PODetail> poIterator = poDetails.iterator();
		int count = 0;
		int i = 0;

		if (vendor == null || vendor.getId() == null
				|| vendor.getName() == null || vendor.getName().equals("")) {
			errors.rejectValue("vendor.name", "vendor.required");
		}
		
		while (poIterator.hasNext()) {
			PODetail poDetail = poIterator.next();
			
			if (poDetail.getPoQty() > poDetail.getReqQty()) {
				errors.rejectValue("poDetails[" + i +"].poQty", "po.greaterQty");				
			}
			
			if (poDetail.getPoQty() != 0) {
				
				if(poDetail.getPoRate()<=0) {
					errors.rejectValue("poDetails[" + i +"].poQty", "po.invalidAmt");
				}
					
				count++;
			}
			
			
			i++;
		}

		if (count == 0)
			errors.rejectValue("poNo","po.noItem");
	}

}
