package com.dv.mms.app.web.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsReceiptHeader {

	private Integer grNo;
	private Date grDate;
	private POHeader poHeader;
	private List<GoodsReceiptDetail> grDetails = new ArrayList<GoodsReceiptDetail>();
	
	public Integer getGrNo() {
		return grNo;
	}
	public void setGrNo(Integer grNo) {
		this.grNo = grNo;
	}
	public Date getGrDate() {
		return grDate;
	}
	public void setGrDate(Date grDate) {
		this.grDate = grDate;
	}
	public POHeader getPoHeader() {
		return poHeader;
	}
	public void setPoHeader(POHeader poHeader) {
		this.poHeader = poHeader;
	}
	public List<GoodsReceiptDetail> getGrDetails() {
		return grDetails;
	}
	public void setGrDetails(List<GoodsReceiptDetail> grDetails) {
		this.grDetails = grDetails;
	}
}
