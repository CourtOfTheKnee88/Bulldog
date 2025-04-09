/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* SevenPlayer class: extends Player class              */
/*        A SevenPlayer rolls until the score reaches 7 */
/********************************************************/

public class SevenPlayer extends Player {

    private Dice dice;

    /********************************************************/
    /* Constructor: SevenPlayer                             */
    /* Purpose: Create a default SevenPlayer                */
    /* Parameters:                                          */
    /* none                                                 */
    /********************************************************/
    public SevenPlayer() {
        this("Seven");
    }

    /********************************************************/
    /* Constructor: SevenPlayer                             */
    /* Purpose: Create a new SevenPlayer object             */
    /* Parameters:                                          */
    /* String name: the name of the Player being created    */
    /********************************************************/
    public SevenPlayer(String name) {
        super(name);
        this.dice = Dice.getInstance(6); // Use Singleton Dice instance
    }

    /********************************************************/
    /* Method: play                                         */
    /* Purpose: Take one turn for this Player               */
    /* One turn for a SevenPlayer is a single roll          */
    /* Parameters:                                          */
    /* none                                                 */
    /* Returns:                                             */
    /* the score earned by the player on this turn,         */
    /* which will be zero if a six was rolled               */
    /********************************************************/
    public int play() {
        int total = 0;
        boolean isTurnActive = true;

        while (isTurnActive) {
            int roll = dice.roll(); // Use Singleton Dice instance
            System.out.print("   Player " + getName() + " rolled " + roll);
            if (roll != 6) {
                total += roll;
                if (total < 7) {
                    System.out.println(" player score is not above 7 so player is continuing. Player is at "
                            + total + " for the turn so far.");
                } else {
                    System.out.println(" player score is above 7 so player is not continuing. Player is at "
                            + total + " for the turn.");
                    isTurnActive = false;
                }
            } else {
                total = 0;
                isTurnActive = false;
                System.out.println(" and scored 0 for the turn.");
            }
        }
        return total;
    }
}
