package com.accenture.beans;

public class Table {
	private static String tableName;
	private static String col1;
	private static String col2;
	private static String col3;
	private static String col4;
	
	public static String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	public String getCol3() {
		return col3;
	}
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	public String getCol4() {
		return col4;
	}
	public void setCol4(String col4) {
		this.col4 = col4;
	}
	@Override
	public String toString() {
		return "Table [tableName=" + tableName + ", col1=" + col1 + ", col2=" + col2 + ", col3=" + col3 + ", col4="
				+ col4 + "]";
	}
	
	public static String[] getField() {
		
		String[] fields = {col1, col2, col3, col4};
		
		return fields;
	}
	
	
	
	
}
