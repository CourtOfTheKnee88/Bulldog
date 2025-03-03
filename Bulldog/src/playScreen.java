/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* playScreen class: responsible for creating the play  */
/*                       screen and its inner workings  */ 
/********************************************************/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * The playScreen class is responsible for creating the play screen and its inner workings.
 */
public class playScreen {

    /**
     * Starts the play screen with the given players.
     * 
     * @param players the list of players to start the game with
     */
    public static void play(ArrayList<Player> players) {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        int numberOfPlayers = players.size();
        String[] columnNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            columnNames[i] = players.get(i).getName();
        }

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable playTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(playTable);

        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a panel to display the players' scores
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, numberOfPlayers));
        JLabel[] scoreLabels = new JLabel[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            scoreLabels[i] = new JLabel(players.get(i).getName() + ": " + players.get(i).getScore());
            scoreLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            scorePanel.add(scoreLabels[i]);
        }

        frame.add(scorePanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        // Start the game loop in a separate thread
        new Thread(() -> {
            boolean gameWon = false;
            while (!gameWon) {
                Object[] rowData = new Object[numberOfPlayers];
                for (int i = 0; i < numberOfPlayers; i++) {
                    Player player = players.get(i);
                    int score = player.play();
                    player.setScore(player.getScore() + score);
                    rowData[i] = player.getName() + " scored " + score + " points for the round";
                    System.out.println("Player " + player.getName() + " has " + player.getScore() + " points.");
                    if (player.getScore() >= Player.WINNING_SCORE) {
                        System.out.println("Player " + player.getName() + " wins!");
                        gameWon = true;
                        SwingUtilities.invokeLater(() -> gameOver.end(player.getName(), player.getScore()));
                        break;
                    }
                }

                // Update the table and scores on the UI
                SwingUtilities.invokeLater(() -> {
                    tableModel.addRow(rowData);
                    for (int i = 0; i < numberOfPlayers; i++) {
                        scoreLabels[i].setText(players.get(i).getName() + ": " + players.get(i).getScore());
                    }
                });

                // Sleep for a short period to simulate game rounds
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
