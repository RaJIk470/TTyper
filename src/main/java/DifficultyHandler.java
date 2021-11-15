public class DifficultyHandler {
    private static Difficulty difficulty = Difficulty.Medium;

    public static void setCurrentDifficulty(Difficulty newDifficulty){
        difficulty = newDifficulty;
    }

    public static Difficulty getCurrentDifficulty(){
       return difficulty;
    }
}
