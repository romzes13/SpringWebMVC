package com.web.spring.service;

import java.util.List;

import com.web.spring.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	

}
