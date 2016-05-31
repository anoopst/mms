package com.dv.mms.app.service;

import java.util.List;

import com.dv.mms.app.web.form.UserForm;

public interface UserService {
	
	void addUser(UserForm user);
	List<UserForm> getUserList(String name);
	UserForm getUser(Integer id);
	void modifyUser(UserForm user);
}
