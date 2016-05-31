package com.dv.mms.app.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dv.app.mms.app.validator.GRValidator;
import com.dv.mms.app.service.GoodsService;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.GoodsReceiptHeader;


@Controller
@RequestMapping("/gr")
@SessionAttributes("grHead")
public class GoodsReceiptsController {

	private GoodsService goodsService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@Autowired
	public GoodsReceiptsController(GoodsService goodsService) {		
		this.goodsService = goodsService;
	}
	
	@RequestMapping("/draft")
	public String draftPO(@RequestParam("poNo") Integer poNo,Model model) {		
		GoodsReceiptHeader grHeader = goodsService.prepareReceipt(poNo);		
		model.addAttribute("grHead", grHeader);
		return "gr/grheader";
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String newGR(@ModelAttribute("grHead") GoodsReceiptHeader grHeader,BindingResult result, Model model) {
		GRValidator grValidator = new GRValidator();
		grValidator.Validate(grHeader, result);
		if(result.hasErrors()) {
			return "gr/grheader";
		} else {
			goodsService.summarize(grHeader);
			model.addAttribute("grHead",grHeader);
			model.addAttribute("saved","unsaved");
			return "gr/grsummary";
		}
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String SaveGR(@ModelAttribute GoodsReceiptHeader grHead,Model model) {
		goodsService.addGR(grHead);
		model.addAttribute("grHead",grHead);
		model.addAttribute("saved","saved");		
		return "gr/grsummary";
	}
	
	@RequestMapping(value="/item/search/{itemId}", method = RequestMethod.GET) 
	public String getItemHistory(@PathVariable("itemId") Integer itemId,Model model){
		List<GoodsReceiptHeader> grHeaders = goodsService.getReceiptsForItem(itemId,Constants.PAST_TEN);
		model.addAttribute("grheaders",grHeaders);
		return "gr/itemhistory";
	}
}
