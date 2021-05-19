package com.pharm.service.impl.customer;

import com.pharm.model.Customer;
import com.pharm.model.User;
import com.pharm.repository.customer.CustomerRepository;
import com.pharm.service.interfaces.customer.CustomerService;
import com.pharm.service.interfaces.user.UserService;
import com.pharm.util.CommonUtil;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.ACTIVE;
import static com.pharm.util.CommonConstant.DELETE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service

public class CustomerImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Customer create(Customer customer)
    {
        final User user = userService.findByUsername(customer.getCreatedBy().getUsername());
        customer.setCreatedBy(user);
        customer.setModifiedBy(null);
        CommonUtil.setSaveCreatedFieldValues(customer, ACTIVE);
        return customerRepository.save(customer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Customer update(Customer customer) {
        Customer persited = null;
        if(customer.getId()!=null){
            persited = findById(customer.getId());
            if(persited==null){
                return  null;
            }
        }
        final User user = userService.findByUsername(customer.getModifiedBy().getUsername());
        customer.setCreatedBy(persited.getCreatedBy());
        customer.setModifiedBy(user);

        /**
         * Add Common Fields
         */
        CommonUtil.setSaveUpdatedFieldValues(customer, ACTIVE);
        Customer updated =customerRepository.save(customer);
        return updated;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Customer delete(Customer customer) {

        if(customer == null || customer.getId() == null) return customer;

        CommonUtil.setSaveUpdatedFieldValues(customer, DELETE);
        return customerRepository.save(customer);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
    public Customer findById(Long id) {

            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            if(optionalCustomer.isPresent())
                return optionalCustomer.get();
        return null;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Customer> findAll(final int pageNumber, final int pageSize, final String sortOrder, final String sortBy, final Customer customer)
    {
        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }

        Page<Customer> customers = customerRepository.filter(customer.getLastName(),customer.getCin(), customer.getCnss(), customer.getEmail(),
                customer.getPhone(), customer.getCreditLimit(), customer.getType()  != null ? customer.getType().getId() : null,PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));
        if(customers.hasContent())
        {
            final Long size = customerRepository.count(customer.getLastName(),customer.getCin(), customer.getCnss(), customer.getEmail(),
                    customer.getPhone(), customer.getCreditLimit(), customer.getType()  != null ? customer.getType().getId() : null);
            customers.getContent().get(0).setCount(size);
        }
        return customers.getContent();
    }
}
