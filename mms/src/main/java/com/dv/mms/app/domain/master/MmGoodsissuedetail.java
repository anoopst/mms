package com.dv.mms.app.domain.master;

// Generated Oct 9, 2010 10:54:31 AM by Hibernate Tools 3.2.4.GA

/**
 * MmGoodsissuedetail generated by hbm2java
 */
public class MmGoodsissuedetail implements java.io.Serializable {

	private Integer gidNo;
	private MmGoodsissueheader mmGoodsissueheader;
	private MmItem mmItem;
	private String gidDesc;
	private double gidQty;	

	public MmGoodsissuedetail() {
	}

	public MmGoodsissuedetail(MmGoodsissueheader mmGoodsissueheader,
			MmItem mmItem, String gidDesc, double gidQty, MmVehicle mmVehicle) {
		this.mmGoodsissueheader = mmGoodsissueheader;
		this.mmItem = mmItem;
		this.gidDesc = gidDesc;
		this.gidQty = gidQty;		
	}

	public Integer getGidNo() {
		return this.gidNo;
	}

	public void setGidNo(Integer gidNo) {
		this.gidNo = gidNo;
	}

	public MmGoodsissueheader getMmGoodsissueheader() {
		return this.mmGoodsissueheader;
	}

	public void setMmGoodsissueheader(MmGoodsissueheader mmGoodsissueheader) {
		this.mmGoodsissueheader = mmGoodsissueheader;
	}

	public MmItem getMmItem() {
		return this.mmItem;
	}

	public void setMmItem(MmItem mmItem) {
		this.mmItem = mmItem;
	}

	public String getGidDesc() {
		return this.gidDesc;
	}

	public void setGidDesc(String gidDesc) {
		this.gidDesc = gidDesc;
	}

	public double getGidQty() {
		return this.gidQty;
	}

	public void setGidQty(double gidQty) {
		this.gidQty = gidQty;
	}

}