package com.Sathya.jdbc2;


public class DataBaseClient {

	public static void main(String[] args) {
		
	EmployeeDao employeeDao=new EmployeeDao();
		
		int res1= employeeDao.save(new EmployeeInfo(1001, "bharath", 100000));
		System.out.println("Data inserted successfully.."+res1);
		
		int res2 = employeeDao.save(new EmployeeInfo(1002, "aslam", 200000));
		System.out.println("Data inserted successfully.."+res2);
		
		EmployeeInfo res3 =employeeDao.findbyId(1001);
	    System.out.println(res3);
		 
		
		//delete
	
		int deletecount=employeeDao.deleteBySalary(1001);
	if(deletecount ==1)
		{
		System.out.println("data deleted successfully");
		}
		else
		{
		System.out.println("data deletion fail");
		}
		
		//update the empSalary
		int res4=employeeDao.updateSalary(10000,5000);
				System.out.println(res4);
	}

	}
