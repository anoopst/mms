package com.dv.app.mms.app.validator;

import java.util.List;

import org.springframework.validation.Errors;

import com.dv.mms.app.web.form.ItemForm;

public class ItemValidator {

	public void Validate(ItemForm item, List<ItemForm> list,Errors errors) {
		for(ItemForm itemForm:list) {
			if(item.getName().equalsIgnoreCase(itemForm.getName())) {
				if(item.getId().equals(-1) || !item.getId().equals(itemForm.getId())) {
					errors.rejectValue("name", "item.exists");
					break;
				}
			}
		}
		
	}
}
