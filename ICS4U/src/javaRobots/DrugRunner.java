package javaRobots;

import becker.robots.City;
import becker.robots.Direction;
/**
 * drug runner template class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class DrugRunner extends RobotVersion2{

	/**
	 * This method sets up the robot.
	 * @param City is the name of the city
	 * @param street is the number of x coordinate
	 * @param avenue is the column number
	 * @param Direction is where the robot is facing
	 */
	public DrugRunner(City theCity, int street, int avenue, Direction direction) {
		super(theCity, street, avenue, direction);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method starts the drugrun
	 */
	public void doDrugRun() {
		this.pickThing();
		// for loop that makes runner go and climb wall
		for (int i = 0; i < 2; i++) {
			this.moveToWall();
			this.climbWall();
		}
		this.putThing();
	}

	/**
	 * This method allows robot to climb wall
	 */
	private void climbWall() {
		// TODO Auto-generated method stub
		this.goUpWall();
		this.goAcrossWall();
		this.goDownWall();
	}

	/**
	 * This method allows robot to go down wall
	 */
	private void goDownWall() {
		// TODO Auto-generated method stub
		this.move(2);
		this.turnLeft();
	}

	/**
	 * This method allows robot to move accros wall
	 */
	private void goAcrossWall() {
		// TODO Auto-generated method stub
		this.move();
		this.turnRight();
	}
	/**
	 * This method allows robot to go up wall
	 */
	private void goUpWall() {
		// TODO Auto-generated method stub
		this.turnLeft();
		this.move(2);
		this.turnRight();
	}

	/**
	 * This method allows robot to move to next wall
	 */
	private void moveToWall() {
		// TODO Auto-generated method stub
		// if front is clear then keep moving
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	
	
}
