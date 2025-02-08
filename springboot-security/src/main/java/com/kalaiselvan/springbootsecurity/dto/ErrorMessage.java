package com.kalaiselvan.springbootsecurity.dto;

public record ErrorMessage(
		String message,
	    String details,
	    String errorCode
		) {
	
	public ErrorMessage(String message, String details) {
        this(message, details, null);
    }

}
