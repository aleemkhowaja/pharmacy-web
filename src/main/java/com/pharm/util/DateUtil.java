package com.samcm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 
	 * @param date with yyyy-MM-dd format in String
	 * @return String date
	 */
	public static String dateToString(Date date)
	{
		if(date == null) return "";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

}
