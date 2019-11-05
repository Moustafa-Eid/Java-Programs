package javaRobots;
import becker.robots.*;
/**
 * testing robot version 2
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class R2E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// declaring city
		City oakville = new City ();
		// making a new robotversion2
		RobotVersion2 myRobot = new RobotVersion2(oakville , 0,0,Direction.EAST);

		// spawning multiple things in the same spot
		Thing drugs = new Thing (oakville,0,3);
		Thing drugs1 = new Thing (oakville,0,3);
		Thing drugs2 = new Thing (oakville,0,3);
		Thing drugs3 = new Thing (oakville,0,3);
		Thing drugs4 = new Thing (oakville,0,3);

		// move 3 spaces
		myRobot.move(3);
		// count things
		System.out.println(myRobot.countThings());
		// pick all things
		myRobot.pickAllThings();
		// move 1 space
		myRobot.move(1);
		// put everything down from backpack
		myRobot.putAllThings();
		// count things
		System.out.println(myRobot.countThings());
		// pick up 2 things 
		myRobot.pickThing(2);
		// move 1 space
		myRobot.move(1);
		// put every thing down
		myRobot.putAllThings();
		// count all things
		System.out.println(myRobot.countThings());


	}

}
