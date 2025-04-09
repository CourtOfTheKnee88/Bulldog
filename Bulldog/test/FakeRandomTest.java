import static org.junit.Assert.*;

import org.junit.Test;

public class FakeRandomTest {

	// Test for a roll of all 1's
	@Test
	public void testlimit1s() {
		FakeRandom fakeDice = new FakeRandom(6, 207129, 7); // Predefined rolls of 1
		SevenPlayer player = new SevenPlayer("TestPlayer", fakeDice);
		int score = player.play();
		assertEquals(7, score);
	}

	// Test for a roll of 6
	@Test
	public void test6Roll() {
		FakeRandom fakeDice = new FakeRandom(6, 5, 1); // Predefined rolls including 6
		SevenPlayer player = new SevenPlayer("TestPlayer", fakeDice);
		int score = player.play();
		assertEquals(0, score);
	}

	// Test for a roll of middle 6
	@Test
	public void testMid6Roll() {
		FakeRandom fakeDice = new FakeRandom(6, 145, 3); // Predefined rolls including 6
		SevenPlayer player = new SevenPlayer("TestPlayer", fakeDice);
		int score = player.play();
		assertEquals(0, score);
	}

	// Test for a roll of 8
	@Test
	public void test8Roll() {
		FakeRandom fakeDice = new FakeRandom(6, 48, 3); // Predefined rolls summing to 8
		SevenPlayer player = new SevenPlayer("TestPlayer", fakeDice);
		int score = player.play();
		assertEquals(8, score);
	}

	// Test for a roll of 7
	@Test
	public void test7Roll() {
		FakeRandom fakeDice = new FakeRandom(6, 42, 10); // Predefined rolls summing to 7
		SevenPlayer player = new SevenPlayer("TestPlayer", fakeDice);
		int score = player.play();
		assertEquals(7, score);
	}

	// Test for a roll of 11
	@Test
	public void testMaxroll() {
		FakeRandom fakeDice = new FakeRandom(6, 139, 3); // Predefined rolls summing to 11
		SevenPlayer player = new SevenPlayer("TestPlayer", fakeDice);
		int score = player.play();
		assertEquals(11, score);
	}

}
