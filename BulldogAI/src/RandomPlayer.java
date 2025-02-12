/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* RandomPlayer class: extends Player class             */
/*           A RandomPlayer decides whether to continue */
/*           rolling or end the turn randomly           */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

import java.util.Random;

public class RandomPlayer extends Player {

    private Random random;

    /********************************************************/
    /* Constructor: RandomPlayer                            */
    /* Purpose: Create a default RandomPlayer               */
    /* Parameters:                                          */
    /*   none                                               */
    /********************************************************/
    public RandomPlayer() {
        this("Random");
    }

    /********************************************************/
    /* Constructor: RandomPlayer                            */
    /* Purpose: Create a new RandomPlayer object            */
    /* Parameters:                                          */
    /*   String name:  the name of the Player being created */
    /********************************************************/
    public RandomPlayer(String name) {
        super(name);
        this.random = new Random();
    }

    /********************************************************/
    /* Method:  play                                        */
    /* Purpose: Take one turn for this Player               */
    /*          A RandomPlayer decides whether to continue  */
    /*          rolling or end the turn randomly            */
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
                continueRolling = random.nextBoolean();
            }
        }

        return turnScore;
    }
}