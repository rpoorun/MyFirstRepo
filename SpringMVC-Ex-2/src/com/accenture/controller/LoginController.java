package com.accenture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// this controller class contains all process and method of the Login page
@Controller
public class LoginController {

	// this method return on the login page
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	// this method react to the logout button and return on the login page
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}

	// this method react to the login button and validate the password and username
	@RequestMapping("/validate")
	public String validateUser(@RequestParam("uname") String uname, @RequestParam("pword") String pword, Model model) {
		if ("admin".equalsIgnoreCase(uname) && "root".equalsIgnoreCase(pword)) {

			// return to the Product Menu Page
			return "index";
		} else {

			String invalid = "Invalid Username/Password";
			model.addAttribute("invalid", invalid);
			
			// return to the login page with status invalid
			return "login";
		}

	}

}
