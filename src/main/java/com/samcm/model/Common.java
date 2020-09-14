package com.samcm.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Common {
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_date")
	private Date createdData;
	
	@Column(name = "modified_by")
	private Integer modifiedBy;
	
	@Column(name = "modified_date")
	private Date modifiedDate;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedData() {
		return createdData;
	}

	public void setCreatedData(Date createdData) {
		this.createdData = createdData;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}