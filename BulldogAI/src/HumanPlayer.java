/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* HumanPlayer class: extends Player class              */
/*           A HumanPlayer decides whether to continue  */
/*           rolling or end the turn                    */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

import java.util.Scanner;

public class HumanPlayer extends Player {

    /********************************************************/
    /* Constructor: HumanPlayer                             */
    /* Purpose: Create a default HumanPlayer                */
    /* Parameters:                                          */
    /*   none                                               */
    /********************************************************/
    public HumanPlayer() {
        this("Human");
    }

    /********************************************************/
    /* Constructor: HumanPlayer                             */
    /* Purpose: Create a new HumanPlayer object             */
    /* Parameters:                                          */
    /*   String name:  the name of the Player being created */
    /********************************************************/
    public HumanPlayer(String name) {
        super(name);
    }

    /********************************************************/
    /* Method:  play                                        */
    /* Purpose: Take one turn for this Player               */
    /*          A HumanPlayer decides whether to continue   */
    /*          rolling or end the turn                     */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   the score earned by the player on this turn,       */
    /*       which will be zero if a six was rolled         */
    /********************************************************/
    public int play() {
        Scanner scanner = new Scanner(System.in);
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
                System.out.print("   Do you want to continue rolling? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (!response.equals("yes")) {
                    continueRolling = false;
                }
            }
        }

        return turnScore;
    }
}