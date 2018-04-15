package com.accenture.exceptions;

public class InvalidFeedbackException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//create constructor 
	public InvalidFeedbackException(String msg) {
		super(msg);
	}

}
