package com.dv.mms.app.web.form;

import java.util.Date;
import java.util.List;

public class RequestHeader {

	private Integer requestId;
	private UserForm requestor;
	private Date requestDate;
	private List<RequestDetail> requestDetail;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public List<RequestDetail> getRequestDetail() {
		return requestDetail;
	}

	public void setRequestDetail(List<RequestDetail> requestDetail) {
		this.requestDetail = requestDetail;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public UserForm getRequestor() {
		return requestor;
	}

	public void setRequestor(UserForm requestor) {
		this.requestor = requestor;
	}

}
