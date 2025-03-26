import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Player> players;

    public PlayerList() {
        players = new ArrayList<>();
    }

    // Add a Player to the list
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Get the name of a Player by index
    public String getPlayerName(int index) {
        if (index >= 0 && index < players.size()) {
            return players.get(index).getName();
        }
        throw new IndexOutOfBoundsException("Invalid player index");
    }

    // Get the score of a Player by index
    public int getPlayerScore(int index) {
        if (index >= 0 && index < players.size()) {
            return players.get(index).getScore();
        }
        throw new IndexOutOfBoundsException("Invalid player index");
    }

    // Set the score of a Player by index
    public void setPlayerScore(int index, int score) {
        if (index >= 0 && index < players.size()) {
            players.get(index).setScore(score);
        } else {
            throw new IndexOutOfBoundsException("Invalid player index");
        }
    }

    // Get the list of Players
    public ArrayList<Player> getPlayers() {
        return players;
    }

    // Get the number of Players in the list
    public int getSize() {
        return players.size();
    }

    // Clear all Players from the list
    public void clearPlayers() {
        players.clear();
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return players.isEmpty();
    }
}
