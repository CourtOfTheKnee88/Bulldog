/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* home class: responsible for creating the home panel  */ 
/********************************************************/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

public class home {

    private static GameHistory gameHistory = new GameHistory();

    /**
     * Initializes and displays the home panel.
     */
    public static void start() {
        // Initialize the frame
        JFrame frame = new JFrame("Bulldog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Create a label with the title
        JLabel titleLabel = new JLabel("Bulldog", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Create a panel to hold the players
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BorderLayout());

        // Create a table with two columns: Name and Type
        String[] columnNames = {"Name", "Type"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable playerTable = new JTable(tableModel);

        // Create a JComboBox for the "Type" column
        String[] playerTypes = {"Human", "Random", "Fifteen", "Unique", "Wimp", "Seven"};
        JComboBox<String> comboBox = new JComboBox<>(playerTypes);
        TableColumn typeColumn = playerTable.getColumnModel().getColumn(1);
        typeColumn.setCellEditor(new DefaultCellEditor(comboBox));

        JScrollPane scrollPane = new JScrollPane(playerTable);
        playerPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(playerPanel, BorderLayout.CENTER);

        // Create a panel for the buttons on the right
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton resetButton = new JButton("Reset");
        JButton instructionsButton = new JButton("How to Play");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(instructionsButton);
        frame.add(buttonPanel, BorderLayout.EAST);

        // Create a panel for the buttons at the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1));

        JPanel winningScorePanel = new JPanel();
        winningScorePanel.setLayout(new FlowLayout());
        JLabel SWScoreLabel = new JLabel("Set Winning Score", SwingConstants.CENTER);
        JTextField winningScoreField = new JTextField(10);
        winningScorePanel.add(SWScoreLabel);
        winningScorePanel.add(winningScoreField);
        JButton startButton = new JButton("Start Game");
        JButton viewHistoryButton = new JButton("View Game History");
        bottomPanel.add(winningScorePanel);
        bottomPanel.add(startButton);
        bottomPanel.add(viewHistoryButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener to the "Add" button
        addButton.addActionListener(e -> {
            // Add a new player to the table
            tableModel.addRow(new Object[]{"New Player", "Wimp"});
        });

        // Add action listener to the "Remove" button
        removeButton.addActionListener(e -> {
            // Remove the selected row from the table
            int row = playerTable.getSelectedRow();
            if (row != -1) {
                tableModel.removeRow(row);
            }
        });

        // Add action listener to the "Reset" button
        resetButton.addActionListener(e -> {
            // Reset the table to the default values
            tableModel.setRowCount(0);
            tableModel.addRow(new Object[]{"New Player", "Wimp"});
        });

        // Add action listener to the "Start Game" button
        startButton.addActionListener(e -> {
            // Get the winning score from the input field
            String input = winningScoreField.getText().trim();
            try {
                int winningScore = Integer.parseInt(input);
                Referee.setWinningScore(winningScore); // Set the winning score in the Referee class
            } catch (NumberFormatException ex) {
                Referee.setWinningScore(104); // Default winning score
                JOptionPane.showMessageDialog(frame, "Invalid input. Using default winning score of 104.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Get the number of players
            int numPlayers = tableModel.getRowCount();

            if (numPlayers == 0) {
                JOptionPane.showMessageDialog(frame, "No players available. Please add players to start the game.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a PlayerList based on the table data
            PlayerList playerList = new PlayerList();
            for (int i = 0; i < numPlayers; i++) {
                String name = (String) tableModel.getValueAt(i, 0);
                String type = (String) tableModel.getValueAt(i, 1);
                switch (type) {
                    case "Human" -> playerList.addPlayer(new HumanPlayer(name));
                    case "Random" -> playerList.addPlayer(new RandomPlayer(name));
                    case "Fifteen" -> playerList.addPlayer(new FifteenPlayer(name));
                    case "Unique" -> playerList.addPlayer(new UniquePlayer(name));
                    case "Wimp" -> playerList.addPlayer(new WimpPlayer(name));
                    case "Seven" -> playerList.addPlayer(new SevenPlayer(name));
                }
            }

            frame.dispose();
            playScreen.play(playerList); // Pass PlayerList to playScreen
        });

        // Add action listener to the "View Game History" button
        viewHistoryButton.addActionListener(e -> {
            JFrame historyFrame = new JFrame("Game History");
            historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            historyFrame.setSize(600, 400);

            JTextArea historyArea = new JTextArea();
            historyArea.setEditable(false);
            StringBuilder historyText = new StringBuilder("Game History:\n\n");
            for (GameHistory.GameRecord record : gameHistory.getHistory()) {
                historyText.append("Players: ").append(record.getPlayers()).append("\n");
                historyText.append("Scores: ").append(record.getScores()).append("\n");
                historyText.append("Winner: ").append(record.getWinner()).append("\n\n");
            }
            historyArea.setText(historyText.toString());

            JScrollPane historyScrollPane = new JScrollPane(historyArea);
            historyFrame.add(historyScrollPane);
            historyFrame.setVisible(true);
        });

        // Add action listener to the "How to Play" button
        instructionsButton.addActionListener(e -> {
            String instructions = """
                How to Play Bulldog:
                1. Add players by clicking the "Add" button and remove them with the "Remove" button.
                2. Set the winning score in the text field and click "Start Game" to begin. If no score is entered, the default is 104.
                3. Players take turns rolling a die, trying to accumulate points. If a human player is selected, the user will be prompted to take actions.
                4. Players can roll as many times as they want, but rolling a six ends their turn with zero points.
                5. The game continues until one player reaches the winning score. To play again, click "Play Again" after a player wins.
                """;
            JOptionPane.showMessageDialog(frame, instructions, "How to Play", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setVisible(true);
    }
}
