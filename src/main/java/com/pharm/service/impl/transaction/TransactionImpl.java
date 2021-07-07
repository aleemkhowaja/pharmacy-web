package com.pharm.service.impl.transaction;

import com.pharm.model.Transaction;
import com.pharm.model.User;
import com.pharm.repository.transaction.TransactionRepository;
import com.pharm.service.interfaces.transaction.TransactionService;
import com.pharm.service.interfaces.user.UserService;
import com.pharm.util.CommonUtil;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.*;
import static java.time.OffsetDateTime.now;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service

public class TransactionImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Transaction create(Transaction transaction)
    {
        /**
         * If customer id is null it means customer didn't set from frontend
         */
        if(transaction.getCustomer() != null && transaction.getCustomer().getId() == null) {
            transaction.setCustomer(null);
        }
        final User user = userService.findByUsername(transaction.getCreatedBy().getUsername());
        transaction.setCreatedBy(user);
        transaction.setModifiedBy(null);
        transaction.setTransDate(now());
        CommonUtil.setSaveCreatedFieldValues(transaction, ACTIVE);

        transactionRepository.save(transaction);

        transaction.setTransactionNumber(SALE_TRAN+"-"+transaction.getId());
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Transaction update(Transaction transaction) {
        Transaction persited = null;
        if(transaction.getId()!=null){
            persited = findById(transaction.getId());
            if(persited==null){
                return  null;
            }
        }
        final User user = userService.findByUsername(transaction.getModifiedBy().getUsername());
        transaction.setCreatedBy(persited.getCreatedBy());
        transaction.setModifiedBy(user);

        /**
         * Add Common Fields
         */
        CommonUtil.setSaveUpdatedFieldValues(transaction, ACTIVE);
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Transaction delete(Transaction transaction) {

        if(transaction == null || transaction.getId() == null) return transaction;

        CommonUtil.setSaveUpdatedFieldValues(transaction, DELETE);
        return transactionRepository.save(transaction);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
    public Transaction findById(Long id) {

            Optional<Transaction> transaction = transactionRepository.findById(id);
            if(transaction.isPresent())
                return transaction.get();
        return null;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Transaction> findAll(final int pageNumber,
                                  final int pageSize,
                                  final String sortOrder,
                                  final String sortBy,
                                  final Transaction transaction)
    {
        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }
        final String customerName = transaction.getCustomer() == null ? null :  transaction.getCustomer().getLastName();
        BigDecimal totalAmount = null;
        if(transaction.getAmount() != null)
        {
            totalAmount =  transaction.getAmount().equals("") ? null :  transaction.getAmount();
        }
        Page<Transaction> transactions = transactionRepository.filter(
                transaction.getTransactionNumber(),
                customerName,
                transaction.getTransDate(),
                transaction.getCreatedDate(),
                totalAmount,
                transaction.getIsDelivered(),
                transaction.getType(),
                PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));
        if(transactions.hasContent())
        {
            final Long size = transactionRepository.count( transaction.getTransactionNumber(),
                    customerName,
                    transaction.getTransDate(),
                    transaction.getCreatedDate(),
                    totalAmount,
                    transaction.getIsDelivered(),
                    transaction.getType());
            transactions.getContent().get(0).setCount(size);
        }
        return transactions.getContent();
    }
}
