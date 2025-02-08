package com.kalaiselvan.springbootsecurity.dto;

import static com.kalaiselvan.springbootsecurity.constants.ComConstants.FAILED;

public record ResponseDto<T>(
	    int code,
	    T data,
	    boolean successFlag,
	    String message
	) {


	    // Constructor for error responses
	    public ResponseDto(int code, T data) {
	        this(code, data, false, FAILED);
	    }
	    
	}
