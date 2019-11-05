package javaRobots;
import java.awt.*;
import java.applet.*;
/**
 * rectangle Shape Class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class Rectangle extends Shape {
	/**
	 * This method crates a general constructor for a rectangle
	 * @param x is the x position of the rectangle
	 * @param y is the y position of rectangle
	 * @param width is the width of the rectangle
	 * @param height is the height of the rectangle
	 */
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method draws a rectangle
	 * @param g is the graphics object for drawing
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, width, height);
	}

}
