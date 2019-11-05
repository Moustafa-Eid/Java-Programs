package javaRobots;
import becker.robots.*;
import becker.robots.Thing;
import becker.robots.City;
import becker.robots.Direction;
/**
 * Spiral Robot
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class R3E4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create city
		City Alexandria = new City(20,20);
		
		// create robot
		SpiralBot rick = new SpiralBot (Alexandria,10,10,Direction.EAST,500);
		
		// method that makes robot do a spiral
		rick.makeSpiral(3);
		
	}

}
