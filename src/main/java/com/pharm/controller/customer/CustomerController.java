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


    public List<Customer> getAllCustomers(
            final int pageNumber,
            final int pageSize,
            final String sortOrder,
            final String sortBy,
            final Customer filter)
    {
        return customerService.findAll(pageNumber, pageSize, sortOrder, sortBy, filter);
    }

    public Customer getCustomerById(Long id){
        return customerService.findById(id);
    }

    public Customer createCustomer(Customer customer){

        return customerService.create(customer);
    }

    public Customer updateCustomer(Long id, Customer customer){
        customer.setId(id);
        return customerService.update(customer);
    }

    public Customer deleteCustomer(Long id){
        Customer customer = new Customer();
        customer.setId(id);
        return customerService.delete(customer);
    }
}
