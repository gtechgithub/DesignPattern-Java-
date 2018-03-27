package com.javapoint;

/*
 * 
 *  Creational Patter
 *  Facade
 *  
 *  it hides the complexity of the system and just provides a method in which client is interested.
 * 
 *  *  ---------------                                  ------------------------ 
 *  (Interface)        contains                                                  
 *  ShapeObject       <---------------------------          ShapeMaker                 <------   CLIENT  
 *  + draw()                                              + ShapeObject rectangle
 *                                                        + ShapeObject square
 *                                                        + drawRectangle
 *                                                        + drawSquare
 *  ----------------                                  ------------------------ 
 *  ^            ^                                                 
 *  |            |                                              
 *  |            |                                             
 *  |            |                                             
 * ----------  ---------                                     
 *  Rectangle   Square                                       
 *  + int x, y  + int x, y                                   
 *  + draw()    + draw()
 * ----------  ---------                                      
 * 
 */

class ShapeMaker{
	private ShapeObject rectangle;
	private ShapeObject square;
	
	ShapeMaker(int x, int y){
		rectangle = new Rectangle(x,y);
		square = new Square(x,y);
	}
	
	public void drawRectangle() {
		rectangle.draw();
	}
	
	public void drawSquare() {
		square.draw();
	}
}

public class FacadeStructuralPattern {

	public static void main(String args[]) {
		ShapeMaker rectangle = new ShapeMaker(10, 12);
		rectangle.drawRectangle();
		
		ShapeMaker square = new ShapeMaker(20, 20);
		square.drawSquare();
		
	}
}


/******************************* OUTPUT **********************


 Drawing rectangle of size x:10 y:12

 Drawing Square of size x:20 y:20


************************************************************/