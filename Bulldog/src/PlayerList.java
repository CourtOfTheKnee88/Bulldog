/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* PlayerList class: encapsulates a list of Player      */
/*                   objects and provides methods to    */
/*                   manage and interact with them.     */
/********************************************************/
import java.util.ArrayList;

/**
 * The PlayerList class encapsulates a list of Player objects and provides
 * methods to manage and interact with the players in the list.
 */
public class PlayerList {
    private ArrayList<Player> players;

    /**
     * Constructs an empty PlayerList.
     */
    public PlayerList() {
        players = new ArrayList<>();
    }

    /**
     * Adds a Player to the list.
     * 
     * @param player the Player to add
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Gets the name of a Player by index.
     * 
     * @param index the index of the Player
     * @return the name of the Player
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public String getPlayerName(int index) {
        if (index >= 0 && index < players.size()) {
            return players.get(index).getName();
        }
        throw new IndexOutOfBoundsException("Invalid player index");
    }

    /**
     * Gets the score of a Player by index.
     * 
     * @param index the index of the Player
     * @return the score of the Player
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public int getPlayerScore(int index) {
        if (index >= 0 && index < players.size()) {
            return players.get(index).getScore();
        }
        throw new IndexOutOfBoundsException("Invalid player index");
    }

    /**
     * Sets the score of a Player by index.
     * 
     * @param index the index of the Player
     * @param score the new score to set
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void setPlayerScore(int index, int score) {
        if (index >= 0 && index < players.size()) {
            players.get(index).setScore(score);
        } else {
            throw new IndexOutOfBoundsException("Invalid player index");
        }
    }

    /**
     * Gets the list of Players.
     * 
     * @return the list of Players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Gets the number of Players in the list.
     * 
     * @return the number of Players
     */
    public int getSize() {
        return players.size();
    }

    /**
     * Clears all Players from the list.
     */
    public void clearPlayers() {
        players.clear();
    }

    /**
     * Checks if the list is empty.
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return players.isEmpty();
    }
}
