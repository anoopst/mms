package com.dv.mms.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.domain.master.MmItem;
import com.dv.mms.app.domain.master.MmUser;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
	}

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;

	public void addUser(MmUser user) {

		sessionFactory.getCurrentSession().merge(user);		
	}

	public List<MmUser> getUserList(String name) {
		
		MmUser mmUser = new MmUser();
		mmUser.setName("%"+name+"%");
		
		Example userExample = Example.create(mmUser).enableLike().ignoreCase().excludeProperty("role").excludeProperty("password");
		
		List<MmUser> list = sessionFactory.getCurrentSession().createCriteria(MmUser.class).add(userExample).list();
		/*List<MmUser> list = sessionFactory.getCurrentSession()
				.createQuery("from MmUser where name like '%" + name + "%'")
				.list();*/
		if (list != null)
			System.out.println("List size " + list.size());
		else
			System.out.println("Empty list");
		return list;
	}

	public MmUser getUser(Integer id) {

		return (MmUser) sessionFactory.getCurrentSession()
				.get(MmUser.class, id);
	}

	public void modifyUser(MmUser user) {

		sessionFactory.getCurrentSession().merge(user);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
