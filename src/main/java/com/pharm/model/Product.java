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

    @Column(name = "name")
    private String name;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "bar_code2")
    private String barCode2;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "therapeutic_class")
    private TherapeuticClass therapeuticClass;

    @ManyToOne
    @JoinColumn(name = "pharm_form_id")
    private PharmaceuticalForm pharmaceuticalForm;

    @ManyToOne
    @JoinColumn(name = "dci_id")
    private DCI dci;

    @Column(name = "laboratory")
    private String laboratory;

    @ManyToOne
    @JoinColumn(name = "range_id")
    private Range range1;

    @Column(name = "sub_range")
    private String subRange;

    @Column(name = "product_table")
    private String productTable;

    @Column(name = "requires_prescription")
    private Boolean requiresPrescription;

    @Column(name = "product_market")
    private Boolean productMarket;

    @Column(name = "pph")
    private Double pph;

    @Column(name = "ppv")
    private Double ppv;

    @Column(name = "vat_on_purchase")
    private Double vatOnPurchase;

    @Column(name = "vat_on_sale")
    private Double vatOnSale;

    @Column(name = "is_refundable")
    private Boolean isRefundable;

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

    @Column(name = "min_stock")
    private Long minStock;

    @Column(name = "max_stock")
    private Long maxStock;


}
