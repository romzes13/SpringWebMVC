package com.web.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//create a query
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get a result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
			
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currrentSession =sessionFactory.getCurrentSession();
		
		// save the customer
		currrentSession.save(theCustomer);
		
		
	}

}
