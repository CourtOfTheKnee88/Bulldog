import java.util.Random;

public class FindSeed {
    public static void main(String[] args) {
        int sides = 6;
        int[] targetRolls = {3, 3, 5};

        for (long seed = 0; seed < Long.MAX_VALUE; seed++) {
            Random random = new Random(seed);
            boolean matches = true;

            for (int i = 0; i < targetRolls.length; i++) {
                if (random.nextInt(sides) + 1 != targetRolls[i]) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                System.out.println("Found seed: " + seed);
                break;
            }
        }
    }
}
