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
import org.springframework.web.servlet.ModelAndView;

import com.dv.app.mms.app.validator.ItemValidator;
import com.dv.mms.app.service.ItemService;
import com.dv.mms.app.web.form.ItemForm;

@Controller
@RequestMapping("/item")
//@SessionAttributes("itemForm")
public class ItemController {
	
	public ItemController() {
		
	}

	@Autowired
	public ItemController(ItemService itemService) {		
		this.itemService = itemService;
	}

	private ItemService itemService;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newItemForm(Model model) {
		ItemForm itemForm = new ItemForm();
		itemForm.setId(-1);
		model.addAttribute("itemForm",itemForm);
		return "item/form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String newItemForm(@ModelAttribute("itemForm") ItemForm form, BindingResult result, Model model) {
		List<ItemForm> list = itemService.getItemList(form.getName());
		String message = "<b>Name </b>"+ form.getName();
		ItemValidator validator = new ItemValidator();
		//if(form.getId().equals(-1)) {
			validator.Validate(form, list, result);
		//}
		if(!result.hasErrors()) {
			itemService.addItem(form);
			ItemForm itemForm = new ItemForm();
			itemForm.setId(-1);
			model.addAttribute("itemForm",itemForm);
			model.addAttribute("message", message);
		}
		
		return "item/form";
	}
	
	@RequestMapping(value = "/getitem", method = RequestMethod.GET)
	public String getItem(Model model) {
		model.addAttribute("itemForm",new ItemForm());
		return "item/search";
	}

	@RequestMapping(value = "/getitem", method = RequestMethod.POST)
	public String getItemSetup(ItemForm form, Model model) {

		List<ItemForm> itemList = itemService.getItemList(form.getName());
		model.addAttribute("itemForm",form);
		model.addAttribute("itemsList", itemList);		
		return "item/search";
	}

	@RequestMapping(value = "/modify/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model) {
		ItemForm item = itemService.getItem(id);
		model.addAttribute("itemForm", item);
		model.addAttribute("disable","true");
		return "item/form";
	}

	@RequestMapping(value = "/autocomplt/", method = RequestMethod.POST)
	public ModelAndView getAutoComplt(ItemForm itemForm, Model model) {				
		List list = itemService.getItemList(itemForm.getName());
				
		return new ModelAndView("autocomplete","list",list);
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

}