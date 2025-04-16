/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 8                             */
/* GameStatus class: encapsulates the status of the     */
/*                   game, including round and winner   */
/********************************************************/

public class GameStatus {

    private int rollValue;
    private int turnTotal;
    private int currentScore;

    /********************************************************/
    /* Constructor: GameStatus                              */
    /* Purpose: Initialize the game status with default     */
    /*          values                                      */
    /* Parameters:                                          */
    /* none                                                 */
    /********************************************************/
    public GameStatus(int rollValue, int turnTotal, int currentScore) {
        this.rollValue = rollValue;
        this.turnTotal = turnTotal;
        this.currentScore = currentScore;
    }

    /********************************************************/
    /* Method: getRollValue                                 */
    /* Purpose: Get the value of the last roll              */
    /* Returns:                                             */
    /* int: the value of the last roll                      */
    /********************************************************/
    public int getRollValue() {
        return rollValue;
    }

    /********************************************************/
    /* Method: getTurnTotal                                 */
    /* Purpose: Get the total score for the current turn    */
    /* Returns:                                             */
    /* int: the total score for the current turn            */
    /********************************************************/
    public int getTurnTotal() {
        return turnTotal;
    }

    /********************************************************/
    /* Method: getCurrentScore                              */
    /* Purpose: Get the player's current overall score      */
    /* Returns:                                             */
    /* int: the player's current overall score              */
    /********************************************************/
    public int getCurrentScore() {
        return currentScore;
    }
}

