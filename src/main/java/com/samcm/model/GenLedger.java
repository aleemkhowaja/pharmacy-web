package com.samcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gen_ledger")
public class GenLedger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gen_ledger_id")
    private Integer genLedgerId;
    
    @Column(name = "gl_code")
    private Integer glCode;
    
    @Column(name = "description")
    private String description;
    
    public Integer getGenLedgerId()
    {
        return genLedgerId;
    }
    public void setGenLedgerId(Integer genLedgerId)
    {
        this.genLedgerId = genLedgerId;
    }
    public Integer getGlCode()
    {
        return glCode;
    }
    public void setGlCode(Integer glCode)
    {
        this.glCode = glCode;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

}
