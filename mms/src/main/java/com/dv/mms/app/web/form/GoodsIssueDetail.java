package com.dv.mms.app.web.form;

public class GoodsIssueDetail {

	private Integer gidNo;
	private GoodsIssueHeader giHeader;
	private ItemForm item;
	private String gidDesc;
	private double gidQty;

	public GoodsIssueDetail() {
		super();
	}

	public GoodsIssueDetail(Integer gidNo, GoodsIssueHeader giHeader,
			ItemForm item, String gidDesc, double gidQty) {
		super();
		this.gidNo = gidNo;
		this.giHeader = giHeader;
		this.item = item;
		this.gidDesc = gidDesc;
		this.gidQty = gidQty;
	}

	public Integer getGidNo() {
		return gidNo;
	}

	public void setGidNo(Integer gidNo) {
		this.gidNo = gidNo;
	}

	public GoodsIssueHeader getGiHeader() {
		return giHeader;
	}

	public void setGiHeader(GoodsIssueHeader giHeader) {
		this.giHeader = giHeader;
	}

	public ItemForm getItem() {
		return item;
	}

	public void setItem(ItemForm item) {
		this.item = item;
	}

	public String getGidDesc() {
		return gidDesc;
	}

	public void setGidDesc(String gidDesc) {
		this.gidDesc = gidDesc;
	}

	public double getGidQty() {
		return gidQty;
	}

	public void setGidQty(double gidQty) {
		this.gidQty = gidQty;
	}

}
