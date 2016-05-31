package com.dv.mms.app.web.form;

import java.io.Serializable;

import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder.PropertyReader;


public class ItemForm implements Serializable, PropertyReader {

	public ItemForm() {
		
	}
	public ItemForm(Integer id, String name, double rate, double rol,
			double stock, ConfigItem mmDimension, ConfigItem mmHeading,
			ConfigItem mmBrand, ConfigItem mmUom, ConfigItem mmSubheading,
			ConfigItem mmModel, ConfigItem mmCategory) {
		this.id = id;
		this.name = name;
		this.rate = rate;
		this.rol = rol;
		this.stock = stock;
		this.mmDimension = mmDimension;
		this.mmHeading = mmHeading;
		this.mmBrand = mmBrand;
		this.mmUom = mmUom;
		this.mmSubheading = mmSubheading;
		this.mmModel = mmModel;
		this.mmCategory = mmCategory;
	}
	public ConfigItem getMmCategory() {
		return mmCategory;
	}
	public void setMmCategory(ConfigItem mmCategory) {
		this.mmCategory = mmCategory;
	}
	private Integer id;
	private String name;
	private double rate;
	private double rol;
	private double stock;
	private ConfigItem mmDimension;
	private ConfigItem mmHeading;
	private ConfigItem mmBrand;
	private ConfigItem mmUom;
	private ConfigItem mmSubheading;
	private ConfigItem mmModel;
	private ConfigItem mmCategory;
	
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
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getRol() {
		return rol;
	}
	public void setRol(double rol) {
		this.rol = rol;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public ConfigItem getMmDimension() {
		return mmDimension;
	}
	public void setMmDimension(ConfigItem mmDimension) {
		this.mmDimension = mmDimension;
	}
	public ConfigItem getMmHeading() {
		return mmHeading;
	}
	public void setMmHeading(ConfigItem mmHeading) {
		this.mmHeading = mmHeading;
	}
	public ConfigItem getMmBrand() {
		return mmBrand;
	}
	public void setMmBrand(ConfigItem mmBrand) {
		this.mmBrand = mmBrand;
	}
	public ConfigItem getMmUom() {
		return mmUom;
	}
	public void setMmUom(ConfigItem mmUom) {
		this.mmUom = mmUom;
	}
	public ConfigItem getMmSubheading() {
		return mmSubheading;
	}
	public void setMmSubheading(ConfigItem mmSubheading) {
		this.mmSubheading = mmSubheading;
	}
	public ConfigItem getMmModel() {
		return mmModel;
	}
	public void setMmModel(ConfigItem mmModel) {
		this.mmModel = mmModel;
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
