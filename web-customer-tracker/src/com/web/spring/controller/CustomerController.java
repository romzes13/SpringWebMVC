package com.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.spring.dao.CustomerDAO;
import com.web.spring.entity.Customer;
import com.web.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	@Autowired
	private CustomerService customerService;
	

	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		
		// get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customers to DAO model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	// 
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		// Create a new model attribute to bind form data
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("cusomer") Customer theCustomer){
		
		// Save the customer using service
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
		
	}
	
	
	
}
