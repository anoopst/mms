package com.dv.mms.app.dao;

import java.util.List;

import com.dv.mms.app.domain.master.MmUser;

public interface UserDao {
	
	void addUser(MmUser user);
	List<MmUser> getUserList(String name);
	MmUser getUser(Integer id);
	void modifyUser(MmUser user);

}
