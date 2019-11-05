package javaRobots;

import becker.robots.City;
import becker.robots.Direction;
/**
 * robot cleaner template class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class RobotCleaner extends RobotVersion2 {

	private boolean stop = false;
	/**
	 * This method sets up the robot.
	 * @param City is the name of the city
	 * @param street is the number of x coordinate
	 * @param avenue is the column number
	 * @param Direction is where the robot is facing
	 */
	public RobotCleaner(City theCity, int street, int avenue, Direction direction) {
		super(theCity, street, avenue, direction);
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method starts cleaning
	 */
	public void doCleaning() {
		// while loop that keeps repeating until no thing left
		while (true) {
			this.getItem();
			this.bringBackItem();
			// if there is no thing then stop
			if (stop == true) {
				break;
			}
		}
	}

	/**
	 * This method allows robot go back and put item
	 */
	private void bringBackItem() {
		// TODO Auto-generated method stub
		this.turnAround();
		// while the front is clear then move
		while(this.frontIsClear()) {
			this.move();
		}
		// if there are things then put them
		this.checkCompletion();
	}
	
	/**
	 * This method allows to check if it is done
	 */
	private void checkCompletion() {
		// TODO Auto-generated method stub
		if (stop == false) {
			this.putThing();
			this.turnAround();
			this.move();
		}
		// if there is not then just turn around
		else {
			this.turnAround();
			this.move();
		}
	}
	
	/**
	 * This method allows robot go get items
	 */
	private void getItem() {
		// TODO Auto-generated method stub
		// while loop that checks if robot cannot pick things and tells it to move
		while(!this.canPickThing() && this.frontIsClear()) {
			this.move();
		}
		// if statement that checks if robot can pick thing then puts things
		if (this.canPickThing()) {
			this.pickThing();
		}
		// stop if there is no thing
		else {
			stop = true;
		}
	}

}
