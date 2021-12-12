/**
 * this class is responsible for setting and getting the current difficulty
 */
public class DifficultyHandler {
    /**
     * current difficulty
     */
    private static Difficulty difficulty = Difficulty.Medium;

    /**
     * this method sets new difficulty
     * @param newDifficulty just a new difficulty that will be set
     */
    public static void setCurrentDifficulty(Difficulty newDifficulty){
        difficulty = newDifficulty;
    }

    /**
     * this method returns current difficulty
     * @return return current difficulty
     */
    public static Difficulty getCurrentDifficulty(){
       return difficulty;
    }
}
