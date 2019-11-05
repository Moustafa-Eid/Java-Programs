import java.awt.Color;
import java.util.Random;

import becker.robots.City;
import becker.robots.Direction;

public class TestFighterRobot2 extends FighterRobot {


	private int health,count = 1;

	public TestFighterRobot2(City c, int a, int s, Direction d, int id, int health) {
		super(c, a, s, d, id, 6, 4, 1);
		this.health = health;
		
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void battleResult(int healthLost, int oppID, int oppHealthLost, int numRoundsFought) {
		// TODO Auto-generated method stub
		
		health -= healthLost;
		if (health <= 0) {
			this.setColor(Color.BLACK);
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
		Random generator = new Random();
		int x = 1;
		if (count % 2 == 0) {
			x = 1;
		}
		else {
			x = -1;
		}
		count ++;
		TurnRequest request = new TurnRequest(this.getAvenue() + x,this.getStreet() ,-1,0);
		return request;
	}

}
