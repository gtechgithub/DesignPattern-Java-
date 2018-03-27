package com.javapoint;

/**
 * 
 * it decouples implementation from the actual abstract, 
 * this bridge pattern creates inteface which has implementation hence concrete
 * class is independent of it's implementation.
 *
 *  -----------------                                     -------------------------
 *   (Interface)                     contains                   (Abstract)
 *   DrawAPi                       <----------------------       Shape
 *   + drawCircle(x,y,radius)                                   + DrawApi
 *                                                              + draw(x,y,radius)
 *  ------------------                                    --------------------------
 *  ^             ^                                                 ^
 *  |             |                                                 |   
 *  |             |                                                 |
 *  |             |                                                 |
 *  |             |                                                 |
 * -----------   -----------                              ---------------------------
 *  RedCircle    GreenCircle                                      Circle
 * + drawCircle  + drawCircle                                    + int x, int y, int radius
 *                                                               + draw(x,y,radius)
 * ------------ -----------                                --------------------------
 *
 */

//this interface will have implementation
interface DrawApi{
	
	public void drawCircle(int x, int y, int radius);
}

class RedCircle implements DrawApi{
	public void drawCircle(int x, int y, int radius) {
		System.out.println("drawing red circle of radius:" + radius + " x:" +x + ":y" + y);
	}
}

class GreenCircle implements DrawApi{
	public void drawCircle(int x, int y, int radius) {
		System.out.println("drawing Green circle of radius:" + radius + " x:" +x + ":y" + y);
	}
}

abstract class Shape{
	protected DrawApi drawApi;
	
	Shape(DrawApi drawApi){
		this.drawApi = drawApi;
	}
	
	public abstract void draw();
}

 class Circle extends Shape{
	
	int x;
	int y;
	int radius;
	
	Circle(int x, int y, int radius, DrawApi drawApi){
		super(drawApi);
		this.x = x;
		this.y=y;
		this.radius = radius;
	}
	
	public void draw() {
		drawApi.drawCircle(x, y, radius);
	}
}

public class BridgeStructuralPattern {

	public static void main(String args[]) {
		
		Shape redCircle =  new Circle(1,1,1,new RedCircle());
		Shape greenCircle =  new Circle(2,2,2,new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
			
			
	}
}

/************************** OUTPUT *******************


drawing red circle of radius:1 x:1:y1
drawing Green circle of radius:2 x:2:y2



***************************************************/