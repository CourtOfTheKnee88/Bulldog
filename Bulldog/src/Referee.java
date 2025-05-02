public class Referee {
    private static Referee instance;
    private static int winningScore = 104; // Default winning score

    private Referee() {
        // Private constructor to prevent instantiation
    }

    public static Referee getInstance() {
        if (instance == null) {
            instance = new Referee();
        }
        return instance;
    }

    /********************************************************/
    /* Method: setWinningScore                              */
    /* Purpose: Set the winning score for the game          */
    /* Parameters:                                          */
    /*   int score - the desired winning score              */
    /* Returns:                                             */
    /*   none                                               */
    /********************************************************/
    public static void setWinningScore(int score) {
        winningScore = score;
    }

    /********************************************************/
    /* Method: getWinningScore                              */
    /* Purpose: Get the current winning score               */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   int - the current winning score                    */
    /********************************************************/
    public static int getWinningScore() {
        return winningScore;
    }

    public void announceWinner(String playerName) {
        System.out.println("Player " + playerName + " wins!");
    }

    public boolean hasPlayerWon(int score) {
        return score >= winningScore; // Use the dynamic winningScore
    }

    public void playGame(PlayerList playerList) {
        boolean gameWon = false;
        while (!gameWon) {
            for (int i = 0; i < playerList.getSize(); i++) {
                Player player = playerList.getPlayers().get(i);
                int score = player.play();
                playerList.setPlayerScore(i, player.getScore() + score);
                System.out.println("Player " + player.getName() + " has " + player.getScore() + " points.");
                if (hasPlayerWon(player.getScore())) {
                    announceWinner(player.getName());
                    gameWon = true;
                    return;
                }
            }
        }
    }
}
