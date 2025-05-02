/********************************************************/
/* David Levine                                         */
/* Login ID: david.b.levine@maine.edu 					*/
/* 			 courtney.jackson@maine.edu					*/
/* COS 420, Spring 2025                                 */
/* Programming Assignment 6                             */
/* WimpPlayer class: extends Player class               */
/*           A WimpPlayer always rolls the die once     */
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