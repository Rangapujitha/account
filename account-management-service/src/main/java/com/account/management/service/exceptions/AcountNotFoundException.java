package com.account.management.service.exceptions;

public class AcountNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	
	public AcountNotFoundException(String id) {
		super("Couldn't find a Account with id: " + id);
	}

}
