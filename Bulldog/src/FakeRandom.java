/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 6                             */
/* FakeRandom class: Subclass of RandomDice             */
/*         Simulates a dice roll with predefined values */
/********************************************************/

import java.util.Random;

public class FakeRandom extends RandomDice {
    private Random random;
    private int[] predefinedRolls;
    private int currentIndex;

    /********************************************************/
    /* Constructor: FakeRandom                              */
    /* Purpose: Create a FakeRandom object                 */
    /* Parameters:                                          */
    /*   int sides: the number of sides on the dice         */
    /*   long seed: seed for generating predefined rolls    */
    /*   int count: number of predefined rolls to generate  */
    /********************************************************/
    public FakeRandom(int sides, long seed, int count) {
        super(sides); // Call RandomDice constructor
        this.random = new Random(seed);
        this.predefinedRolls = new int[count];
        this.currentIndex = 0;

        // Generate predefined rolls using the seed
        for (int i = 0; i < count; i++) {
            this.predefinedRolls[i] = random.nextInt(sides) + 1;
        }
    }

    /********************************************************/
    /* Method: roll                                         */
    /* Purpose: Simulate a dice roll using predefined values*/
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   the next value in the predefined sequence          */
    /********************************************************/
    @Override
    public int roll() {
        if (predefinedRolls.length == 0) {
            throw new IllegalStateException("No predefined rolls available.");
        }
        int roll = predefinedRolls[currentIndex];
        currentIndex = (currentIndex + 1) % predefinedRolls.length; // Loop through values
        return roll;
    }
}
