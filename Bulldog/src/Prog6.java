/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* Main class: creates instance of the game             */ 
/********************************************************/

import javax.swing.*;

public class Prog6 {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            home.start(); // Use the home GUI to start the game
        });

        // Example usage of Referee's playGame method
        PlayerList playerList = new PlayerList(); // Assume this is initialized properly
        Referee.getInstance().playGame(playerList);
    }
}
