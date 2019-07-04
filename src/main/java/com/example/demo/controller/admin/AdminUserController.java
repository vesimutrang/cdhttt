package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String pageAdminUser() {
		return "admin/admin-user";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String pageAdminLogin() {
		return "admin/admin-user-login";
	}
}
