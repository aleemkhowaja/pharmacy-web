package com.pharm.service.interfaces.transaction;

import com.pharm.model.Transaction;

import java.util.List;


public interface TransactionService {

    List<Transaction> findAll(int pageNumber, final int pageSize, final String sortOrder, final String sortBy, final Transaction transaction);

    Transaction findById(final Long id);

    Transaction create(final Transaction transaction);

    Transaction update(final Transaction transaction);

    Transaction delete(final Transaction transaction);
}
