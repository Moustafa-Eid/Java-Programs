package javaRobots;
import becker.robots.*;
import java.util.*;
public class R3E2 {

	/**
	 * Bar Graph Drawer
	 * @author Moustafa Eid
	 * @version 11/15/2017
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create City
		City Alexandria = new City();
		// Create Robot
		BarDrawer rick = new BarDrawer (Alexandria,1,1,Direction.EAST);
		// Create Random Generator
		Random generator = new Random();
		// randomize number of bars
		int numBars = generator.nextInt(6) + 1;
		// show count of things
		Alexandria.showThingCounts(true);	
		
		// for loop to put things in the starting positions
		for (int i = 1; i < numBars + 1; i++) {
			int bar = generator.nextInt(14) + 1;
			for (int j = 0; j < bar; j++) {
				Thing Points = new Thing(Alexandria,i,1);
			}
		}
		
		// Graph things
		rick.Graph();
	}

}
