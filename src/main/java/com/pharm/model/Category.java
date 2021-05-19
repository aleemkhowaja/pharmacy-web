package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "category")
@Where(clause = "status='A'")
public class Category extends Common {

    @Column(name = "name")
    private String name;
}
