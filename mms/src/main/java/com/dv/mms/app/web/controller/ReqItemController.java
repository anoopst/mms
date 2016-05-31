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
import org.springframework.web.bind.support.SessionStatus;

import com.dv.mms.app.service.ItemService;
import com.dv.mms.app.service.RequestService;
import com.dv.mms.app.web.form.ItemForm;
import com.dv.mms.app.web.form.RequestDetail;
import com.dv.mms.app.web.form.RequestHeader;

@Controller
@RequestMapping("/request/{reqId}/item")
@SessionAttributes(types = RequestDetail.class)
public class ReqItemController {

	private RequestService requestService;
	private ItemService itemService;

	@Autowired
	public ReqItemController(RequestService requestService,ItemService itemService) {
		this.requestService = requestService;
		this.itemService = itemService;
	}

	public ReqItemController() {
	}

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}

	@RequestMapping(value = "/{itemId}/new", method = RequestMethod.POST)
	public String requestNewItem(@PathVariable("reqId") Integer reqId,@PathVariable("itemId") Integer itemId,Model model) {
		RequestDetail reqDetail = requestService.getRequestItem(reqId, itemId);
		model.addAttribute("reqItem", reqDetail);
		return "request/reqitem";
	}

	/*@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String requestNewItem(@PathVariable("reqId") Integer reqId,
								 @ModelAttribute RequestDetail reqDetail, 
								 Model model,
								 SessionStatus status) {
		requestService.addRequestItem(reqId, reqDetail);
		status.setComplete();
		return "request/{reqId}";
	}*/
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String requestNewItem(@PathVariable("reqId") Integer reqId,@ModelAttribute("reqItem") RequestDetail reqDetail, Model model){//,SessionStatus status) {		
		requestService.addRequestItem(reqId, reqDetail);
		//status.setComplete();
		RequestHeader reqHead = requestService.getRequest(reqId);
		model.addAttribute("reqHead", reqHead);
		return "request/summary";
		//return "redirect:/request/" + reqId;
	}
	
	@RequestMapping(value = "/search1", method = RequestMethod.POST)
	public String requestSearchItem(@PathVariable("reqId") Integer reqId,Model model) {
		ItemForm itemForm = new ItemForm();
		model.addAttribute("reqId",reqId);
		model.addAttribute("itemForm",itemForm);
		return "request/itemsearch";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String requestDisplayItem(@PathVariable("reqId") Integer reqId,
			 @ModelAttribute ItemForm itemForm,Model model) {
		List<ItemForm> itemFormList = itemService.getItemList(itemForm); 
		model.addAttribute("itemForm",itemForm);
		model.addAttribute("itemFormList",itemFormList);
		model.addAttribute("reqId",reqId);
		return "request/itemsearch";
	}
	
	@RequestMapping(value="/{itemId}/edit",method = RequestMethod.GET)
	public String editRequestItem(@PathVariable("reqId") Integer reqId,@PathVariable("itemId") Integer itemId,Model model) {	
		RequestDetail reqDetail = requestService.getRequestItem(reqId, itemId);
		model.addAttribute("reqItem",reqDetail);
		return "request/reqitem";
	}
	
	@RequestMapping(value="/{itemId}/edit",method = RequestMethod.POST)
	public String editRequestItem1(@PathVariable("reqId") Integer reqId,@PathVariable("itemId") Integer itemId,Model model) {
		RequestDetail reqDetail = requestService.getRequestItem(reqId, itemId);
		model.addAttribute("reqItem", reqDetail);
		return "request/reqitem";
	}
	
	@RequestMapping("/{itemId}/del")
	public String delRequestItem(@PathVariable("reqId") Integer reqId,@PathVariable("itemId") Integer itemId,Model model) {
		requestService.delRequestItem(reqId, itemId);
		return "request/{reqId}";
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

}
