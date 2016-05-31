package com.dv.mms.app.domain.master;


public class MmPodetail implements java.io.Serializable {

	private Integer pdNo;
	private MmPoheader mmPoheader;
	private MmItem mmItem;
	private String poDesc;
	private double poQty;
	private double poRate;
	private double poAmt;
	private double grQty = 0;
	private double giQty = 0;
	
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

	public MmPodetail() {
	}

	public MmPodetail(MmPoheader mmPoheader, MmItem mmItem, String poDesc,
			double poQty, double poRate, double poAmt) {
		this.mmPoheader = mmPoheader;
		this.mmItem = mmItem;
		this.poDesc = poDesc;
		this.poQty = poQty;
		this.poRate = poRate;
		this.poAmt = poAmt;
	}

	public Integer getPdNo() {
		return this.pdNo;
	}

	public void setPdNo(Integer pdNo) {
		this.pdNo = pdNo;
	}

	public MmPoheader getMmPoheader() {
		return this.mmPoheader;
	}

	public void setMmPoheader(MmPoheader mmPoheader) {
		this.mmPoheader = mmPoheader;
	}

	public MmItem getMmItem() {
		return this.mmItem;
	}

	public void setMmItem(MmItem mmItem) {
		this.mmItem = mmItem;
	}

	public String getPoDesc() {
		return this.poDesc;
	}

	public void setPoDesc(String poDesc) {
		this.poDesc = poDesc;
	}

	public double getPoQty() {
		return this.poQty;
	}

	public void setPoQty(double poQty) {
		this.poQty = poQty;
	}

	public double getPoRate() {
		return this.poRate;
	}

	public void setPoRate(double poRate) {
		this.poRate = poRate;
	}

	public double getPoAmt() {
		return this.poAmt;
	}

	public void setPoAmt(double poAmt) {
		this.poAmt = poAmt;
	}

}
