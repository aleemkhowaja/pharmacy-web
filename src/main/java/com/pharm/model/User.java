package com.pharm.model;

import lombok.*;
import org.hibernate.annotations.Where;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Where(clause="status='A'")
public class User extends Common {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

}