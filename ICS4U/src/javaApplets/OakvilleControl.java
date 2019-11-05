package javaApplets;
import java.applet.*;
import java.awt.*;

/**
 * application class for oop traffic light
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class OakvilleControl extends Applet {
	/**
	 * This method sets up the applet
	 */
	public void init() {
		setSize(400,600);
	}
	/**
	 * This method paints the 3 traffic lights
	 * @param graphics variable
	 */
	public void paint(Graphics g) {
		// creating 3 traffic lights
		TrafficLight trafalgar = new TrafficLight(0,0,g);
		TrafficLight dundas = new TrafficLight(300,0,g);
		TrafficLight sixthline = new TrafficLight(600,0,g);

		// makes the lights go green, yellow and red
		trafalgar.goGreen();
		dundas.goYellow();
		sixthline.goRed();
	}
}
