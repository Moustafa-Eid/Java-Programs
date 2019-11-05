package javaRecursion;
import java.applet.*;
import java.awt.*;

public class A1E7 extends Applet {

	/**
	 * This method sets up the applet
	 */
	public void init() {
		setSize(1012,300);
		setBackground(Color.YELLOW);
	}
	
	public void drawCantor (int x, int y, int length, Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x,y,length,20);
		
		y += 50;
		
		if (length % 3 == 0) {
			int l1 = length/3;
			int x2 = x+(length*2/3);
			drawCantor(x,y,l1, g);
			drawCantor(x2,y,l1, g);
		}


				
	}
	
	
	
	/**
	 * This method paints everything on screen
	 * @param graphics variable
	 */
	public void paint (Graphics g) {
		this.drawCantor(20, 20, 972, g);

	}
}
