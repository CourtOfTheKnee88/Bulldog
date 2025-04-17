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
    /* Constructor: HumanPlayer                             */
    /* Purpose: Create a default HumanPlayer                */
    /* Parameters:                                          */
    /* none                                                 */
    /********************************************************/
    public HumanPlayer() {
        this("Human");
    }

    /********************************************************/
    /* Constructor: HumanPlayer                             */
    /* Purpose: Create a new HumanPlayer object             */
    /* Parameters:                                          */
    /* String name: the name of the Player being created    */
    /********************************************************/
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    /**
     * Determines whether the HumanPlayer continues their turn.
     * The decision is made based on user input via a dialog box.
     *
     * @param total the current total score for the turn
     * @return true if the user decides to continue, false otherwise
     */
    protected boolean continueTurn(int total) {
        int userInput = JOptionPane.showConfirmDialog(null, "You rolled. Your total is " + total + ". Do you want to continue rolling?", 
        "Continue Rolling?", JOptionPane.YES_NO_OPTION);
        if (userInput == JOptionPane.YES_OPTION) {
            System.out.println(" and choosing to continue, scoring " + total + " for the turn so far.");
            return true;
        } else {
            System.out.println(" and choosing not to continue, scoring " + total + " for the turn.");
            return false;
        }
    }
}