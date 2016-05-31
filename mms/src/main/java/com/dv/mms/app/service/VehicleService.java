package com.dv.mms.app.service;

import java.util.List;

import com.dv.mms.app.web.form.VehicleForm;

public interface VehicleService {
	
	void addVehicle(VehicleForm vehicle);
	List<VehicleForm> getVehicleList(String name);
	VehicleForm getVehicle(Integer id);
	void modifyVehicle(VehicleForm vehicle);

}
