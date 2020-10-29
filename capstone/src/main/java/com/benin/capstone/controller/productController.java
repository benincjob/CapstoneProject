package com.benin.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.benin.capstone.model.product;
import com.benin.capstone.service.productService;
@Controller
public class productController {
	
	@Autowired
	private productService ProductService;
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		List<product> products = ProductService.findAll();
		model.addAttribute("products", products);
		return "product-list";
	}

}
