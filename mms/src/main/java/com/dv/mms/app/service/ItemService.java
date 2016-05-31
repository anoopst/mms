package com.dv.mms.app.service;

import java.util.List;

import com.dv.mms.app.web.form.ItemForm;

public interface ItemService {
	
	void addItem(ItemForm itemForm);
	ItemForm getItem(Integer id);
	List<ItemForm> getItemList(String name);
	List<ItemForm> getItemList(ItemForm itemForm);

}
