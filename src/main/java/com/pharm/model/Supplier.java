package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="supplier")
@Where(clause = "status='A'")
public class Supplier extends Common {

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="fax")
    private String fax;

    @Column(name="webstie")
    private String website;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    @Column(name="description")
    private String description;
}

