package com.dv.mms.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.dao.UserDao;
import com.dv.mms.app.domain.master.MmUser;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.UserForm;

@Transactional
public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
	}

	@Autowired
	public UserServiceImpl(UserDao userDao,PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	private UserDao userDao;
	private PasswordEncoder passwordEncoder;

	public void addUser(UserForm user) {

		MmUser mmUser = new MmUser();
		String passwd = passwordEncoder.encodePassword(Constants.DEF_PASSWD,null);
		user.setPassword(passwd);
		BeanUtils.copyProperties(user, mmUser);
		System.out.println(mmUser.getName() +" "+mmUser.getRole());
		userDao.addUser(mmUser);

	}

	public List<UserForm> getUserList(String name) {

		List<MmUser> userList = userDao.getUserList(name);
		List<UserForm> userFormList = new ArrayList<UserForm>();
		for (MmUser user : userList) {
			UserForm userForm = new UserForm();
			BeanUtils.copyProperties(user, userForm);
			userFormList.add(userForm);
		}
		System.out.println("Service List Size "+userFormList.size());
		return userFormList;
	}

	public UserForm getUser(Integer id) {

		MmUser mmUser = userDao.getUser(id);
		UserForm user = new UserForm();

		if (mmUser != null)
			BeanUtils.copyProperties(mmUser, user);

		return user;
	}

	public void modifyUser(UserForm user) {

		MmUser mmUser = new MmUser();
		BeanUtils.copyProperties(user, mmUser);

		userDao.modifyUser(mmUser);

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
