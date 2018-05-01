package com.mysql.demoMysql.model;
import java.util.ArrayList;

public class DataTableEntity<T> {
	private int totalRecords;
	private int first;
	private int rows;
	private ArrayList<T> data;
	
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
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
	public ArrayList<T> getData() {
		return data;
	}
	public void setData(ArrayList<T> data) {
		this.data = data;
	}
}
