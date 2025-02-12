/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* UniquePlayer class: extends Player class             */
/*           A UniquePlayer rolls up to three times     */
/*           per turn, stopping if the score reaches    */
/*           or exceeds 10, or if a six is rolled       */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

public class UniquePlayer extends Player {

    /********************************************************/
    /* Constructor: UniquePlayer                            */
    /* Purpose: Create a default UniquePlayer               */
    /* Parameters:                                          */
    /*   none                                               */
    /********************************************************/
    public UniquePlayer() {
        this("Unique");
    }

    /********************************************************/
    /* Constructor: UniquePlayer                            */
    /* Purpose: Create a new UniquePlayer object            */
    /* Parameters:                                          */
    /*   String name:  the name of the Player being created */
    /********************************************************/
    public UniquePlayer(String name) {
        super(name);
    }

    /********************************************************/
    /* Method:  play                                        */
    /* Purpose: Take one turn for this Player               */
    /*          A UniquePlayer rolls up to three times,     */
    /*          stopping if the score reaches or exceeds    */
    /*          10, or if a six is rolled                   */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   the score earned by the player on this turn,       */
    /*       which will be zero if a six was rolled         */
    /********************************************************/
    public int play() {
        int turnScore = 0;
        int rolls = 0;

        while (rolls < 3) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.print("   Player " + getName() + " rolled " + roll);
            if (roll == 6) {
                System.out.println(" and scored 0 for the turn.");
                turnScore = 0;
                break;
            } else {
                turnScore += roll;
                System.out.println(" and the cumulative score for this turn is " + turnScore);
                if (turnScore >= 10) {
                    break;
                }
            }
            rolls++;
        }

        return turnScore;
    }
}