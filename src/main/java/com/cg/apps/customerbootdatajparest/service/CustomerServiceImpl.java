package com.cg.apps.customerbootdatajparest.service;

import com.cg.apps.customerbootdatajparest.entities.Customer;
import com.cg.apps.customerbootdatajparest.repository.*;
import com.cg.apps.customerbootdatajparest.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class CustomerServiceImpl implements CustomerService
{
    private static final Logger Log= LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer register(Customer customer) 
	{
		// TODO Auto-generated method stub
		boolean exists=customer.getId()!=null && customerRepo.existsById(customer.getId());
        if(exists) 
        {
            System.out.println("customer already exists for id="+customer.getId());
        }
        customer = customerRepo.save(customer);
        return customer;
	}
	
	@Override
	public Customer findById(Long id) {
		Optional<Customer> optional = customerRepo.findById(id);
        if(!optional.isPresent())
        {
            throw new CustomerNotFoundException("Customer not found for id="+id);
        }
        Customer customer=optional.get();
        return customer;
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Customer customer=findById(id);
		customerRepo.delete(customer);		
	}
	
	@Override
	public Customer update(Customer customer) {
		boolean exists=customer.getId()!=null && customerRepo.existsById(customer.getId());
        if(!exists) 
        {
            throw new CustomerNotFoundException("Customer not found for id="+customer.getId()+" can't be updated");
        }
        customer = customerRepo.save(customer);
        return customer;
	}
	
	@Override
	public List<Customer> findAll() 
	{
		List<Customer> customers=customerRepo.findAll();
		return customers;
	}
	
	@Override
	public List<Customer> findByFirstName(String fname) {
		List<Customer> customers=customerRepo.findByFirstName(fname);
		return customers;
	}
	
	@Override
	public List<Customer> findByLastName(String lname) {
		// TODO Auto-generated method stub
		List<Customer> customers=customerRepo.findByLastName(lname);
		return customers;
	}
	
	@Override
	public List<Customer> findByFullName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		List<Customer> list=customerRepo.findByFullName(firstName, lastName);
		return list;
	}

	

}
