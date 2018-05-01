package com.mysql.demoMysql.model;



public class DataTableParam {

	private int first;
	private int rows;
	private String sortField;
	private int sortOrder;
	private String searchValue;
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	@Override
	public String toString() {
		return "DataTableParam [first=" + first + ", rows=" + rows + ", sortField=" + sortField + ", sortOrder="
				+ sortOrder + ", searchValue=" + searchValue + "]";
	}
	
	
	
}

