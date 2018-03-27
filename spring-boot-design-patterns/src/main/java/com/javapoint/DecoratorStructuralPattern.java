package com.javapoint;

/*****************
 * 
 *  Structural Pattern
 *  Decorator
 *  
 *  This patten can be choosen if you are planning to add new functionality to an existing functionality 
 *  without modifying structure
 *  
 *  ---------------                                  ------------------------ 
 *  (Interface)        contains                             Abstract
 *  ShapeObject       <---------------------------       ShapeDecorator
 *  + draw()                                              + enum color
 *                                                        + draw(color)
 *  ----------------                                  ------------------------ 
 *  ^            ^                                               ^   
 *  |            |                                               |
 *  |            |                                               |
 *  |            |                                               |
 * ----------  ---------                                     -------------
 *  Rectangle   Square                                         ColorDecorator
 *  + int x, y  + int x, y                                     + draw(color)
 *  + draw()    + draw()
 * ----------  ---------                                     ---------------- 
 * 
 */

import com.javapoint.ShapeDecorator.Color;

interface ShapeObject{
	public void draw();
}

class Rectangle implements ShapeObject{
	
	int x, y;
	
	Rectangle(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		System.out.println("\n Drawing rectangle of size x:" + x + " y:" + y);
	}
}

class Square implements ShapeObject{
	
	int x, y;
	
     Square(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		System.out.println("\n Drawing Square of size x:" + x + " y:" + y);
	}
}

abstract class ShapeDecorator {
	public static enum Color { blue, green, red, yellow, black};

	ShapeObject shapeObject;
	
	public ShapeDecorator(ShapeObject shapeObject) {
		this.shapeObject = shapeObject;
	}
	
	public abstract void draw(ShapeDecorator.Color color);
}

 class ColorDecorator extends ShapeDecorator {
	
	public ColorDecorator(ShapeObject shapeObject) {
		super(shapeObject);
	}
	
	public  void draw(ShapeDecorator.Color color) {
		shapeObject.draw();
		setColorBorder(color);
	}
	
	public void setColorBorder(Color color) {
		System.out.println("drawing " + color + " for border " + shapeObject.toString());
	}
}

public class DecoratorStructuralPattern {

	public static void main(String args[]) {
		
		ShapeDecorator drawRectangleRedBorder =  new ColorDecorator(new Rectangle(10, 12));
		drawRectangleRedBorder.draw(Color.red);
		
		ShapeDecorator drawRectangleGreenBorder =  new ColorDecorator(new Rectangle(11, 12));
		drawRectangleGreenBorder.draw(Color.green);
		
		ShapeDecorator drawSquareYellowBorder =  new ColorDecorator(new Square(20, 20));
		drawSquareYellowBorder.draw(Color.yellow);
		
		ShapeDecorator drawSquareBlueBorder =  new ColorDecorator(new Square(10, 12));
		drawSquareBlueBorder.draw(Color.blue);
		
	}
}


/****************** OUTPUT **************************


Drawing rectangle of size x:10 y:12
drawing red for border com.javapoint.Rectangle@70dea4e

Drawing rectangle of size x:11 y:12
drawing green for border com.javapoint.Rectangle@5c647e05

Drawing Square of size x:20 y:20
drawing yellow for border com.javapoint.Square@33909752

Drawing Square of size x:10 y:12
drawing blue for border com.javapoint.Square@55f96302

********************************************/
