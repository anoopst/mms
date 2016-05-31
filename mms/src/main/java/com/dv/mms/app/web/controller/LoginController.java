package com.dv.mms.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dv.mms.app.domain.useraccess.UserAAService;
import com.dv.mms.app.utils.Constants;

@Controller
public class LoginController {

	private UserAAService userAAService;
	private PasswordEncoder passwordEncoder; 

	@Autowired
	public LoginController(UserAAService userAAService,PasswordEncoder passwordEncoder) {
		super();
		this.userAAService = userAAService;
		this.passwordEncoder = passwordEncoder;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public UserAAService getUserAAService() {
		return userAAService;
	}

	public void setUserAAService(UserAAService userAAService) {
		this.userAAService = userAAService;
	}

	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/aa/login")
	public void home() {
	}

	@RequestMapping("/aa/changepassword")
	public void showChangePasswordPage() {
	}

	@RequestMapping(value = "/aa/submitchangepassword", method = RequestMethod.POST)
	public String submitChangePasswordPage(@RequestParam("newpassword1") String newPassword) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = principal.toString();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		
		String password = passwordEncoder.encodePassword(newPassword,null);
		
		userAAService.changePassword(username, password);
		
		SecurityContextHolder.clearContext();
		return "redirect:login";
	}
	
	@RequestMapping(value="/aa/resetpassword", method = RequestMethod.GET)
	public String showResetPasswordPage() {
		return "/aa/resetpassword";
	}
	
	@RequestMapping(value="/aa/resetpassword", method = RequestMethod.POST)
	public String submitResetPassword(@RequestParam("id") Integer id,@RequestParam("name") String name,Model model) {
		userAAService.changePassword(name, passwordEncoder.encodePassword(Constants.DEF_PASSWD,null));
		String message = "<b>Name</b> "+name;		
		model.addAttribute("message", message);
		return "/aa/resetpassword";
	}
}