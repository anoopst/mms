package com.dv.app.mms.app.validator;

import java.util.Iterator;
import java.util.List;

import org.springframework.validation.Errors;

import com.dv.mms.app.web.form.GoodsReceiptDetail;
import com.dv.mms.app.web.form.GoodsReceiptHeader;
import com.dv.mms.app.web.form.PODetail;

public class GRValidator {

	public void Validate(GoodsReceiptHeader grHeader, Errors errors) {
		
		List<GoodsReceiptDetail> grDetails = grHeader.getGrDetails();		
		Iterator<GoodsReceiptDetail> grIterator = grDetails.iterator();
		int count = 0;
		int i = 0;
		
		while (grIterator.hasNext()) {
			GoodsReceiptDetail grDetail = grIterator.next();
			
			if (grDetail.getGrdQty() > grDetail.getPoQty()) {				
				errors.rejectValue("grDetails[" + i +"].grdQty", "grd.greaterQty");				
			}
			
			if (grDetail.getGrdQty() != 0) {
				count++;
			}
			i++;
		}

		if (count == 0)
			errors.rejectValue("grNo","grd.noItem");
	}

}

