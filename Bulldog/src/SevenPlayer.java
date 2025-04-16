/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 4                             */
/* SevenPlayer class: extends Player class              */
/*        A SevenPlayer rolls until the score reaches 7 */
/********************************************************/

public class SevenPlayer extends Player {

    private FakeRandom dice;

    /********************************************************/
    /* Constructor: SevenPlayer                             */
    /* Purpose: Create a default SevenPlayer                */
    /* Parameters:                                          */
    /* none                                                 */
    /********************************************************/
    public SevenPlayer() {
        this("Seven", new FakeRandom(6, 42L, 10)); // Use FakeRandom with default seed and rolls
    }

    /********************************************************/
    /* Constructor: SevenPlayer                             */
    /* Purpose: Create a new SevenPlayer object             */
    /* Parameters:                                          */
    /* String name: the name of the Player being created    */
    /********************************************************/
    public SevenPlayer(String name) {
        this(name, new FakeRandom(6, 42L, 10)); // Default FakeRandom instance
    }

    /********************************************************/
    /* Constructor: SevenPlayer                             */
    /* Purpose: Create a new SevenPlayer object             */
    /* Parameters:                                          */
    /* String name: the name of the Player being created    */
    /* FakeRandom dice: the FakeRandom instance to use      */
    /********************************************************/
    public SevenPlayer(String name, FakeRandom dice) {
        super(name);
        this.dice = dice; // Use FakeRandom instance
    }


    @Override
    protected boolean continueTurn(int total) {
        if (total < 7) {
            System.out.println(" player score is not above 7 so player is continuing. Player is at " + total + " for the turn so far.");
            return true;
        } else {
            System.out.println(" player score is above 7 so player is not continuing. Player is at " + total + " for the turn.");
            return false;
        }
    }
}
