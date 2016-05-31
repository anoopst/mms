package com.dv.mms.app.web.form;

import java.io.Serializable;

import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder.PropertyReader;

public class UserForm implements Serializable, PropertyReader {

	private Integer id;
	private String name;
	private String role;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
