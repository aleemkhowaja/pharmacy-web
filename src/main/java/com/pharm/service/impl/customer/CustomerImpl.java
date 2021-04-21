package com.pharm.service.impl.customer;

import com.pharm.model.Customer;
import com.pharm.repository.customer.CustomerRepository;
import com.pharm.service.interfaces.customer.CustomerService;
import com.samcm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        customer.setStatus("A");
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        if(customer.getId()!=null){
            Customer persited = findById(customer.getId().intValue());
            if(persited==null){
                return  null;
            }
        }
        Customer updated =customerRepository.save(customer);
        return updated;
    }

    @Override
    public Customer delete(Customer customer) {
        if(customer!=null && customer.getId()!=null){
            customer.setStatus(CommonConstant.DELETE);
        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {

            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            if(optionalCustomer.isPresent())
                return optionalCustomer.get();
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }
}
