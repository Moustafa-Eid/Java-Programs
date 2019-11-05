package javaRobots;

import java.util.Random;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 * Robot cleaning program
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class R2E2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring variables
		int x = 0,y = 0,pos = 1;
		// declaring city
		City america = new City ();
		// declaring random generator
		Random generator = new Random();
		// creating wall 2d array
		Wall [][] walls = new Wall[4][5];
		// making a new robot
		RobotVersion2 trump = new RobotVersion2 (america , 1,1,Direction.EAST);

		// create north wall
		for (int i = 0; i < 5; i++) {
			walls[0][i] = new Wall(america, 1,1+i, Direction.NORTH);
		}
		// create south wall
		for (int i = 0; i < 5; i++) {
			walls[3][i] = new Wall(america, 4,1+i, Direction.SOUTH);
		}
		// create west wall
		for (int i = 0; i < 4; i++) {
			walls[i][0] = new Wall(america, 1+i,1, Direction.WEST);
		}
		// create east wall
		for (int i = 0; i < 4; i++) {
			walls[i][4] = new Wall(america, 1+i,5, Direction.EAST);
		}

		// random generating where things are located
		for (int i = 0; i < 5; i++) {
			x = generator.nextInt(4) + 1;
			y = generator.nextInt(3) + 1;
			Thing drugs = new Thing (america,x,y);
		}

		// while loop to move robot
		while (true) {
			// if there is a thing on the floor
			if (trump.canPickThing()) {
				trump.pickAllThings();
			}
			// if there is no thing on the floor
			else {
				// if there is no wall in front
				if (trump.frontIsClear()) {
					trump.move();
				}
				//go to row 2
				else if (pos == 1) {
					trump.turnRight();
					trump.move();
					trump.turnRight();
					pos += 1;
				}
				// go to row 3
				else if (pos == 2) {
					trump.turnLeft();
					trump.move();
					trump.turnLeft();
					pos += 1;
				}
				// go to row 3
				else if (pos == 3) {
					trump.turnRight();
					trump.move();
					trump.turnRight();
					pos += 1;
				}
				// go to row 4
				else if (pos == 4) {
					trump.turnRight();
					trump.move(3);
					trump.putAllThings();
					trump.turnRight();
					break;
				}
			}
		}


	}

}
