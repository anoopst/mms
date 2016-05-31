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

import com.dv.app.mms.app.validator.UserValidator;
import com.dv.mms.app.service.UserService;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.UserForm;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	public UserController() {

	}

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	private UserService userService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newUserSetup(Model model) {
		UserForm user = new UserForm();
		user.setId(-1);
		model.addAttribute("user", user);
		model.addAttribute("roles",Constants.ROLES);
		model.addAttribute("disable", "false");
		return "user/form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String newUser(@ModelAttribute("user") UserForm user, BindingResult result,Model model) {
		List<UserForm> list = userService.getUserList(user.getName());
		UserValidator validator = new UserValidator();
		String message = "<b>User Name</b> "+ user.getName() +"<br>";
		if(user.getId().equals(-1)) {
			validator.Validate(user, list, result);
			message+= "<b> password </b>"+Constants.DEF_PASSWD;
		}
		if (!result.hasErrors()) {
			userService.addUser(user);				
			
			UserForm userForm = new UserForm();
			userForm.setId(-1);
			model.addAttribute("user",userForm);
			model.addAttribute("message",message);			
		}
		model.addAttribute("roles",Constants.ROLES);
		return "user/form";
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public String getUser(Model model) {
		model.addAttribute("user",new UserForm());
		return "user/search";
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.POST)
	public String getUserSetup(UserForm user, Model model) {

		List<UserForm> userList = userService.getUserList(user.getName());
		model.addAttribute("user",user);
		model.addAttribute("users", userList);		
		return "user/search";
	}

	@RequestMapping(value = "/modify/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model) {
		UserForm user = userService.getUser(id);
		model.addAttribute("user", user);
		model.addAttribute("roles",Constants.ROLES);
		model.addAttribute("disable", "true");
		return "user/form";
	}

	@RequestMapping(value = "/autocomplt/", method = RequestMethod.POST)
	public ModelAndView getAutoComplt(UserForm userForm, Model model) {				
		List list = userService.getUserList(userForm.getName());
				
		return new ModelAndView("autocomplete","list",list);
	}
	
	public UserService getUserservice() {
		
		return userService;
	}

	public void setUserservice(UserService userService) {
		
		this.userService = userService;
	}

}
