package com.dv.mms.app.web.controller;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report")
public class ReportsController {

	private DataSource dataSource;

	@Autowired
	public ReportsController(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@RequestMapping("/{reportname}/{format}")
	public String generateReport(@PathVariable("reportname") String reportName,
			@PathVariable("format") String format, ModelMap modelMap) {
		System.out.println("reportname "+reportName+" format"+format);
		modelMap.put("dataSource",dataSource);
		modelMap.put("format", format);		
		return  reportName;
	}

	//pPO_no
	@RequestMapping("/PO/pdf")
	public String generatePOReport(@RequestParam("poNo") Integer poNo, ModelMap modelMap) {		
		modelMap.put("dataSource",dataSource);
		modelMap.put("format", "pdf");	
		modelMap.put("pPO_no", poNo.toString());
		return  "PO";
	}
	
	@RequestMapping("/GRDate/jsp")
	public String showRepGRDate() {
		return "reports/grRepDateWise";
	}
	
	@RequestMapping("/PODate/jsp")
	public String showRepPODate() {
		return "reports/poDateWise";
	}
	
	@RequestMapping("/STKDate/jsp")
	public String showRepSTKDate() {
		return "reports/stkDateWise";
	}
	
	@RequestMapping("/GIDate/jsp")
	public String showRepGIDate() {
		return "reports/giDateWise";
	}
	
	@RequestMapping("/POVEN/jsp")
	public String showRepPOVEN() {
		return "reports/poVenWise";
	}
	
	@RequestMapping("/GRVEN/jsp")
	public String showRepGRVEN() {
		return "reports/grVenWise";
	}
	
	@RequestMapping("/STKITM/jsp")
	public String showRepSTKITM() {
		return "reports/stkitemWise";
	}
	
	@RequestMapping("/STKSUM/jsp")
	public String showRepSTKSUM() {
		return "reports/stkSUM";
	}
	
	@RequestMapping("/STKCHART/jsp")
	public String showRepSTKCHART() {
		return "reports/stkCHART";
	}
	
	@RequestMapping("/GRDate/{format}")
	public String generateGRDate(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,ModelMap modelMap) {
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		return "GRDate";
	}
	
	@RequestMapping("/PODate/{format}")
	public String generatePODate(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,ModelMap modelMap) {
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		return "PODate";
	}
	
	@RequestMapping("/STKDate/{format}")
	public String generateSTKDate(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,ModelMap modelMap) {
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		return "STKDate";
	}
	
	@RequestMapping("/GIDate/{format}")
	public String generateGIDate(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,ModelMap modelMap) {
		System.out.println("GIDATE");
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		return "GIDate";
	}
	
	@RequestMapping("/POVEN/{format}")
	public String generatePOVEN(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,@RequestParam("venNo") Integer vendorNo,ModelMap modelMap) {
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		modelMap.put("VendorNo", vendorNo);
		return "POVEN";
	}
	
	@RequestMapping("/GRVEN/{format}")
	public String generateGRVEN(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,@RequestParam("venNo") Integer vendorNo,ModelMap modelMap) {
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		modelMap.put("VendorNo", vendorNo);
		return "GRVEN";
	}
	
	@RequestMapping("/STKITM/{format}")
	public String generateSTKITM(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,@RequestParam("itemNo") Integer itemNo,ModelMap modelMap) {
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		modelMap.put("itemno", itemNo);
		return "STKITM";
	}
	
	@RequestMapping("/STKSUM/{format}")
	public String generateSTKSUM(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,ModelMap modelMap) {
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		return "STKSUM";
	}
	
	@RequestMapping("/STKCHART/{format}")
	public String generateSTKCHART(@PathVariable("format") String format,@RequestParam("fromDate") Date fromDate,@RequestParam("toDate") Date toDate,ModelMap modelMap) {
		modelMap.put("dataSource",dataSource);
		modelMap.put("format",format);
		modelMap.put("FromDate",fromDate);
		modelMap.put("ToDate",toDate);
		return "STKCHART";
	}
}
