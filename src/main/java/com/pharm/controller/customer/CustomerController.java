package com.pharm.controller.customer;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Customer;
import com.pharm.service.interfaces.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerController implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private CustomerService customerService;

    public List<Customer> getAllCustomers()
    {
        return customerService.findAll();
    }

    public Customer getCustomerById(Integer id)
    {
        return customerService.findById(id);
    }

    public Customer createCustomer(Customer customer)
    {
        return customerService.create(customer);
    }

    public Customer updateCustomer(Long id, Customer customer)
    {
        customer.setId(id);
        return customerService.update(customer);
    }

    public Customer deleteCustomer(Long id)
    {
        Customer customer = new Customer();
        customer.setId(id);
        return customerService.delete(customer);
    }
}
