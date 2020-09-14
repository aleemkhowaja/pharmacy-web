package com.samcm.util;

import java.util.Date;
import com.samcm.model.Common;

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
		common.setCreatedBy(1);
		common.setCreatedData(new Date());
    }
    
    /**
     * set values in common model while updating record 
     * @param common
     * @param status
     */
    public static void setSaveUpdatedFieldValues(Common common, String status)
    {
		common.setStatus(status);
		common.setModifiedBy(1);
		common.setModifiedDate(new Date());
    }
    
}
