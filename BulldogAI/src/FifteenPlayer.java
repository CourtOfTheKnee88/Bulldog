/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* FifteenPlayer class: extends Player class            */
/*           A FifteenPlayer continues rolling until    */
/*           a score of at least 15 is reached          */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

public class FifteenPlayer extends Player {

    /********************************************************/
    /* Constructor: FifteenPlayer                           */
    /* Purpose: Create a default FifteenPlayer              */
    /* Parameters:                                          */
    /*   none                                               */
    /********************************************************/
    public FifteenPlayer() {
        this("Fifteen");
    }

    /********************************************************/
    /* Constructor: FifteenPlayer                           */
    /* Purpose: Create a new FifteenPlayer object           */
    /* Parameters:                                          */
    /*   String name:  the name of the Player being created */
    /********************************************************/
    public FifteenPlayer(String name) {
        super(name);
    }

    /********************************************************/
    /* Method:  play                                        */
    /* Purpose: Take one turn for this Player               */
    /*          A FifteenPlayer continues rolling until     */
    /*          a score of at least 15 is reached           */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   the score earned by the player on this turn,       */
    /*       which will be zero if a six was rolled         */
    /********************************************************/
    public int play() {
        int turnScore = 0;
        boolean continueRolling = true;

        while (continueRolling) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.print("   Player " + getName() + " rolled " + roll);
            if (roll == 6) {
                System.out.println(" and scored 0 for the turn.");
                turnScore = 0;
                break;
            } else {
                turnScore += roll;
                System.out.println(" and the cumulative score for this turn is " + turnScore);
                if (turnScore >= 15) {
                    continueRolling = false;
                }
            }
        }

        return turnScore;
    }
}