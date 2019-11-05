package javaApplets;

import java.applet.*;
import java.awt.*;

/**
 * Drawing a traffic light with three states
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class A1E1 extends Applet
{
	/**
	 * This method sets up the applet
	 */
	public void init () {
		setSize (200,500);
		setBackground(Color.BLACK);
	}
	
	public void delay (int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method draws the traffic light
	 * @param x variable of traffic light
	 * @param y variable of traffic light
	 * @param graphics variable
	 */
	public void drawLight (int x, int y, Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 200, 500);
		g.setColor(Color.BLACK);
		g.fillOval(x+50, y+50, 100, 100);
		g.fillOval(x+50, y+200, 100, 100);
		g.fillOval(x+50, y+350, 100, 100);
	}

	/**
	 * This method makes the taffic light go green
	 * @param x variable of traffic light
	 * @param y variable of traffic light
	 * @param graphics variable	 */
	public void goGreen (int x, int y, Graphics g){
		g.setColor(Color.GREEN);
		g.fillOval(x+55, y+55, 90, 90);
	}

	/**
	 * This method makes the taffic light go yellow
	 * @param x variable of traffic light
	 * @param y variable of traffic light
	 * @param graphics variable	 */
	public void goYellow (int x, int y, Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(x+55, y+205, 90, 90);
	}
	
	/**
	 * This method makes the taffic light go red
	 * @param x variable of traffic light
	 * @param y variable of traffic light
	 * @param graphics variable	 */
	public void goRed (int x, int y, Graphics g){
		g.setColor(Color.RED);
		g.fillOval(x+55, y+355, 90, 90);
	}
	
	/**
	 * This method makes the taffic light go red
	 * @param x variable of traffic light
	 * @param y variable of traffic light
	 * @param graphics variable	 */
	public void goBlack1 (int x, int y, Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(x+55, y+55, 90, 90);
	}
	
	/**
	 * This method makes the taffic light go red
	 * @param x variable of traffic light
	 * @param y variable of traffic light
	 * @param graphics variable	 */
	public void goBlack2 (int x, int y, Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(x+55, y+205, 90, 90);
	}
	
	/**
	 * This method makes the taffic light go red
	 * @param x variable of traffic light
	 * @param y variable of traffic light
	 * @param graphics variable	 */
	public void goBlack3 (int x, int y, Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(x+55, y+355, 90, 90);
	}
	
	/**
	 * This method paints all the traffic light
	 * @param graphics variable
	 */
	public void paint(Graphics g) {
		while(true) {
			this.drawLight(0,0,g);
			this.goGreen(0,0,g);
			this.delay(1000);
			this.goBlack1(0, 0, g);
			this.goYellow(0,0,g);
			this.delay(1000);
			this.goBlack2(0, 0, g);
			this.goRed(0,0,g);
			this.delay(1000);
			this.goBlack3(0, 0, g);
		}
		
	}
}
