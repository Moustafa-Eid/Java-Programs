package javaRobots;
import becker.robots.*;
/**
 * Update version of Robots
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class RobotVersion2 extends Robot
{
	/**
	 * This method sets up the robot.
	 * @param City is the name ofd the city
	 * @param street is the number of x coordinate
	 * @param avenue is the column number
	 * @param Direction is where the robot is facing
	 */
	public RobotVersion2 (City theCity, int street, int avenue, Direction direction) {
		super(theCity, street, avenue, direction);
	}

	/**
	 * This method allows robot to turn right
	 */
	public void turnRight() {
		super.turnLeft();
		super.turnLeft();
		super.turnLeft();
	}

	/**
	 * This method allows robot to turn around
	 */
	public void turnAround() {
		super.turnLeft();
		super.turnLeft();
	}

	/**
	 * This method allows robot to move a specific number of steps
	 * @param numSteps is the number of steps
	 */
	public void move(int numSteps) {
		// takes numSteps and runs for loop that many timea
		for (int i = 0; i < numSteps; i++) {
			super.move();
		}
	}

	/**
	 * This method allows robot pick a number of things 
	 * @param numThings is the number of things
	 */
	public void pickThing(int numThings) {
		// takes numThings and runs for loop that many times
		for (int i = 0; i < numThings; i++) {
			super.pickThing();
		}
	}

	/**
	 * This method allows robot to count every thing in spot
	 */
	public int countThings () {
		// counter
		int num = 0;
		// while loop to pick things and count how many things then put it back
		while (true) {
			// if it can pick thing then pick it up
			if (super.canPickThing()) {
				super.pickThing();
				num++;
			}
			else {
				// put things back
				for (int i = 0; i < num; i++) {
					super.putThing();
				}
				break;
			}
		}
		// return number of things
		return num;
	}

	/**
	 * This method allows robot to pick everything up on spot
	 */
	public void pickAllThings () {
		// while loop that picks things
		while (true) {
			if (super.canPickThing()) {
				super.pickThing();
			}
			else {
				break;
			}
		}
	}

	/**
	 * This method allows robot to put all things in backpack down
	 */
	public void putAllThings () {
		// how many things in backpack
		int thing = super.countThingsInBackpack();
		// for loop that puts all things
		for (int i = 0; i < thing ;i++) {
			super.putThing();
		}
	}


}
