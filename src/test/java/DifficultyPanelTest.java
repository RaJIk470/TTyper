import org.junit.Assert;
import org.junit.Test;

import java.awt.event.ActionEvent;

public class DifficultyPanelTest {
    @Test
    public void isDifficultyPanelNotNull(){
        Assert.assertNotNull(DifficultyPanel.getInstance());
    }

    @Test
    public void isButtonEasyWorkingCorrectly(){
        ActionEvent event = new ActionEvent(this, 1, "Easy");

        DifficultyPanel.getInstance().actionPerformed(event);
        Assert.assertEquals(DifficultyHandler.getCurrentDifficulty(), Difficulty.Easy);

    }
    @Test
    public void isButtonMediumWorkingCorrectly(){
        ActionEvent event = new ActionEvent(this, 1, "Medium");

        DifficultyPanel.getInstance().actionPerformed(event);
        Assert.assertEquals(DifficultyHandler.getCurrentDifficulty(), Difficulty.Medium);

    }
    @Test
    public void isButtonHardWorkingCorrectly(){
        ActionEvent event = new ActionEvent(this, 1, "Hard");

        DifficultyPanel.getInstance().actionPerformed(event);
        Assert.assertEquals(DifficultyHandler.getCurrentDifficulty(), Difficulty.Hard);

    }
    @Test
    public void isButtonMixedWorkingCorrectly(){
        ActionEvent event = new ActionEvent(this, 1, "Mixed");

        DifficultyPanel.getInstance().actionPerformed(event);
        Assert.assertEquals(DifficultyHandler.getCurrentDifficulty(), Difficulty.Mixed);

    }
}