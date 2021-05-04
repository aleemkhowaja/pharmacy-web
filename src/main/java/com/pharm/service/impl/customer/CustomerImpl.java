package com.pharm.service.impl.customer;

import com.pharm.model.Customer;
import com.pharm.repository.customer.CustomerRepository;
import com.pharm.service.interfaces.customer.CustomerService;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.DELETE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

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
            Customer persited = findById(customer.getId());
            if(persited==null){
                return  null;
            }
        }
        customer.setStatus("A");
        Customer updated =customerRepository.save(customer);
        return updated;
    }

    @Override
    public Customer delete(Customer customer) {
        if(customer!=null && customer.getId()!=null){
            customer.setStatus(DELETE);
        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {

            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            if(optionalCustomer.isPresent())
                return optionalCustomer.get();
        return null;
    }

    @Override
    public List<Customer> findAll(final int pageNumber, final int pageSize, final String sortOrder, final String sortBy)
    {
        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }

        Page<Customer> customers = customerRepository.findAll(PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));
        if(customers.hasContent())
        {
            final Long size = customerRepository.count();
            customers.getContent().get(0).setCount(size);
        }
        return customers.getContent();
    }
}
