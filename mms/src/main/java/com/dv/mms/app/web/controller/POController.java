package com.dv.mms.app.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dv.app.mms.app.validator.POValidator;
import com.dv.mms.app.service.POService;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.POHeader;

@Controller
@RequestMapping("/po")
@SessionAttributes("poHead")
public class POController {
	
	private POService poService;
	//private RequestService requestService;
	
	
	public POService getPoService() {
		return poService;
	}

	@Autowired
	public POController(POService poService) { //,RequestService requestService) {
		super();
		this.poService = poService;		
		//this.requestService = requestService;
	}

	public void setPoService(POService poService) {
		this.poService = poService;
	}
	
	@RequestMapping("/draft")
	public String draftPO(@RequestParam("reqId") Integer reqId,Model model) {		
		POHeader poHead = poService.preparePO(reqId);		
		model.addAttribute("poHead", poHead);
		model.addAttribute("types",Constants.PO_TYPES);
		return "po/poheader";
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String newPO(@ModelAttribute("poHead") POHeader poHeader,BindingResult result,Model model) {		
		POValidator poValidator = new POValidator();
		poValidator.Validate(poHeader, result);
		if(result.hasErrors()) {
			model.addAttribute("types",Constants.PO_TYPES);
			return "po/poheader";
		}
		else {
			poService.summarize(poHeader);
			model.addAttribute("poHead",poHeader);
			model.addAttribute("saved","unsaved");
			return "po/posummary";
		}
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String SavePO(@ModelAttribute POHeader poHeader,Model model) {
		POHeader po = poService.addPO(poHeader);
		model.addAttribute("poHead", po);
		System.out.println(po.getPoNo()+" "+po.getPoDate());
		model.addAttribute("saved","saved");
		return "po/posummary";
	}
	
	@RequestMapping("/list")
	public String getList(Model model) {
		List status = new ArrayList();
		status.add(Constants.REQUEST_PO_RAISED);
		List list = poService.getPOList(status);		
		model.addAttribute("poList", list);
		return "po/polist";
	}
	
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public String searchPO(Model model) {
		model.addAttribute("poHead",new POHeader());
		return "po/search";
	}
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public String searchListPO(POHeader poHeader,Model model) {
		List status = new ArrayList();
		status.add(Constants.REQUEST_PO_RAISED);
		List<POHeader> poList = poService.getPOList(poHeader,status);
		model.addAttribute("poHead",poHeader);
		model.addAttribute("poList",poList);
		return "po/search";
	}
}
