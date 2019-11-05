import java.util.Random;
import java.awt.Color;
import java.util.*;
import becker.robots.City;
import becker.robots.Direction;
import javaSorting.BankAccount;


public class EidFighterRobotv1 extends FighterRobot {

	private int health;
	private int fightsWon[] = {0,0,0,0,0,0,0,0,0};
	
	public EidFighterRobotv1(City c, int a, int s, Direction d, int id, int health) {
		super(c, a, s, d, id, 5, 3, 2);
		this.health = health;
		this.setColor(Color.GRAY);
		
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void battleResult(int healthLost, int oppID, int oppHealthLost, int numRoundsFought) {
		// TODO Auto-generated method stub
		health -= healthLost;
		if (healthLost>oppHealthLost) {
			fightsWon[oppID] += 1;
		}
		else if(healthLost < oppHealthLost) {
			fightsWon[oppID] -= 1;
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
		EidEnhancedOppData[] dataE = new EidEnhancedOppData[data.length];
		int myAvenue = this.getAvenue();
		int myStreet= this.getStreet();
		int myID = this.getID();
		int closestAvenue = 0;
		int closestStreet = 0;
		int closestID = 0;
		sortData(data);

		for (int i = 0; i < dataE.length; i++) {
			dataE[i] = new EidEnhancedOppData(data[i].getID(),data[i].getAvenue(),data[i].getStreet(),data[i].getHealth(),fightsWon[i],average(data,i));
		}

		
		
		for (int i = 0; i < data.length; i++) {
			if (data[i].getID() != myID && data[i].getHealth() > 0) {
				closestAvenue = data[i].getAvenue();
				closestStreet = data[i].getStreet();
				closestID = data[i].getID();
				break;
		}
	}
			int x = 0,y = 0,fightID = -1,numR = 0;			

		if(myAvenue < closestAvenue && myStreet < closestStreet) {
			x = 1;
			y = 1;
			fightID = -1;
			numR = 0;
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
			numR = 5;
		}


		
		

		TurnRequest request = new TurnRequest(this.getAvenue()+x,this.getStreet()+y,fightID,numR);
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
		double dWeight = 0.6,hWeight = 0.1,average,dCalc,hCalc;
		
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
}
