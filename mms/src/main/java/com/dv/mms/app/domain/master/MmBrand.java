package com.dv.mms.app.domain.master;

// Generated Oct 9, 2010 10:54:31 AM by Hibernate Tools 3.2.4.GA

/**
 * MmBrand generated by hbm2java
 */
public class MmBrand implements java.io.Serializable {

	public MmBrand(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private Integer id;
	private String name;

	public MmBrand() {
	}

	public MmBrand(String name) {
		this.name = name;
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

}
