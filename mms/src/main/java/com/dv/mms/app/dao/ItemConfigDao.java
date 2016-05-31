package com.dv.mms.app.dao;

import java.util.List;

public interface ItemConfigDao {
	
	void addConfigItem(Object object);
	List getConfigList(Class clazz,String name);
	Object getConfigItem(Class clazz,Integer id);
	void modifyConfigItem(Object object);

}
