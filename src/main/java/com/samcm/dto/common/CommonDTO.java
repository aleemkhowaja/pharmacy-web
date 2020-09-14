package com.samcm.dto.common;

import java.sql.Date;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * CommonDTO.java used to send common parameters with response
 */

public class CommonDTO
{
    private String status;

    private Integer createdBy;

    private Date createdData;

    private Integer modifiedBy;

    private Date modifiedDate;

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public Integer getCreatedBy()
    {
	return createdBy;
    }

    public void setCreatedBy(Integer createdBy)
    {
	this.createdBy = createdBy;
    }

    public Date getCreatedData()
    {
	return createdData;
    }

    public void setCreatedData(Date createdData)
    {
	this.createdData = createdData;
    }

    public Integer getModifiedBy()
    {
	return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy)
    {
	this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate()
    {
	return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate)
    {
	this.modifiedDate = modifiedDate;
    }
}