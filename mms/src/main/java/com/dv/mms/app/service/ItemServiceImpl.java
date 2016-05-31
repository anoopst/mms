package com.dv.mms.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dv.mms.app.dao.ItemDao;
import com.dv.mms.app.domain.master.MmItem;
import com.dv.mms.app.utils.BeanUtil;
import com.dv.mms.app.web.form.ConfigItem;
import com.dv.mms.app.web.form.ItemForm;

@Transactional
public class ItemServiceImpl implements ItemService {
	
	public ItemServiceImpl() {
	}

	@Autowired
	public ItemServiceImpl(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	private ItemDao itemDao;

	public void addItem(ItemForm itemForm) {
		MmItem item = BeanUtil.getItemForDao(itemForm);
		itemDao.addItem(item);
	}

	public ItemForm getItem(Integer id) {
		MmItem mmItem = itemDao.getItem(id);
		ItemForm item = new ItemForm();
		BeanUtil.setItem(mmItem,item);
		return item;
	}

	public List<ItemForm> getItemList(String name) {
		List<MmItem> itemList = itemDao.getItemList(name);
		List<ItemForm> itemFormList = new ArrayList<ItemForm>();
		
		for (MmItem mmItem : itemList) {
			ItemForm itemForm = new ItemForm();
			BeanUtil.setItem(mmItem, itemForm);
			itemFormList.add(itemForm);
		}
		
		return itemFormList;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public List<ItemForm> getItemList(ItemForm itemForm) {
		MmItem mmItem = BeanUtil.getItemForDao(itemForm);
		List<MmItem> list = itemDao.getItemList(mmItem);
		List<ItemForm> itemList = new ArrayList<ItemForm>();		
		for (MmItem object : list) {
			ItemForm item = new ItemForm();
			BeanUtil.setItem(object, item);
			itemList.add(item);
		}
		
		return itemList;
	}

}
