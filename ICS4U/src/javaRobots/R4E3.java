package javaRobots;

import java.applet.*;

import java.awt.*;

import javaApplets.TrafficLight;
import java.util.*;
/**
 * moving shapes application class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class R4E3 extends Applet implements Runnable{
	
	/**
	 * This method initializes screen
	 */
	public void init() {
		setSize(1280,720);
		timer = new Thread (this);
		timer.start();
	}
	
	// create variables
	private Thread timer;
	private int x = 100;
	// create array shape
	Shape [] shapes = new Shape[3];

	/**
	 * This method paints shapes on to screen
	 */
	public void paint(Graphics g) {
		// creating 3 different shapes
		shapes [0] = new Circle(x,240,100,100);
		shapes [1] = new Rectangle(x,480,100,50);
		shapes [2] = new Square(x,600,100,100);
		
		// general for loop that draws shapes from rach class using abstract shape constructor
		for (int i = 0; i < shapes.length; i++) {
			shapes[i].draw(g);
		}
	}


	/**
	 * This method runs the program and updates screen
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random generator = new Random(); // For random numbers
		// Game loop that keeps cycling the traffic light
		while (true)
		{
			try
			{
				timer.sleep (50); // 500 millisecond delay
				this.x += 50; // Randomize state of light
				repaint(); // call paint method again
			}
			catch (Exception e)
			{
				// catch exceptions that could be thrown by the Thread
				// any reference variable automatically inherits a toString() method
				// that gives back a String version of the object.
				System.out.println(e.toString());
			}
		}
	}




}
