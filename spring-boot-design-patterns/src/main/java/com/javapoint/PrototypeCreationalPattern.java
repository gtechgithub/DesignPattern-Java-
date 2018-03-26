package com.javapoint;

/***************************
 * 
 *  PATTERN: CREATIONAL
 * 
 * 
 *   -------------                             --------------------
 *    ProtoProduct   <---------------------     Client
 *    + clone()
 *   --------------                            --------------------
 *   ^             ^
 *   |             |   
 *   |             |
 *   |             |
 *  -----------   -----------
 *   ProductA      ProductB
 *  -----------   -----------
 *   
 *   
 */

import java.util.HashMap;

abstract class ProtoProduct implements Cloneable{
	
	String description;
	public Object clone() throws CloneNotSupportedException {
		Object clone =  null;
		clone = super.clone();
		return clone;
	}
	
	public abstract String showDesc();
	
}

class Book extends ProtoProduct{

	Book(String description){
		this.description = description;
	}
	
	
	public String showDesc() {
		return description;
	}
}

class DVD extends ProtoProduct{

	DVD(String description){
		this.description = description;
	}
	
	public String showDesc() {
		return description;
	}
}

public class PrototypeCreationalPattern {

	private HashMap<String, ProtoProduct> hm = new <String,ProtoProduct> HashMap();
	
	public ProtoProduct getProductClone(String type) throws CloneNotSupportedException {
		return (ProtoProduct) hm.get(type).clone();
	}
	
	public void loadCache() {
		hm.put("b1", new Book("Java Spring"));
		hm.put("d1", new DVD("Java Spring in DVD"));
	}
	
	public static void main(String args[]) {
		
		PrototypeCreationalPattern prototype = new PrototypeCreationalPattern();
		prototype.loadCache();
		
		try {
		
		ProtoProduct product = (Book) prototype.getProductClone("b1");
		System.out.println("HashCode:" + product.hashCode() + " Product:" + product.showDesc());
		
		product = (DVD) prototype.getProductClone("d1");
		System.out.println("HashCode:" + product.hashCode() + " Product:" + product.showDesc());

		ProtoProduct product1 = (Book) prototype.getProductClone("b1");
		System.out.println("HashCode:" + product1.hashCode() + " Product:" + product1.showDesc());
		
		
		}
		catch(CloneNotSupportedException cl) {
			
		}
		catch(Exception e) {
			
		}
	}
}


/**************************
product object:

HashCode:118352462 Product:Java Spring
HashCode:1550089733 Product:Java Spring in DVD

product1 object:
HashCode:865113938 Product:Java Spring


******************************/