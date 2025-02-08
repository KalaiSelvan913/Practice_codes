package com.fa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class CrudEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="team")
	private String team;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="companyname")
	private String companyName;
	
	@Column(name="pre_experience")
	private String pre_exp;
	
	@Column(name="base64value")
	private String base64Value;
	


	public String getBase64Value() {
		return base64Value;
	}

	public void setBase64Value(String base64Value) {
		this.base64Value = base64Value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPre_exp() {
		return pre_exp;
	}

	public void setPre_exp(String pre_exp) {
		this.pre_exp = pre_exp;
	}


	

}
