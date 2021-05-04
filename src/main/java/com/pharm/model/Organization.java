package com.pharm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "organization")
@Getter
@Setter
public class Organization extends  Common{

    @Column(name = "name")
    private String name;
}
