package com.samcm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "dispatch_party_details")
@Where(clause = "status='A'")
public class DispatchPartyDetails extends Common  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispatch_party_details_id")
    private Integer dispatchPartyDetailsId;
    
    @Column(name = "date_of")
    @Temporal(TemporalType.TIMESTAMP)
    private  Date dateOf;
    
    @Column(name = "quality")
    private String quality;
    
    @Column(name = "tons")
    private Integer tons;
    
    @Column(name = "rate")
    private Integer rate;
    
    @Column(name = "amount")
    private Integer amount;
    
    @Column(name = "rebate")
    private Integer rebate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dispatch_party_id", referencedColumnName = "dispatch_party_id")
    private DispatchParty dispatchParty;
    
 
    @Transient
    private Integer dispatchpartyId;


    public Integer getDispatchPartyDetailsId()
    {
        return dispatchPartyDetailsId;
    }

    public void setDispatchPartyDetailsId(Integer dispatchPartyDetailsId)
    {
        this.dispatchPartyDetailsId = dispatchPartyDetailsId;
    }
    
    public Date getDateOf()
    {
        return dateOf;
    }

    public void setDateOf(Date dateOf)
    {
        this.dateOf = dateOf;
    }

    public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public Integer getTons()
    {
        return tons;
    }

    public void setTons(Integer tons)
    {
        this.tons = tons;
    }

    public Integer getRate()
    {
        return rate;
    }

    public void setRate(Integer rate)
    {
        this.rate = rate;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public Integer getRebate()
    {
        return rebate;
    }

    public void setRebate(Integer rebate)
    {
        this.rebate = rebate;
    }

    public DispatchParty getDispatchParty()
    {
        return dispatchParty;
    }

    public void setDispatchParty(DispatchParty dispatchParty)
    {
        this.dispatchParty = dispatchParty;
    }

    public Integer getDispatchpartyId()
    {
        return dispatchpartyId;
    }

    public void setDispatchpartyId(Integer dispatchpartyId)
    {
        this.dispatchpartyId = dispatchpartyId;
    }
}