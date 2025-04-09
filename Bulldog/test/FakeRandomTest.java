import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* FakeRandomTest class: Test FakeRandom and SevenPlayer*/
/********************************************************/

public class FakeRandomTest {

    @Test
    public void testFakeRandomRolls() {
        // Create a FakeRandom with predefined rolls
        int[] predefinedRolls = {1, 2, 3, 4, 5};
        FakeRandom fakeRandom = new FakeRandom(6, predefinedRolls);

        // Verify the sequence of rolls
        assertEquals(1, fakeRandom.roll());
        assertEquals(2, fakeRandom.roll());
        assertEquals(3, fakeRandom.roll());
        assertEquals(4, fakeRandom.roll());
        assertEquals(5, fakeRandom.roll());
        assertEquals(1, fakeRandom.roll()); // Loop back to the start
    }

    @Test
    public void testSevenPlayerWithFakeRandom() {
        // Create a FakeRandom with predefined rolls
        int[] predefinedRolls = {1, 2, 3, 1, 6}; // Total reaches 7, then rolls a 6
        FakeRandom fakeRandom = new FakeRandom(6, predefinedRolls);

        // Inject FakeRandom into SevenPlayer
        SevenPlayer player = new SevenPlayer("TestPlayer") {
            @Override
            protected Dice getDice() {
                return fakeRandom;
            }
        };

        // Play a turn and verify the score
        int score = player.play();
        assertEquals(7, score); // Player stops after reaching 7
    }
}
package Bulldog.test;

public class FakeRandomTest {
    
}
