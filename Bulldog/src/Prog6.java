/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* Main class: creates instance of the game             */ 
/********************************************************/

import javax.swing.*;
import java.util.Scanner;

public class Prog6 {

    public static void PlayGame(PlayerList playerList) {
        boolean gameWon = false;
        while (!gameWon) {
            for (int i = 0; i < playerList.getSize(); i++) {
                Player player = playerList.getPlayers().get(i);
                int score = player.play();
                playerList.setPlayerScore(i, player.getScore() + score);
                System.out.println("Player " + player.getName() + " has " + player.getScore() + " points.");
                if (player.getScore() >= Player.WINNING_SCORE) {
                    System.out.println("Player " + player.getName() + " wins!");
                    gameWon = true;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            home.start(); // Use the home GUI to start the game
        });
    }
}
