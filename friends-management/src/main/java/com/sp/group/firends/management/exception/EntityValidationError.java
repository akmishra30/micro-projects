package com.sp.group.firends.management.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

public class EntityValidationError {
	private List<FieldError> fieldErrors;
	private List<ObjectError> objectErrors;
	
	public EntityValidationError(){
		
	}
	
	public EntityValidationError(List<FieldError> fieldErrors, List<ObjectError> objectErrors){
		this.fieldErrors = fieldErrors;
		this.objectErrors = objectErrors;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public List<ObjectError> getObjectErrors() {
		return objectErrors;
	}

	public void setObjectErrors(List<ObjectError> objectErrors) {
		this.objectErrors = objectErrors;
	}

	@Override
	public String toString() {
		return "EntityValidationError [fieldErrors=" + fieldErrors + ", objectErrors=" + objectErrors + "]";
	}

}
