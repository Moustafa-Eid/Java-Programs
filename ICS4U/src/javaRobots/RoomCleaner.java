package javaRobots;

import becker.robots.*;
/**
 * Room Cleaner template class
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class RoomCleaner extends RobotSE {

	/**
	 * This method is the constructor that creates RoomCleaner\
	 * @param City is the name of the city
	 * @param street is the number of x coordinate
	 * @param avenue is the column number
	 * @param Direction is where the robot is facing
	 */
	public RoomCleaner(City arg0, int arg1, int arg2, Direction arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method automatically moves robot using overriding
	 */
	public void move() {
		// while there is nothing on the front
		this.pickAllThings();
		super.move();
		

	}

}
