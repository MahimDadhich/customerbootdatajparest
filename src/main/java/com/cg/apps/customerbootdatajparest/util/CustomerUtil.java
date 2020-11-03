package com.cg.apps.customerbootdatajparest.util;

import com.cg.apps.customerbootdatajparest.dto.CustomerDetails;
import com.cg.apps.customerbootdatajparest.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomerUtil {


    public List<CustomerDetails> toDetails(Collection<Customer> customers) {
        List<CustomerDetails> desired = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDetails details = toDetails(customer);
            desired.add(details);
        }
        return desired;
    }

    public CustomerDetails toDetails(Customer customer) {
        CustomerDetails details = new CustomerDetails(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getCustomerKey());
        return details;

    }

}