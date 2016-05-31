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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dv.app.mms.app.validator.ItemConfigValidator;
import com.dv.mms.app.domain.master.MmBrand;
import com.dv.mms.app.domain.master.MmCategory;
import com.dv.mms.app.domain.master.MmDimension;
import com.dv.mms.app.domain.master.MmHeading;
import com.dv.mms.app.domain.master.MmModel;
import com.dv.mms.app.domain.master.MmSubheading;
import com.dv.mms.app.domain.master.MmUom;
import com.dv.mms.app.service.ItemConfigService;
import com.dv.mms.app.web.form.ConfigItem;

@Controller
@RequestMapping("/iconfig")
@SessionAttributes("conobject")
public class ItemConfigController {

	public ItemConfigController() {
		super();
	}

	@Autowired
	public ItemConfigController(ItemConfigService itemConfigService) {
		super();
		this.itemConfigService = itemConfigService;		
	}

	private ItemConfigService itemConfigService;	

	@RequestMapping(value = "/new/{id}", method = RequestMethod.GET)
	public String editItemConfig(@PathVariable("id") Integer id, Model model) {
		Class clazz = getConfigClass(id);
		ConfigItem configItem = new ConfigItem();		
		model.addAttribute("config",clazz.getSimpleName());
		model.addAttribute("conobject",configItem);
		model.addAttribute("submitVal","/iconfig/save/"+id);
		return "iconfig/form";
	}

	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
	public String save(@ModelAttribute("conobject") ConfigItem config,BindingResult result, Model model, @PathVariable("id") Integer id) {
		if (config != null) {			
			Class clazz = getConfigClass(id);			
			List list = itemConfigService.getConfigList(clazz, config.getName());
			ItemConfigValidator iconfValidator = new ItemConfigValidator();
			iconfValidator.Validate(config, list, result);
			if(!result.hasErrors()) {
				String message = "<b>Name</b> "+config.getName();
				itemConfigService.addConfigItem(clazz, config);
				model.addAttribute("message",message);
				model.addAttribute("conobject",new ConfigItem());
			}
			model.addAttribute("config",clazz.getSimpleName());			
			model.addAttribute("submitVal","/iconfig/save/"+id);			
		}

		return "iconfig/form";
	}
	
	@RequestMapping(value = "/geticonfig/{id}", method = RequestMethod.GET)
	public String getIConfig(@PathVariable("id") Integer id, Model model) {
		Class clazz = getConfigClass(id);
		model.addAttribute("config",clazz.getSimpleName());
		model.addAttribute("conobject",new ConfigItem());
		model.addAttribute("ConfigId",id);
		return "iconfig/search";
	}

	@RequestMapping(value = "/geticonfig/{id}", method = RequestMethod.POST)
	public String getIConfig(@PathVariable("id") Integer id,ConfigItem config, Model model) {
		Class clazz = getConfigClass(id);
		List<ConfigItem> configList = itemConfigService.getConfigList(clazz, config.getName());
		model.addAttribute("conobject",config);
		model.addAttribute("configlist", configList);
		model.addAttribute("ConfigId",id);
		model.addAttribute("config",clazz.getSimpleName());
		return "iconfig/search";
	}

	@RequestMapping(value = "/autocomplt/{id}", method = RequestMethod.POST)
	public ModelAndView getAutoComplt(@PathVariable("id") Integer id,ConfigItem config, Model model) {
		Class clazz = getConfigClass(id);		
		List list = itemConfigService.getConfigList(clazz, config.getName());
				
		return new ModelAndView("autocomplete","list",list);
	}
	
	@RequestMapping(value = "/modify/{configId}/{id}")
	public String editConfig(@PathVariable("configId") Integer configId, @PathVariable("id") Integer id, Model model) {
		Class clazz = getConfigClass(configId);
		model.addAttribute("config",clazz.getSimpleName());
		ConfigItem config = itemConfigService.getConfigItem(clazz, id);
		model.addAttribute("conobject",config);
		model.addAttribute("submitVal","/iconfig/save/"+configId);
		return "iconfig/form";
	}

	public ItemConfigService getItemConfigService() {
		return itemConfigService;
	}

	public void setItemConfigService(ItemConfigService itemConfigService) {
		this.itemConfigService = itemConfigService;
	}
	
	private Class getConfigClass(Integer id) {
		Class clazz = null;
		switch (id) {
		case 1: clazz = MmBrand.class;			
				break;
		case 2: clazz = MmCategory.class;			
				break;
		case 3: clazz = MmDimension.class;			
				break;
		case 4: clazz = MmHeading.class;
				break;				
		case 5: clazz = MmSubheading.class;
				break;
		case 6: clazz = MmUom.class;
				break;
		case 7: clazz = MmModel.class;
				break;
		}
		
		return clazz;
	}
}
