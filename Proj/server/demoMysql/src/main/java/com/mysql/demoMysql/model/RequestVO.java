package com.mysql.demoMysql.model;
import java.util.HashMap;

public class RequestVO<T> {

	T valueObject;
	private HashMap<String,String> paramMap;
	private DataTableParam dataTableParam; 

	

	public T getValueObject() {
		return valueObject;
	}

	public void setValueObject(T valueObject) {
		this.valueObject = valueObject;
	}
	
	public HashMap<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(HashMap<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public DataTableParam getDataTableParam() {
		return dataTableParam;
	}

	public void setDataTableParam(DataTableParam dataTableParam) {
		this.dataTableParam = dataTableParam;
	}
	
	
}
