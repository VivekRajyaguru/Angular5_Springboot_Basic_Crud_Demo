package com.mysql.demoMysql.model;

import java.util.ArrayList;

public class ResponseVO<T> {

	String statusCode;
	String statusDescription;
	T valueObject;
	ArrayList<T> data;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public T getValueObject() {
		return valueObject;
	}
	public void setValueObject(T valueObject) {
		this.valueObject = valueObject;
	}
	public ArrayList<T> getData() {
		return data;
	}
	public void setData(ArrayList<T> data) {
		this.data = data;
	}
	
	
}
