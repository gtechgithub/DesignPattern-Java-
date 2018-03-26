package com.javapoint;

/*******************
 * 
 *   PATTERN: CREATIONAL
 *     
 *    ---------                         --------------
 *   |         |
 *   | Product |<----------------------- ProductFactory <--------------- Client
 *   |         |
 *   -----------                        ---------------
 *     ^     ^                            createProduct
 *     |     |
 *     |     |
 *     |     |
 * -------  --------    
 *     
 * ProductA  ProductB
 * -------  --------
 * 
 */

import com.javapoint.Product.productType;

abstract class Product{
	
	public void writeName(String name) {
		
		System.out.println("inside Product Write name");
	}
	
	public static enum productType { A, B};
}

class ProductA extends Product{
	
	//this will reverse the string
	@Override
	public void writeName(String name) {
		
		StringBuilder sb = new StringBuilder(name);
		System.out.println("inside ProductA Write name String:" + sb.reverse());
	}
}

class ProductB extends Product{
	
	//this will convert to upper case
	@Override
	public void writeName(String name) {
		System.out.println("inside ProductB Write name String:" + name.toUpperCase());
	}
}

class ProductFactory{
	public Product createProduct(productType type) {
		
		Product product = null;
		
		if(type == productType.A) {
			product = new ProductA();
		}
		else if (type == productType.B) {
			product = new ProductB();
		}
		return product;
	}
}

public class FactoryDesginCreationalPattern{
	
	public static void main(String args[]) {
		
		Product product = null;
		ProductFactory factoryClient = new ProductFactory();

		//create instance for ProductA
		product = factoryClient.createProduct(productType.A);
		product.writeName("gopal");

		//create instance for ProductB
		product = factoryClient.createProduct(productType.B);
		product.writeName("gopal");
		
	}
}