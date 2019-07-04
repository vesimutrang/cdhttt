package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminMainController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String indexAdmin() {
		return "admin/admin-index";
	}
}
