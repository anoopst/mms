package com.dv.mms.app.web.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POHeader {
	
	private Integer poNo;
	private Date poDate;
	private RequestHeader reqHeader;
	private VendorForm vendor;
	private List<PODetail> poDetails = new ArrayList<PODetail>();
	private String status;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPoNo() {
		return poNo;
	}
	public void setPoNo(Integer poNo) {
		this.poNo = poNo;
	}
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	public RequestHeader getReqHeader() {
		return reqHeader;
	}
	public void setReqHeader(RequestHeader reqHeader) {
		this.reqHeader = reqHeader;
	}
	
	public VendorForm getVendor() {
		return vendor;
	}
	public void setVendor(VendorForm vendor) {
		this.vendor = vendor;
	}
	public List<PODetail> getPoDetails() {
		return poDetails;
	}
	public void setPoDetails(List<PODetail> poDetails) {
		this.poDetails = poDetails;
	}

}
