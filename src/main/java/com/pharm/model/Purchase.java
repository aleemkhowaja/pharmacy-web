package com.pharm.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "purchase")
@Where(clause = "status='A'")
public class Purchase extends Common {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @ManyToOne
//    @JoinColumn(name = "provider_id")
//    private Provider provider;


    @Column(name = "avail")
    private String avail;

    @Column(name = "could")
    private Double could;

    @Column(name = "total")
    private Double total;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "transaction_number")
    private String transactionNumber;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date_of_delivery")
    private LocalDate dateOfDelivery;

    @Column(name = "delivery_reference")
    private String deliveryReference;

    @Column(name = "value")
    private String value;
}
