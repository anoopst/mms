package com.dv.mms.app.web.form;

public class RequestDetail {
	
	private Integer rdNo;
	private ItemForm item;	
	private double qty;
	private double poQty;
	public double getPoQty() {
		return poQty;
	}

	public void setPoQty(double poQty) {
		this.poQty = poQty;
	}

	private RequestHeader reqHeader;

	public RequestHeader getReqHeader() {
		return reqHeader;
	}

	public void setReqHeader(RequestHeader reqHeader) {
		this.reqHeader = reqHeader;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public Integer getRdNo() {
		return rdNo;
	}

	public void setRdNo(Integer rdNo) {
		this.rdNo = rdNo;
	}

	public ItemForm getItem() {
		return item;
	}

	public void setItem(ItemForm item) {
		this.item = item;
	}

}
