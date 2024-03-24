package com.Sathya.JdbcProject;

import java.util.List;

public class ProductClient {

	public static void main(String[] args) {
		
	ProductDao product = new ProductDao();
	int res1=product.CreateProductTable();
		System.out.println("create table successfully..."+res1);
		//inserting:
		int res2=product.saveProduct(new ProductInfo(101,"laptop",50000.0));
		System.out.println("data is inserted successfully"+res2);
		int res3=product.saveProduct(new ProductInfo(102,"mobile",16000.0));
		System.out.println("data is inserted successfully"+res3);
		int res4=product.saveProduct(new ProductInfo(103,"smart watch",1000.0));
		System.out.println("data is inserted successfully"+res4);
		//findbyid:
//	  	ProductInfo res = product.findbyId(101);
//  	System.out.println(res);
//	
//	//findall;
//		List<ProductInfo> prod=product.getALLProducts();
//		prod.forEach(System.out::println);
//	  	
//	//updateprice:
//	int count=product.UpdateByPrice(50,16000);
//	System.out.println("updated successfully"+count);
//
//		//deleteid:
//		int count=product.DeleteById(103);
//		System.out.println("deleted by id successfully"+count);
//	
//	//deletebyprice:
//	int count=product.deleteByprice(16000);
//	System.out.println("deleted by price successfully"+count);
//	
//	//droptable:
//	int res2=product.droptable();
//	System.out.println("droped table successfully"+res2);
//	}

}
}