import java.util.Random;
import java.awt.Color;
import java.util.*;
import becker.robots.City;
import becker.robots.Direction;
import javaSorting.BankAccount;


public class EidFighterRobotBackup extends FighterRobot {

	private int health,recentFightID;

	public EidFighterRobotBackup(City c, int a, int s, Direction d, int id, int health) {
		super(c, a, s, d, id, 4, 4, 2);
		this.health = health;
		
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void battleResult(int healthLost, int oppID, int oppHealthLost, int numRoundsFought) {
		// TODO Auto-generated method stub
		health -= healthLost;
		recentFightID = oppID;
		if (health <= 0) {
			this.setColor(Color.black);
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
		int myAvenue = this.getAvenue();
		int myStreet= this.getStreet();
		int counter = 0;
		double [][] distance = new double[4][data.length -1];
		
	
		for (int i = 0; i < data.length; i ++) {
			if (data[i].getID() != this.getID()) {
				int vx,vy;
				double dis;
				vx = ((data[i].getAvenue()) - myAvenue);
				vy = ((data[i].getStreet()) - myStreet);
				dis = (Math.sqrt((Math.pow(vx, 2) + (Math.pow(vy, 2)))));
				
				distance[0][counter] = dis;
				distance[1][counter] = data[i].getAvenue();
				distance[2][counter] = data[i].getStreet();
				distance[3][counter] = data[i].getID();
				counter++;
			}
		}
		
		for (int i =0; i < data.length-2;i++) {
			for (int j = i+1; j <data.length-1;j++) {
				if (distance[0][j] < distance[0][i]) {
					double temp1 = distance[0][j];
					double temp2 = distance[1][j];
					double temp3 = distance[2][j];
					double temp4 = distance[3][j];

					distance[0][j] = distance[0][i];
					distance[1][j] = distance[1][i];
					distance[2][j] = distance[2][i];
					distance[3][j] = distance[3][i];

					distance[0][i] = temp1;
					distance[1][i] = temp2;
					distance[2][i] = temp3;
					distance[3][i] = temp4;
				}
			}
		}
		
		
		sortDistance(data);
		
		int closestAvenue = (int) distance[1][0];
		int closestStreet = (int) distance[2][0];
		int closestID = (int) distance[3][0];
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
			numR = 4;
		}
/*		
		if(myAvenue < closestAvenue) {
			x = 1;
		}
		else if (myAvenue > closestAvenue){
			x = -1;
		}
		else {
			if(myStreet < closestStreet) {
				y = 1;
			}
			else if (myStreet > closestStreet){
				y = -1;
			}
		}*/

		
		/*for (int i =0; i < data.length-1;i++) {
			for (int j = i+1; j <data.length;j++) {
				if (data[j].getHealth() < data[i].getHealth()) {
					OppData temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
		}*/

		TurnRequest request = new TurnRequest(this.getAvenue()+x,this.getStreet()+y,fightID,numR);
		return request;
	}
	
	private void sortDistance(OppData[] data) {
		int counter = 0;
		int myAvenue = this.getAvenue();
		int myStreet= this.getStreet();
		double [][] distance = new double[4][data.length -1];
		
		
		for (int i = 0; i < data.length; i ++) {
			if (data[i].getID() != this.getID()) {
				int vx,vy;
				double dis;
				vx = ((data[i].getAvenue()) - myAvenue);
				vy = ((data[i].getStreet()) - myStreet);
				dis = (Math.sqrt((Math.pow(vx, 2) + (Math.pow(vy, 2)))));
				
				distance[0][counter] = dis;
				distance[1][counter] = data[i].getAvenue();
				distance[2][counter] = data[i].getStreet();
				distance[3][counter] = data[i].getID();
				counter++;
			}
		}
		
		for (int i =0; i < data.length-2;i++) {
			for (int j = i+1; j <data.length-1;j++) {
				if (distance[0][j] < distance[0][i]) {
					double temp1 = distance[0][j];
					double temp2 = distance[1][j];
					double temp3 = distance[2][j];
					double temp4 = distance[3][j];

					distance[0][j] = distance[0][i];
					distance[1][j] = distance[1][i];
					distance[2][j] = distance[2][i];
					distance[3][j] = distance[3][i];

					distance[0][i] = temp1;
					distance[1][i] = temp2;
					distance[2][i] = temp3;
					distance[3][i] = temp4;
				}
			}
		}
	}
	
	

}
