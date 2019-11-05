package javaApplets;

import java.applet.*;
import java.awt.*;

/**
 * Drawing a robot with two states
 * @author Moustafa Eid
 * @version 11/5/2017
 */

public class A1E2 extends Applet {
	
	/**
	 * This method sets up the applet
	 */
	public void init() {
		setSize(1200,800);
		setBackground(Color.BLUE);
	}
	
	/**
	 * This method draws head of first robot
	 * @param x variable of robot
	 * @param y variable of robot
	 * @param graphics variable
	 */
	public void drawHead (int x, int y, Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x+240,y+100,150,150);
		g.setColor(Color.RED);
		g.fillRect(x+267, y+135, 40, 20);
		g.fillRect(x+323, y+135, 40, 20);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x+300, y+170, 28, 20);
		g.setColor(Color.ORANGE);
		g.fillRect(x+280, y+200, 68, 30);
		g.setColor(Color.BLACK);
		g.fillRect(x+280, y+214, 68, 2);
		g.fillRect(x+297, y+145, 5, 5);
		g.fillRect(x+353, y+145, 5, 5);
	}
	
	/**
	 * This method draws head of second robot
	 * @param x variable of robot
	 * @param y variable of robot
	 * @param graphics variable	 */
	public void drawHead2 (int x, int y, Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x+240,y+100,150,150);
		g.setColor(Color.RED);
		g.fillRect(x+267, y+135, 40, 20);
		g.fillRect(x+323, y+135, 40, 20);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x+300, y+170, 28, 20);
		g.setColor(Color.ORANGE);
		g.fillRect(x+280, y+200, 68, 30);
		g.setColor(Color.BLACK);
		g.fillRect(x+290, y+214, 48, 2);
		g.fillRect(x+290, y+214, 2, 17);
		g.fillRect(x+336, y+214, 2, 17);
		g.fillRect(x+297, y+145, 5, 5);
		g.fillRect(x+353, y+145, 5, 5);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x+330, y+125, 5, 5);
		g.fillRect(x+335, y+125, 5, 5);
		g.fillRect(x+335, y+120, 5, 5);
		g.fillRect(x+340, y+120, 5, 5);
		g.fillRect(x+340, y+115, 5, 5);
		g.fillRect(x+345, y+115, 5, 5);
		g.fillRect(x+345, y+110, 5, 5);
		g.fillRect(x+350, y+110, 5, 5);
		g.fillRect(x+295, y+125, 5, 5);
		g.fillRect(x+290, y+125, 5, 5);
		g.fillRect(x+290, y+120, 5, 5);
		g.fillRect(x+285, y+120, 5, 5);
		g.fillRect(x+285, y+115, 5, 5);
		g.fillRect(x+280, y+115, 5, 5);
		g.fillRect(x+280, y+110, 5, 5);
		g.fillRect(x+275, y+110, 5, 5);
	}
	
	/**
	 * This method draws body of first and second robot
	 * @param x variable of robot
	 * @param y variable of robot
	 * @param graphics variable	 */
	public void drawBody (int x, int y, Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x+200, y+250, 230, 400);
		g.fillRect(x+120, y+300, 50, 250);
		g.fillRect(x+120, y+300, 100, 50);
		g.fillRect(x+460, y+300, 50, 250);
		g.fillRect(x+430, y+300, 40, 50);
		g.fillRect(x+200, y+250, 70, 600);
		g.fillRect(x+360, y+250, 70, 600);
	}
	
	/**
	 * This method paints everything on screen
	 * @param graphics variable
	 */
	public void paint (Graphics g) {
		this.drawHead(0, 0, g);
		this.drawBody(0, 0, g);
		this.drawHead2(600, 0, g);
		this.drawBody(600, 0, g);
	}
	

}
