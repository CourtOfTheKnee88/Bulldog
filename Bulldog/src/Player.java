/********************************************************/
/* David Levine                                         */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* abstract Player class: holds generic info about a    */
/*           player of the game Bulldog                 */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

public abstract class Player {
	
	private String name;   	// The name of the Player
	
	private int score;		// The score earned by this Player during the game


	/********************************************************/
	/* Constructor: Player                                  */
	/* Purpose: Create a new Player object                  */
	/* Parameters:                                          */
	/*   String name:  the name of the Player being created */
	/********************************************************/
	public Player (String name) {
		this.name = name;
		this.score = 0;
	}
	
	/********************************************************/
	/* Method:  getName                                     */
	/* Purpose: return the name of this Player              */
	/* Parameters:                                          */
	/*   none                                               */
	/* Returns:                                             */
	/*   the name of this Player                            */
	/********************************************************/
	public String getName() {
		return this.name;
	}

	/********************************************************/
	/* Method:  getScore                                    */
	/* Purpose: return the current score of this Player     */
	/* Parameters:                                          */
	/*   none                                               */
	/* Returns:                                             */
	/*   the current score of this Player                   */
	/********************************************************/
	public int getScore() {
		return this.score;
	}
	
	/********************************************************/
	/* Method:  setScore                                    */
	/* Purpose: set the current score of this Player        */
	/* Parameters:                                          */
	/*   int score - the new value of the score             */
	/* Returns:                                             */
	/*   none                                               */
	/********************************************************/
	public void setScore(int score) {
		this.score = score;
	}
	
	/********************************************************/
	/* Method: play                                         */
	/* Purpose: Encapsulate one turn for this Player        */
	/* Parameters:                                          */
	/*   none                                               */
	/* Returns:                                             */
	/*   the score earned by the player on this turn,       */
	/*       which will be zero if a six was rolled         */
	/********************************************************/
	public int play() {
		int total = 0;
		boolean isTurnActive = true;

		while (isTurnActive) {
			int roll = Dice.getInstance(6).roll(); // Use Singleton Dice instance
			System.out.print("   Player " + getName() + " rolled " + roll);
			if (roll != 6) {
				total += roll;
				GameStatus status = new GameStatus(roll, total, this.getScore());
				isTurnActive = continueTurn(status.getTurnTotal());
			} else {
				total = 0;
				isTurnActive = false;
				System.out.println(" and scored 0 for the turn.");
			}
		}
		return total;
	}

	/********************************************************/
	/* Method: continueTurn                                 */
	/* Purpose: Determine whether the player continues      */
	/* Parameters:                                          */
	/*   int total - the current total score for the turn   */
	/* Returns:                                             */
	/*   boolean - true to continue, false to stop          */
	/********************************************************/
	protected abstract boolean continueTurn(int total);
	
}