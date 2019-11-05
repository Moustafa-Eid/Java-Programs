package javaApplets;
import java.applet.*;
import java.awt.*;
/**
 * Drawing a traffic light oop
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class TrafficLight {
	// declaring global variables
	private int x, y;
	private Graphics g;
	
	/**
	 * This method makes the index variables equal to the global variable
	 * @param x variable of traffic light
	 * @param y variable of traffic light
	 * @param graphics variable	 */
	public TrafficLight (int x, int y, Graphics g) {
		this.x = x;
		this.y = y;
		this.g = g;
		this.drawLight();
	}
	/**
	 * This method draws the traffic light
	 */
	private void drawLight (){
		g.setColor(Color.YELLOW);
		g.fillRect(this.x, this.y, 200, 500);
		g.setColor(Color.BLACK);
		g.fillOval(this.x+50, this.y+50, 100, 100);
		g.fillOval(this.x+50, this.y+200, 100, 100);
		g.fillOval(this.x+50, this.y+350, 100, 100);
	}
	/**
	 * This method makes the traffic light go green
	 */
	public void goGreen (){
		g.setColor(Color.GREEN);
		g.fillOval(this.x+55, this.y+55, 90, 90);
	}
	/**
	 * This method makes the taffic light go yellow
	 */
	public void goYellow (){
		g.setColor(Color.YELLOW);
		g.fillOval(this.x+55, this.y+205, 90, 90);
	}
	/**
	 * This method makes the taffic light go red
	 */
	public void goRed (){
		g.setColor(Color.RED);
		g.fillOval(this.x+55, this.y+355, 90, 90);
	}

}
