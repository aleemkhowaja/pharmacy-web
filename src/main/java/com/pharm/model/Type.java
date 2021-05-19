package com.pharm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "type")
@Where(clause = "status='A'")
public class Type extends Common {

    @Column(name = "name")
    private String name;
}
