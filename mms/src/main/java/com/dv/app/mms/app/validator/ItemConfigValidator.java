package com.dv.app.mms.app.validator;

import java.util.List;

import org.springframework.validation.Errors;

import com.dv.mms.app.web.form.ConfigItem;

public class ItemConfigValidator {
	
	public void Validate(ConfigItem configItem, List<ConfigItem> list,Errors errors) {
		for(ConfigItem confItem:list) {
			if(confItem.getName().equals(configItem.getName())) {
				errors.rejectValue("name", "iconfig.exists");
				break;
			}
		}
		
	}

}
