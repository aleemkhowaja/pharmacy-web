package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
@Where(clause = "status='A'")
@Getter
@Setter
public class Doctor extends Common {

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "cin")
    private String cin;

    @Column(name = "cnss")
    private String cnss;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

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

    @Column(name = "description")
    private String description;
}
