package com.dv.mms.app.web.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsIssueHeader {

	private Integer gihNo;
	private Date gihDate;
	private List<GoodsIssueDetail> giDetails = new ArrayList();
	private VehicleForm vehicle;
	private UserForm user;
	private String status;

	public GoodsIssueHeader() {
		super();
	}

	public GoodsIssueHeader(Integer gihNo, Date gihDate,
			List<GoodsIssueDetail> giDetails, VehicleForm vehicle,
			UserForm user, String status) {
		super();
		this.gihNo = gihNo;
		this.gihDate = gihDate;
		this.giDetails = giDetails;
		this.vehicle = vehicle;
		this.user = user;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getGihNo() {
		return gihNo;
	}

	public void setGihNo(Integer gihNo) {
		this.gihNo = gihNo;
	}

	public Date getGihDate() {
		return gihDate;
	}

	public void setGihDate(Date gihDate) {
		this.gihDate = gihDate;
	}

	public List<GoodsIssueDetail> getGiDetails() {
		return giDetails;
	}

	public void setGiDetails(List<GoodsIssueDetail> giDetails) {
		this.giDetails = giDetails;
	}

	public VehicleForm getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleForm vehicle) {
		this.vehicle = vehicle;
	}

	public UserForm getUser() {
		return user;
	}

	public void setUser(UserForm user) {
		this.user = user;
	}
}
