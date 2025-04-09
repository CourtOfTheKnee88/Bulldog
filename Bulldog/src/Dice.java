import java.util.Random;
/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 5                             */
/* Dice class: responsible for simulating a dice roll   */
/*    with a specified number of sides                  */
/********************************************************/

public class Dice extends RandomDice {
    private static Dice instance; // Singleton instance
    private Random random;

    /********************************************************/
    /* Constructor: Dice                                    */
    /* Purpose: Private to enforce Singleton pattern        */
    /* Parameters:                                          */
    /*   int sides: the number of sides on the dice         */
    /********************************************************/
    private Dice(int sides) {
        super(sides); // Call RandomDice constructor
        this.random = new Random();
    }

    /********************************************************/
    /* Method: getInstance                                  */
    /* Purpose: Get the Singleton instance of Dice          */
    /* Parameters:                                          */
    /*   int sides: the number of sides on the dice         */
    /* Returns:                                             */
    /*   the Singleton instance of Dice                    */
    /********************************************************/
    public static Dice getInstance(int sides) {
        if (instance == null) {
            instance = new Dice(sides);
        }
        return instance;
    }

    /********************************************************/
    /* Method: roll                                         */
    /* Purpose: Simulate a dice roll                        */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   a random number between 1 and the number of sides  */
    /********************************************************/
    @Override
    public int roll() {
        return random.nextInt(sides) + 1;
    }

    /********************************************************/
    /* Method: getRandom                                    */
    /* Purpose: Expose the Random instance                  */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   the Random instance                                */
    /********************************************************/
    public Random getRandom() {
        return random;
    }
}
