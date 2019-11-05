import becker.robots.*;

import java.awt.Color;
import java.util.*;




public class IlicFighterRobot2 extends FighterRobot{
	
	private int players;
	private int  health,oppdefence, oppid, max, oppdefencetotal, fightingRounds, count;
	//private int [] robotsdefence = new int [players];
	/**
	 * Creating the robot
	 * @param c - Variable for the city
	 * @param a - Variable for the streets (y coordinate)
	 * @param s - Variable for the avenues (x coordinate)
	 * @param d - Variable for the direction
	 * @param id - This is the robots ID 
	 * @param attack - Variable for the attack power
	 * @param defence - Variable for the defense power
	 * @param numMoves - Variable for the number of moves
	 */
	public IlicFighterRobot2(City c, int a, int s, Direction d, int id, int health) {
		super(c, a, s, d, id, 5, 3, 2);
		// TODO Auto-generated constructor stub
		this.health = health;
		this.setColor(Color.BLUE);
	}
	

	
	/**
	 * Method that allows the robot to get to the desired location
	 * @param a - Variable for the avenue 
	 * @param s - Variable for the street
	 */
	@Override
	public void goToLocation(int a, int s) {
		// TODO Auto-generated method stub
		//Movement for going west
		
		if (this.getAvenue() > a && this.getDirection()==Direction.EAST) {
			//if (this.frontIsClear()) {
				this.turnAround();
				this.move();
			//}
		}

		if (this.getAvenue() > a && this.getDirection()==Direction.NORTH) {
			//if (this.frontIsClear()) {
				this.turnLeft();
				this.move();
			//}
		}
		if (this.getAvenue() > a && this.getDirection()==Direction.WEST) {
			//if (this.frontIsClear()) {
				this.move();
			//}
		}

		if (this.getAvenue() > a && this.getDirection()==Direction.SOUTH) {
			//if (this.frontIsClear()) {
				this.turnRight();
				this.move();
			//}
		}

		//Movement for going east
		if (this.getAvenue() < a && this.getDirection()==Direction.EAST) {
			//if (this.frontIsClear()) {
				this.move();
			//}
		}
		if (this.getAvenue() < a && this.getDirection()==Direction.NORTH) {
			//if (this.frontIsClear()) {
				this.turnRight();
				this.move();
			//}
		}
		if (this.getAvenue() < a && this.getDirection()==Direction.WEST) {
			//if (this.frontIsClear()) {
				this.turnAround();
				this.move();
			//}
		}
		if (this.getAvenue() < a && this.getDirection()==Direction.SOUTH) {
			//if (this.frontIsClear()) {
				this.turnLeft();
				this.move();
			//}
		}
		
		//Movement going north
		if (this.getStreet() > s && this.getDirection()==Direction.EAST) {
			//if (this.frontIsClear()) {
				this.turnLeft();
				this.move();
			//}
		}
		if (this.getStreet() > s && this.getDirection()==Direction.NORTH) {
			//if (this.frontIsClear()) {
				this.move();
			//}
		}
		if (this.getStreet() > s && this.getDirection()==Direction.WEST) {
			//if (this.frontIsClear()) {
				this.turnRight();
				this.move();
			//}
		}
		if (this.getStreet() > s && this.getDirection()==Direction.SOUTH) {
			//if (this.frontIsClear()) {
				this.turnAround();
				this.move();
			//}
		}

		
		//Movement going south
		if (this.getStreet() < s && this.getDirection()==Direction.EAST) {
			//if (this.frontIsClear()) {
				this.turnRight();
				this.move();
			//}
		}
		if (this.getStreet() < s && this.getDirection()==Direction.NORTH) {
			//if (this.frontIsClear()) {
				this.turnAround();
				this.move();
			//}
		}
		if (this.getStreet() < s && this.getDirection()==Direction.WEST) {
			//if (this.frontIsClear()) {
				this.turnLeft();
				this.move();
			//}
		}
		if (this.getStreet() < s && this.getDirection()==Direction.SOUTH) {
			//if (this.frontIsClear()) {
				this.move();
			//}
		}
		
		
		
		


	}
	
	/**
	 * Method that performs the moves during your turn
	 * @param energy - Variable for the energy for the robot
	 * @param data - Variable for the opponents data
	 */
	@Override
	public TurnRequest takeTurn(int energy, OppData[] data) {
		// TODO Auto-generated method stub
		//Random generator = new Random();
		int robotAvenue = this.getAvenue();
		int robotStreet = this.getStreet();
		int robotID = this.getID();
		int fightID = 0;
		int oppdefencerobot = 0;
		int [] robotsdefence = new int [data.length];
		//double [][] distance_combined = new double [4][data.length-1];
		IlicEnhancedOppData [] enhancedData = new IlicEnhancedOppData[data.length];
		
		
		
		sort(data);
		//players = data.length;
		//max = oppdefence;
		
		//if (count == 0) {
		//robotsdefence = new int [players];
/*		for (int i = 0; i < players; i++) {
			robotsdefence[i] = 0;
		}*/
		//}
		
/*		for (int i = 0; i < robotsdefence.length;i++) {
			System.out.print(robotsdefence[i]+" ");
		}
		oppdefencetotal += oppdefence;
		System.out.println(oppdefencetotal);
		System.out.println(max);*/
		if (oppdefence > max) {
			max = oppdefence;
		}
			

		if (oppid != -1&&(max > robotsdefence[oppid])  ) {
			System.out.println("OPPD = "+oppdefence);
			System.out.println("fightID = "+fightID);
			System.out.println("oppID = "+oppid);
			System.out.println("MAXD = "+max);
			robotsdefence[oppid] = max;
				
		}
		
		
		
		health = data[0].getHealth();
		System.out.println(health);
		
			
		
		
		/*for (int i = 0; i <robotsdefence.length;i++) {
			System.out.println(robotsdefence[i]);
		}
		System.out.println();*/


		for (int i = 0; i <enhancedData.length;i++) {
			
			enhancedData[i]=new IlicEnhancedOppData(data[i].getID(), data[i].getAvenue(), data[i].getStreet(), data[i].getHealth(),robotsdefence[i], formula(data,i));
			
			
		}
		for (int i = 0; i <enhancedData.length;i++) {
			System.out.println(enhancedData[i].getID()+" "+enhancedData[i].getFormula()+" "+enhancedData[i].getDefence());
/*			System.out.println(enhancedData[i].getAvenue());
			System.out.println(enhancedData[i].getStreet());
			System.out.println(enhancedData[i].getHealth());*/
			//System.out.println(enhancedData[i].getDefence());
			//System.out.println(enhancedData[i].getFormula());
			//System.out.println(formula2(data,i));
		}
		
		System.out.println();
		System.out.println();
		//System.out.println(enhancedData[1].getDefence());
		//System.out.println(enhancedData[2].getDefence());
		
		
		
		
		//ATTACKING CODE
		if (energy >= 50 && health >=50) {
			if ((robotAvenue!= enhancedData[1].getAvenue())&&(enhancedData[1].getAvenue() != -1)&&(enhancedData[1].getDefence()<=6)) {
				if (robotAvenue > enhancedData[1].getAvenue()) {
					robotAvenue -=1;			
				}

				else if (robotAvenue == enhancedData[1].getAvenue()) {
					//robotAvenue +=0;
					
					if (robotStreet > enhancedData[1].getStreet()) {
						robotStreet -=1;
						robotAvenue +=0;
					}

					else {
						robotStreet +=1;
						robotAvenue +=0;
					}

				}

				else {
					robotAvenue +=1;
				}

			}
			if (robotStreet != enhancedData[1].getStreet()&&(enhancedData[1].getStreet() != -1)&&(enhancedData[1].getDefence()<=6)) {
				if (robotStreet > enhancedData[1].getStreet()) {
					robotStreet -=1;
				}

				else if (robotStreet == enhancedData[1].getStreet()) {
					//robotStreet = robotStreet;
					if (robotAvenue > enhancedData[1].getAvenue()) {
						robotAvenue -=1;
						robotStreet +=0;
					}

					else {
						robotAvenue +=1;
						robotStreet +=0;
					}

				}

				else {
					robotStreet +=1;
				}
			}
		}
		
		//EVASIVE CODE
		if (energy < 50 && health < 50) {
			robotAvenue += 0;
			robotStreet += 0;
			fightID = -1;
			
			if (enhancedData[1].getFormula() <= 5 && enhancedData[1].getAvenue() <= robotAvenue && enhancedData[1].getStreet() <= robotStreet ) {
				robotAvenue +=1;
				robotStreet +=1;
			}
			else if (enhancedData[1].getFormula() <= 5 && enhancedData[1].getAvenue() >= robotAvenue && enhancedData[1].getStreet() >= robotStreet ) {
				robotAvenue -=1;
				robotStreet -=1;
			}
		}
			
        //Initializing fight
		if (enhancedData[1].getStreet() == robotStreet && enhancedData[1].getAvenue() == robotAvenue &&enhancedData[1].getHealth()!=0 ) {
			//if (enhancedData[1].getDefence()==0 || enhancedData[1].getDefence() > 2) {
				oppid = enhancedData[1].getID();			
				System.out.println("Fight");
			//}
			/*else {
				oppid = -1;
			}*/
		
		}
		else {
			oppid = -1;
			System.out.println("HELLO THERE!");

		}
		
		//Determining the number of rounds to fight
		if (health >= 90 && energy >= 90) {
			fightingRounds = 5;
		}
		else if (health >= 70 && health < 90 && energy >= 70 && energy < 90) {
			fightingRounds = 4;
		}
		else if (health >= 50 && health < 70 && energy >= 50 && energy < 70) {
			fightingRounds = 3;
		}
		else if (energy < 50 && health < 50) {
			fightingRounds = 0;
			oppid = -1;
		}
		System.out.println(fightingRounds);
	
        //strategy (distance_combined, robotAvenue, robotStreet);
        		
		TurnRequest request = new TurnRequest(robotAvenue, robotStreet, oppid , fightingRounds);
		return request;
		
		//(int)distance_combined[3][0]
	}
	
	/**
	 * Method that gets the opponents information
	 * @param healthLost - Variable for the amount of health lost during the game
	 * @param oppID - Variable for the opponents ID
	 * @param oppHealthLost - Variable for the opponents health lost
	 * @param numRoundsFought - Variable for the number of rounds fought 
	 */
	@Override
	public void battleResult(int healthLost, int oppID, int oppHealthLost, int numRoundsFought) {
		// TODO Auto-generated method stub
		health -= healthLost;
		oppdefence = oppHealthLost;
		oppid = oppID;
		
/*		if (oppdefence > max) {
			max = oppdefence;
		}
			

		if (oppid != -1&&(max > robotsdefence[oppid])  ) {
			robotsdefence[oppid] = max;
				
		}*/
		
	
	}
		
	private double disCalc(OppData[] data, int index) {
		double distancetotal=0,distancex=0,distancey=0;
		int robotID = this.getID();
		int robotAvenue = this.getAvenue();
		int robotStreet = this.getStreet();
		if (robotID != data[index].getID()) {
			distancex= Math.pow((data[index].getAvenue()-robotAvenue), 2);
			distancey= Math.pow((data[index].getStreet()-robotStreet), 2);
		}
		return distancetotal = Math.sqrt(distancex+distancey);
		
	}
	
	private double formula(OppData[] data, int index) {
		double HEALTHCONS = 0.1, DISTANCECONS = 1, formula =0;
		int robotID = this.getID();
		if (robotID != data[index].getID()) {
			double opphealth = data[index].getHealth()*HEALTHCONS;
			double distancetotal = this.disCalc(data, index)*DISTANCECONS;
			formula = opphealth+distancetotal;
		}
		return formula;
		
		
	}
	
	private void sort(OppData[] data) {
		int robotID = this.getID();
		for(int i=0;i<data.length-1;i++) {   
			for(int j=i+1;j<data.length;j++) {
				
				if(formula(data,j)<formula(data,i)) {
					OppData temp = data[i];
					data[i] = data[j];
					data[j] = temp;
					System.out.println("Switch");

					
				}
				
			}
		}
		
	}
	
	public void setLabel() {
		this.setLabel("Health: " + health);
	}
	
	
	
	
}

