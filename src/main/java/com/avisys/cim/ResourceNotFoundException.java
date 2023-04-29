package com.avisys.cim;


public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String resorceName;
	
	String fieldName;
	
	Long fieldValue;
	
	String mobileNumber;

	public ResourceNotFoundException(String resorceName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s : %s",resorceName,fieldName,fieldValue));
		this.resorceName = resorceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public ResourceNotFoundException(String resorceName, String fieldName, String mobileNumber) {
		super(String.format("%s not found with %s : %s",resorceName,fieldName, mobileNumber));
		this.resorceName = resorceName;
		this.fieldName = fieldName;
		this.mobileNumber = mobileNumber;
	}

	public String getResorceName() {
		return resorceName;
	}

	public void setResorceName(String resorceName) {
		this.resorceName = resorceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Long getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Long fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}	
	
	
}
