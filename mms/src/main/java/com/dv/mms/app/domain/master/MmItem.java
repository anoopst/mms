package com.dv.mms.app.domain.master;

// Generated Oct 10, 2010 3:24:33 PM by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * MmItem generated by hbm2java
 */
public class MmItem implements java.io.Serializable {

	private Integer id;
	private String name;
	private double rate;
	private double rol;
	private double stock;
	private MmHeading mmHeading;
	private MmSubheading mmSubheading;
	private MmDimension mmDimension;
	private MmBrand mmBrand;
	private MmUom mmUom;
	private MmModel mmModel;
	private MmCategory mmCategory;
	private Set mmGoodsreceiptdetails = new HashSet(0);
	private Set mmReqdetails = new HashSet(0);
	private Set mmPodetails = new HashSet(0);
	private Set mmGoodsissuedetails = new HashSet(0);

	public MmItem() {
	}

	public MmItem(String name, double rate, double rol, double stock,
			MmHeading mmHeading, MmSubheading mmSubheading,
			MmDimension mmDimension, MmBrand mmBrand, MmUom mmUom,
			MmModel mmModel, MmCategory mmCategory, Set mmGoodsreceiptdetails,
			Set mmReqdetails, Set mmPodetails, Set mmGoodsissuedetails) {
		this.name = name;
		this.rate = rate;
		this.rol = rol;
		this.stock = stock;
		this.mmHeading = mmHeading;
		this.mmSubheading = mmSubheading;
		this.mmDimension = mmDimension;
		this.mmBrand = mmBrand;
		this.mmUom = mmUom;
		this.mmModel = mmModel;
		this.mmCategory = mmCategory;
		this.mmGoodsreceiptdetails = mmGoodsreceiptdetails;
		this.mmReqdetails = mmReqdetails;
		this.mmPodetails = mmPodetails;
		this.mmGoodsissuedetails = mmGoodsissuedetails;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getRol() {
		return this.rol;
	}

	public void setRol(double rol) {
		this.rol = rol;
	}

	public double getStock() {
		return this.stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public MmHeading getMmHeading() {
		return this.mmHeading;
	}

	public void setMmHeading(MmHeading mmHeading) {
		this.mmHeading = mmHeading;
	}

	public MmSubheading getMmSubheading() {
		return this.mmSubheading;
	}

	public void setMmSubheading(MmSubheading mmSubheading) {
		this.mmSubheading = mmSubheading;
	}

	public MmDimension getMmDimension() {
		return this.mmDimension;
	}

	public void setMmDimension(MmDimension mmDimension) {
		this.mmDimension = mmDimension;
	}

	public MmBrand getMmBrand() {
		return this.mmBrand;
	}

	public void setMmBrand(MmBrand mmBrand) {
		this.mmBrand = mmBrand;
	}

	public MmUom getMmUom() {
		return this.mmUom;
	}

	public void setMmUom(MmUom mmUom) {
		this.mmUom = mmUom;
	}

	public MmModel getMmModel() {
		return this.mmModel;
	}

	public void setMmModel(MmModel mmModel) {
		this.mmModel = mmModel;
	}

	public MmCategory getMmCategory() {
		return this.mmCategory;
	}

	public void setMmCategory(MmCategory mmCategory) {
		this.mmCategory = mmCategory;
	}

	public Set getMmGoodsreceiptdetails() {
		return this.mmGoodsreceiptdetails;
	}

	public void setMmGoodsreceiptdetails(Set mmGoodsreceiptdetails) {
		this.mmGoodsreceiptdetails = mmGoodsreceiptdetails;
	}

	public Set getMmReqdetails() {
		return this.mmReqdetails;
	}

	public void setMmReqdetails(Set mmReqdetails) {
		this.mmReqdetails = mmReqdetails;
	}

	public Set getMmPodetails() {
		return this.mmPodetails;
	}

	public void setMmPodetails(Set mmPodetails) {
		this.mmPodetails = mmPodetails;
	}

	public Set getMmGoodsissuedetails() {
		return this.mmGoodsissuedetails;
	}

	public void setMmGoodsissuedetails(Set mmGoodsissuedetails) {
		this.mmGoodsissuedetails = mmGoodsissuedetails;
	}

}