package com.pharm.service.interfaces.customer;

import com.pharm.model.Customer;

import java.util.List;
public interface CustomerService {

    Customer create(final Customer customer);

    Customer update(final Customer customer);

    Customer delete(final Customer customer);

    Customer findById(final Long id);

    List<Customer> findAll(final int pageNumber, final int pageSize, final String sortOrder, final String sortBy, final Customer customer);

}
