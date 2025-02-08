package com.fa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AddressDto {

	private String id;

	private String address;

	private String city;

	private String pincode;

	@JsonIgnore
	private RelationDto relation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public RelationDto getRelation() {
		return relation;
	}

	public void setRelation(RelationDto relation) {
		this.relation = relation;
	}

}
