package com.pharm.dto.dispatchpartyledger;

import com.pharm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * RequestDispatchPartyLedgerDTO.java used to send request parameters
 */
public class RequestDispatchPartyLedgerDTO
{
	 private Integer dispatchPartyId;
	 
	 private RequestDispatchPartyDetailsDTO requestDispatchPartyDetailsDTO = new RequestDispatchPartyDetailsDTO();
	 
	 private Integer dispatchPartyLedgerId;
    
	 private Integer recievedAmount;
    
	 private Integer remaining;
    
	 private String sourceOfAmount;
    
	 private Integer recievedAccount;
    
	 private String bank;

	 
	 
	 public Integer getDispatchPartyId() {
		return dispatchPartyId;
	 }

	 public void setDispatchPartyId(Integer dispatchPartyId) {
		this.dispatchPartyId = dispatchPartyId;
	 }

	public RequestDispatchPartyDetailsDTO getRequestDispatchPartyDetailsDTO() {
		return requestDispatchPartyDetailsDTO;
	 }

	 public void setRequestDispatchPartyDetailsDTO(RequestDispatchPartyDetailsDTO requestDispatchPartyDetailsDTO) {
		this.requestDispatchPartyDetailsDTO = requestDispatchPartyDetailsDTO;
	 }

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
}