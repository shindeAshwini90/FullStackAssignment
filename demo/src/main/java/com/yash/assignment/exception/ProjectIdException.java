package com.yash.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProjectIdException(String arg0) {
		super(arg0);
	}

}