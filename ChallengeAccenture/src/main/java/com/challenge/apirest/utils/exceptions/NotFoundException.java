package com.challenge.apirest.utils.exceptions;

/** 
 * Status 404 
 * */

public class NotFoundException extends RuntimeException{
	
	private static final String DESCRIPTION = "Not Found Exception (400)";
	
	public NotFoundException(String message) {
		super(DESCRIPTION + ". " + message);
	}

}
