package com.samcm.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * Copyright 2020, Geeks Solutions Geeks Solutions retains all ownership rights
 * to this source code
 * 
 * @author: Alim Khowaja
 *
 *  PropertiesUtil.java used to class properties management
 */
public class PropertiesUtil
{
    /**
     * copy properties from one object to another
     * 
     * @param from
     * @param to
     */
    public static void copyProperties(Object from, Object to)
    {
		Field[] fields = from.getClass().getDeclaredFields();
		for(Field field : fields)
		{
		   
				/**
				 * 
				 *  Field fieldFrom = from.getClass().getDeclaredField(field.getName());
				    fieldFrom.setAccessible(true);
				    List value = (List) fieldFrom.get(from);
				 * 
				 */
		    	
				if(!field.getType().getCanonicalName().equals("java.util.List"))
				{
					try {
						
						/**
						 * get field value from source (from) object
						 */
						Field fieldFrom = from.getClass().getDeclaredField(field.getName());
						fieldFrom.setAccessible(true);
						Object value = fieldFrom.get(from);
						
						/**
					     * set field value to destination (to) object
					     */
					    Field fieldTo = to.getClass().getDeclaredField(field.getName());
					    fieldTo.setAccessible(true);
					    fieldTo.set(to, value);
					    
						
					} catch (Exception e) {
					}
				}
	
		}
    }

    /**
     * copy properties of list to another list
     * @param sourceList
     * @return
     */
    public static List copyListToList(List sourceList, List destinationList)
    {
		destinationList = (List) sourceList.stream().collect(Collectors.toList());
		return destinationList;
    }
    
    /**
     * empty Properties to Null values
     * @param from
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public static void emptyPropertiesToNull(Object from) 
    {
    	Field[] fields = from.getClass().getDeclaredFields();
		for(Field field : fields)
		{
			if(field.getType().toString().contains("String"))
			{
				try {
					Field fieldFrom = from.getClass().getDeclaredField(field.getName());
					fieldFrom.setAccessible(true);
					String value = (String) fieldFrom.get(from);
					if(!value.isEmpty()) continue;
					fieldFrom.set(from, null);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
    }
}
