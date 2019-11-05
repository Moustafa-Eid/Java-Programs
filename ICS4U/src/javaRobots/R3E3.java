package javaRobots;
import becker.robots.*;
import java.util.*;
public class R3E3 {
	/**
	 * Avenue Clearer
	 * @author Moustafa Eid
	 * @version 11/15/2017
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creating city
		City Alexandria = new City();
		
		// declaring robot 
		RobotCleaner rick = new RobotCleaner (Alexandria,2,0,Direction.EAST);
		// declaring random generator
		Random generator = new Random();
		// how many things in tunnel
		int numThings = generator.nextInt(9) + 1;
		
		//start position
		Wall start = new Wall (Alexandria,2,0,Direction.WEST);
		//ending position
		Wall end = new Wall (Alexandria,2,numThings+1,Direction.EAST);
		//showing things count
		Alexandria.showThingCounts(true);

		// spawning things
		for (int j = 2; j < numThings+2; j++) {
			Thing lifts = new Thing(Alexandria,2,j);
			Thing lifts2 = new Thing(Alexandria,2,j);
		}
		// north wall 
		for (int j = 2; j < numThings+2; j++) {
			Wall walls = new Wall(Alexandria, 2,j, Direction.NORTH);
		}
		// south wall
		for (int j = 2; j < numThings+2; j++) {
			Wall walls = new Wall(Alexandria, 2,j, Direction.SOUTH);
		}
		
		// clean method that robot does
		rick.doCleaning();



	}

}
