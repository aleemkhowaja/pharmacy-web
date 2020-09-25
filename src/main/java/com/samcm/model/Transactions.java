package com.samcm.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transactions")
public class Transactions extends Common 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactions_id")
    private Integer transactionsId;
    
    @Column(name = "transaction_type")
    private String transactionType;
    
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Column(name = "amount")
    private Integer amount;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gen_ledger_id", referencedColumnName = "gen_ledger_id")
    private GenLedger genLedger;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_gen_ledger_id", referencedColumnName = "sub_gen_ledger_id")
    private SubGenLedger subGenLedger;

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
    
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public GenLedger getGenLedger()
    {
        return genLedger;
    }

    public void setGenLedger(GenLedger genLedger)
    {
        this.genLedger = genLedger;
    }

    public SubGenLedger getSubGenLedger()
    {
        return subGenLedger;
    }

    public void setSubGenLedger(SubGenLedger subGenLedger)
    {
        this.subGenLedger = subGenLedger;
    }
    
    
}