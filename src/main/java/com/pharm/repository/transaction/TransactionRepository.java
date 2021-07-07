package com.pharm.repository.transaction;

import com.pharm.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select distinct t from Transaction  t "
            + " left outer join t.customer c "
            + " where (:transactionId is null or :transactionId= '' or UPPER(t.transactionNumber) like '%'||UPPER(:transactionId)||'%') and "
            + " (:customer is null or :customer= '' or  UPPER(c.lastName) like '%'||UPPER(:customer)||'%')  and "
            + " (:saleDate is null or  t.transDate =:saleDate)  and "
            + " (:createdDate is null or t.createdDate= :createdDate)  and "
            + " (:total is null or  t.amount = :total) and"
            + " (:isDelivered is null or  t.isDelivered = :isDelivered ) and " +
            "   (t.type = :transType)"
    )
    Page<Transaction> filter(@Param("transactionId") final String transactionId,
                             @Param("customer") final String customer,
                             @Param("saleDate") final OffsetDateTime saleDate,
                             @Param("createdDate") final OffsetDateTime createdDate,
                             @Param("total") final BigDecimal total,
                             @Param("isDelivered") final Boolean isDelivered,
                             @Param("transType") final String transType,
                          Pageable pageable);



    @Query("select count(t) from Transaction  t "
            + " left outer join t.customer c "
            + " where (:transactionId is null or :transactionId= '' or UPPER(t.transactionNumber) like '%'||UPPER(:transactionId)||'%') and "
            + " (:customer is null or :customer= '' or  UPPER(c.lastName) like '%'||UPPER(:customer)||'%')  and "
            + " (:saleDate is null or  t.transDate =:saleDate)  and "
            + " (:createdDate is null or t.createdDate= :createdDate)  and "
            + " (:total is null  or  t.amount = :total) and"
            + " (:isDelivered is null or  t.isDelivered = :isDelivered ) and " +
            "   (t.type = :transType)"
    )
    long count(@Param("transactionId") final String transactionId,
               @Param("customer") final String customer,
               @Param("saleDate") final OffsetDateTime saleDate,
               @Param("createdDate") final OffsetDateTime createdDate,
               @Param("total") final BigDecimal total,
               @Param("isDelivered") final Boolean isDelivered,
               @Param("transType") final String transType);

}
