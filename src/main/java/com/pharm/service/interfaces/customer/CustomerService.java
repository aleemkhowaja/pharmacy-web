package com.pharm.service.interfaces.customer;

import com.pharm.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface CustomerService {

    Customer create(Customer customer);
    Customer update(Customer customer);
    Customer delete(Customer customer);
    @Transactional
    Customer findById(Integer id);
    @Transactional
    List<Customer> findAll();

}
