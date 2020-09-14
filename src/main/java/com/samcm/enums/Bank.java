package com.samcm.enums;

/**
 * Bank enum
 * @author Aleem Khowaja
 *
 */
public enum Bank {
	
	Meezan("Meezan"), 
	Hbl("Hbl"), 
	Nbp("Nbp"), 
	Ubl("Ubl"), 
	Dubaiislami("Dubaiislami"), 
	Bankislami("Bankislami"),
	Habibmetro("Habibmetro"),
	Alhabib("Alhabib"),
	Soneri("Soneri");
	
	 private final String bank;
	 
	 Bank(String bank) 
	 { 
		 this.bank = bank; 
	 }
	  
	 public String getValue() 
	 { 
		 return bank; 
	 }
	 
	 /**
	  * get value of enum as per argument which passed from service
	  * @param bank
	  * @return
	  */
	 public static String getValue(String bank) 
	 { 
		 if(bank.equals(Meezan.toString()))
		 {
			 return Meezan.getValue();
		 }
		else 
			if(bank.equals(Hbl.toString()))
			{
				return Hbl.getValue();
			}
		else 
			if(bank.equals(Nbp.toString()))
			{
				return Nbp.getValue();
			}
		else 
			if(bank.equals(Ubl.toString()))
			{
				return Ubl.getValue();
			}
		else 
			if(bank.equals(Dubaiislami.toString()))
			{
				return Dubaiislami.getValue();
			}
		else 
			if(bank.equals(Bankislami.toString()))
			{
				return Bankislami.getValue();
			}
		else 
			if(bank.equals(Habibmetro.toString()))
			{
				return Habibmetro.getValue();
			}
		else 
			if(bank.equals(Alhabib.toString()))
			{
				return Alhabib.getValue();
			}
		else 
			if(bank.equals(Soneri.toString()))
			{
				return Soneri.getValue();
			}
		 return ""; 
		}
}