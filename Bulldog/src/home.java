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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The home class is responsible for creating the home panel of the Bulldog game.
 */
public class home {
    
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
        Object[][] data = {
            {"New Player", "Wimp"},
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable playerTable = new JTable(tableModel);

        // Create a JComboBox for the "Type" column
        String[] playerTypes = {"Human", "Random", "Fifteen", "Unique", "Wimp"};
        JComboBox<String> comboBox = new JComboBox<>(playerTypes);
        TableColumn typeColumn = playerTable.getColumnModel().getColumn(1);
        typeColumn.setCellEditor(new DefaultCellEditor(comboBox));

        JScrollPane scrollPane = new JScrollPane(playerTable);
        playerPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(playerPanel, BorderLayout.CENTER);

        // Create a panel for the buttons on the right
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton resetButton = new JButton("Reset");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(resetButton);
        frame.add(buttonPanel, BorderLayout.EAST);

        // Create a panel for the button at the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 1));
        JButton startButton = new JButton("Start Game");
        bottomPanel.add(startButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener to the "Add" button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add a new player to the table
                tableModel.addRow(new Object[]{"New Player", "Wimp"});
            }
        });

        // Add action listener to the "Remove" button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the selected row from the table
                int row = playerTable.getSelectedRow();
                if (row != -1) {
                    tableModel.removeRow(row);
                }
            }
        });

        // Add action listener to the "Reset" button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the table to the default values
                tableModel.setRowCount(0);
                tableModel.addRow(new Object[]{"New Player", "Wimp"});
            }
        });

        // Add action listener to the "Start Game" button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the number of players
                int numPlayers = tableModel.getRowCount();

                // Create an arrayList of players based on the number of players the user entered
                ArrayList<Player> players = new ArrayList<Player>();

                for (int i = 0; i < numPlayers; i++) {
                    String name = (String) tableModel.getValueAt(i, 0);
                    String type = (String) tableModel.getValueAt(i, 1);
                    if (type.equals("Human")) {
                        players.add(new HumanPlayer(name));
                    } else if (type.equals("Random")) {
                        players.add(new RandomPlayer(name));
                    } else if (type.equals("Fifteen")) {
                        players.add(new FifteenPlayer(name));
                    } else if (type.equals("Unique")) {
                        players.add(new UniquePlayer(name));
                    } else if (type.equals("Wimp")) {
                        players.add(new WimpPlayer(name));
                    }
                }
                frame.dispose();
                playScreen.play(players);
                // gameOver.end("HA HA LOSER", 104);
            }
        });

        frame.setVisible(true);
    }
}
