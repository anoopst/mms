package com.dv.mms.app.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmGoodsissuedetail;
import com.dv.mms.app.domain.master.MmGoodsissueheader;
import com.dv.mms.app.domain.master.MmGoodsreceiptheader;
import com.dv.mms.app.domain.master.MmItem;
import com.dv.mms.app.domain.master.MmUser;
import com.dv.mms.app.domain.master.MmVehicle;

@Repository
@Transactional
public class GoodsDaoImpl implements GoodsDao {

	private SessionFactory sessionFactory;

	@Autowired
	public GoodsDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(MmGoodsreceiptheader grhead) {
		Session session = sessionFactory.getCurrentSession();		
		System.out.println("debug 4");
		// session.persist(grhead);
		session.saveOrUpdate(grhead);
		// session.merge(grhead);
	}

	public Integer addGI(MmGoodsissueheader mmGIHeader) {
		Session session = sessionFactory.getCurrentSession();
		session.save(mmGIHeader);
		return mmGIHeader.getGihNo();
	}

	public MmGoodsissueheader getGI(Integer gihNo) {
		Session session = sessionFactory.getCurrentSession();
		MmGoodsissueheader mmGIHeader = (MmGoodsissueheader) session.get(
				MmGoodsissueheader.class, gihNo);
		Set<MmGoodsissuedetail> set = mmGIHeader.getMmGoodsissuedetails();
		for (MmGoodsissuedetail mmGIDetail : set) {
			System.out.println(mmGIDetail.getGidNo() + " "
					+ mmGIDetail.getGidQty());
		}
		MmUser user = mmGIHeader.getMmUser();
		MmVehicle vehicle = mmGIHeader.getMmVehicle();
		System.out.println("User: " + user.getId() + " " + user.getName());
		System.out.println("Vehicle: " + vehicle.getId() + " "
				+ vehicle.getName());
		return mmGIHeader;
	}

	public MmGoodsissuedetail getGIItem(Integer gihNo, Integer itemId) {
		Session session = sessionFactory.getCurrentSession();
		MmGoodsissuedetail mmGIDetail = null;
		MmGoodsissueheader mmGIHeader = (MmGoodsissueheader) session.get(
				MmGoodsissueheader.class, gihNo);
		MmItem mmItem = (MmItem) session.get(MmItem.class, itemId);

		Query query = session
				.createQuery("from MmGoodsissuedetail where mmGoodsissueheader=? and mmItem=?");
		query.setParameter(0, mmGIHeader);
		query.setParameter(1, mmItem);
		List<MmGoodsissuedetail> list = query.list();

		if (list == null || list.isEmpty()) {
			mmGIDetail = new MmGoodsissuedetail();
			mmGIDetail.setGidNo(-1);
			mmGIDetail.setMmGoodsissueheader(mmGIHeader);
			mmGIDetail.setMmItem(mmItem);
		} else {
			mmGIDetail = list.get(0);
		}

		return mmGIDetail;
	}

	public void addGID(MmGoodsissuedetail mmGIDetail) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(mmGIDetail);

	}

	public void modify(MmGoodsissueheader mmGIHead) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(mmGIHead);

	}

	public void issue(MmGoodsissueheader mmGIHead) {
		Session session = sessionFactory.getCurrentSession();
		Set<MmGoodsissuedetail> mmGIDetails = mmGIHead.getMmGoodsissuedetails();
		for (MmGoodsissuedetail mmGIDetail : mmGIDetails) {
			session.saveOrUpdate(mmGIDetail.getMmItem());
		}
		session.saveOrUpdate(mmGIHead);
	}

	public List<MmGoodsreceiptheader> getReceiptsForItem(Integer itemId,
			Integer records) {
		System.out.println("Item id "+itemId);
		Session session = sessionFactory.getCurrentSession();
		List list = null;
		/*String query = "select h from MmItem i, MmGoodsreceiptheader h join h.mmGoodsreceiptdetails d where i.id = d.mmItem.id and i.id = ? order by h.grhDate";
		Query qry = session.createQuery(query);
		qry.setParameter(0, itemId);
		qry.setFetchSize(records);		
		List list = qry.list();*/
		Criteria criteria = session.createCriteria(MmGoodsreceiptheader.class);
		criteria.createCriteria("mmPoheader").createCriteria("mmPodetails").createAlias("mmItem", "poitem");
		criteria.createCriteria("mmGoodsreceiptdetails").createAlias("mmItem", "gritem")
				.add(Restrictions.and(Restrictions.eqProperty("poitem.id", "gritem.id"), Restrictions.eq("gritem.id", itemId)));		
		//criteria.setFetchMode("mmPoheader.mmReqheader.Requestor", FetchMode.EAGER);
		
		list = criteria.list();
		return list;
	}

} 
