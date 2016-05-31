package com.dv.mms.app.service;

import java.util.List;

import com.dv.mms.app.web.form.ConfigItem;

public interface ItemConfigService {
	
	void addConfigItem(Class clazz,ConfigItem config);
	List<ConfigItem> getConfigList(Class clazz,String name);
	ConfigItem getConfigItem(Class clazz,Integer id);
	void modifyConfigItem(Class clazz,ConfigItem config);	

}
