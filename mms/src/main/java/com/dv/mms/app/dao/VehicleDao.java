package com.dv.mms.app.dao;

import java.util.List;

import com.dv.mms.app.domain.master.MmVehicle;

public interface VehicleDao {
	
	void addVehicle(MmVehicle vehicle);
	List<MmVehicle> getVehicleList(String name);
	MmVehicle getVehicle(Integer id);
	void modifyVehicle(MmVehicle vehicle);

}
