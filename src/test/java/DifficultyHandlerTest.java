import org.junit.Assert;
import org.junit.Test;

public class DifficultyHandlerTest {
    @Test
    public void isDifficultySetCorrectly(){
        DifficultyHandler.setCurrentDifficulty(Difficulty.Easy);
        Assert.assertEquals(Difficulty.Easy, DifficultyHandler.getCurrentDifficulty());
    }
}
