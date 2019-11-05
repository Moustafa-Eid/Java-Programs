package javaAssignments;
import becker.robots.*;
import java.util.*;
	/**
	 * Sweeper robot Application Class
	 * @author Moustafa Eid
	 * @version 11/22/2017
	 */
public class EidAssignment1 {
	
	/**
	 * Sweeper robot Application Class
	 */
	
	public static void main(String[] args) {
		
		// Create a City
		City zimbabwe = new City(15,34);
		
		
		// Create Random Generator
		Random generator = new Random();
		
		
		// variable that stores a random  y value of the starting ground location
		int y_start = generator.nextInt(10) + 3;
		// variable that stores a random value for the number of steps going up
		int stairs  = generator.nextInt(10) + 1;
		// variable that stores a random value for the number of steps going down
		int stairs_end = generator.nextInt(10) + 1;
		// variable that stores a random value for the length of the starting ground
		int start  = generator.nextInt(4) + 1;
		// variable that stores a random value for the length of the top of the stairs
		int top = generator.nextInt(4);
		// variable that stores a random value for the length of the ending ground
		int end = generator.nextInt(4) + 3;
		// variable that stores a random value for the position of the garbage can between the start and end of ending ground
		int garbagepos = generator.nextInt(end) + 1 ;

		// a variable that stores the x value of garbage can
		int garbage = stairs+start+top+stairs_end;
		
		// creating the sweeper Robot
		EidSweeperRobot cleaner = new EidSweeperRobot (zimbabwe,y_start,0,Direction.EAST);
		// show how many things are available
		zimbabwe.showThingCounts(true);

		
		// up stairs
		for (int i = 0; i < stairs; i++){
			// y position
			int y = y_start - i;
			// x position
			int x = i + start;
			// drawing stair
			Wall stairup = new Wall(zimbabwe,y, x,Direction.WEST);
			Wall stair = new Wall(zimbabwe, y, x,Direction.NORTH);
			// boolean for thing
			boolean thing = generator.nextBoolean();
			// if boolean is true generate a thing at that location
			if (thing == true) {
				Thing trash = new Thing (zimbabwe, y,x-1);
			}
		}
		
		
		// start ground
		for (int i = 0; i < start; i++){
			// drawing ground
			Wall groundstart = new Wall(zimbabwe,y_start, i,Direction.SOUTH);
			// boolean for thing
			boolean thing = generator.nextBoolean();
			// if boolean is true generate a thing at that location
			if (thing == true) {
				Thing trash = new Thing (zimbabwe, y_start,i);
			}
		}
		
		
		// end ground
		for (int i = 0; i < end; i++){
			// drawing ground
			Wall groundend = new Wall(zimbabwe,((y_start)-stairs)+ stairs_end,garbage+i-1,Direction.SOUTH);
			// boolean for thing
			boolean thing = generator.nextBoolean();
			// if boolean is true generate a thing at that location
			if (thing == true) {
				Thing trash = new Thing (zimbabwe, ((y_start)-stairs)+ stairs_end,garbage+i-1);
			}
		}
		
		
		// top ground
		for (int i = 0; i < top; i++){
			// drawing ground
			Wall topstairs = new Wall(zimbabwe,((y_start+1)-stairs), (stairs+start+i),Direction.NORTH);
			// boolean for thing
			boolean thing = generator.nextBoolean();
			// if boolean is true generate a thing at that location
			if (thing == true) {
				Thing trash = new Thing (zimbabwe,(y_start-stairs),(stairs+start+i));
			}
		}
		// down stairs
		for (int i = 0; i < stairs_end; i++){
			// y position
			int y = ((y_start+1)-stairs) + i;
			// x position
			int x = i + (start+stairs+top-1);
			// drawing stairs going down
			Wall stairdown = new Wall(zimbabwe,y, x,Direction.EAST);
			Wall stairright= new Wall(zimbabwe, y, x,Direction.NORTH);
			// boolean for thing
			boolean thing = generator.nextBoolean();
			// if boolean is true generate a thing at that location
			if (thing == true) {
				Thing trash = new Thing (zimbabwe, y,x+1);
			}
		}
		
		// Drawing Walls and ground for Garbage Can
		Wall garbageside = new Wall(zimbabwe,((y_start)-stairs)+ stairs_end, garbage + garbagepos-1,Direction.WEST);
		Wall garbageside2 = new Wall(zimbabwe,((y_start)-stairs)+ stairs_end, garbage+ garbagepos-1,Direction.EAST);
		Wall ground = new Wall(zimbabwe,((y_start)-stairs)+ stairs_end,garbage + garbagepos-1,Direction.SOUTH);
		Wall ground2 = new Wall(zimbabwe,((y_start)-stairs)+ stairs_end,garbage + garbagepos,Direction.SOUTH);

		// telling robot to start cleaning
		cleaner.sweepStairs();



	}
		

}
