package javaRobots;
import becker.robots.*;
public class R3E1 {
	/**
	 * Drug Hurdle Runner
	 * @author Moustafa Eid
	 * @version 11/15/2017
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create City
		City Alexandria = new City();
		// Create Robots
		DrugRunner Sheridan = new DrugRunner (Alexandria,3,0,Direction.EAST);
		DrugRunner Ching = new DrugRunner (Alexandria,3,4,Direction.EAST);
		// Create Thing
		Thing Drugs = new Thing (Alexandria,3,0);
		// Create vertical Walls that act as ground
		for (int i = 0; i <10 ; i++) {
			Wall walls = new Wall(Alexandria,3,i, Direction.SOUTH);
		}
		// Create vertical Walls that act as hurdles
		for (int j = 1; j < 8; j+=2) {
			for (int i = 0; i <2 ; i++) {
				Wall walls = new Wall(Alexandria, 3-i,j, Direction.EAST);
			}
		}
		
		// Robot 1 do drug run
		Sheridan.doDrugRun();
		// Robot 2 do drug run
		Ching.doDrugRun();


		
		
	}

}
