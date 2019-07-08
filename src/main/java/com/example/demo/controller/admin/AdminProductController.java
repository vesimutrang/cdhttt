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

<<<<<<< HEAD
=======
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
>>>>>>> branch 'master' of https://github.com/phinguyen202/cdhttt.git
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping(value = "/admin/product")
public class AdminProductController {

	@Autowired
	ProductService productService;
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/phinguyen202/cdhttt.git
	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String pageAdminProduct() {
		return "admin/admin-product";
	}
<<<<<<< HEAD
=======
	@RequestMapping(value = "/datatable", method = RequestMethod.GET)
	@ResponseBody
	public DataTablesOutput<Product> list(@Valid DataTablesInput input) {
		return productService.findAll(input);
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getFormProductEdit(
			@RequestParam(value = "productId", required = false, defaultValue = "") Long productId, Model model) {
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);
		model.addAttribute("products", productService.getAllProduct());
		return "admin/admin-product-form-edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(@Valid Product product, BindingResult bindResult, Model model) {

		model.addAttribute("products", productService.getAllProduct());
		if (bindResult.hasErrors()) {
			return "admin/admin-product-form-edit";
		}

		productRepository.save(product);

		return "redirect:/admin/product";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getFormCategory(Product product, Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "admin/admin-product-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@Valid Product product, BindingResult bindResult, Model model) {

		model.addAttribute("categorys", productService.getAllProduct());
		if (bindResult.hasErrors()) {
			return "admin/admin-product-form";
		}

		productRepository.save(product);

		return "redirect:/admin/product";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam() Long productId) {
		productRepository.deleteById(productId);
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode root = mapper.createObjectNode();

		root.put("status", "success");
		root.put("message", "# " + productId + " Xóa thành công");

		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(root);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

>>>>>>> branch 'master' of https://github.com/phinguyen202/cdhttt.git
}
