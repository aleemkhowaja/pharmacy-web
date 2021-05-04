package com.pharm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country  extends  Common {

    @Column(name = "name")
    private String name;
}
