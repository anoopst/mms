package com.dv.mms.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dv.mms.app.service.GoodsService;
import com.dv.mms.app.service.ItemService;
import com.dv.mms.app.web.form.GoodsIssueDetail;
import com.dv.mms.app.web.form.GoodsIssueHeader;
import com.dv.mms.app.web.form.ItemForm;

@Controller
@RequestMapping("/gi/{gihNo}/item")
@SessionAttributes(types = GoodsIssueDetail.class)
public class GoodsIssueDetailController {
	
	private GoodsService goodsService;
	private ItemService itemService;
	
	public GoodsIssueDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public GoodsIssueDetailController(GoodsService goodsService,
			ItemService itemService) {
		super();
		this.goodsService = goodsService;
		this.itemService = itemService;
	}
	
	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public ItemService getItemService() {
		return itemService;
	}
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	} 
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String requestSearchItem(@PathVariable("gihNo") Integer gihNo,Model model) {
		System.out.println("search form");
		ItemForm itemForm = new ItemForm();
		model.addAttribute("gihNo",gihNo);
		model.addAttribute("itemForm",itemForm);
		System.out.println("search end");
		return "gi/itemsearch";
	}

	@RequestMapping(value = "/search1", method = RequestMethod.POST)
	public String requestDisplayItem(@PathVariable("gihNo") Integer gihNo,
			 @ModelAttribute ItemForm itemForm,Model model) {
		List<ItemForm> itemFormList = itemService.getItemList(itemForm); 
		model.addAttribute("itemForm",itemForm);
		model.addAttribute("itemFormList",itemFormList);
		model.addAttribute("gihNo",gihNo);
		return "gi/itemsearch";
	}
	
	@RequestMapping(value = "/{itemId}/new", method = RequestMethod.POST)
	public String requestNewItem(@PathVariable("gihNo") Integer gihNo,@PathVariable("itemId") Integer itemId,Model model) {
		GoodsIssueDetail giItem = goodsService.getGIItem(gihNo, itemId);
		model.addAttribute("giItem", giItem);
		return "gi/giitem";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String requestNewItem(@PathVariable("gihNo") Integer gihNo,@ModelAttribute("giItem") GoodsIssueDetail giDetail, Model model){		
		goodsService.addGIItem(gihNo, giDetail);
		GoodsIssueHeader giHead = goodsService.getGIRequest(gihNo);
		model.addAttribute("giHead", giHead);
		return "gi/gisummary";
	}
}
