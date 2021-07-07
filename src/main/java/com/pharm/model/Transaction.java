package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="transaction")
@Where(clause = "status='A'")
public class Transaction extends Common {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name="transaction_number")
    private String transactionNumber;

    @Column(name="trans_date")
    private OffsetDateTime transDate;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="trans_status")
    private String transStatus;

    @Column(name="reference")
    private String reference;

    @Column(name="is_delivered")
    private Boolean isDelivered;

    @Column(name="type")
    private String type;

    @OneToMany(mappedBy="transaction", fetch = FetchType.EAGER)
    private Set<TransactionDetails> transactionDetails;
}