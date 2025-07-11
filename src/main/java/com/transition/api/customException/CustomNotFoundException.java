package com.transition.api.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class CustomNotFoundException extends RuntimeException{

	public CustomNotFoundException(String message) {
		super(message);
	}
}
