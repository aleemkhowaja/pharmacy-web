package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@Entity
@Table(name = "customer")
@Where(clause = "status='A'")
@Getter
@Setter
public class Customer extends Common {

    @ManyToOne
    @JoinColumn(name = "manager")
    private Manager manager;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "type")
    private Type type;

    @Column(name = "cin")
    private String cin;

    @Column(name = "cnss")
    private String cnss;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "credit_limit")
    private String creditLimit;

    @ManyToOne
    @JoinColumn(name = "organization")
    private Organization organization;

    @Column(name = "registeration_number")
    private String registerationNumber;

    @Column(name = "affiliate_number")
    private String affiliateNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    @Column(name = "description")
    private String description;
}
