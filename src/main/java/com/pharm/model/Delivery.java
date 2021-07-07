package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "delivery")
@Where(clause = "status='A'")
public class Delivery extends Common {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @ManyToOne
//    @JoinColumn(name = "provider_id")
//    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(name = "transaction_number")
    private String transactionNumber;

    @Column(name = "delivery_note_date")
    private LocalDate deliveryNoteDate;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "delivery_reference")
    private String deliveryReference;

    @Column(name = "value")
    private String value;

    @Column(name = "total")
    private Double total;

}
