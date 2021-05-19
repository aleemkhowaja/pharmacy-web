package com.pharm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@MappedSuperclass
@Getter
@Setter
public class Common {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;
	
	@Column(name = "created_date")
	private OffsetDateTime createdDate;

	@ManyToOne
	@JoinColumn(name = "modified_by")
	private User modifiedBy;
	
	@Column(name = "modified_date")
	private OffsetDateTime modifiedDate;

	@Transient
	private Long count;

}