package com.example.demo.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping(value = "/admin/category")
public class AdminCategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String pageAdminCategory() {
		return "admin/admin-category";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getFormCategory(Category category, Model model) {
		model.addAttribute("categorys", categoryService.getCategoryAll());
		return "admin/admin-category-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@Valid Category category, BindingResult bindResult, Model model) {

		model.addAttribute("categorys", categoryService.getCategoryAll());
		if (bindResult.hasErrors()) {
			return "admin/admin-category-form";
		}

		categoryService.save(category);

		return "redirect:/admin/category";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getFormCategoryEdit(
			@RequestParam(value = "categoryId", required = false, defaultValue = "") Long categoryId, Model model) {
		Category category = categoryService.getCategoryById(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("categorys", categoryService.getCategoryAll());
		return "admin/admin-category-form-edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(@Valid Category category, BindingResult bindResult, Model model) {

		model.addAttribute("categorys", categoryService.getCategoryAll());
		if (bindResult.hasErrors()) {
			return "admin/admin-category-form-edit";
		}

		categoryService.save(category);

		return "redirect:/admin/category";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam() Long categoryId) {
		categoryService.delete(categoryId);
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode root = mapper.createObjectNode();

		root.put("status", "success");
		root.put("message", "# " + categoryId + " Xóa thành công");

		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(root);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

	@RequestMapping(value = "/datatable", method = RequestMethod.GET)
	@ResponseBody
	public DataTablesOutput<Category> list(@Valid DataTablesInput input) {
		return categoryService.findAll(input);
	}
}
