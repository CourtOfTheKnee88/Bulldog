import java.util.*;
import java.util.stream.Collectors;

/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Programming Assignment 9                             */
/* GameHistory class: maintains a record of previous    */
/*                   games, including players, scores,  */
/*                   and the winner                     */
/********************************************************/
public class GameHistory {

    // Inner class to represent a single game's record
    public static class GameRecord {
        private final List<String> players;
        private final List<String> types;
        private final List<Integer> scores;
        private final String winner;
        private final int winningScore;
        private final int winnerScore;
        private final int rounds;

        /********************************************************/
        /* Constructor: GameRecord                              */
        /* Purpose: Create a record for a single game           */
        /* Parameters:                                          */
        /*   List<String> players - names of players            */
        /*   List<String> types - types of players              */
        /*   List<Integer> scores - scores of players           */
        /*   String winner - name of the winner                 */
        /*   int winningScore - the winning score set for game  */
        /*   int winnerScore - the score of the winner          */
        /*   int rounds - the number of rounds it took to win   */
        /********************************************************/
        public GameRecord(List<String> players, List<String> types, List<Integer> scores, String winner, int winningScore, int winnerScore, int rounds) {
            this.players = new ArrayList<>(players);
            this.types = new ArrayList<>(types);
            this.scores = new ArrayList<>(scores);
            this.winner = winner;
            this.winningScore = winningScore;
            this.winnerScore = winnerScore;
            this.rounds = rounds;
        }

        public List<String> getPlayers() {
            return players;
        }

        public List<String> getTypes() {
            return types;
        }

        public List<Integer> getScores() {
            return scores;
        }

        public String getWinner() {
            return winner;
        }

        public int getWinningScore() {
            return winningScore;
        }

        public int getWinnerScore() {
            return winnerScore;
        }

        public int getRounds() {
            return rounds;
        }
    }

    private final List<GameRecord> history;

    /********************************************************/
    /* Constructor: GameHistory                             */
    /* Purpose: Initialize the game history                 */
    /* Parameters:                                          */
    /*   none                                               */
    /********************************************************/
    public GameHistory() {
        this.history = new ArrayList<>();
    }

    /********************************************************/
    /* Method: addGameRecord                                */
    /* Purpose: Add a record of a completed game            */
    /* Parameters:                                          */
    /*   List<String> players - names of players            */
    /*   List<String> types - types of players              */
    /*   List<Integer> scores - scores of players           */
    /*   String winner - name of the winner                 */
    /*   int winningScore - the winning score set for game  */
    /*   int winnerScore - the score of the winner          */
    /*   int rounds - the number of rounds it took to win   */
    /* Returns:                                             */
    /*   none                                               */
    /********************************************************/
    public void addGameRecord(List<String> players, List<String> types, List<Integer> scores, String winner, int winningScore, int winnerScore, int rounds) {
        history.add(new GameRecord(players, types, scores, winner, winningScore, winnerScore, rounds));
    }

    /********************************************************/
    /* Method: getHistory                                   */
    /* Purpose: Retrieve the list of all game records       */
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   List<GameRecord> - list of all game records        */
    /********************************************************/
    public List<GameRecord> getHistory() {
        return history;
    }

    /********************************************************/
    /* Method: calculateAverageScore                        */
    /* Purpose: Calculate the average score across all games*/
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   double - the average score                         */
    /********************************************************/
    public double calculateAverageScore() {
        return history.stream()
                .flatMap(record -> record.getScores().stream())
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    /********************************************************/
    /* Method: getMostWinningType                           */
    /* Purpose: Determine the player type that wins the most*/
    /* Parameters:                                          */
    /*   none                                               */
    /* Returns:                                             */
    /*   String - the player type that wins the most        */
    /********************************************************/
    public String getMostWinningType() {
        Map<String, Long> typeCounts = history.stream()
                .collect(Collectors.groupingBy(record -> {
                    int winnerIndex = record.getPlayers().indexOf(record.getWinner());
                    return record.getTypes().get(winnerIndex);
                }, Collectors.counting()));

        return typeCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
    }
}
