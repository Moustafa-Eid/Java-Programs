package javaRobots;
import becker.robots.City;
import becker.robots.Direction;

/**
 * bar drawer template class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class BarDrawer extends RobotVersion2 {

	// declaring variables
	private int xpos;
	
	/**
	 * This method sets up the robot.
	 * @param City is the name of the city
	 * @param street is the number of x coordinate
	 * @param avenue is the column number
	 * @param Direction is where the robot is facing
	 */
	public BarDrawer(City theCity, int street, int avenue, Direction direction) {
		super(theCity, street, avenue, direction);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method allows robot to graph
	 */
	public void Graph() {
		// get x pos
		this.getPos();
		// while loop that keeps graphing until there is none left
		while (true) {
			this.draw();
			this.nextBar();
			// if this cant pick thing then stop
			if (!this.canPickThing()) {
				break;
			}
		}
	}
	
	
	/**
	 * This method allows robot to switch to next bar
	 */
	private void nextBar() {
		// TODO Auto-generated method stub
		this.moveAcross();
		this.goBack();
	}

	/**
	 * This method allows robot to turn right
	 */
	private void goBack() {
		// TODO Auto-generated method stub
		// go back to start pos
		while (this.getAvenue() != xpos) {
			this.move();
		}
		this.turnAround();
	}

	/**
	 * This method allows robot to turn right
	 */
	private void moveAcross() {
		// TODO Auto-generated method stub
		this.turnRight();
		this.move();
		this.turnRight();
	}

	/**
	 * This method allows robot to turn right
	 */
	private void draw() {
		// TODO Auto-generated method stub
		this.pickAllThings();
		// while loop that checks if you have things in backpack then puts it
		while (this.countThingsInBackpack() > 0) {
			this.move();
			this.putThing();
		}
	}
	
	/**
	 * This method allows robot to get pos of robot at start of program
	 */
	private void getPos() {
		// TODO Auto-generated method stub
		// record x and y pos at start
		xpos = this.getAvenue();
	}

}
