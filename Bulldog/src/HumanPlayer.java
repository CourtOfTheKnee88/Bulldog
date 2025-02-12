
/********************************************************/
/* David Levine                                         */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* HumanPlayer class: extends Player class               */
/*           A HumanPlayer rolls until user says to stop */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/
import java.util.Scanner;

public class HumanPlayer extends Player {

    /********************************************************/
    /* Constructor: HumanPlayer */
    /* Purpose: Create a default HumanPlayer */
    /* Parameters: */
    /* none */
    /********************************************************/
    public HumanPlayer() {
        this("Human");
    }

    /********************************************************/
    /* Constructor: HumanPlayer */
    /* Purpose: Create a new HumanPlayer object */
    /* Parameters: */
    /* String name: the name of the Player being created */
    /********************************************************/
    public HumanPlayer(String name) {
        super(name);
    }

    /********************************************************/
    /* Method: play */
    /* Purpose: Take one turn for this Player */
    /* One turn for a HumanPlayer is a single roll */
    /* Parameters: */
    /* none */
    /* Returns: */
    /* the score earned by the player on this turn, */
    /* which will be zero if a six was rolled */
    /********************************************************/

    public int play() {
        int total = 0;
        boolean isTurnActive = true;
        Scanner scanner = new Scanner(System.in);

        while (isTurnActive == true) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println("   Player " + getName() + " rolled " + roll);
            if (roll != 6) {
                total += roll;
                System.out.println("You are at " + total + " Enter 1 if you want to contiune rolling. Enter any other number to stop rolling.");
                int userInput = scanner.nextInt();
                if (userInput == 1) {
                    System.out.println(" and choosing to continue, scoring "
                            + total + " for the turn so far.");
                } else {
                    System.out.println(" and choosing not to continue, scoring "
                            + total + " for the turn.");
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