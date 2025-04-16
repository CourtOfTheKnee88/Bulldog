/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* RandomPlayer class: extends Player class             */
/*         A RandomPlayer rolls until user says to stop */
/********************************************************/

public class RandomPlayer extends Player {

    private Dice dice;

    /********************************************************/
    /* Constructor: RandomPlayer                            */
    /* Purpose: Create a default RandomPlayer               */
    /* Parameters:                                          */
    /* none                                                 */
    /********************************************************/
    public RandomPlayer() {
        this("Random");
    }

    /********************************************************/
    /* Constructor: RandomPlayer                            */
    /* Purpose: Create a new RandomPlayer object            */
    /* Parameters:                                          */
    /* String name: the name of the Player being created    */
    /********************************************************/
    public RandomPlayer(String name) {
        super(name);
        this.dice = Dice.getInstance(6); // Use Singleton Dice instance
    }

    /********************************************************/
    /* Method: continueTurn                                 */
    /* Purpose: Decide whether to continue the turn         */
    /* Parameters:                                          */
    /* int total: the current score for the turn            */
    /* Returns:                                             */
    /* true if the player decides to continue, false otherwise */
    /********************************************************/
    @Override
    protected boolean continueTurn(int total) {
        int chance = Dice.getInstance(2).roll(); // Randomly choose to continue or not
        if (chance == 1) {
            System.out.println(" and is randomly choosing to continue. Player is at " + total + " for the turn so far.");
            return true;
        } else {
            System.out.println(" and randomly chose not to continue, scoring " + total + " for the turn.");
            return false;
        }
    }

}