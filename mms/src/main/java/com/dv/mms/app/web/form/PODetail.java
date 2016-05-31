package com.dv.mms.app.web.form;


public class PODetail {
	
	private Integer pdNo;
	private POHeader poHeader;
	private ItemForm item;
	private String poDesc;
	private double poQty;
	private double poRate;
	private double poAmt;
	private double reqQty;
	private double grQty;
	private double giQty;
	
	public double getGiQty() {
		return giQty;
	}
	public void setGiQty(double giQty) {
		this.giQty = giQty;
	}
	public double getGrQty() {
		return grQty;
	}
	public void setGrQty(double grQty) {
		this.grQty = grQty;
	}
	public double getReqQty() {
		return reqQty;
	}
	public void setReqQty(double reqQty) {
		this.reqQty = reqQty;
	}
	public Integer getPdNo() {
		return pdNo;
	}
	public void setPdNo(Integer pdNo) {
		this.pdNo = pdNo;
	}
	public POHeader getPoHeader() {
		return poHeader;
	}
	public void setPoHeader(POHeader poHeader) {
		this.poHeader = poHeader;
	}
	public ItemForm getItem() {
		return item;
	}
	public void setItem(ItemForm item) {
		this.item = item;
	}
	public String getPoDesc() {
		return poDesc;
	}
	public void setPoDesc(String poDesc) {
		this.poDesc = poDesc;
	}
	public double getPoQty() {
		return poQty;
	}
	public void setPoQty(double poQty) {
		this.poQty = poQty;
	}
	public double getPoRate() {
		return poRate;
	}
	public void setPoRate(double poRate) {
		this.poRate = poRate;
	}
	public double getPoAmt() {
		return poAmt;
	}
	public void setPoAmt(double poAmt) {
		this.poAmt = poAmt;
	}

}
