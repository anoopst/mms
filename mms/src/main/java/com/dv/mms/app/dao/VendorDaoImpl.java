package com.dv.mms.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmItem;
import com.dv.mms.app.domain.master.MmVendor;

@Repository
@Transactional
public class VendorDaoImpl implements VendorDao {
	
	public VendorDaoImpl() {
	}

	@Autowired
	public VendorDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;
	
	public void addVendor(MmVendor vendor) {

		sessionFactory.getCurrentSession().merge(vendor);		
	}

	public List<MmVendor> getVendorList(String name) {

		/*List<MmVendor> list = sessionFactory.getCurrentSession()
				.createQuery("from MmVendor where name like '%" + name + "%'")
				.list();*/
		MmVendor mmVendor = new MmVendor();
		mmVendor.setName("%"+name+"%");
			
		Example example = Example.create(mmVendor).enableLike().ignoreCase();
		
		List<MmVendor> list = sessionFactory.getCurrentSession().createCriteria(MmVendor.class).add(example).list();
		
		if (list != null)
			System.out.println("List size " + list.size());
		else
			System.out.println("Empty list");
		return list;
	}

	public MmVendor getVendor(Integer id) {

		return (MmVendor) sessionFactory.getCurrentSession()
				.get(MmVendor.class, id);
	}

	public void modifyVendor(MmVendor vendor) {

		sessionFactory.getCurrentSession().merge(vendor);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
