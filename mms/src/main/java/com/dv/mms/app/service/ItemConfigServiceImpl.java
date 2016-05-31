package com.dv.mms.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.dao.ItemConfigDao;
import com.dv.mms.app.utils.BeanUtil;
import com.dv.mms.app.web.form.ConfigItem;

@Transactional
public class ItemConfigServiceImpl implements ItemConfigService {

	public ItemConfigServiceImpl() {
		
	}

	@Autowired
	public ItemConfigServiceImpl(ItemConfigDao itemConfigDao) {		
		this.itemConfigDao = itemConfigDao;
	}

	private ItemConfigDao itemConfigDao;

	public void addConfigItem(Class clazz, ConfigItem config) {
		Object object = BeanUtil.getItemConfigForDao(clazz, config);
		itemConfigDao.addConfigItem(object);
	}

	public List<ConfigItem> getConfigList(Class clazz, String name) {
		List<Object> list = itemConfigDao.getConfigList(clazz, name);
		List<ConfigItem> configList = new ArrayList<ConfigItem>();
		for (Object object : list) {
			ConfigItem config = new ConfigItem();
			BeanUtils.copyProperties(object, config);
			configList.add(config);
		}
		return configList;
	}

	public ConfigItem getConfigItem(Class clazz, Integer id) {
		Object object = itemConfigDao.getConfigItem(clazz, id);
		ConfigItem config = new ConfigItem();
		BeanUtils.copyProperties(object, config);
		return config;
	}

	public void modifyConfigItem(Class clazz, ConfigItem config) {
		Object object = BeanUtil.getItemConfigForDao(clazz, config);
		itemConfigDao.modifyConfigItem(object);
	}

	public ItemConfigDao getItemConfigDao() {
		return itemConfigDao;
	}

	public void setItemConfigDao(ItemConfigDao itemConfigDao) {
		this.itemConfigDao = itemConfigDao;
	}

}
