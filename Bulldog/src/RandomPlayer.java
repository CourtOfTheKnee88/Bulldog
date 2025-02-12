/********************************************************/
/* David Levine                                         */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* RandomPlayer class: extends Player class               */
/*           A RandomPlayer rolls until user says to stop */
/*      See Kettering University, CS-101, Prog 6        */
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

        while (isTurnActive == true) {
            int roll = (int) (Math.random() * 6 + 1);
            int chance = (int) (Math.random() * 2);
            System.out.print("   Player " + getName() + " rolled " + roll);
            if (roll != 6) {
                total += roll;
                if (chance == 1) {
                    System.out.println(" and is randomly choosing to continue "
                            + roll + " for the turn.");
                } else {
                    System.out.println(" and randomly chose not to continue, scoring " + total + " for the turn.");
                    isTurnActive = false;
                }
            } else {
                total = 0;
                isTurnActive = false;
                System.out.println(" and scored 0 for the turn.");
            }
        }
        return total;
    }

}