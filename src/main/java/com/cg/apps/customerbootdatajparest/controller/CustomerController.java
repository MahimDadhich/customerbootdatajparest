package com.cg.apps.customerbootdatajparest.controller;

import com.cg.apps.customerbootdatajparest.dto.CreateCustomerRequest;
import com.cg.apps.customerbootdatajparest.dto.CustomerDetails;
import com.cg.apps.customerbootdatajparest.dto.UpdateCustomerRequest;
import com.cg.apps.customerbootdatajparest.entities.Customer;
import com.cg.apps.customerbootdatajparest.exception.CustomerNotFoundException;
import com.cg.apps.customerbootdatajparest.service.CustomerService;
import com.cg.apps.customerbootdatajparest.util.CustomerUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerUtil customerUtil;
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails add(@RequestBody @Valid CreateCustomerRequest requestData) {
        Customer customer = new Customer(requestData.getFirstName(), requestData.getLastName(), requestData.getCustomerKey());
        customer= service.register(customer);
        CustomerDetails details = customerUtil.toDetails(customer);
        return details;
    }

    @PutMapping("/update")
    public CustomerDetails update(@RequestBody @Valid UpdateCustomerRequest requestData) {
    	
        Customer customer = new Customer(requestData.getFirstName(),requestData.getLastName(),requestData.getCustomerKey());
        customer.setId(requestData.getId());
        customer = service.update(customer);
        CustomerDetails details = customerUtil.toDetails(customer);
        return details;
    }


    @GetMapping("/get/{id}")
    public CustomerDetails fetchCustomer(@PathVariable("id") Long id) {
        Customer customer = service.findById(id);
        CustomerDetails details = customerUtil.toDetails(customer);
        return details;
    }
    
    @GetMapping("/by/firstname/{name}")
    public List<CustomerDetails> findCustomerByName(@PathVariable("name") @NotBlank @Size(min = 2, max = 10) String name) {
        List<Customer> customers = service.findByFirstName(name);
        List<CustomerDetails> response = customerUtil.toDetails(customers);
        return response;
    }
    
    @GetMapping("/by/lastname/{name}")
    public List<CustomerDetails> findCustomerByLastName(@PathVariable("name") @NotBlank @Size(min = 2, max = 10) String name) {
        List<Customer> customers = service.findByLastName(name);
        List<CustomerDetails> response = customerUtil.toDetails(customers);
        return response;
    }
    
    @GetMapping("/by/fullname/{firstName}/{lastName}")
    public List<CustomerDetails>findByFullName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        List<Customer>list=service.findByFullName(firstName, lastName);
        List<CustomerDetails>response=customerUtil.toDetails(list);
        return response;
    }

   @GetMapping
    public List<CustomerDetails> fetchAll() {
        List<Customer> customer= service.findAll();
        List<CustomerDetails> response = customerUtil.toDetails(customer);
        return response;
    }


    @DeleteMapping("/remove/{id}")
    public String removeCustomer(@PathVariable("id") Long id) 
    {
        service.deleteById(id);
        String response = "Removed Customer with id=" + id;
        return response;
    }


}