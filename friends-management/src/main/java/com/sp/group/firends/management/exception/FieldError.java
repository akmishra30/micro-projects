package com.sp.group.firends.management.exception;

public class FieldError {
	private String field;
    private String code;
    private Object invalidValue;
    private String message;
    
    public FieldError(){
    	
    }
    
	public FieldError(String field, String code, Object invalidValue, String message) {
		super();
		this.field = field;
		this.code = code;
		this.invalidValue = invalidValue;
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Object getInvalidValue() {
		return invalidValue;
	}

	public void setInvalidValue(Object invalidValue) {
		this.invalidValue = invalidValue;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FieldError [field=" + field + ", code=" + code + ", invalidValue=" + invalidValue + ", message="
				+ message + "]";
	}

	 
}
