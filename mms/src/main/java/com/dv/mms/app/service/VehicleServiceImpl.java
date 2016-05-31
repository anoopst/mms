package com.dv.mms.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.dao.VehicleDao;
import com.dv.mms.app.domain.master.MmVehicle;
import com.dv.mms.app.domain.master.MmVehicle;
import com.dv.mms.app.web.form.VehicleForm;
import com.dv.mms.app.web.form.VehicleForm;

@Transactional
public class VehicleServiceImpl implements VehicleService {

	public VehicleServiceImpl() {
	}

	@Autowired
	public VehicleServiceImpl(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	private VehicleDao vehicleDao;

	public void addVehicle(VehicleForm vehicle) {

		MmVehicle mmVehicle = new MmVehicle();
		BeanUtils.copyProperties(vehicle, mmVehicle);
		vehicleDao.addVehicle(mmVehicle);

	}

	public List<VehicleForm> getVehicleList(String name) {

		List<MmVehicle> vehicleList = vehicleDao.getVehicleList(name);
		List<VehicleForm> vehicleFormList = new ArrayList<VehicleForm>();
		for (MmVehicle vehicle : vehicleList) {
			VehicleForm vehicleForm = new VehicleForm();
			BeanUtils.copyProperties(vehicle, vehicleForm);
			vehicleFormList.add(vehicleForm);
		}
		return vehicleFormList;
	}

	public VehicleForm getVehicle(Integer id) {

		MmVehicle mmVehicle = vehicleDao.getVehicle(id);
		VehicleForm vehicle = new VehicleForm();

		if (mmVehicle != null)
			BeanUtils.copyProperties(mmVehicle, vehicle);

		return vehicle;
	}

	public void modifyVehicle(VehicleForm vehicle) {

		MmVehicle mmVehicle = new MmVehicle();
		BeanUtils.copyProperties(vehicle, mmVehicle);

		vehicleDao.modifyVehicle(mmVehicle);

	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

}
