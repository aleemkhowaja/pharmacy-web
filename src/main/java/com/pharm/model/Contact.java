package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "contact")
@Where(clause = "status='A'")
public class Contact extends Common{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "manager")
    private String manager;

    @Column(name = "title")
    private String title;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "customer")
    private String customer;

    @Column(name = "provider")
    private String provider;

    @Column(name = "relationship_type")
    private String relationshipType;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "portable")
    private String portable;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "description")
    private String description;


}

