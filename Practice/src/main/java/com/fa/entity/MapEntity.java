package com.fa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "map")
public class MapEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile")
	private String mobile;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, })
	@JoinTable(name = "map_role_mapping", joinColumns = { @JoinColumn(name = "map_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<RoleEntity> role;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<RoleEntity> getRole() {
		return role;
	}

	public void setRole(List<RoleEntity> role) {
		this.role = role;
	}

}
