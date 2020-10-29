package com.benin.capstone.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.benin.capstone.model.customer;
import com.benin.capstone.service.customerService;
@Controller
public class customerController {

	@Autowired
	private customerService CustomerService;
	
	@GetMapping(value = {"/", "index"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/customers")
	public String getcustomers(Model model) {
		List<customer> customers = CustomerService.findAll();
		model.addAttribute("customers", customers);
		return "customer-list";
	
	}
	
	@GetMapping(value="/customers/{customer_id}")
	public String getCustomerById(Model model, @PathVariable Long customer_id) {		
		
		customer customer = null;
		
		try {
			
			customer = CustomerService.findById(customer_id);
		} catch(Exception e) {
			String errorMessage = e.getMessage();
			model.addAttribute("errorMessage", "customer not found.");
		}
		
		model.addAttribute("customer", customer);
		return "customer";
	} 
	@GetMapping(value = {"/customers/add"})
	public String showAddcustomer(Model model) {
		customer customer = new customer();
		model.addAttribute("add", true);
		model.addAttribute("customer", customer);
		return "customer-edit";
	}
	
	@PostMapping(value="/customers/add")
	public String addcustomer(Model model,
			                  @ModelAttribute("customer") customer customer) {
		try {
			
			customer newcustomer = CustomerService.save(customer);
			return "redirect:/customers/" + String.valueOf(newcustomer.getCustomer_id());
			
		} catch(Exception e) {
		
			String errorMessage = e.getMessage();
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("add", true);
			return "customer-edit";
		}
	}
	
	@GetMapping(value= {"/customers/{customerId}/edit"})
	public String showEditcustomer(Model model, 
			                       @PathVariable Long customer_id) {
		customer customer = null;
		try {
			
			customer = CustomerService.findById(customer_id);
			
		} catch(Exception e) {
			model.addAttribute("errorMessage", "customer not found");
		}
		
		model.addAttribute("add", false);
		model.addAttribute("customer", customer);
		
		return "customer-edit";
	}
	
	@PostMapping(value= {"/customer/{customer_id}/edit"})
	public String updatecustomer(Model model,
			                     @PathVariable Long customer_id,
			                     @ModelAttribute("customer") customer customer) {
		try {
			customer.setCustomer_id(customer_id);
			CustomerService.update(customer);
			return "redirect:/customers/" + String.valueOf(customer.getCustomer_id());
			
		} catch(Exception e) {
			
			String errorMessage = e.getMessage();
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("add", false);
			return "customer-edit";
		}
	}
	
}
	
