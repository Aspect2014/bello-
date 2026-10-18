public class WordMatch{
    private String secret;

    /** Constructs a WordMatch object with the given secret word. */
    public WordMatch(String word) {
        secret = word;
    }

    /** 
     * Part (a): Returns a score for guess based on the number of times 
     * it appears as a substring (including overlapping occurrences) 
     * multiplied by the square of the length of guess.
     */
    public int scoreGuess(String guess) {
        int count = 0;
        int idx = secret.indexOf(guess);
        
        // Loop to find all occurrences, including overlapping ones
        while (idx != -1) {
            count++;
            idx = secret.indexOf(guess, idx + 1);
        }
        
        return count * guess.length() * guess.length();
    }

    /** 
     * Part (b): Returns the better guess of its two parameters, guess1 and guess2.
     * If scores are different, returns the one with the higher score.
     * If scores are equal, returns the alphabetically greater guess.
     */
    public String findBetterGuess(String guess1, String guess2) {
        int score1 = scoreGuess(guess1);
        int score2 = scoreGuess(guess2);

        if (score1 > score2) {
            return guess1;
        } else if (score2 > score1) {
            return guess2;
        } else {
            // If scores are equal, compare alphabetically
            if (guess1.compareTo(guess2) > 0) {
                return guess1;
            } else {
                return guess2;
            }
        }
    }

    /** Main method for testing the implementation */
    public static void main(String[] args) {
        WordMatch game = new WordMatch("mississippi");
        
        System.out.println("scoreGuess(\"i\"): " + game.scoreGuess("i"));       // Expected: 4
        System.out.println("scoreGuess(\"iss\"): " + game.scoreGuess("iss"));   // Expected: 18
        System.out.println("scoreGuess(\"issipp\"): " + game.scoreGuess("issipp")); // Expected: 36
        System.out.println("scoreGuess(\"mississippi\"): " + game.scoreGuess("mississippi")); // Expected: 121

        WordMatch game2 = new WordMatch("concatenation");
        System.out.println("scoreGuess(\"ten\"): " + game2.scoreGuess("ten")); // Expected: 9
    }
}

