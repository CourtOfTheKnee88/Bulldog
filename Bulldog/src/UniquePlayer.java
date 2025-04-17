/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* UniquePlayer class: extends Player class             */
/*         A UniquePlayer rolls until it reaches 12     */
/*    points, then randomly decides whether to continue */
/********************************************************/

public class UniquePlayer extends Player {


    /********************************************************/
    /* Constructor: UniquePlayer                            */
    /* Purpose: Create a default UniquePlayer               */
    /* Parameters:                                          */
    /* none                                                 */
    /********************************************************/
    public UniquePlayer() {
        this("Unique");
    }

    /********************************************************/
    /* Constructor: UniquePlayer                            */
    /* Purpose: Create a new UniquePlayer object            */
    /* Parameters:                                          */
    /* String name: the name of the Player being created    */
    /********************************************************/
    public UniquePlayer(String name) {
        super(name);
    }


    @Override
    /**
     * Determines whether the UniquePlayer continues their turn.
     * The player continues if their score is 12 or below. If above 12, 
     * the decision is made randomly.
     *
     * @param total the current total score for the turn
     * @return true if the player decides to continue, false otherwise
     */
    protected boolean continueTurn(int total) {
        if (total <= 12) {
            System.out.println(" player score is not above 12 so player is continuing. Player is at " + total + " for the turn so far.");
            return true;
        } else {
            int chance = Dice.getInstance(2).roll(); // Randomly choose to continue or not
            if (chance == 1) {
                System.out.println(" player score is above 12 and is randomly choosing to continue. Player is at " + total + " for the turn so far.");
                return true;
            } else {
                System.out.println(" player score is above 12 and is randomly choosing not to continue. Player is at " + total + " for the turn.");
                return false;
            }
        }
    }

}