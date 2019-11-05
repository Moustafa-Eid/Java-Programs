import java.util.Random;
import java.awt.Color;
import java.util.*;
import becker.robots.City;
import becker.robots.Direction;
import javaSorting.BankAccount;

/**
 * EidFighterRobot Summative AI
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class EidFighterRobot extends FighterRobot {

	// declaring global variables
	private int health,players,count = 0,defcount = 0;
	private double dWeight = 0.7,hWeight = 0.3;
	private int fightsWon[] = new int[players];

	/**
	 * This method sets up the robot.
	 * @param City is the name of the city
	 * @param a is the number of avenue coordinate
	 * @param s is the number of street coordinate
	 * @param Direction is where the robot is facing
	 * @param health is the health value of robot
	 */
	public EidFighterRobot(City c, int a, int s, Direction d, int id, int health) {
		super(c, a, s, d, id, 4, 4, 2);
		this.health = health;
		this.setColor(Color.GRAY);
		this.setLabel();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method returns data after a fight
	 * @param healthLost is how much health was lost / gained per fight
	 * @param oppId is the ID of the robot you just fought
	 * @param oppHealthLost is how much health was lost / gained per fight for opponent
	 * @param numRoundsFought is how many rounds i fought
	 */
	@Override
	public void battleResult(int healthLost, int oppID, int oppHealthLost, int numRoundsFought) {
		// TODO Auto-generated method stub
		System.out.println("healthlost = " + healthLost);
		System.out.println(oppID + " opphealthlost = " + oppHealthLost);
		this.setLabel();
		// if health is 0 then set robots colour black
		if (health <= 3) {
			this.setColor(Color.black);
		}
		// If oppID is fighting my robot
		if (oppID != -1) {
			// if my lost health is higher than the opponents, i lost the fight therefore add 1 to array for fightsWon
			if (healthLost>oppHealthLost) {
				System.out.println(fightsWon.length);
				fightsWon[oppID] += 1;
			}
			// if my lost health is lower than the opponents, i won the fight therefore deduct 1 to array for fightsWon
			else if(healthLost < oppHealthLost && fightsWon[oppID] > 0) {
				fightsWon[oppID] -= 1;
			}
		}		
	}

	/**
	 * This method sets up the basic movement of the robot.
	 * @param a is the number of avenue coordinate
	 * @param s is the number of street coordinate
	 */
	@Override
	public void goToLocation(int a, int s) {
		// TODO Auto-generated method stub

		// if i am to the left of my intended location and facing East then move this way
		if (this.getAvenue()< a && this.getDirection() == Direction.EAST) {
			this.move();
		}
		// if i am to the left of my intended location and facing North then move this way
		if (this.getAvenue()< a && this.getDirection() == Direction.NORTH) {
			this.turnRight();
			this.move();
		}
		// if i am to the left of my intended location and facing West then move this way
		if (this.getAvenue()< a && this.getDirection() == Direction.WEST) {
			this.turnAround();
			this.move();
		}
		// if i am to the left of my intended location and facing South then move this way
		if (this.getAvenue()< a && this.getDirection() == Direction.SOUTH) {
			this.turnLeft();
			this.move();
		}

		// if i am to the right of my intended location and facing East then move this way
		if (this.getAvenue()> a && this.getDirection() == Direction.EAST) {
			this.turnAround();
			this.move();
		}
		// if i am to the right of my intended location and facing North then move this way
		if (this.getAvenue()> a && this.getDirection() == Direction.NORTH) {
			this.turnLeft();
			this.move();
		}
		// if i am to the right of my intended location and facing West then move this way
		if (this.getAvenue()> a && this.getDirection() == Direction.WEST) {
			this.move();
		}
		// if i am to the right of my intended location and facing South then move this way
		if (this.getAvenue()> a && this.getDirection() == Direction.SOUTH) {
			this.turnRight();
			this.move();
		}

		// if i am above my intended location and facing East then move this way
		if (this.getStreet()< s && this.getDirection() == Direction.EAST) {
			this.turnRight();
			this.move();
		}
		// if i am above my intended location and facing North then move this way
		if (this.getStreet()< s && this.getDirection() == Direction.NORTH) {
			this.turnAround();
			this.move();
		}
		// if i am above my intended location and facing West then move this way
		if (this.getStreet()< s && this.getDirection() == Direction.WEST) {
			this.turnLeft();
			this.move();
		}
		// if i am above my intended location and facing South then move this way
		if (this.getStreet()< s && this.getDirection() == Direction.SOUTH) {
			this.move();
		}

		// if i am below my intended location and facing East then move this way
		if (this.getStreet()> s && this.getDirection() == Direction.EAST) {
			this.turnLeft();
			this.move();
		}
		// if i am below my intended location and facing North then move this way
		if (this.getStreet()> s && this.getDirection() == Direction.NORTH) {
			this.move();
		}
		// if i am below my intended location and facing West then move this way
		if (this.getStreet()> s && this.getDirection() == Direction.WEST) {
			this.turnRight();
			this.move();
		}
		// if i am below my intended location and facing South then move this way
		if (this.getStreet()> s && this.getDirection() == Direction.SOUTH) {
			this.turnAround();
			this.move();
		}


	}

	/**
	 * This method decides what the robot will do each turn.
	 * @param energy is the number that my robot has for energy
	 * @param data is the array with all the opponents data used for calculations
	 */
	@Override
	public TurnRequest takeTurn(int energy, OppData[] data) {
		// TODO Auto-generated method stub
		// declaring local variables and declaring arrays
		players = data.length;
		// Enhance OppData Record declaration
		EidEnhancedOppData[] dataE = new EidEnhancedOppData[data.length];
		int myAvenue = this.getAvenue();
		int myStreet= this.getStreet();
		int myID = this.getID();
		int closestAvenue = 0;
		int closestStreet = 0;
		int closestID = 0;
		// Array for decision making
		int[] turn = new int[4];

		// for loop that goes through the data array
		for (int i = 0 ; i < data.length;i++) {
			// if my id is found then set my global health variable to equal to that health
			if (data[i].getID() ==  this.getID()) {
				health = data[i].getHealth();
			}
		}

		// calling the method that sorts the oppData Array based on distance and average.
		sortData(data);

		// set all values in fightsWon Array to 0 as a starting point
		if (count == 0) {
			fightsWon = new int [players];
			for (int i = 0; i < players; i++) {
				fightsWon[i] = 0;
			}
		}

		// for loop that transfers data from oppData array to Enhanced oppData Array and adds more data like FightsWon and score
		for (int i = 0; i < dataE.length; i++) {
			dataE[i] = new EidEnhancedOppData(data[i].getID(),data[i].getAvenue(),data[i].getStreet(),data[i].getHealth(),fightsWon[data[i].getID()],average(data,i));
		}

		// for loop that takes my robots data and puts it at the end of the array.
		for (int i = 0; i < dataE.length; i++) {
			// if loop finds my data
			if (dataE[i].getID() == myID) {
				EidEnhancedOppData temp = dataE[i];
				// then push all data forward and then put my data at end
				for (int j = i+1; j < dataE.length; j++) {
					dataE[j-1] = dataE[j];
				}
				dataE[dataE.length-1] = temp;
			}
		}

		// if players are 4 or more then sort first 3 elements of array using fightsWon Data
		if (data.length >= 4) {
			// for loop that goes through first 2 elements
			for (int i = 0; i < 2; i++) {
				int min = dataE[i].getLoss();
				// for loop for last element
				for (int j = i+1; j < 3; j ++) {
					// if they have less fightsWon then put them in front of the array
					if (dataE[j].getLoss() < min) {
						EidEnhancedOppData temp = dataE[i];
						dataE[i] = dataE[j];
						dataE[j] = temp;
					}
				}
			}
		}
		// else if there are less than 4 players then sort first 2 elements
		else {
			// for loop that goes through first element
			for (int i = 0; i < 1; i++) {
				int min = dataE[i].getLoss();
				// for loop that goes through 2nd element
				for (int j = i+1; j < 2; j ++) {
					// if statement that puts lowest fightsWon at the beginning of array
					if (dataE[j].getLoss() < min) {
						EidEnhancedOppData temp = dataE[i];
						dataE[i] = dataE[j];
						dataE[j] = temp;
					}
				}
			}
		}


		// for loop that calculates the location of the best robot to attack
		for (int i = 0; i < data.length; i++) {
			// if the id is not my id and health > 0 then get closest avenue and street
			if (dataE[i].getID() != myID && dataE[i].getHealth() > 0) {
				closestAvenue = dataE[i].getAvenue();
				closestStreet = dataE[i].getStreet();
				closestID = dataE[i].getID();
				break;
			}
		}
		// declaring variables for lowest health
		int lowestHealthID = 0;
		int minhealth = 100;

		// for loop that sets variable to min health
		for (int i = 0; i < dataE.length; i++) {
			if (dataE[i].getID() != myID) {
				if (dataE[i].getHealth() < minhealth) {
					minhealth = dataE[i].getHealth();
					lowestHealthID = dataE[i].getID();
				}
			}
		}
		// getting avenue and street for health
		int lowestHealthAvenue = dataE[lowestHealthID].getAvenue();
		int lowestHealthStreet = dataE[lowestHealthID].getStreet();

		int x = 0,y = 0,fightID = -1,numR = 0,xchoice,ychoice;

		// if energy and health is high then attack
		if (energy > 30 && health > 45) {
			defcount = 0;
			if (this.frontIsClear()) {
				System.out.println("attack");
				turn = attack(x,y,myAvenue,myStreet,closestAvenue,closestStreet,fightID,numR,closestID);
			}
		}
		// else if energy is low but health is high or both are low then don't move to regain energy
		else if ((energy <= 30 && health > 45) || (energy <= 45 && health <= 45)) {
			turn[0] = 0;
			turn[1] = 0;
			turn[2] = -1;
			turn[3] = 4;
		}
		// if energy is greater than 30 and health is low then defence for 5 rounds
		else if (energy > 30 && health <= 45) {
			if (this.frontIsClear()) {
				if (defcount < 5) {
					System.out.println("defence");
					turn = defence(x,y,myAvenue,myStreet,closestAvenue,closestStreet,fightID,numR,closestID);
					// This count was the one i forgot mr ching
					defcount++;								//
					//										//
				}
				// then attack 
				else {
					defcount = 0;
					System.out.println("attack");
					turn = attack(x,y,myAvenue,myStreet,lowestHealthAvenue,lowestHealthStreet,fightID,numR,closestID);

				}
			}
		}
		
		if (this.getDirection() == Direction.NORTH && myStreet == 0 && energy > 30) {
			turn[0] = 0;
			turn[1] = 1;
			turn[2] = -1;
			turn[3] = 0;
		}

		// set all the array to variables
		xchoice = myAvenue + turn[0];
		ychoice = myStreet + turn[1];
		fightID = turn[2];
		System.out.println("\n" + fightID);
		numR = turn[3];

		// if the fightID = my ID then dont fight
		if (fightID == myID) {
			fightID = -1;
		}

		// if 1st round and i start at top then go down
		if (count == 0 && myStreet == 0) {
			ychoice = myStreet + 1;
		}
		

		count++;
		// request turn
		TurnRequest request = new TurnRequest(xchoice,ychoice,fightID,numR);
		return request;
	}

	/**
	 * This method calculates distance
	 * @param i is the index of the robot
	 * @param data is the array with all the opponents data used for calculations
	 */
	private double distance(OppData[] data, int i) {
		// declaring local variables
		int counter = 0;
		int myAvenue = this.getAvenue();
		int myStreet= this.getStreet();
		int vx,vy;
		double dis;

		// calculate velocity x and y
		vx = ((data[i].getAvenue()) - myAvenue);
		vy = ((data[i].getStreet()) - myStreet);
		// calculate distance
		dis = (Math.sqrt((Math.pow(vx, 2) + (Math.pow(vy, 2)))));

		return dis;
	}

	/**
	 * This method calculates weighted average
	 * @param i is the index of the robot
	 * @param data is the array with all the opponents data used for calculations
	 */
	private double average(OppData[] data, int i) {
		// declaring local variables
		double average,dCalc,hCalc;
		// calculate numbers for distance and health then add them
		dCalc = distance(data,i) * dWeight;
		hCalc = data[i].getHealth() * hWeight;

		average = dCalc+hCalc;
		// return weighted average
		return average;
	}

	/**
	 * This method sorts the oppData Array using distance and average
	 * @param data is the array with all the opponents data used for calculations
	 */
	private void sortData(OppData[] data) {
		// for loop that sorts data using average with selection sort
		for (int i = 0; i < data.length-1; i++) {
			for (int j = i+1; j < data.length; j++) {
				if (average(data,j) < average(data,i)) {
					OppData temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	/**
	 * This method sets the label for health and ID
	 */
	public void setLabel() {
		// set label for health and ID
		this.setLabel("H: " + health + " ID: " + this.getID());
	}

	/**
	 * This query method returns an array of decisions for attack
	 * @param x is the addition to x coord each turn
	 * @param y is the addition to y coord each turn
	 * @param myAvenue is the avenue my robot is at
	 * @param myStreet is the street my robot is at
	 * @param closestAvenue is the closest Avenue and best to attack
	 * @param closestStreet is the closest Street and best to attack
	 * @param fightID is the decision on who to fight
	 * @param numR is how many rounds to fight a robot
	 * @param closestID is the ID of the closest  robot
	 */
	public int[] attack(int x, int y, int myAvenue, int myStreet, int closestAvenue, int closestStreet, int fightID, int numR, int closestID) {
		int attackData [] = new int[4];
		// if robot is 1 away and in this direction then move this way
		if (myAvenue - closestAvenue == 1 && myStreet - closestStreet == 1) {
			x = -1;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == -1 && myStreet - closestStreet == -1) {
			x = 1;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == 1 && myStreet - closestStreet == -1) {
			x = -1;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == -1 && myStreet - closestStreet == 1) {
			x = 1;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == -1 && myStreet == closestStreet) {
			x = 1;
			y = 0;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == 1 && myStreet == closestStreet) {
			x = -1;
			y = 0;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue == closestAvenue && myStreet - closestStreet == -1) {
			x = 0;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue == closestAvenue && myStreet - closestStreet == 1) {
			x = 0;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is left and below destination move this way
		else if (myAvenue < closestAvenue && myStreet > closestStreet){
			x = 1;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		// if robot is right and above destination move this way
		else if (myAvenue > closestAvenue && myStreet < closestStreet){
			x = -1;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		// if robot is right and below below move this way
		else if (myAvenue > closestAvenue && myStreet > closestStreet){
			x = -1;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		// if robot is left and below above move this way
		else if (myAvenue < closestAvenue && myStreet < closestStreet){
			x = 1;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		// left and same street
		else if (myAvenue < closestAvenue && myStreet == closestStreet) {
			x = 1;
			y = 0;
			fightID = -1;
			numR = 0;
		}
		// right and same street
		else if (myAvenue > closestAvenue && myStreet == closestStreet) {
			x = -1;
			y = 0;
			fightID = -1;
			numR = 0;
		}
		// if above and avenue same
		else if (myAvenue == closestAvenue && myStreet < closestStreet) {
			x = 0;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		// if below and avenue same
		else if (myAvenue == closestAvenue && myStreet > closestStreet) {
			x = 0;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		// if on the same spot
		else if (myAvenue == closestAvenue && myStreet == closestStreet) {
			x = 0;
			y = 0;
			fightID = closestID;
			numR = 4;
		}

		// add all data to array and return it
		attackData[0] = x;
		attackData[1] = y;
		attackData[2] = fightID;
		attackData[3] = numR;

		return attackData;

	}

	/**
	 * This query method returns an array of decisions for attack
	 * @param x is the addition to x coord each turn
	 * @param y is the addition to y coord each turn
	 * @param myAvenue is the avenue my robot is at
	 * @param myStreet is the street my robot is at
	 * @param closestAvenue is the closest Avenue and best to attack
	 * @param closestStreet is the closest Street and best to attack
	 * @param fightID is the decision on who to fight
	 * @param numR is how many rounds to fight a robot
	 * @param closestID is the ID of the closest  robot
	 */
	public int[] defence(int x, int y, int myAvenue, int myStreet, int closestAvenue, int closestStreet, int fightID, int numR, int closestID) {	
		int defenceData [] = new int[4];
		// if robot is 1 away and in this direction then move this way
		if (myAvenue - closestAvenue == 1 && myStreet - closestStreet == 1) {
			x = 1;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == -1 && myStreet - closestStreet == -1) {
			x = -1;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == 1 && myStreet - closestStreet == -1) {
			x = 1;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == -1 && myStreet - closestStreet == 1) {
			x = -1;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == -1 && myStreet == closestStreet) {
			x = -1;
			y = 0;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue - closestAvenue == 1 && myStreet == closestStreet) {
			x = 1;
			y = 0;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue == closestAvenue && myStreet - closestStreet == -1) {
			x = 0;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is 1 away and in this direction then move this way
		else if (myAvenue == closestAvenue && myStreet - closestStreet == 1) {
			x = 0;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		// if robot is left and below destination move this way
		else if (myAvenue < closestAvenue && myStreet > closestStreet){
			x = -1;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		// if robot is right and above destination move this way
		else if (myAvenue > closestAvenue && myStreet < closestStreet){
			x = 1;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		// if robot is right and below below move this way
		else if (myAvenue > closestAvenue && myStreet > closestStreet){
			x = 1;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		// if robot is left and below above move this way
		else if (myAvenue < closestAvenue && myStreet < closestStreet){
			x = -1;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		// left and same street
		else if (myAvenue < closestAvenue && myStreet == closestStreet) {
			x = -1;
			y = 0;
			fightID = -1;
			numR = 0;
		}
		// right and same street
		else if (myAvenue > closestAvenue && myStreet == closestStreet) {
			x = 1;
			y = 0;
			fightID = -1;
			numR = 0;
		}
		// if above and avenue same
		else if (myAvenue == closestAvenue && myStreet < closestStreet) {
			x = 0;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		// if below and avenue same
		else if (myAvenue == closestAvenue && myStreet > closestStreet) {
			x = 0;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		// if on the same spot
		else if (myAvenue == closestAvenue && myStreet == closestStreet) {
			x = 0;
			y = 0;
			fightID = closestID;
			numR = 4;
		}


		
		
		// put all data in to array and return it
		defenceData[0] = x;
		defenceData[1] = y;
		defenceData[2] = fightID;
		defenceData[3] = numR;

		return defenceData;
	}
}
