package com.dv.mms.app.dao;

import java.lang.reflect.Constructor;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmItem;

@Repository
@Transactional
public class ItemConfigDaoImpl implements ItemConfigDao {

	public ItemConfigDaoImpl() {
	}

	@Autowired
	public ItemConfigDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;

	public void addConfigItem(Object object) {
		sessionFactory.getCurrentSession().merge(object);
	}

	public List getConfigList(Class clazz, String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				clazz);
		/*criteria.add(Restrictions.like("name", name));
		List list = criteria.list();*/
		/*String qry = "from "+ clazz.getSimpleName() +" where name like '%" + name + "%'";
		List list = sessionFactory.getCurrentSession().createQuery(qry).list();
		if (list != null)
			System.out.println("List size " + list.size());
		else
			System.out.println("Empty list");*/
		
		Object iConfig = null;
		try {
			Constructor constructor = clazz.getConstructor(String.class);
			
			iConfig = constructor.newInstance("%"+name+"%");
		
		} catch(Exception e) {e.printStackTrace();}
		
		
		Example example = Example.create(iConfig).enableLike().ignoreCase();
		
		List<MmItem> list = sessionFactory.getCurrentSession().createCriteria(clazz).add(example).list();

		return list;
	}

	public Object getConfigItem(Class clazz, Integer id) {
		Object object = sessionFactory.getCurrentSession().get(clazz, id);
		return object;
	}

	public void modifyConfigItem(Object object) {
		sessionFactory.getCurrentSession().merge(object);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
