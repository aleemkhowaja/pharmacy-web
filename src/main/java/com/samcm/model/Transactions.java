package com.samcm.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DispatchParty.java")
public class Transactions extends Common 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactions_id")
    private Integer transactionsId;
    
    @Column(name = "transaction_type")
    private String transactionType;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "amount")
    private Integer amount;

    public Integer getTransactionsId()
    {
        return transactionsId;
    }

    public void setTransactionsId(Integer transactionsId)
    {
        this.transactionsId = transactionsId;
    }

    public String getTransactionType()
    {
        return transactionType;
    }

    public void setTransactionType(String transactionType)
    {
        this.transactionType = transactionType;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }
}