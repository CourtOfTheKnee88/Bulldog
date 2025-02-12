/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* Prog6 class: main class to run the Bulldog game      */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class Prog6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the type of player (Human/Wimp/Random/Fifteen/Unique/UniqueV1) for player " + (i + 1) + ": ");
            String playerType = scanner.nextLine().trim().toLowerCase();

            System.out.print("Enter the name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine().trim();

            switch (playerType) {
                case "human":
                    players.add(new HumanPlayer(playerName));
                    break;
                case "wimp":
                    players.add(new WimpPlayer(playerName));
                    break;
                case "random":
                    players.add(new RandomPlayer(playerName));
                    break;
                case "fifteen":
                    players.add(new FifteenPlayer(playerName));
                    break;
                case "unique":
                    players.add(new UniquePlayer(playerName));
                    break;
                case "uniquev1":
                    players.add(new UniquePlayerV1(playerName));
                    break;
                default:
                    System.out.println("Invalid player type. Defaulting to WimpPlayer.");
                    players.add(new WimpPlayer(playerName));
                    break;
            }
        }

        boolean gameEnded = false;
        while (!gameEnded) {
            for (Player player : players) {
                int turnScore = player.play();
                player.setScore(player.getScore() + turnScore);
                System.out.println(player.getName() + "'s total score: " + player.getScore());

                if (player.getScore() >= 104) {
                    System.out.println(player.getName() + " has reached 104 points and wins the game!");
                    gameEnded = true;
                    break;
                }
            }
        }

        scanner.close();
    }
}