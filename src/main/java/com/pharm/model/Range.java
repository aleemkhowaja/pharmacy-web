package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "range1")
@Where(clause = "status='A'")
public class Range extends Common {

    @Column(name = "name")
    private String name;
}
