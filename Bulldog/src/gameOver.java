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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The gameOver class is responsible for creating the game over screen and its inner workings.
 */
public class gameOver {
    
    /**
     * Displays the game over screen with the winner and score.
     * 
     * @param winner the name of the winning player
     * @param score the score of the winning player
     */
    public static void end(String winner, int score) {
        JFrame frame = new JFrame("Game Over");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JLabel winnerLabel = new JLabel("Winner: " + winner, SwingConstants.CENTER);
        winnerLabel.setFont(new Font("Serif", Font.BOLD, 32));
        frame.add(winnerLabel, BorderLayout.NORTH);

        JLabel scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(scoreLabel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 1));
        JButton playAgainButton = new JButton("Play Again");
        bottomPanel.add(playAgainButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener to the "Play Again" button
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                home.start();
            }
        });

        frame.setVisible(true);
    }
}
