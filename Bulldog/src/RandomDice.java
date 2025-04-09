/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 6                             */
/* RandomDice class: Abstract superclass for dice       */
/*         Keeps track of the number of sides           */
/*         Defines an abstract roll() method            */
/********************************************************/

public abstract class RandomDice {
    protected int sides;

    /********************************************************/
    /* Constructor: RandomDice                              */
    /* Purpose: Create a RandomDice object                 */
    /* Parameters:                                          */
    /*   int sides: the number of sides on the dice         */
    /********************************************************/
    public RandomDice(int sides) {
        this.sides = sides;
    }

    /********************************************************/
    /* Method: roll                                         */
    /* Purpose: Abstract method to simulate a dice roll     */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   an integer representing the result of the roll     */
    /********************************************************/
    public abstract int roll();
}
