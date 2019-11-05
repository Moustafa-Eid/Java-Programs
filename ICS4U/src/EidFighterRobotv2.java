import java.util.Random;
import java.awt.Color;
import java.util.*;
import becker.robots.City;
import becker.robots.Direction;
import javaSorting.BankAccount;


public class EidFighterRobotv2 extends FighterRobot {

	private int health,players,count = 0;
	private double dWeight = 0.4,hWeight = 0.15;
	private int fightsWon[] = new int[players];
	
	public EidFighterRobotv2(City c, int a, int s, Direction d, int id, int health) {
		super(c, a, s, d, id, 4, 4, 2);
		this.health = health;
		this.setColor(Color.GRAY);
		
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void battleResult(int healthLost, int oppID, int oppHealthLost, int numRoundsFought) {
		// TODO Auto-generated method stub
		System.out.println(oppID);
		if (oppID != -1) {
			if (healthLost>oppHealthLost) {
				System.out.println(fightsWon.length);
				fightsWon[oppID] += 1;
			}
			else if(healthLost < oppHealthLost && fightsWon[oppID] > 0) {
				fightsWon[oppID] -= 1;
			}
		}		
	}

	@Override
	public void goToLocation(int a, int s) {
		// TODO Auto-generated method stub
		
		if (this.getAvenue()< a && this.getDirection() == Direction.EAST) {
			this.move();
		}
		if (this.getAvenue()< a && this.getDirection() == Direction.NORTH) {
			this.turnRight();
			this.move();
		}
		if (this.getAvenue()< a && this.getDirection() == Direction.WEST) {
			this.turnAround();
			this.move();
		}
		if (this.getAvenue()< a && this.getDirection() == Direction.SOUTH) {
			this.turnLeft();
			this.move();
		}
		
		//
		if (this.getAvenue()> a && this.getDirection() == Direction.EAST) {
			this.turnAround();
			this.move();
		}
		if (this.getAvenue()> a && this.getDirection() == Direction.NORTH) {
			this.turnLeft();
			this.move();
		}
		if (this.getAvenue()> a && this.getDirection() == Direction.WEST) {
			this.move();
		}
		if (this.getAvenue()> a && this.getDirection() == Direction.SOUTH) {
			this.turnRight();
			this.move();
		}
		
		// 
		if (this.getStreet()< s && this.getDirection() == Direction.EAST) {
			this.turnRight();
			this.move();
		}
		if (this.getStreet()< s && this.getDirection() == Direction.NORTH) {
			this.turnAround();
			this.move();
		}
		if (this.getStreet()< s && this.getDirection() == Direction.WEST) {
			this.turnLeft();
			this.move();
		}
		if (this.getStreet()< s && this.getDirection() == Direction.SOUTH) {
			this.move();
		}
		
		//
		if (this.getStreet()> s && this.getDirection() == Direction.EAST) {
			this.turnLeft();
			this.move();
		}
		if (this.getStreet()> s && this.getDirection() == Direction.NORTH) {
			this.move();
		}
		if (this.getStreet()> s && this.getDirection() == Direction.WEST) {
			this.turnRight();
			this.move();
		}
		if (this.getStreet()> s && this.getDirection() == Direction.SOUTH) {
			this.turnAround();
			this.move();
		}
		
		
	}

	@Override
	public TurnRequest takeTurn(int energy, OppData[] data) {
		// TODO Auto-generated method stub
		players = data.length;
		EidEnhancedOppData[] dataE = new EidEnhancedOppData[data.length];
		int myAvenue = this.getAvenue();
		int myStreet= this.getStreet();
		int myID = this.getID();
		int closestAvenue = 0;
		int closestStreet = 0;
		int closestID = 0;
	    int[] turn = new int[4];
	    
	    for(int i = 0; i < data.length; i ++) {
	    	if (data[i].getID() == myID) {
	    		health = data[i].getHealth();
	    	}
	    }

		sortData(data);
		
		System.out.println("[" + count + "]");
		if (count == 0) {
			fightsWon = new int [players];
			for (int i = 0; i < players; i++) {
				fightsWon[i] = 0;
			}
		}

		for (int i = 0; i < dataE.length; i++) {
			dataE[i] = new EidEnhancedOppData(data[i].getID(),data[i].getAvenue(),data[i].getStreet(),data[i].getHealth(),fightsWon[i],average(data,i));
		}
		for (int i = 0; i < dataE.length; i++) {
			System.out.print(dataE[i].getID() + ", ");
		}
		System.out.println("\n");
		for (int i = 0; i < dataE.length; i++) {
			System.out.print(dataE[i].getLoss() + ", ");
		}
		if (data.length >= 4) {
			for (int i = 0; i < 2; i++) {
				int min = dataE[i].getLoss();
				for (int j = i+1; j < 3; j ++) {
					if (dataE[j].getLoss() < min) {
						EidEnhancedOppData temp = dataE[i];
						dataE[i] = dataE[j];
						dataE[j] = temp;
					}
				}
			}
		}
		System.out.println("\n");
		for (int i = 0; i < dataE.length; i++) {
			System.out.print(dataE[i].getID() + ", ");
		}
		
		for (int i = 0; i < data.length; i++) {
			if (dataE[i].getID() != myID && dataE[i].getHealth() > 0) {
				closestAvenue = dataE[i].getAvenue();
				closestStreet = dataE[i].getStreet();
				closestID = dataE[i].getID();
				break;
		}
	}
		int x = 0,y = 0,fightID = -1,numR = 0;
		
		
		if (energy > 30 && health > 45) {
			if (this.frontIsClear()) {
				turn = attack(x,y,myAvenue,myStreet,closestAvenue,closestStreet,fightID,numR,closestID);
			}
			else {
				if (myAvenue > 18) {
					turn[0] = -1;
					turn[1] = 0;
					turn[2] = -1;
					turn[3] = 4;
				}
				if (myAvenue < 1) {
					turn[0] = 1;
					turn[1] = 0;
					turn[2] = -1;
					turn[3] = 4;
				}
				if (myStreet > 10) {
					turn[0] = 0;
					turn[1] = -1;
					turn[2] = -1;
					turn[3] = 4;
				}
				if (myStreet < 1) {
					turn[0] = 0;
					turn[1] = 1;
					turn[2] = -1;
					turn[3] = 4;
				}
				
			}
		}
		else if (energy <= 15 && health > 45) {
			turn[0] = 0;
			turn[1] = 0;
			turn[2] = -1;
			turn[3] = 4;
		}
		else if (energy > 15 && health <= 45) {
			dWeight = 0;
			hWeight = 1;
			
			if (this.frontIsClear()) {
				turn = defence(x,y,myAvenue,myStreet,closestAvenue,closestStreet,fightID,numR,closestID);
			}
			else {
				if (myAvenue > 18) {
					turn[0] = -1;
					turn[1] = 0;
					turn[2] = -1;
					turn[3] = 4;
				}
				if (myAvenue < 1) {
					turn[0] = 1;
					turn[1] = 0;
					turn[2] = -1;
					turn[3] = 4;
				}
				if (myStreet > 10) {
					turn[0] = 0;
					turn[1] = -1;
					turn[2] = -1;
					turn[3] = 4;
				}
				if (myStreet < 1) {
					turn[0] = 0;
					turn[1] = 1;
					turn[2] = -1;
					turn[3] = 4;
				}
				
			}
		}
		else {
			if (this.frontIsClear()) {
				turn[0] = -1;
				turn[1] = 1;
				turn[2] = -1;
				turn[3] = 4;
			}
		}
		

		
		
		


		int xchoice = myAvenue + turn[0];
		int ychoice = myStreet + turn[1];
		fightID = turn[2];
		System.out.println("\n" + fightID);
		numR = turn[3];
		
		if (fightID == myID) {
			fightID = -1;
		}
		
		count++;
		System.out.println("x: " + x + ", y:" + y);
		TurnRequest request = new TurnRequest(xchoice,ychoice,fightID,numR);
		return request;
	}
	
	private double distance(OppData[] data, int i) {
		int counter = 0;
		int myAvenue = this.getAvenue();
		int myStreet= this.getStreet();
		int vx,vy;
		double dis;
		vx = ((data[i].getAvenue()) - myAvenue);
		vy = ((data[i].getStreet()) - myStreet);
		dis = (Math.sqrt((Math.pow(vx, 2) + (Math.pow(vy, 2)))));
		
		return dis;
	}
	
	private double average(OppData[] data, int i) {
		double average,dCalc,hCalc;
		dWeight = 0.4;
		hWeight = 0.15;
		dCalc = distance(data,i) * dWeight;
		hCalc = data[i].getHealth() * hWeight;
		
		average = dCalc+hCalc;
		return average;
	}
	
	private void sortData(OppData[] data) {
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
	
	public void setLabel() {
		this.setLabel("Health: " + health);
	}
	
	public int[] attack(int x, int y, int myAvenue, int myStreet, int closestAvenue, int closestStreet, int fightID, int numR, int closestID) {
		int attackData [] = new int[4];
		if (myAvenue - closestAvenue == 1 && myStreet - closestStreet == 1) {
			x = -1;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		else if (myAvenue - closestAvenue == -1 && myStreet - closestStreet == -1) {
			x = 1;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		else if (myAvenue - closestAvenue == 1 && myStreet - closestStreet == -1) {
			x = -1;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		else if (myAvenue - closestAvenue == -1 && myStreet - closestStreet == 1) {
			x = 1;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		else if (myAvenue - closestAvenue == -1 && myStreet == closestStreet) {
			x = 1;
			y = 0;
			fightID = closestID;
			numR = 4;
		}
		else if (myAvenue - closestAvenue == 1 && myStreet == closestStreet) {
			x = -1;
			y = 0;
			fightID = closestID;
			numR = 4;
		}
		else if (myAvenue == closestAvenue && myStreet - closestStreet == -1) {
			x = 0;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		else if (myAvenue == closestAvenue && myStreet - closestStreet == 1) {
			x = 0;
			y = -1;
			fightID = closestID;
			numR = 4;
		}
		else if (myAvenue < closestAvenue && myStreet > closestStreet){
			x = 1;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue > closestAvenue && myStreet < closestStreet){
			x = -1;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue > closestAvenue && myStreet > closestStreet){
			x = -1;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue < closestAvenue && myStreet == closestStreet) {
			x = 1;
			y = 0;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue > closestAvenue && myStreet == closestStreet) {
			x = -1;
			y = 0;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue == closestAvenue && myStreet < closestStreet) {
			x = 0;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue == closestAvenue && myStreet > closestStreet) {
			x = 0;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue == closestAvenue && myStreet == closestStreet) {
			x = 0;
			y = 0;
			fightID = closestID;
			numR = 4;
		}

		
		attackData[0] = x;
		attackData[1] = y;
		attackData[2] = fightID;
		attackData[3] = numR;
		
		return attackData;

	}
	
	public int[] defence(int x, int y, int myAvenue, int myStreet, int closestAvenue, int closestStreet, int fightID, int numR, int closestID) {	
		int defenceData [] = new int[4];

		if(myAvenue < closestAvenue && myStreet < closestStreet) {
			x = -1;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue < closestAvenue && myStreet > closestStreet){
			x = -1;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue > closestAvenue && myStreet < closestStreet){
			x = 1;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue > closestAvenue && myStreet > closestStreet){
			x = 1;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue < closestAvenue && myStreet == closestStreet) {
			x = -1;
			y = 0;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue > closestAvenue && myStreet == closestStreet) {
			x = 1;
			y = 0;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue == closestAvenue && myStreet < closestStreet) {
			x = 0;
			y = -1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue == closestAvenue && myStreet > closestStreet) {
			x = 0;
			y = 1;
			fightID = -1;
			numR = 0;
		}
		else if (myAvenue == closestAvenue && myStreet == closestStreet) {
			x = -1;
			y = 1;
			fightID = closestID;
			numR = 4;
		}
		defenceData[0] = x;
		defenceData[1] = y;
		defenceData[2] = fightID;
		defenceData[3] = numR;
		
		return defenceData;
	}
}
