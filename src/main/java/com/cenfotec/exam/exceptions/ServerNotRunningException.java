package com.cenfotec.exam.exceptions;

public class ServerNotRunningException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerNotRunningException() {
		super();
	}

	public ServerNotRunningException(final String message) {
		super(message);
	}

}
