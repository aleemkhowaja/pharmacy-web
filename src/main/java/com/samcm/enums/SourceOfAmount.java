package com.samcm.enums;

/**
 * Source of Amount Enum
 * @author Aleem Khowaja
 *
 */
public enum SourceOfAmount {
	
	Cash("Cash"), Online("Online");
	
	 private final String sourceOfAmount;
	 
	 SourceOfAmount(String sourceOfAmount) 
	 { 
		 this.sourceOfAmount = sourceOfAmount; 
	 }
	  
	 public String getValue() 
	 { 
		 return sourceOfAmount; 
	 }
	 
	 /**
		 * get value of enum as per argument which passed from service
		 * @param sourceOfAmount
		 * @return
		 */
		public static String getValue(String sourceOfAmount) 
		{ 
			if(sourceOfAmount.equals(Cash.toString()))
			{
				return Cash.getValue();
			}
			else 
				if(sourceOfAmount.equals(Online.toString()))
			{
				return Online.getValue();
			}
			return ""; 
		}

}
