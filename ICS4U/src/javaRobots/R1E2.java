package javaRobots;
import becker.robots.*;
/**
 * draw a walled city
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class R1E2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create city
		City Trump = new City ();
		// create 2d arrays for walls
		Wall [][] walls = new Wall[4][5];
		
		// create north wall
		for (int i = 0; i < 5; i++) {
			walls[0][i] = new Wall(Trump, 1,1+i, Direction.NORTH);
		}
		// create south wall
		for (int i = 0; i < 5; i++) {
			walls[3][i] = new Wall(Trump, 4,1+i, Direction.SOUTH);
		}
		// create west wall
		for (int i = 0; i < 4; i++) {
			walls[i][0] = new Wall(Trump, 1+i,1, Direction.WEST);
		}
		// create east wall
		for (int i = 0; i < 4; i++) {
			walls[i][4] = new Wall(Trump, 1+i,5, Direction.EAST);
		}
	}

}
