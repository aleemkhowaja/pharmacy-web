package com.pharm.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product")
@Where(clause = "status='A'")
public class Product extends Common {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "bar_code2")
    private String barCode2;

    @Column(name = "category")
    private String category;

    @Column(name = "therapeutic_class")
    private String therapeuticClass;

    @Column(name = "pharmaceutical_form")
    private String pharmaceuticalForm;

    @ManyToOne
    @JoinColumn(name = "dci")
    private DCI dci;

    @Column(name = "laboratory")
    private String laboratory;

    @Column(name = "range1")
    private String range1;

    @Column(name = "sub_range")
    private String subRange;

    @Column(name = "product_table")
    private String productTable;

    @Column(name = "requires_prescription")
    private String requiresPrescription;

    @Column(name = "product_market")
    private String productMarket;

    @Column(name = "pph")
    private String pph;

    @Column(name = "ppv")
    private String ppv;

    @Column(name = "vat_on_purchase")
    private String vatOnPurchase;

    @Column(name = "vat_on_sale")
    private String vatOnSale;

    @Column(name = "is_refundable")
    private String isRefundable;

    @Column(name = "basis_of_reimbursement")
    private String basisOfReimbursement;

    @Column(name = "presentation")
    private String presentation;

    @Column(name = "excipients")
    private String excipients;

    @Column(name = "adult_dosage")
    private String adultDosage;

    @Column(name = "dosage_for_children")
    private String dosageForChildren;

    @Column(name = "indications")
    private String indications;

    @Column(name = "contraindication_driving")
    private String contraindicationDriving;

    @Column(name = "breast_feeding_contraindication")
    private String breastFeedingContraindication;

    @Column(name = "pregnancy_contraindication")
    private String pregnancyContraindication;

    @Column(name = "product_lab_reference")
    private String productLabReference;

    @Column(name = "conditioning")
    private String conditioning;

    @Column(name = "mono_graph")
    private String monoGraph;

    @Column(name = "description")
    private String description;




}
