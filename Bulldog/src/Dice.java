import java.util.Random;
/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 5                             */
/* Dice class: responsible for simulating a dice roll   */
/*    with a specified number of sides                  */
/********************************************************/

public class Dice {
    private int sides;
    private Random random;

    /********************************************************/
    /* Constructor: Dice                                    */
    /* Purpose: Create a new Dice object with N sides       */
    /* Parameters:                                          */
    /*   int sides: the number of sides on the dice         */
    /********************************************************/
    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    /********************************************************/
    /* Method: roll                                         */
    /* Purpose: Simulate a dice roll                        */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   a random number between 1 and the number of sides  */
    /********************************************************/
    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
