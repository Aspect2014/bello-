class Level {
    private boolean goal;
    private int points;

    public Level(boolean goal, int points) {
        this.goal = goal;
        this.points = points;
    }

    public boolean goalReached() {
        return goal;
    }

    public int getPoints() {
        return points;
    }
}

public class Main {
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;
    private boolean bonusGame;

    // Constructor for testing
    public Main(boolean l1Goal, int l1Pts, boolean l2Goal, int l2Pts, boolean l3Goal, int l3Pts, boolean isBonus) {
        levelOne = new Level(l1Goal, l1Pts);
        levelTwo = new Level(l2Goal, l2Pts);
        levelThree = new Level(l3Goal, l3Pts);
        this.bonusGame = isBonus;
    }

    /** Postcondition: All instance variables have been initialized. */
    public Main() {
        levelOne = new Level(true, 50);
        levelTwo = new Level(true, 30);
        levelThree = new Level(false, 20);
        bonusGame = false;
    }

    public boolean isBonus() {
        return bonusGame;
    }

    public void play() {
        // Simulates changing level states or randomness if desired
        // For testing, we can keep the current states or randomize them
    }

    /** 
     * Part (a): Returns the score earned in the most recently played game
     */
    public int getScore() {
        int score = 0;
        
        if (levelOne.goalReached()) {
            score += levelOne.getPoints();
            
            if (levelTwo.goalReached()) {
                score += levelTwo.getPoints();
                
                if (levelThree.goalReached()) {
                    score += levelThree.getPoints();
                }
            }
        }
        
        if (isBonus()) {
            score *= 3;
        }
        
        return score;
    }

    /** 
     * Part (b): Simulates the play of num games and returns the highest score earned. 
     * Precondition: num > 0
     */
    public int playManyTimes(int num) {
        int maxScore = 0;
        
        for (int i = 0; i < num; i++) {
            play();
            int currentScore = getScore();
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }
        
        return maxScore;
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Example: Creating a game where level 1 and 2 are passed, but level 3 is not.
        // Points: 50 + 30 = 80. Not a bonus game.
        Main game = new Main(true, 50, true, 30, false, 20, false);
        
        System.out.println("Single Game Score: " + game.getScore()); // Should print 80

        // Testing playManyTimes simulation
        int highestScore = game.playManyTimes(5);
        System.out.println("Highest score across multiple plays: " + highestScore);
    }
}
