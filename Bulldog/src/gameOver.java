/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* gameOver class: responsible for creating the game    */
/*                  over screen and its inner workings  */ 
/********************************************************/

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The gameOver class is responsible for creating the game over screen and its inner workings.
 */
public class gameOver {

    private static GameHistory gameHistory = new GameHistory(); // Shared GameHistory instance

    /********************************************************/
    /* Method: end                                          */
    /* Purpose: Display the game over screen and allow      */
    /*          access to game history                      */
    /* Parameters:                                          */
    /*   String winner - name of the winning player         */
    /*   int score - score of the winning player            */
    /* Returns:                                             */
    /*   none                                               */
    /********************************************************/
    public static void end(String winner, int score) {
        JFrame frame = new JFrame("Game Over");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new GridLayout(2, 1));
        JLabel message = new JLabel("Congratulations " + winner + "!", SwingConstants.CENTER);
        JLabel message2 = new JLabel(score + " points.", SwingConstants.CENTER);
        message.setFont(new Font("Serif", Font.BOLD, 18));
        message2.setFont(new Font("Serif", Font.BOLD, 18));
        messagePanel.add(message);
        messagePanel.add(message2);
        frame.add(messagePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton viewHistoryButton = new JButton("View Game History");
        JButton restartButton = new JButton("Restart Game");
        buttonPanel.add(viewHistoryButton);
        buttonPanel.add(restartButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Action listener for viewing game history
        viewHistoryButton.addActionListener(e -> {
            JFrame historyFrame = new JFrame("Game History");
            historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            historyFrame.setSize(600, 400);

            JTextArea historyArea = new JTextArea();
            historyArea.setEditable(false);

            StringBuilder historyText = new StringBuilder();
            historyText.append("Game History Summary:\n");
            historyText.append("Average Score: ").append(gameHistory.calculateAverageScore()).append("\n");
            historyText.append("Most Winning Player Type: ").append(gameHistory.getMostWinningType()).append("\n\n");

            historyText.append("Detailed Game History:\n\n");
            for (GameHistory.GameRecord record : gameHistory.getHistory()) {
                historyText.append("Players: ").append(record.getPlayers()).append("\n");
                historyText.append("Types: ").append(record.getTypes()).append("\n");
                historyText.append("Scores: ").append(record.getScores()).append("\n");
                historyText.append("Winner: ").append(record.getWinner()).append("\n");
                historyText.append("Winning Score: ").append(record.getWinningScore()).append("\n");
                historyText.append("Winner's Score: ").append(record.getWinnerScore()).append("\n");
                historyText.append("Rounds Played: ").append(record.getRounds()).append("\n\n");
            }

            historyArea.setText(historyText.toString());

            JScrollPane scrollPane = new JScrollPane(historyArea);
            historyFrame.add(scrollPane);
            historyFrame.setVisible(true);
        });

        // Action listener for restarting the game
        restartButton.addActionListener(e -> {
            frame.dispose();
            home.start();
        });

        frame.setVisible(true);
    }

    /********************************************************/
    /* Method: addGameToHistory                             */
    /* Purpose: Add a completed game to the game history    */
    /* Parameters:                                          */
    /*   List<String> players - names of players            */
    /*   List<String> types - types of players              */
    /*   List<Integer> scores - scores of players           */
    /*   String winner - name of the winner                 */
    /*   int winningScore - the winning score set for game  */
    /*   int winnerScore - the score of the winner          */
    /*   int rounds - the number of rounds it took to win   */
    /* Returns:                                             */
    /*   none                                               */
    /********************************************************/
    public static void addGameToHistory(List<String> players, List<String> types, List<Integer> scores, String winner, int winningScore, int winnerScore, int rounds) {
        gameHistory.addGameRecord(players, types, scores, winner, winningScore, winnerScore, rounds);
    }

    /********************************************************/
    /* Method: getGameHistory                               */
    /* Purpose: Retrieve the shared game history instance   */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   GameHistory - the shared game history instance     */
    /********************************************************/
    public static GameHistory getGameHistory() {
        return gameHistory;
    }
}
