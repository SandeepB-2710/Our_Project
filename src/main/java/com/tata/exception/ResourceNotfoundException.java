package com.tata.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotfoundException extends RuntimeException{

	String entityName;
	String attributeName;
	Integer attributeValue;
	
	public ResourceNotfoundException(String entityName, String attributeName, Integer attributeValue) {
		super(String.format("Oops..!! %s not found with %s: %d",entityName,attributeName,attributeValue));
		
		this.entityName = entityName;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}
	
	
}
