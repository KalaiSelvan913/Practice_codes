package com.fa.dto;

import java.util.List;

public class MapDto {

	private String id;

	private String name;

	private String mobile;

	private List<RoleDto> role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<RoleDto> getRole() {
		return role;
	}

	public void setRole(List<RoleDto> role) {
		this.role = role;
	}

}
