package com.pharm.controller.transaction;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Transaction;
import com.pharm.service.interfaces.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private TransactionService transactionService;

    public List<Transaction> getAllTransaction(
            final int pageNumber,
            final int pageSize,
            final String sortOrder,
            final String sortBy,
            final Transaction filter)
    {
        return transactionService.findAll(pageNumber, pageSize, sortOrder, sortBy, filter);
    }

    public Transaction getTransactionById(final Long id){
        return transactionService.findById(id);
    }

    public Transaction createTransaction(final Transaction transaction){

        return transactionService.create(transaction);
    }

    public Transaction updateTransaction(final Long id, final Transaction transaction){
        transaction.setId(id);
        return transactionService.update(transaction);
    }

    public Transaction deleteTransaction(final Long id){
        Transaction transaction = new Transaction();
        transaction.setId(id);
        return transactionService.delete(transaction);
    }
}
