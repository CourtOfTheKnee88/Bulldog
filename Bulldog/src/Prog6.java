/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* Main class: creates instance of the game             */ 
/********************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class Prog6 {

    public static void PlayGame(ArrayList<Player> players) {
        boolean gameWon = false;
        while (gameWon == false) {
            for (Player player : players) {
                int score = player.play();
                player.setScore(player.getScore() + score);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players for the game: ");

        int numPlayers = scanner.nextInt();

        ArrayList<Player> players = new ArrayList<Player>();
        // Create an arrayList of players based on the number of players the user entered
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter the type of player for player " + i
                    + " (1:Human, 2:Random, 3:Fifteen, 4:Unique, or 5:Wimp): ");
            int playerType = scanner.nextInt();
            if (playerType == 1) {
                players.add(new HumanPlayer());
            } else if (playerType == 2) {
                players.add(new RandomPlayer());
            } else if (playerType == 3) {
                players.add(new FifteenPlayer());
            } else if (playerType == 4) {
                players.add(new UniquePlayer());
            } else if (playerType == 5) {
                players.add(new WimpPlayer());
            } else {
                System.out.println("Invalid player type. Please enter a number between 1 and 5.");
                i--;
            }
        }
        PlayGame(players);
        home.start();

        scanner.close();
    }
}
