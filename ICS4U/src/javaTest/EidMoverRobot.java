package javaTest;
import becker.robots.*;
/**
 * Mover Robot that moves things
 * @author Moustafa Eid
 * @version 12/07/2017
 */
public class EidMoverRobot extends RobotSE {

	// declaring global variables
	private int capacity;
	private int xpos;
	private int ypos;
	
	/**
	 * This method sets up the robot.
	 * @param city is the name of the city
	 * @param street is the number of x coordinate
	 * @param avenue is the column number or y coordinate
	 * @param direction is where the robot is facing
	 * @param Capacity of robot
	 */
	public EidMoverRobot(City arg0, int arg1, int arg2, Direction arg3, int capacity) {
		super(arg0, arg1, arg2, arg3);
		this.capacity = capacity;
	}
	
	/**
	 * This method allows robot to move pile to depot and back
	 */
	public void movePile() {
		this.getPos();
		this.moveToThing();
		this.pickThingCapacity();
		this.movetoDepot();
		this.moveBack();
	}

	/**
	 * This method allows robot to pick as much things as it can
	 */
	private void pickThingCapacity() {
		// TODO Auto-generated method stub
		// for loop that runs through capacity and picks thing
		for (int i = 0; i < capacity; i++) {
			if (this.canPickThing()) {
				this.pickThing();
			}
		}
	}

	/**
	 * This method allows robot to move back to starting pos
	 */
	private void moveBack() {
		// TODO Auto-generated method stub
		// while loop to move back to x pos
		while (this.getAvenue() != xpos) {
			this.move();
		}
		// if there is still a thing there then go back
		if (this.canPickThing()) {
			this.pickThingCapacity();
			this.turnAround();
			this.movetoDepot();
			this.moveBack();
		}
		// if there is not go back to start
		else {
			this.turnRight();
			while (this.getStreet() != this.ypos) {
				this.move();
			}
			this.turnAround();
			
		}
	}

	/**
	 * This method allows robot to move to depot
	 */
	private void movetoDepot() {
		// TODO Auto-generated method stub
		// while front is clear go forward
		while (this.frontIsClear()) {
			this.move();
		}
		// put all things and turn around
		this.putAllThings();
		this.turnAround();
	}

	/**
	 * This method allows robot to thing in front of it
	 */
	private void moveToThing() {
		// TODO Auto-generated method stub
		// while there is no thing on floor then move
		while (this.canPickThing() == false) {
			this.move();
		}
		// turn left once thing is found
		this.turnLeft();

	}

	/**
	 * This method allows robot to get pos of robot at start of program
	 */
	private void getPos() {
		// TODO Auto-generated method stub
		// record x and y pos at start
		xpos = this.getAvenue();
		ypos = this.getStreet();
	}
	
	
	

}
