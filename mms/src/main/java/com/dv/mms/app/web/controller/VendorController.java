package com.dv.mms.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dv.app.mms.app.validator.VendorValidator;
import com.dv.mms.app.service.VendorService;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.VendorForm;

@Controller
@RequestMapping("/vendor")
@SessionAttributes("vendor")
public class VendorController {

	public VendorController() {

	}

	@Autowired
	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	private VendorService vendorService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newVendorSetup(Model model) {
		VendorForm vendor = new VendorForm();
		vendor.setId(-1);
		model.addAttribute("vendor", vendor);
		model.addAttribute("type",Constants.VEN_TYPE);

		return "vendor/form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String newVendor(@ModelAttribute("vendor") VendorForm vendor,BindingResult result, Model model) {		
		VendorValidator vendorValidator = new VendorValidator();
		
		if(vendor.getId().equals(-1)) {
		List<VendorForm> list = vendorService.getVendorList(vendor.getName());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list",list);
		map.put("vendor",vendor);
		vendorValidator.validate(vendor,list,result);
		//vendorValidator.validate(map, result);
		}
		model.addAttribute("type",Constants.VEN_TYPE);
		if (!result.hasErrors()) {
			vendorService.addVendor(vendor);	
			VendorForm vendorForm = new VendorForm();
			vendorForm.setId(-1);
			String message = "<b>Name </b>"+vendor.getName();
			model.addAttribute("vendor",vendorForm);
			model.addAttribute("message",message);
		}
		return "vendor/form";
	}

	@RequestMapping(value = "/getvendor", method = RequestMethod.GET)
	public String getVendor(Model model) {
		model.addAttribute("vendor",new VendorForm());
		return "vendor/search";
	}

	@RequestMapping(value = "/getvendor", method = RequestMethod.POST)
	public String getVendorSetup(VendorForm vendor, Model model) {

		List<VendorForm> vendorList = vendorService.getVendorList(vendor.getName());
		model.addAttribute("vendor",vendor);
		model.addAttribute("vendorList", vendorList);		
		return "vendor/search";
	}

	@RequestMapping(value = "/modify/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model) {
		VendorForm vendor = vendorService.getVendor(id);
		model.addAttribute("vendor", vendor);
		model.addAttribute("type",Constants.VEN_TYPE);
		model.addAttribute("disable", "true");
		return "vendor/form";
	}
	
	@RequestMapping(value = "/autocomplt/", method = RequestMethod.POST)
	public ModelAndView getVendorComplt(VendorForm vendorForm, Model model) {				
		List list = vendorService.getVendorList(vendorForm.getName());
				
		return new ModelAndView("autocomplete","list",list);
	}

}
