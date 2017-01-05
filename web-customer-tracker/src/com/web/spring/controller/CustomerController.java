package com.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.spring.dao.CustomerDAO;
import com.web.spring.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel){
		
		// get customers from DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// add customers to DAO model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
}
