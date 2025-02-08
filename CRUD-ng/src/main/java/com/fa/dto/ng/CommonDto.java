package com.fa.dto.ng;

import java.util.*;

public class CommonDto {
	
	private String status;
	private Object responsedata;
	private  List<?> responseDto;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResponsedata() {
		return responsedata;
	}
	public void setResponsedata(Object responsedata) {
		this.responsedata = responsedata;
	}
	public List<?> getResponseDto() {
		return responseDto;
	}
	public void setResponseDto(List<?> responseDto) {
		this.responseDto = responseDto;
	}

	
	
}
