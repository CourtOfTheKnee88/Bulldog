/********************************************************/
/* David Levine                                         */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* UniquePlayer class: extends Player class               */
/*           A UniquePlayer rolls until user says to stop */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

public class UniquePlayerV1 extends Player {

    /********************************************************/
    /* Constructor: UniquePlayer */
    /* Purpose: Create a default UniquePlayer */
    /* Parameters: */
    /* none */
    /********************************************************/
    public UniquePlayerV1() {
        this("UniqueV1");
    }

    /********************************************************/
    /* Constructor: UniquePlayer */
    /* Purpose: Create a new UniquePlayer object */
    /* Parameters: */
    /* String name: the name of the Player being created */
    /********************************************************/
    public UniquePlayerV1(String name) {
        super(name);
    }

    /********************************************************/
    /* Method: play */
    /* Purpose: Take one turn for this Player */
    /* One turn for a UniquePlayer is a single roll */
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
                if (total <= 12) {
                    System.out.println(" player score is not above 12 so player is contiuning player is at "
                            + total + " for the turn so far.");
                } else {
                    if (chance == 1) {
                        System.out.println(" player score is above 12 and is randomly choosing to continue "
                                + total + " for the turn so far.");
                    } else {
                        System.out.println(" player score is above 12 and is randomly choosing not to continue "
                                + total + " for the turn");
                        isTurnActive = false;
                    }
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