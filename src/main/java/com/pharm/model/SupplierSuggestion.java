package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="suggestion")
@Where(clause = "status='A'")
public class SupplierSuggestion extends Common {


    @Column(name="last_name")
    private String supplierLastName;

    @Column(name="email")
    private String supplierEmail;

    @Column(name="phone")
    private String supplierPhone;

    @Column(name="fax")
    private String supplierFax;

    @Column(name="webstie")
    private String supplierWebsite;

    @Column(name="address")
    private String supplierAddress;

    @Column(name="city")
    private String supplierCity;

    @Column(name="supplier_postal_code")
    private String supplierPostalCode;

    @Column(name="supplier_country")
    private String supplierCountry;

    @Column(name="supplier_description")
    private String supplierDescription;
}

