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
    /* Constructor: FifteenPlayer */
    /* Purpose: Create a default FifteenPlayer */
    /* Parameters: */
    /* none */
    /********************************************************/
    public FifteenPlayer() {
        this("Fifteen");
    }

    /********************************************************/
    /* Constructor: FifteenPlayer */
    /* Purpose: Create a new FifteenPlayer object */
    /* Parameters: */
    /* String name: the name of the Player being created */
    /********************************************************/
    public FifteenPlayer(String name) {
        super(name);
    }

    /********************************************************/
    /* Method: play */
    /* Purpose: Take one turn for this Player */
    /* One turn for a FifteenPlayer is a single roll */
    /* Parameters: */
    /* none */
    /* Returns: */
    /* the score earned by the player on this turn, */
    /* which will be zero if a six was rolled */
    /********************************************************/

    public int play() {
        int total = 0;
        boolean isTurnActive = true;

        while (isTurnActive == true) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.print("   Player " + getName() + " rolled " + roll);
            if (roll != 6) {
                total += roll;
                if (total < 15) {
                    System.out.println(" player score is not above 15 so player is contiuning player is at "
                            + total + " for the turn so far.");
                } else {
                    System.out.println(" player score is above 15 so player is not contiuning player is at "
                            + total + " for the turn");
                    isTurnActive = false;
                }
                ;
            } else {
                total = 0;
                isTurnActive = false;
                System.out.println(" and scored 0 for the turn.");
            }
        }
        return total;
    }

}