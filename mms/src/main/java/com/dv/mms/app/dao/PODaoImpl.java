package com.dv.mms.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmPoheader;

@Repository
@Transactional
public class PODaoImpl implements PODao {
	
	private SessionFactory sessionFactory;

	@Autowired
	public PODaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MmPoheader getPO(Integer poId) {
		Session session = sessionFactory.getCurrentSession();
		MmPoheader mmPOHeader = (MmPoheader)session.get(MmPoheader.class, poId);
		mmPOHeader.getMmReqheader().getRequestor();
		return mmPOHeader;
	}
	
	public void save(MmPoheader mmPOHeader) {
		Session session = sessionFactory.getCurrentSession();
		session.save(mmPOHeader);		
	}

	public List getList(List status) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MmPoheader.class);
		criteria.add(Restrictions.in("poStatus",status));		
		List<MmPoheader> list = criteria.list();
		for(MmPoheader mmpo: list) {
			mmpo.getMmReqheader().getRequestor();			
		}
		
		return list;
	}
	
	public List getList(MmPoheader mmPOHeader,List status) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MmPoheader.class);
		if(mmPOHeader.getPoNo()!=null && !mmPOHeader.getPoNo().equals(""))
			criteria.add(Restrictions.idEq(mmPOHeader.getPoNo()));
		if(mmPOHeader.getMmVendor()!=null && mmPOHeader.getMmVendor().getId()!=null && mmPOHeader.getMmVendor().getName()!=null)
			criteria.add(Restrictions.eq("mmVendor",mmPOHeader.getMmVendor()));
		if(status!=null && !status.isEmpty())
			criteria.add(Restrictions.in("poStatus",status));
		List<MmPoheader> list = criteria.list();
		for(MmPoheader mmpo: list) {
			mmpo.getMmReqheader().getRequestor();			
		}
		System.out.println("getList "+list.size());
		return list;
	}

	public void modifyRequest(MmPoheader mmPOHeader) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(mmPOHeader);
	}

}
