import java.awt.Color;
import java.util.Random;

import becker.robots.City;
import becker.robots.Direction;

public class TestFighterRobot extends FighterRobot {


	private int health;

	public TestFighterRobot(City c, int a, int s, Direction d, int id, int health) {
		super(c, a, s, d, id, 3, 1, 6);
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
		int x = generator.nextInt(2);
		int y = generator.nextInt(2);
		if (x == 0) {
			x = -3;
		}
		else {
			x = 3;
		}
		if (y == 0) {
			y = -3;
		}
		else {
			y = 3;
		}
		System.out.println(this.getAvenue() + x);
		System.out.println(this.getStreet() + y);

		TurnRequest request = new TurnRequest(this.getAvenue() + x,this.getStreet() + y,-1,3);
		return request;
	}

}
