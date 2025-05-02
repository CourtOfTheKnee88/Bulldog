/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* Partly Written by David Levine                       */
/* ScoreboardView class: updates the scoreboard when    */
/* notified of game state changes                       */
/********************************************************/
import javax.swing.*;
import java.awt.*;
import java.util.Observer;

/**
 * The ScoreboardView class provides a way to display the scores of players
 * in both a console-based and GUI-based format.
 */
public class ScoreboardView implements Observer {
    private final PlayerList playerList;

    /**
     * Constructs a ScoreboardView with the given PlayerList.
     * 
     * @param playerList the PlayerList to display
     */
    public ScoreboardView(PlayerList playerList) {
        this.playerList = playerList;
    }

    /**
     * Displays the scoreboard in the console.
     */
    public void displayScoreboard() {
        System.out.println("Scoreboard:");
        for (int i = 0; i < playerList.getPlayers().size(); i++) {
            Player player = playerList.getPlayers().get(i);
            System.out.println((i + 1) + ". " + player.getName() + " - " + player.getScore());
        }
    }

    /**
     * The ScoreboardViewer class provides a GUI-based view of the scoreboard.
     */
    public class ScoreboardViewer extends JPanel {
        JFrame frame;
        private JTextArea textArea;

        /**
         * Constructs a ScoreboardViewer and initializes the GUI components.
         */
        public ScoreboardViewer() {
            // Initialize the GUI components
            frame = new JFrame("Scoreboard Viewer");
            textArea = new JTextArea(10, 30);
            textArea.setEditable(false);

            frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);

            // Display the initial scoreboard
            updateView();
        }

        /**
         * Updates the GUI view with the current state of the PlayerList.
         */
        public void updateView() {
            StringBuilder scoreboard = new StringBuilder("Scoreboard:\n");
            for (int i = 0; i < playerList.getPlayers().size(); i++) {
                Player player = playerList.getPlayers().get(i);
                scoreboard.append((i + 1) + ". " + player.getName() + " - " + player.getScore() + "\n");
            }
            textArea.setText(scoreboard.toString());
        }
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        if (arg instanceof GameStatus) {
            GameStatus status = (GameStatus) arg;
            // Update the scoreboard based on the new game status
            System.out.println("Scoreboard updated: Player rolled " + status.getRollValue() + ", Turn Total: " + status.getTurnTotal() + ", Current Score: " + status.getCurrentScore());
            // Add logic to refresh the UI if necessary
        }
    }
}
