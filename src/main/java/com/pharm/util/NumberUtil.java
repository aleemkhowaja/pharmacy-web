package com.samcm.util;

public class NumberUtil
{
    /**
     * check if number is null then return 0
     * otherwise return num sent with parameter
     * @param num
     * @return
     */
    public static Integer integerNullToZero(Integer num)
    {
	if(num == null)
	    return 0;
        return num;
    }
    
    /**
     * check if number is null 
     * @param num
     * @return
     */
    public static boolean isNullNumber(Integer num)
    {
	return num == null ? true : false;
    }

}
