package com.dv.mms.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmVehicle;

@Repository
@Transactional
public class VehicleDaoImpl implements VehicleDao {

	public VehicleDaoImpl() {

	}

	@Autowired
	public VehicleDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;

	public void addVehicle(MmVehicle vehicle) {

		sessionFactory.getCurrentSession().merge(vehicle);
	}

	public List<MmVehicle> getVehicleList(String name) {

		List<MmVehicle> list = sessionFactory.getCurrentSession()
				.createQuery("from MmVehicle where name like '%" + name + "%'")
				.list();

		return list;
	}

	public MmVehicle getVehicle(Integer id) {

		return (MmVehicle) sessionFactory.getCurrentSession().get(
				MmVehicle.class, id);
	}

	public void modifyVehicle(MmVehicle vehicle) {

		sessionFactory.getCurrentSession().merge(vehicle);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
