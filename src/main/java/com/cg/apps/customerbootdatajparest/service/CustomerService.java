package com.cg.apps.customerbootdatajparest.service;

import java.util.List;

import com.cg.apps.customerbootdatajparest.entities.Customer;

public interface CustomerService 
{
	Customer register(Customer customer);
	
	Customer findById(Long id);
	
	void deleteById(Long id);

	Customer update(Customer customer);

	List<Customer>findAll();

	List<Customer> findByFirstName(String name);

	List<Customer> findByLastName(String name);

	List<Customer>findByFullName(String firstName, String lastName);
}
