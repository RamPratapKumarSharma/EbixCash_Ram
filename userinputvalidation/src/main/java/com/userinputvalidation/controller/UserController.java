package com.userinputvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.userinputvalidation.dao.UserDaoInterface;
import com.userinputvalidation.dto.User;
import com.userinputvalidation.service.UserServiceInterface;

@Controller
public class UserController {
	@Autowired
	UserDaoInterface dao;

	@Autowired
	UserServiceInterface service;

	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "userinput";
	}

	@PostMapping("/adduserdata")
	public String insertUserData(ModelMap map, User user) {
		if (service.userinputvalidation(user) != 0) {
			map.addAttribute("errMsg", "Sucessfully!!....");
		} else
			map.addAttribute("errMsg", "Data Not Inserted Sucessfully!!!....");

		return "userinput";

	}

}
