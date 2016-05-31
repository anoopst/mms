package com.dv.mms.app.web.form;


public class GoodsReceiptDetail {
	
	private Integer grdNo;
	private GoodsReceiptHeader grHeader;
	private ItemForm item;
	private String grdDesc;
	private double grdQty;
	private double poQty;
	
	public Integer getGrdNo() {
		return grdNo;
	}
	public double getPoQty() {
		return poQty;
	}
	public void setPoQty(double poQty) {
		this.poQty = poQty;
	}
	public void setGrdNo(Integer grdNo) {
		this.grdNo = grdNo;
	}
	public GoodsReceiptHeader getGrHeader() {
		return grHeader;
	}
	public void setGrHeader(GoodsReceiptHeader grHeader) {
		this.grHeader = grHeader;
	}
	public ItemForm getItem() {
		return item;
	}
	public void setItem(ItemForm item) {
		this.item = item;
	}
	public String getGrdDesc() {
		return grdDesc;
	}
	public void setGrdDesc(String grdDesc) {
		this.grdDesc = grdDesc;
	}
	public double getGrdQty() {
		return grdQty;
	}
	public void setGrdQty(double grdQty) {
		this.grdQty = grdQty;
	}

}
