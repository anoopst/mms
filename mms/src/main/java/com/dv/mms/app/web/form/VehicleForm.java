package com.dv.mms.app.web.form;

import java.io.Serializable;

import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder.PropertyReader;

public class VehicleForm implements Serializable, PropertyReader {
	
	private Integer id;
	private String name;
	
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
	
	public String getValue() {
		// TODO Auto-generated method stub
		return this.getId().toString();
	}
	public boolean isCData() {
		// TODO Auto-generated method stub
		return true;
	}

}
