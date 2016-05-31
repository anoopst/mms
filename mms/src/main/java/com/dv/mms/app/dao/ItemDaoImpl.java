package com.dv.mms.app.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmItem;

@Repository
@Transactional
public class ItemDaoImpl implements ItemDao {

	@Autowired
	public ItemDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public ItemDaoImpl() {
		super();
	}

	private SessionFactory sessionFactory;

	public void addItem(MmItem item) {
		sessionFactory.getCurrentSession().saveOrUpdate(item);
	}

	public List<MmItem> getItemList(String name) {
		
		MmItem mmItem = new MmItem();
		mmItem.setName("%"+name+"%");
		Example itemExample = Example.create(mmItem).enableLike().ignoreCase().excludeProperty("rate").excludeProperty("rol").excludeProperty("stock");
		
		List<MmItem> list = sessionFactory.getCurrentSession().createCriteria(MmItem.class).add(itemExample).list();
		
		/*List<MmItem> list = sessionFactory.getCurrentSession()
				.createQuery("from MmItem where name like '%" + name + "%'")
				.list();
		for (MmItem mmItem : list) {
			System.out.println(mmItem.getMmBrand().getName() + " "
					+ mmItem.getMmCategory().getName() + " "
					+ mmItem.getMmDimension().getName() + " "
					+ mmItem.getMmHeading().getName() + " "
					+ mmItem.getMmSubheading().getName() + " "
					+ mmItem.getMmUom().getName()
					+ mmItem.getMmModel().getName());
		}*/
		/*
		 * Criteria criteria =
		 * sessionFactory.getCurrentSession().createCriteria( MmItem.class);
		 * criteria.add(Restrictions.like("name", name)); List list =
		 * criteria.list();
		 */
		return list;
	}

	public List<MmItem> getItemList(MmItem mmItem) {
		Session session = sessionFactory.getCurrentSession();
		List<MmItem> list = null;
		/*if (mmItem.getId() != null && !mmItem.getId().equals(-1)) {
			MmItem mmLoadItem = (MmItem) session.get(MmItem.class,
					mmItem.getId());
			list = new ArrayList<MmItem>();
			list.add(mmLoadItem);
		} else {
			System.out.println("else");*/
			Criteria criteria = session.createCriteria(MmItem.class);
			Map<String,Serializable> map = new HashMap<String,Serializable>();
			if(mmItem.getId()!=null && mmItem.getId()>0)
				map.put("id", mmItem.getId());
			if(mmItem.getMmBrand()!=null && mmItem.getMmBrand().getId()!=null && mmItem.getMmBrand().getId()>0)
				map.put("mmBrand", mmItem.getMmBrand());
			if(mmItem.getMmCategory()!=null && mmItem.getMmCategory().getId()!=null && mmItem.getMmCategory().getId()>0)
				map.put("mmCategory",mmItem.getMmCategory());
			if(mmItem.getMmDimension()!=null && mmItem.getMmDimension().getId()!=null && mmItem.getMmDimension().getId()>0)
				map.put("mmDimension",mmItem.getMmDimension());
			if(mmItem.getMmHeading()!=null && mmItem.getMmHeading().getId()!=null && mmItem.getMmHeading().getId()>0)
				map.put("mmHeading",mmItem.getMmHeading());
			if(mmItem.getMmModel()!=null && mmItem.getMmModel().getId()!=null && mmItem.getMmModel().getId()>0)
				map.put("mmModel",mmItem.getMmModel());
			if(mmItem.getMmSubheading()!=null && mmItem.getMmSubheading().getId()!=null && mmItem.getMmSubheading().getId()>0)
				map.put("mmSubheading",mmItem.getMmSubheading());
			if(mmItem.getMmUom()!=null && mmItem.getMmUom().getId()!=null && mmItem.getMmUom().getId()>0)
				map.put("mmUom",mmItem.getMmUom());
			criteria.add(Restrictions.allEq(map));
			/*Query query = session
					.createQuery("from MmItem item where item.mmHeading=? and item.mmSubheading=? and item.mmBrand=? and item.mmModel=? and item.mmDimension=? and item.mmCategory=?");
			
			query.setParameter(0, mmItem.getMmHeading());
			query.setParameter(1, mmItem.getMmSubheading());
			query.setParameter(2, mmItem.getMmBrand());
			query.setParameter(3, mmItem.getMmModel());
			query.setParameter(4, mmItem.getMmDimension());
			query.setParameter(5, mmItem.getMmCategory());
			list = query.list();*/
			list = criteria.list();
		//}
		return list;
	}

	public MmItem getItem(Integer id) {
		MmItem mmItem = (MmItem) sessionFactory.getCurrentSession().get(
				MmItem.class, id);
		return mmItem;
	}

	public void modifyItem(MmItem item) {
		sessionFactory.getCurrentSession().merge(item);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
