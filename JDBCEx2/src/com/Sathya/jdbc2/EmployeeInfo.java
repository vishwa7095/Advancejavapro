package com.Sathya.jdbc2;

public class EmployeeInfo {
	int empID;
	String empName;
	double empSalary;
	public EmployeeInfo(int empID, String empName, double empSalary) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empSalary = empSalary;
			
	}
	@Override
	public String toString() {
		return "EmployeeInfo [empID=" + empID + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public EmployeeInfo() {
		super();
		
	}
	

}
