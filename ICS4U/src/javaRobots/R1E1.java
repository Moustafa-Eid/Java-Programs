package javaRobots;
import becker.robots.*;
/**
 * Create neame with things by robot
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class R1E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creating city
		City england = new City();
		// creating robot
		Robot NickC = new Robot (england, 0,0, Direction.EAST);

		// spawning things
		for (int x = 0; x < 12; x++) {
			Thing thing1 = new Thing (england, 0,0);
		}
		// pick up things
		for (int x = 1; x < 13; x++) {
			NickC.pickThing();
		}
		// move to position for first thing 
		for (int x = 1; x < 8; x++) {
			if ( x < 7 )
			{
				NickC.move();
			}
			else {
				NickC.turnLeft();
				NickC.turnLeft();
				NickC.turnLeft();
				NickC.move();
			}
		}
		// place first thing
		for (int i = 0; i < 5; i++) {
			NickC.move();
			if ( i >= 1 )
			{
				NickC.putThing();
			}
		}
		// turn right
		NickC.turnLeft();
		NickC.turnLeft();
		NickC.turnLeft();
		// go to the seconbd position
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				NickC.move();
			}
			if (i == 1) {
				// turn right
				NickC.turnLeft();
				NickC.turnLeft();
				NickC.turnLeft();
				NickC.move();
				NickC.move();

			}
			if ( i == 3 )
			{
				// put things down+
				NickC.putThing();
			}
		}
		NickC.turnLeft();

		NickC.move();
		NickC.turnLeft();
		NickC.move();
		NickC.putThing();
		// turn right
		NickC.turnLeft();
		NickC.turnLeft();
		NickC.turnLeft();

		// for loop to move to last position
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				NickC.move();
			}
			if (i == 1) {
				// turn right
				NickC.turnLeft();
				NickC.turnLeft();
				NickC.turnLeft();
				NickC.move();

			}
			if ( i == 3 )
			{
				// put last thing
				NickC.putThing();
			}
		}

		// move out of the way
		NickC.move();
		NickC.turnLeft();
		NickC.move();
		NickC.putThing();
		NickC.turnLeft();

		// put 1 last thing
		for (int x = 0; x < 3; x++) {
			NickC.move();
			NickC.putThing();

		}
		// get out of screen
		NickC.move();
		NickC.move();







		//		NickC.turnLeft();
		//		NickC.move();
		//		NickC.turnLeft();
		//		NickC.move();
		//		NickC.putThing();
		//		
		//		NickC.move();
		//		NickC.turnLeft();
		//		NickC.turnLeft();
		//		NickC.turnLeft();
		//		NickC.move();
		//		NickC.putThing();
		//		NickC.turnLeft();
		//		NickC.move();
		//		NickC.move();
		//		NickC.move();


	}

}
