/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* RandomPlayer class: extends Player class             */
/*         A RandomPlayer rolls until user says to stop */
/********************************************************/

public class RandomPlayer extends Player {

    /********************************************************/
    /* Constructor: RandomPlayer */
    /* Purpose: Create a default RandomPlayer */
    /* Parameters: */
    /* none */
    /********************************************************/
    public RandomPlayer() {
        this("Random");
    }

    /********************************************************/
    /* Constructor: RandomPlayer */
    /* Purpose: Create a new RandomPlayer object */
    /* Parameters: */
    /* String name: the name of the Player being created */
    /********************************************************/
    public RandomPlayer(String name) {
        super(name);
    }

    /********************************************************/
    /* Method: play */
    /* Purpose: Take one turn for this Player */
    /* One turn for a RandomPlayer is a single roll */
    /* Parameters: */
    /* none */
    /* Returns: */
    /* the score earned by the player on this turn, */
    /* which will be zero if a six was rolled */
    /********************************************************/

    public int play() {

        int total = 0;
        boolean isTurnActive = true;
        String output = "";

        while (isTurnActive == true) {
            int roll = (int) (Math.random() * 6 + 1);
            int chance = (int) (Math.random() * 2);
            output += "   Player " + getName() + " rolled " + roll;
            if (roll != 6) {
                total += roll;
                if (chance == 1) {
                     output += " and is randomly choosing to continue "
                            + roll + " for the turn.";
                } else {
                     output +=" and randomly chose not to continue, scoring " + total + " for the turn.";
                    isTurnActive = false;
                }
            } else {
                total = 0;
                isTurnActive = false;
                output += " and scored 0 for the turn.";
            }
        }
        System.out.println(output);
        return total;
    }

}