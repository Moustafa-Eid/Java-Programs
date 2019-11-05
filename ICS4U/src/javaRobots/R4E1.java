package javaRobots;
import becker.robots.*;

import java.util.Random;
/**
 * Robot cleaning program
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class R4E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// declaring variables
		int x = 0,y = 0,pos = 1;
		// declaring city
		City america = new City ();
		// declaring random generator
		Random generator = new Random();
		// creating wall 2d array
		// making a new robot
		RoomCleaner trump = new RoomCleaner (america , 3,3,Direction.NORTH);
		
		// creating arrays
		int numWalls1 = generator.nextInt(10) + 1;
		int numWalls2 = generator.nextInt(10) + 1;


		//Creating the 2D array
		  Wall[][] walls=new Wall[numWalls1][numWalls2];

		  //Creating the top horizontal wall
		  for (int i=0;i<numWalls2;i++) {
		   walls [0][i] = new Wall (america, 1, 1+i, Direction.NORTH);
		  }

		  //Creating the right vertical right
		  for (int i=0;i<numWalls1;i++) {
		   walls[i][0] = new Wall (america, 1+i, 1, Direction.WEST);
		  }
		  //Creating the bottom horizontal wall
		  for (int i=0;i<numWalls2;i++) {
		   walls[numWalls1-1][i] = new Wall (america, numWalls1, 1+i, Direction.SOUTH);
		  }
		  //Creating the left vertical right
		  for (int i=0;i<numWalls1;i++) {
		   walls[i][numWalls2-1] = new Wall (america, 1+i, numWalls2, Direction.EAST);
		  }
		
		//Creating things
		  for (int i=0; i<5 ;i++) {   
		   Thing thing1 = new Thing (america,(int)(Math.random()*numWalls1+1),(int)(Math.random()*numWalls2+1));
		  }
		  
		  if (trump.getDirection() == Direction.EAST) {
			  trump.turnLeft();
		  }
		  else if (trump.getDirection() == Direction.WEST) {
			  trump.turnRight();
		  }
		  else if (trump.getDirection() == Direction.SOUTH) {
			  trump.turnAround();
		  }
		  
		  while (true) {
			  if (trump.frontIsClear()) {
				  trump.move();
			  }
			  else {
				  trump.turnLeft();
				  break;
			  }
		  }
		  while (true) {
			  if (trump.frontIsClear()) {
				  trump.move();
			  }
			  else {
				  trump.turnAround();
				  break;
			  }
		  }
		
		// while loop to move robot
		  while (true) {
				// pick all things and move
				if (trump.frontIsClear()) {
					while (trump.frontIsClear()) {
						trump.move();
					}
				}
				// if there is somehting on front and robot is east then turn right and go to next row
				if (trump.getDirection() == Direction.EAST) {
					trump.turnRight();
					// // pick all things while moving across
					if (trump.frontIsClear()) {
						trump.move();
						trump.turnRight();
					}
					// turn around and pick everything up
					else {
						trump.turnAround();
						// if everythign is clear then move
						while (true) {
							if (trump.frontIsClear()) {
								trump.move();
							}
							// move back to top left
							else {
								trump.turnLeft();
								while (trump.frontIsClear()) {
									trump.move();
								}
								break;
							}
						}
						// put all things down
						trump.turnAround();
						trump.putAllThings();
						break;
					}
				}
				// if robot starts facing west
				else if (trump.getDirection() == Direction.WEST) {
					// go across
					trump.turnLeft();
					// pick everything up
					if (trump.frontIsClear()) {
						trump.move();
						trump.turnLeft();
					}
					// go back to top left position
					else {
						trump.turnAround();
						while (trump.frontIsClear()) {
							trump.move();
						}
						// put everything down
						trump.turnRight();
						trump.putAllThings();
						break;
					}

				}
			}
	}



}



