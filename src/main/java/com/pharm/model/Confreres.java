package com.pharm.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "confreres")
@Where(clause = "status='A'")
public class Confreres extends Common {

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "CIN")
    private String cin;
    @Column(name = "CNSS")
    private String cnss;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "manager")
    private Manager manager;



}
