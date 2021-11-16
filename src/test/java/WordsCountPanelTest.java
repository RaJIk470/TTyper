import org.junit.Assert;
import org.junit.Test;

import java.awt.event.ActionEvent;

public class WordsCountPanelTest {
    @Test
    public void isDifficultyPanelNotNull(){
            Assert.assertNotNull(WordsCountPanel.getInstance());
    }

    @Test
    public void isButton45WorkingCorrectly(){
        ActionEvent event = new ActionEvent(this, 1, "45");

        WordsCountPanel.getInstance().actionPerformed(event);
        Assert.assertEquals(WordsCountHandler.getCurrentWordsCount(), WordsCount.FortyFiveWords);

    }
    @Test
    public void isButton15WorkingCorrectly(){
        ActionEvent event = new ActionEvent(this, 1, "15");

        WordsCountPanel.getInstance().actionPerformed(event);
        Assert.assertEquals(WordsCountHandler.getCurrentWordsCount(), WordsCount.FifteenWords);

    }
    @Test
    public void isButton30WorkingCorrectly(){
        ActionEvent event = new ActionEvent(this, 1, "30");

        WordsCountPanel.getInstance().actionPerformed(event);
        Assert.assertEquals(WordsCountHandler.getCurrentWordsCount(), WordsCount.ThirtyWords);

    }
    @Test
    public void isButton60WorkingCorrectly(){
        ActionEvent event = new ActionEvent(this, 1, "60");

        WordsCountPanel.getInstance().actionPerformed(event);
        Assert.assertEquals(WordsCountHandler.getCurrentWordsCount(), WordsCount.SixtyWords);

    }
}
