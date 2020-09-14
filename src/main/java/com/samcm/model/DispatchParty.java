package com.samcm.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "dispatch_party")
@Where(clause = "status='A'")
public class DispatchParty extends Common 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispatch_party_id")
    private Integer dispatchPartyId;
    
    @Column(name = "dispatch_party")
    private String dispatchParty;
    
    @Column(name = "dispatch_party_owner")
    private String dispatchPartyOwner;

	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dispatchParty")
    private List<DispatchPartyDetails> requestDispatchPartyDetailsList = new ArrayList<DispatchPartyDetails>();
	 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dispatchLedgerParty")
    private List<DispatchPartyLedger> dispatchPartyLedgers = new ArrayList<DispatchPartyLedger>();
	
    
    public Integer getDispatchPartyId()
    {
        return dispatchPartyId;
    }

    public void setDispatchPartyId(Integer dispatchPartyId)
    {
        this.dispatchPartyId = dispatchPartyId;
    }

    public String getDispatchParty()
    {
        return dispatchParty;
    }

    public void setDispatchParty(String dispatchParty)
    {
        this.dispatchParty = dispatchParty;
    }

    public String getDispatchPartyOwner()
    {
        return dispatchPartyOwner;
    }

    public void setDispatchPartyOwner(String dispatchPartyOwner)
    {
        this.dispatchPartyOwner = dispatchPartyOwner;
    }

    public List<DispatchPartyDetails> getRequestDispatchPartyDetailsList() 
    {
    	return requestDispatchPartyDetailsList; 
    }
	  
    public void setRequestDispatchPartyDetailsList(List<DispatchPartyDetails> requestDispatchPartyDetailsList) 
    { 
    	this.requestDispatchPartyDetailsList = requestDispatchPartyDetailsList; 
    }

	public List<DispatchPartyLedger> getDispatchPartyLedgers() {
		return dispatchPartyLedgers;
	}

	public void setDispatchPartyLedgers(List<DispatchPartyLedger> dispatchPartyLedgers) {
		this.dispatchPartyLedgers = dispatchPartyLedgers;
	}
    
    
	 
}