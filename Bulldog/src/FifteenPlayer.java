/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* FifteenPlayer class: extends Player class            */
/*        A FifteenPlayer rolls until user says to stop */
/********************************************************/

public class FifteenPlayer extends Player {


    /********************************************************/
    /* Constructor: FifteenPlayer                           */
    /* Purpose: Create a default FifteenPlayer              */
    /* Parameters:                                          */
    /* none                                                 */
    /********************************************************/
    public FifteenPlayer() {
        this("Fifteen");
    }

    /********************************************************/
    /* Constructor: FifteenPlayer                           */
    /* Purpose: Create a new FifteenPlayer object           */
    /* Parameters:                                          */
    /* String name: the name of the Player being created    */
    /********************************************************/
    public FifteenPlayer(String name) {
        super(name);
    }


    @Override
    protected boolean continueTurn(int total) {
        if (total < 15) {
            System.out.println(" player score is not above 15 so player is continuing. Player is at " + total + " for the turn so far.");
            return true;
        } else {
            System.out.println(" player score is above 15 so player is not continuing. Player is at " + total + " for the turn.");
            return false;
        }
    }

}