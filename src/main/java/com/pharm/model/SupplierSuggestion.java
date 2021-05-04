package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="supplier_suggestion")
@Where(clause = "status='A'")
public class SupplierSuggestion extends Common {

    @Column(name="supplier_last_name")
    private String supplierLastName;
    @Column(name="supplier_email")
    private String supplierEmail;
    @Column(name="supplier_phone")
    private String supplierPhone;
    @Column(name="supplier_fax")
    private String supplierFax;
    @Column(name="supplier_webstie")
    private String supplierWebsite;
    @Column(name="supplier_address")
    private String supplierAddress;
    @Column(name="supplier_city")
    private String supplierCity;
    @Column(name="supplier_postal_code")
    private String supplierPostalCode;
    @ManyToOne
    @JoinColumn(name="supplier_country")
    private Country country;
    @Column(name="supplier_description")
    private String supplierDescription;
}

