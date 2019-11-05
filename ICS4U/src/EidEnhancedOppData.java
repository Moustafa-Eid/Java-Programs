
/**
 * Enhanced OPP Data for summative EidFighterRobot
 * @author Moustafa Eid
 * @version 11/15/2017
 */
public class EidEnhancedOppData extends OppData {
	// declaring global variables
	private int loss; 
	private double score;
	
	/**
	 * This method sets up the robot.
	 * @param id 
	 * @param a is the number of avenue coordinate
	 * @param s is the number of street coordinate
	 * @param health is the health value of robot
	 * @param loss is how many times the robot won a fight against me
	 * @param score is the average of distance and health
	 */
	public EidEnhancedOppData(int id, int a, int s, int health, int loss, double score) {
		super(id, a, s, health);
		this.loss = loss;
		this.score = score;
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method returns the loss amount
	 */
	public int getLoss() {
		return this.loss;
	}
	/**
	 * This method returns the score amount
	 */
	public double getScore() {
		return this.score;
	}

	
}
