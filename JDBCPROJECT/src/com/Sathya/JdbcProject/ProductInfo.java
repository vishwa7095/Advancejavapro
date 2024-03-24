package com.Sathya.JdbcProject;

public class ProductInfo {
	int proId;
	String proName;
	Double proPrice;
	public ProductInfo(int proId, String proName, Double proPrice) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proPrice = proPrice;
		
	}
	@Override
	public String toString() {
		return "ProductInfo [proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + "]";
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
