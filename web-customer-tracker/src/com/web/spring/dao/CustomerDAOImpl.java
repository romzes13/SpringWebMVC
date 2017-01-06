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
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get a result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
			
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currrentSession =sessionFactory.getCurrentSession();
		
		// save/update the customer
		currrentSession.saveOrUpdate(theCustomer);
		
		
	}


	@Override
	public Customer getCustomer(int theId) {
	
		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// Retrieve/read from database using primary key
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
