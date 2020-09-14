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
import org.hibernate.annotations.Where;

@Entity
@Table(name = "dispatch_party_ledger")
@Where(clause = "status='A'")
public class DispatchPartyLedger extends Common {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispatch_party_ledger_id")
    private Integer dispatchPartyLedgerId;
    
    @Column(name = "recieved_amount")
    private Integer recievedAmount;
    
    @Column(name = "remaining")
    private Integer remaining;
    
    @Column(name = "source_of_amount")
    private String sourceOfAmount;
    
    @Column(name = "recieved_account")
    private Integer recievedAccount;
    
    @Column(name = "bank")
    private String bank;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dispatch_party_id", referencedColumnName = "dispatch_party_id")
    private DispatchParty dispatchLedgerParty;

	public Integer getDispatchPartyLedgerId() {
		return dispatchPartyLedgerId;
	}

	public void setDispatchPartyLedgerId(Integer dispatchPartyLedgerId) {
		this.dispatchPartyLedgerId = dispatchPartyLedgerId;
	}

	public Integer getRecievedAmount() {
		return recievedAmount;
	}

	public void setRecievedAmount(Integer recievedAmount) {
		this.recievedAmount = recievedAmount;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

	public String getSourceOfAmount() {
		return sourceOfAmount;
	}

	public void setSourceOfAmount(String sourceOfAmount) {
		this.sourceOfAmount = sourceOfAmount;
	}

	public Integer getRecievedAccount() {
		return recievedAccount;
	}

	public void setRecievedAccount(Integer recievedAccount) {
		this.recievedAccount = recievedAccount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public DispatchParty getDispatchLedgerParty() {
		return dispatchLedgerParty;
	}

	public void setDispatchLedgerParty(DispatchParty dispatchLedgerParty) {
		this.dispatchLedgerParty = dispatchLedgerParty;
	}

}