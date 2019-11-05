package javaRobots;

import java.awt.Color;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
/**
 * spiral bot template class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class SpiralBot extends RobotSE {

	/**
	 * This method sets up the robot.
	 * @param City is the name of the city
	 * @param street is the number of x coordinate
	 * @param avenue is the column number
	 * @param Direction is where the robot is facing
	 */
	public SpiralBot(City theCity, int street, int avenue, Direction direction, int numThings) {
		super(theCity, street, avenue, direction, numThings);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method starts the robot to make a spiral
	 * @param numLoops is the amount of loops
	 */
	public void makeSpiral(int numLoops) {
		this.putThing();
		// for loop that makes robot spiral
		for (int i = 1; i < numLoops + 1; i++) {
			this.goRight(i);
			this.goTop(i);
			this.goLeft(i);
			this.goBottom(i);
		}
		this.move();

	}

	/**
	 * This method allows robot go down
	 * @param numLoops is the amount of loops
	 */
	private void goBottom(int numLoops) {
		// TODO Auto-generated method stub
		this.move();
		this.loopMove(numLoops);
	}

	/**
	 * This method allows robot go left
	 * @param numLoops is the amount of loops
	 */
	private void goLeft(int numLoops) {
		// TODO Auto-generated method stub
		this.move();
		this.loopMove(numLoops);
		this.turnLeft();
	}

	/**
	 * This method allows robot go up
	 * @param numLoops is the amount of loops
	 */
	private void goTop(int numLoops) {
		// TODO Auto-generated method stub
		this.move();
		this.loopMove(numLoops);
		this.turnLeft();
	}

	/**
	 * This method allows robot go right
	 * @param numLoops is the amount of loops
	 */
	private void goRight(int numLoops) {
		// TODO Auto-generated method stub
		this.move();
		this.turnLeft();
		this.loopMove(numLoops);
		this.turnLeft();
	}

	/**
	 * This method allows robot to move to next loop
	 * @param numLoops is the amount of loops
	 */
	private void loopMove(int numLoops) {
		// TODO Auto-generated method stub
		// for loop that calculates how to move for each spiral
		for (int i = 0; i < (numLoops*2);i++) {
			this.putThing();
			// move using pattern
			if (i < (numLoops*2) - 1) {
				this.move();
			}
		}
	}

}
