package com.dv.app.mms.app.validator;

import java.util.List;

import org.springframework.validation.Errors;

import com.dv.mms.app.web.form.VehicleForm;

public class VehicleValidator {

	public void Validate(VehicleForm vehicle, List<VehicleForm> list,Errors errors) {
		for(VehicleForm vehicleForm:list) {
			if(vehicle.getName().equalsIgnoreCase(vehicleForm.getName())) {
				errors.rejectValue("name", "vehicle.exists");
				break;
			}
		}
		
	}
}
