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

import com.dv.app.mms.app.validator.VehicleValidator;
import com.dv.mms.app.service.VehicleService;
import com.dv.mms.app.web.form.VehicleForm;

@Controller
@RequestMapping("/vehicle")
@SessionAttributes("vehicle")
public class VehicleController {
	
	public VehicleController() {

	}

	@Autowired
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	private VehicleService vehicleService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newVehicleSetup(Model model) {
		VehicleForm vehicle = new VehicleForm();
		vehicle.setId(-1);
		model.addAttribute("vehicle", vehicle);

		return "vehicle/form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String newUser(@ModelAttribute("vehicle") VehicleForm vehicle, BindingResult result, Model model) {
		List<VehicleForm> list = vehicleService.getVehicleList(vehicle.getName());
		VehicleValidator validator = new VehicleValidator();
		//if(vehicle.getId().equals(-1)) {
			validator.Validate(vehicle, list, result);
		//}		
		if (!result.hasErrors()) {
			String message = "<b>Name</b> "+ vehicle.getName() +"<br>";
			vehicleService.addVehicle(vehicle);
			VehicleForm vehicle1 = new VehicleForm();
			vehicle1.setId(-1);
			model.addAttribute("vehicle", vehicle1);
			model.addAttribute("message",message);
			
		}
		
		return "vehicle/form";
	}

	@RequestMapping(value = "/getvehicle", method = RequestMethod.GET)
	public String getVehicle(Model model) {
		model.addAttribute("vehicle",new VehicleForm());
		return "vehicle/search";
	}

	@RequestMapping(value = "/getvehicle", method = RequestMethod.POST)
	public String getVehicleSetup(VehicleForm vehicle, Model model) {

		List<VehicleForm> vehicleList = vehicleService.getVehicleList(vehicle.getName());
		model.addAttribute("vehicle",vehicle);
		model.addAttribute("vehicles", vehicleList);		
		return "vehicle/search";
	}

	@RequestMapping(value = "/modify/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model) {
		VehicleForm vehicle = vehicleService.getVehicle(id);
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("disable", "true");
		return "vehicle/form";
	}
	
	@RequestMapping(value = "/autocomplt/", method = RequestMethod.POST)
	public ModelAndView getAutoComplt(VehicleForm vehicleForm, Model model) {				
		List list = vehicleService.getVehicleList(vehicleForm.getName());
				
		return new ModelAndView("autocomplete","list",list);
	}

	public VehicleService getVehicleservice() {
		
		return vehicleService;
	}

	public void setVehicleservice(VehicleService vehicleService) {
		
		this.vehicleService = vehicleService;
	}


}
