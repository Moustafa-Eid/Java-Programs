package javaRobots;
import java.awt.*;
import java.applet.*;
/**
 * Abstract Shape Class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public abstract class Shape {
	
	// declare global variables for shape
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	/**
	 * This method crates a general constructor for a shape
	 * @param x is the x position of the shape
	 * @param y is the y position of shape
	 * @param width is the width of the shape
	 * @param height is the height of the shape
	 */
	public Shape(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * This abstract method crates a general draw command
	 * @param g is the graphics object for drawing
	 */
	public abstract void draw(Graphics g);
	
}
