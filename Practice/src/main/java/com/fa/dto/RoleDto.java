package com.fa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RoleDto {

	private String id;

	private String role;

	@JsonIgnore
	private MapDto map;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public MapDto getMap() {
		return map;
	}

	public void setMap(MapDto map) {
		this.map = map;
	}

}
