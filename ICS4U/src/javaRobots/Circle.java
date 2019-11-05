package javaRobots;

import java.awt.*;
import java.applet.*;
/**
 * circle Shape Class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class Circle extends Shape{
	/**
	 * This method crates a general constructor for a circle
	 * @param x is the x position of the circle
	 * @param y is the y position of circle
	 * @param width is the width of the width
	 * @param height is the height of the height
	 */
	public Circle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method draws a circle
	 * @param g is the graphics object for drawing
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillOval(x, y, width, height);
	}

}
