package com.dv.mms.app.service;

import java.util.List;

import com.dv.mms.app.web.form.GoodsIssueDetail;
import com.dv.mms.app.web.form.GoodsIssueHeader;
import com.dv.mms.app.web.form.GoodsReceiptHeader;

public interface GoodsService {
	
	/*Methods related to Goods Receipts for PO*/
	GoodsReceiptHeader prepareReceipt(Integer poId);
	GoodsReceiptHeader addGR(GoodsReceiptHeader grHeader);
	void summarize(GoodsReceiptHeader grHeader);	
	
	/*Methods related to Goods Issue*/
	Integer addGIRequest(GoodsIssueHeader giHead);
	GoodsIssueHeader getGIRequest(Integer gihNo);
	GoodsIssueDetail getGIItem(Integer gihNo, Integer itemId);
	void addGIItem(Integer gihNo, GoodsIssueDetail giDetail);
	void modifyGI(GoodsIssueHeader giHead);
	void issue(GoodsIssueHeader giHead);
	
	/*Item History*/
	List<GoodsReceiptHeader> getReceiptsForItem(Integer itemId, Integer records);
}
