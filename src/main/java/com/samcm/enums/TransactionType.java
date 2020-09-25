package com.samcm.enums;

/**
 * TransactionType enum
 * @author Aleem Khowaja
 *
 */
public enum TransactionType {
	
	credit("credit"), 
	debit("debit");
	
	
	 private final String transactionType;
	 
	 TransactionType(String transactionType) 
	 { 
		 this.transactionType = transactionType; 
	 }
	  
	 public String getValue() 
	 { 
		 return transactionType; 
	 }
	 
	 /**
	  * get value of enum as per argument which passed from service
	  * @param transactionType
	  * @return
	  */
	 public static String getValue(String transactionType) 
	 { 
		 if(transactionType.equals(credit.toString()))
		 {
		     return credit.getValue();
		 }
		 else 
		    if(transactionType.equals(debit.toString()))
		    {
			return debit.getValue();
		    }
		 return ""; 
		}
}