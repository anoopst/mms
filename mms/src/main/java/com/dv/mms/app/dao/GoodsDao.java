package com.dv.mms.app.dao;

import java.util.List;

import com.dv.mms.app.domain.master.MmGoodsissuedetail;
import com.dv.mms.app.domain.master.MmGoodsissueheader;
import com.dv.mms.app.domain.master.MmGoodsreceiptheader;

public interface GoodsDao {

	public void save(MmGoodsreceiptheader grhead);

	public Integer addGI(MmGoodsissueheader mmGIHeader);

	public MmGoodsissueheader getGI(Integer gihNo);

	public MmGoodsissuedetail getGIItem(Integer gihNo, Integer itemId);

	public void addGID(MmGoodsissuedetail mmGIDetail);

	public void modify(MmGoodsissueheader mmGIHead);

	public void issue(MmGoodsissueheader mmGIHead);

	public List<MmGoodsreceiptheader> getReceiptsForItem(Integer itemId,Integer records);
}
