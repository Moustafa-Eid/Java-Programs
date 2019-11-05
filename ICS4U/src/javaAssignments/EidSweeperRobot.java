package javaAssignments;
import becker.robots.*;
/**
 * Sweeper robot that cleans stairs
 * @author Moustafa Eid
 * @version 11/22/2017
 */
public class EidSweeperRobot extends RobotSE {

	/**
	 * This method sets up the robot.
	 * @param city is the name of the city
	 * @param street is the number of x coordinate
	 * @param avenue is the column number or y coordinate
	 * @param direction is where the robot is facing
	 */
	public EidSweeperRobot(City city, int street, int avenue, Direction direction) {
		super(city, street, avenue, direction);
	}
	
	/**
	 * This method allows robot to clean the stairs and house and combines all methods
	 */
	public void sweepStairs() {
		this.cleanMoveGround();	// clean starting ground
		this.cleanMoveUpstairs(); // clean upward stairs
		this.cleanMoveAcross(); // clean top of stairs
		this.cleanMoveDownstairs(); // clean downward stairs
		this.cleanMoveGround(); // clean ending ground
		this.throwGarbage(); // Throw trash in Garbage
	}
	
	/**
	 * This method allows robot to check if there is trash then pick it up
	 */
	private void pickTrash() {
		if (this.canPickThing()) {
			// pick all trash on that spot
			this.pickAllThings();
		}
	}
	
	/**
	 * This method allows robot to move when its on the ground.
	 */
	private void cleanMoveGround() {
		// while the front is clear move and pick trash
		while (true) {
			if (this.frontIsClear()) {
				this.pickTrash();
				this.move();
				
			}
			else {
				this.pickTrash();
				break;
			}
		}
	}

	/**
	 * This method allows robot to move and clean when going up stairs
	 */
	private void cleanMoveUpstairs() {
		// while robot on stairs pick trash and climb
		while (true) {
			this.goUp();
			this.pickTrash();
			// if there is no stairs left then move and stop
			if (this.isFacingEast() && this.frontIsClear()) {
				this.move();
				break;
			}
		}
	}

	/**
	 * This method allows robot to move and clean when going across stairs
	 */
	private void cleanMoveAcross() {
		// while there is ground on bottom then move to the right
		while (true) {
			this.turnRight();
			if (this.frontIsClear() == false) {
				this.pickTrash();
				this.turnLeft();
				this.move();
			}
			// else then go down the stairs
			else {
				this.move();
				this.turnLeft();
				this.pickTrash();
				break;
			}
		}
	}

	/**
	 * This method allows robot to move and clean when going down stairs
	 */
	private void cleanMoveDownstairs() {
		// while there is still stairs then clean and climb down
		while (true) {
			if (this.frontIsClear()) {
				this.move();
				this.turnRight();
				if (this.frontIsClear()) {
					this.goDown();
					this.pickTrash();

				}
				// else pick trash and stop
				else {
					this.turnLeft();
					this.pickTrash();
					break;
				}

			}
			// if front is not clear then pick trash 
			else {
				this.pickTrash();
				break;
			}

		}
	}
	
	/**
	 * This method allows the robot to move 1 step up
	 */
	private void goUp() {
		// move left then right to climb stairs
		this.turnLeft();
		this.move();
		this.turnRight();
		this.move();
	}
	
	/**
	 * This method allows the robot to move 1 step down
	 */
	private void goDown() {
		// climb down stairs
		this.move();
		this.turnLeft();
	}

	/**
	 * This method allows the robot to throw garbage in to bin then get out and stop
	 */
	private void throwGarbage() {
		// get in garbage
		this.goUp();
		this.turnRight();
		this.goDown();
		// put trash in garbage
		this.putAllThings();
		// get out of garbage
		this.goUp();
		this.turnRight();
		this.goDown();
	}

}
