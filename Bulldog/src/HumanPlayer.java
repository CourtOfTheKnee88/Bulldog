/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* HumanPlayer class: extends Player class              */
/*          A HumanPlayer rolls until user says to stop */
/********************************************************/
import javax.swing.*;

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

        while (isTurnActive) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println("   Player " + getName() + " rolled " + roll);
            if (roll != 6) {
                total += roll;
                int userInput = JOptionPane.showConfirmDialog(null, "You rolled " + roll + ". Your total is " + total + ". Do you want to continue rolling?", "Continue Rolling?", JOptionPane.YES_NO_OPTION);
                if (userInput == JOptionPane.YES_OPTION) {
                    System.out.println(" and choosing to continue, scoring " + total + " for the turn so far.");
                } else {
                    System.out.println(" and choosing not to continue, scoring " + total + " for the turn.");
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