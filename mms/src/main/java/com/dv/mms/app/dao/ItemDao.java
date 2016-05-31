package com.dv.mms.app.dao;

import java.util.List;

import com.dv.mms.app.domain.master.MmItem;

public interface ItemDao {

	void addItem(MmItem item);
	List<MmItem> getItemList(String name);
	List<MmItem> getItemList(MmItem mmItem);
	MmItem getItem(Integer id);
	void modifyItem(MmItem item);
}
