public class Referee {
    private static Referee instance;
    public static final int WINNING_SCORE = 104; // Define the winning score

    private Referee() {
        // Private constructor to prevent instantiation
    }

    public static Referee getInstance() {
        if (instance == null) {
            instance = new Referee();
        }
        return instance;
    }

    public void announceWinner(String playerName) {
        System.out.println("Player " + playerName + " wins!");
    }

    public boolean hasPlayerWon(int score) {
        return score >= WINNING_SCORE; // Use the constant WINNING_SCORE
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
