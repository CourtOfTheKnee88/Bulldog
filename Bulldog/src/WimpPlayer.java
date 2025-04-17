/********************************************************/
/* David Levine                                         */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* WimpPlayer class: extends Player class               */
/*           A WimpPlayer always rolls the die once     */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

public class WimpPlayer extends Player {

	/********************************************************/
	/* Constructor: WimpPlayer                              */
	/* Purpose: Create a default WimpPlayer                 */
	/* Parameters:                                          */
	/*   none                                               */
	/********************************************************/
	public WimpPlayer () {
		this("Wimp");
	}

	/********************************************************/
	/* Constructor: WimpPlayer                              */
	/* Purpose: Create a new WimpPlayer object              */
	/* Parameters:                                          */
	/*   String name:  the name of the Player being created */
	/********************************************************/
	public WimpPlayer (String name) {
		super(name);
	}


	@Override
	/**
	 * Determines whether the WimpPlayer continues their turn.
	 * A WimpPlayer always stops after the first roll.
	 *
	 * @param total the current total score for the turn
	 * @return false, as the WimpPlayer never continues
	 */
	protected boolean continueTurn(int total) {
		System.out.println(" and chose not to continue, scoring " + total + " for the turn.");
		return false;
	}

}