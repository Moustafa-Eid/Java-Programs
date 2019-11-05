package javaRobots;
import java.awt.*;

import java.applet.*;
/**
 * Square Shape Class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class Square extends Shape{
	
	/**
	 * This method crates a general constructor for a square
	 * @param x is the x position of the square
	 * @param y is the y position of square
	 * @param width is the width of the square
	 * @param height is the height of the square
	 */
	public Square(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method draws a square
	 * @param g is the graphics object for drawing
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, width, height);
	}

}
