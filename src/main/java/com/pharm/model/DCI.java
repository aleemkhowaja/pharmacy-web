package com.pharm.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="dci")
@Getter
@Setter
public class DCI extends  Common{

    @Column(name = "name")
    private String name;
}
