package com.dv.mms.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dv.mms.app.service.GoodsService;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.GoodsIssueHeader;
import com.dv.mms.app.web.form.RequestHeader;

@Controller
@RequestMapping("/gi")
@SessionAttributes("giHead")
public class GoodsIssueHeadController {
	
	private GoodsService goodsService;

	@Autowired
	public GoodsIssueHeadController(GoodsService goodsService) {
		super();
		this.goodsService = goodsService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String setupForm(Model model) {
		GoodsIssueHeader giHead = new GoodsIssueHeader();
		giHead.setStatus(Constants.GI_DRAFTED);
		model.addAttribute("giHead",giHead);
		return "gi/giheader";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createRequest(@ModelAttribute GoodsIssueHeader giHead,
			Model model) {		
		Integer gihNo = goodsService.addGIRequest(giHead);
		return "redirect:/gi/" + gihNo;
	}
	
	@RequestMapping("/{gihNo}")
	public String manageRequest(@PathVariable("gihNo") Integer gihNo,
			Model model) {
		GoodsIssueHeader giHead = goodsService.getGIRequest(gihNo);
		model.addAttribute("giHead", giHead);
		return "gi/gisummary";
	}
	
	@RequestMapping("/{gihNo}/save")
	public String completeRequest(@PathVariable("gihNo") Integer gihNo,
			Model model) {
		GoodsIssueHeader giHead = goodsService.getGIRequest(gihNo);
		giHead.setStatus(Constants.GI_ISSUED);
		goodsService.issue(giHead);
		return "redirect:/gi/" + gihNo;
	}

}
