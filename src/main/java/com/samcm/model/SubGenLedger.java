package com.samcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gen_ledger")
public class SubGenLedger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_gen_ledger_id")
    private Integer subGenLedgerId;
    
    @Column(name = "gl_code")
    private Integer glCode;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gen_ledger_id", referencedColumnName = "gen_ledger_id")
    private GenLedger genLedger;
    
    public Integer getSubGenLedgerId()
    {
        return subGenLedgerId;
    }
    public void setSubGenLedgerId(Integer subGenLedgerId)
    {
        this.subGenLedgerId = subGenLedgerId;
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
    public GenLedger getGenLedger()
    {
        return genLedger;
    }
    public void setGenLedger(GenLedger genLedger)
    {
        this.genLedger = genLedger;
    }

}
