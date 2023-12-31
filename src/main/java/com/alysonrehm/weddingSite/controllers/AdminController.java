package com.alysonrehm.weddingSite.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alysonrehm.weddingSite.models.LoginUser;
import com.alysonrehm.weddingSite.models.User;
import com.alysonrehm.weddingSite.services.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "loginReg.jsp";
	}
	
	
//LOGOUT
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.setAttribute("userId", null);
		 return "redirect:/";
	 }

	 
//REGISTER NEW USERS 
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	     
		 User user = userService.register(newUser, result);
	     
	     if(result.hasErrors()) {
	         model.addAttribute("newLogin", new LoginUser());
	         return "loginReg.jsp";
	     }
	     	     session.setAttribute("userId", user.getId());
	 
	     return "adminHome.jsp";
	 }

	 
//LOGIN USERS
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
	     
	     User user = userService.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "loginReg.jsp";
	     }
	 
	     session.setAttribute("userId", user.getId());
	 
	     return "adminHome.jsp";
	 }
}
