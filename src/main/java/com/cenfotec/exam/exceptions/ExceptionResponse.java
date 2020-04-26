package com.cenfotec.exam.exceptions;

public class ExceptionResponse {
	private String errorMessage;
	private String requestedURL;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURL() {
		return requestedURL;
	}

	public void callerURL(final String requestedURL) {
		this.requestedURL = requestedURL;
	}
}
