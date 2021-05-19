package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "pharmaceutical_form")
@Where(clause = "status='A'")
public class PharmaceuticalForm extends Common {

    @Column(name = "name")
    private String name;
}
