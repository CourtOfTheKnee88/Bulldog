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
import java.util.List;

/**
 * The playScreen class is responsible for creating the play screen and its inner workings.
 */
public class playScreen implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(GameStatus status) {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }

    /**
     * Starts the play screen with the given players.
     * 
     * @param playerList the list of players to start the game with
     */
    public static void play(PlayerList playerList) {
        if (playerList.getSize() == 0) {
            JOptionPane.showMessageDialog(null, "No players available. Please add players to start the game.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700); // Adjusted size to accommodate the scoreboard

        int numberOfPlayers = playerList.getSize();
        String[] columnNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            columnNames[i] = playerList.getPlayerName(i);
        }

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable playTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(playTable);

        // Create a panel to display the players' scores
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, numberOfPlayers));
        JLabel[] scoreLabels = new JLabel[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            scoreLabels[i] = new JLabel(playerList.getPlayerName(i) + ": " + playerList.getPlayerScore(i));
            scoreLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            scorePanel.add(scoreLabels[i]);
        }

        // Integrate the ScoreboardView beside the play table
        ScoreboardView scoreboardView = new ScoreboardView(playerList);
        ScoreboardView.ScoreboardViewer scoreboardViewer = scoreboardView.new ScoreboardViewer();

        // Add components to the frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(scorePanel, BorderLayout.SOUTH);

        // Add the scoreboard viewer beside the play table
        JPanel scoreboardPanel = new JPanel(new BorderLayout());
        scoreboardPanel.add(scoreboardViewer.frame.getContentPane(), BorderLayout.CENTER);
        frame.add(scoreboardPanel, BorderLayout.EAST);

        frame.setVisible(true);

        playScreen subject = new playScreen();

        // Start the game loop in a separate thread
        new Thread(() -> {
            boolean gameWon = false;
            int rounds = 0; // Track the number of rounds
            while (!gameWon) {
                rounds++; // Increment the round counter
                Object[] rowData = new Object[numberOfPlayers];
                for (int i = 0; i < numberOfPlayers; i++) {
                    Player player = playerList.getPlayers().get(i);
                    int score = player.play();
                    playerList.setPlayerScore(i, player.getScore() + score);

                    GameStatus status = new GameStatus(score, player.getScore(), playerList.getPlayerScore(i));
                    subject.notifyObservers(status); // Notify observers of the updated game state

                    rowData[i] = player.getName() + " scored " + score + " points for the round";
                    System.out.println("Player " + player.getName() + " has " + player.getScore() + " points.");
                    if (player.getScore() >= Referee.getWinningScore()) { // Use dynamic winning score
                        System.out.println("Player " + player.getName() + " wins!");
                        gameWon = true;

                        // Log the game into shared GameHistory
                        List<String> playerNames = new ArrayList<>();
                        List<String> playerTypes = new ArrayList<>();
                        List<Integer> playerScores = new ArrayList<>();
                        for (int j = 0; j < numberOfPlayers; j++) {
                            playerNames.add(playerList.getPlayerName(j));
                            playerTypes.add(playerList.getPlayers().get(j).getClass().getSimpleName());
                            playerScores.add(playerList.getPlayerScore(j));
                        }
                        gameOver.addGameToHistory(playerNames, playerTypes, playerScores, player.getName(), Referee.getWinningScore(), player.getScore(), rounds);

                        SwingUtilities.invokeLater(() -> gameOver.end(player.getName(), player.getScore()));
                        break;
                    }
                }

                // Update the table and scores on the UI
                SwingUtilities.invokeLater(() -> {
                    tableModel.addRow(rowData);
                    for (int i = 0; i < numberOfPlayers; i++) {
                        scoreLabels[i].setText(playerList.getPlayerName(i) + ": " + playerList.getPlayerScore(i));
                    }
                    scoreboardViewer.updateView(); // Ensure the scoreboard viewer is updated
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
