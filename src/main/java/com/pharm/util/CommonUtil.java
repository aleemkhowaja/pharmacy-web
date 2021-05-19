package com.pharm.util;

import com.pharm.model.Common;

import java.time.OffsetDateTime;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * Commonutil.java used to
 */
public class CommonUtil
{
    /**
     * set values in common model while inserting record 
     * @param common
     * @param status
     */
    public static void setSaveCreatedFieldValues(Common common, String status)
    {
		common.setStatus(status);
		common.setCreatedDate(OffsetDateTime.now());
    }
    
    /**
     * set values in common model while updating record 
     * @param common
     * @param status
     */
    public static void setSaveUpdatedFieldValues(Common common, String status)
    {
		common.setStatus(status);
		common.setModifiedDate(OffsetDateTime.now());
    }
    
}
