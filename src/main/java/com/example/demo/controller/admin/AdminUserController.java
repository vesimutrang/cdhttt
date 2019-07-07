package com.example.demo.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
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
	
	@RequestMapping(value = "/datatable", method = RequestMethod.GET)
	@ResponseBody
	public DataTablesOutput<User> list(@Valid DataTablesInput input) {
		return userService.findAll(input);
	}
}
