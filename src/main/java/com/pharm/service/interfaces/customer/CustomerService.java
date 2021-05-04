package com.pharm.service.interfaces.customer;

import com.pharm.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface CustomerService {

    Customer create(final Customer customer);

    Customer update(final Customer customer);

    Customer delete(final Customer customer);

    @Transactional
    Customer findById(final Long id);

    @Transactional
    List<Customer> findAll(final int pageNumber, final int pageSize, final String sortOrder, final String sortBy);

}
