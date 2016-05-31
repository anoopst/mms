package com.dv.mms.app.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmItem;
import com.dv.mms.app.domain.master.MmReqdetail;
import com.dv.mms.app.domain.master.MmReqheader;
import com.dv.mms.app.domain.master.MmUser;

@Repository
@Transactional
public class RequestDaoImpl implements RequestDao {
	
	private SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public RequestDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public RequestDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer addRequest(MmReqheader mmReqHead) {
		System.out.println(mmReqHead.getRhDate());
		Session session = sessionFactory.getCurrentSession();
		session.save(mmReqHead);		
		return mmReqHead.getRhNo();
	}

	public void addRequestItem(Integer mmReqHead, MmReqdetail mmReqDetail) {
		Session session = sessionFactory.getCurrentSession();
		//mmReqDetail.getMmReqheader().setMmReqdetails(null);
		MmReqdetail mmreq1 = (MmReqdetail)session.merge(mmReqDetail);
		System.out.println(mmreq1.getRdNo());
		System.out.println(mmreq1.getRdQty());
		System.out.println(mmreq1.getMmItem().getId()+" "+mmreq1.getMmItem().getName());
		System.out.println(mmreq1.getMmReqheader().getRhNo()+" "+mmreq1.getMmReqheader().getStatus());
		
	}

	public void modifyRequestItem(Integer mmReqHead, MmReqdetail reqDetail) {

	}

	public void delRequestItem(Integer mmReqHead, Integer mmReqDetail) {
		// TODO Auto-generated method stub

	}

	public void modifyRequest(MmReqheader mmReqHead) {
		sessionFactory.getCurrentSession().merge(mmReqHead);
	}

	public MmReqheader getRequest(Integer mmReqHead) {
		Session session = sessionFactory.getCurrentSession();
		MmReqheader mmReqHeader = (MmReqheader)session.get(MmReqheader.class, mmReqHead);
		Set set = mmReqHeader.getMmReqdetails();		
		for(Iterator iterator = set.iterator();iterator.hasNext();) {
			MmReqdetail reqDetail = (MmReqdetail)iterator.next();
			MmItem mmItem = reqDetail.getMmItem();
			System.out.println("Item: "+mmItem.getId()+" "+mmItem.getName());
		}
		MmUser user = mmReqHeader.getRequestor();
		System.out.println("User: "+user.getId()+" "+user.getName());
		return mmReqHeader;
	}

	public MmReqdetail getRequestItem(Integer mmReqHead, Integer itemId) {
		
		Session session = sessionFactory.getCurrentSession();		
		MmReqdetail mmReqDetail = null;
		MmReqheader mmReqHeader = (MmReqheader)session.get(MmReqheader.class,mmReqHead);			
		MmItem mmItem = (MmItem)session.get(MmItem.class,itemId);
		
		Query query = session.createQuery("from MmReqdetail where mmReqheader=? and mmItem=?");
		query.setParameter(0, mmReqHeader);
		query.setParameter(1,mmItem);
		List list = query.list();
				
		if(list == null||list.isEmpty()) {
			mmReqDetail = new MmReqdetail();	
			mmReqDetail.setRdNo(-1);
			mmReqDetail.setMmReqheader(mmReqHeader);
			mmReqDetail.setMmItem(mmItem);
		} else {
			mmReqDetail = (MmReqdetail)list.get(0);
		}		
		
		return mmReqDetail;
	}

	public List<MmReqheader> getRequestsByStatus(String status) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MmReqheader.class);
		criteria.add(Restrictions.eq("status",status));
		List<MmReqheader> list = criteria.list();
		for(MmReqheader mmReq: list) {
			System.out.println(mmReq.getRequestor().getName());
		}
		return list;
	}

	public List<MmReqheader> getRequestsByStatus(List status) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MmReqheader.class);
		criteria.add(Restrictions.in("status",status));		
		List list = criteria.list();
		return list;		
	}

}
