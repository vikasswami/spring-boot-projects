package com.viks.rest.exception;

public class ApiValidationError extends ApiSubError{
	
	private String object;
	private String field;
	private String rejectedValue;
	private String message;
	
	public ApiValidationError(String object, String field, String rejectedValue, String message) {
		this.object = object;
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}
	
	public ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(String rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
