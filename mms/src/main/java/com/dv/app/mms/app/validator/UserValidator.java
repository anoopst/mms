package com.dv.app.mms.app.validator;

import java.util.List;

import org.springframework.validation.Errors;

import com.dv.mms.app.web.form.UserForm;

public class UserValidator {
	
	public void Validate(UserForm user, List<UserForm> list,Errors errors) {
		for(UserForm userForm:list) {
			if(user.getName().equalsIgnoreCase(userForm.getName())) {
				errors.rejectValue("name", "user.exists");
				break;
			}
		}
		
	}

}
