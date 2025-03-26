import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScoreboardView {
    private PlayerList playerList;

    public ScoreboardView(PlayerList playerList) {
        this.playerList = playerList;
    }

    public void displayScoreboard() {
        System.out.println("Scoreboard:");
        for (int i = 0; i < playerList.getPlayers().size(); i++) {
            Player player = playerList.getPlayers().get(i);
            System.out.println((i + 1) + ". " + player.getName() + " - " + player.getScore());
        }
    }

    // Inner class for a GUI-based scoreboard viewer
    public class ScoreboardViewer {
        JFrame frame;
        private JTextArea textArea;

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

        // Update the view with the current state of the PlayerList
        public void updateView() {
            StringBuilder scoreboard = new StringBuilder("Scoreboard:\n");
            for (int i = 0; i < playerList.getPlayers().size(); i++) {
                Player player = playerList.getPlayers().get(i);
                scoreboard.append((i + 1) + ". " + player.getName() + " - " + player.getScore() + "\n");
            }
            textArea.setText(scoreboard.toString());
        }
    }

// The follow was meant for testing purposes to ensure the code was working as intended
    // public static void main(String[] args) {
    //     // Create the PlayerList (Model)
    //     PlayerList playerList = new PlayerList();

    //     // Populate the game roster with Player objects
    //     playerList.addPlayer(new WimpPlayer("Alice"));
    //     playerList.addPlayer(new WimpPlayer("Bob"));
    //     playerList.addPlayer(new WimpPlayer("Charlie"));

    //     // Set initial scores
    //     playerList.setPlayerScore(0, 10);
    //     playerList.setPlayerScore(1, 20);
    //     playerList.setPlayerScore(2, 15);

    //     // Create the ScoreboardView (Viewer)
    //     ScoreboardView scoreboardView = new ScoreboardView(playerList);

    //     // Display the initial scoreboard in the console
    //     scoreboardView.displayScoreboard();

    //     // Create and display the GUI-based scoreboard viewer
    //     ScoreboardViewer guiViewer = scoreboardView.new ScoreboardViewer();

    //     // Pause with a JOptionPane dialog
    //     JOptionPane.showMessageDialog(null, "Click OK to update Bob's score.");

    //     // Update Bob's score (index 1)
    //     playerList.setPlayerScore(1, 50);

    //     // Display the updated scoreboard in the console
    //     System.out.println("\nUpdated Scoreboard:");
    //     scoreboardView.displayScoreboard();

    //     // Update the GUI-based scoreboard viewer
    //     guiViewer.updateView();
    // }
}
