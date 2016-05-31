package com.dv.mms.app.web.form;

import java.io.Serializable;

import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder.PropertyReader;

public class VendorForm implements Serializable, PropertyReader {
	
	private Integer id;
	private String name;
	private String venType;
	private String add1;
	private String add2;
	private String add3;
	private String add4;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVenType() {
		return venType;
	}
	public void setVenType(String venType) {
		this.venType = venType;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getAdd3() {
		return add3;
	}
	public void setAdd3(String add3) {
		this.add3 = add3;
	}
	public String getAdd4() {
		return add4;
	}
	public void setAdd4(String add4) {
		this.add4 = add4;
	}
	
	public String getValue() {
		return this.getId().toString();
	}
	public boolean isCData() {
		return true;
	}
}
