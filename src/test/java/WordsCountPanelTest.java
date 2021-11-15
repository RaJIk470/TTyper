import org.junit.Assert;
import org.junit.Test;

public class WordsCountPanelTest {
    @Test
    public void isDifficultyPanelNotNull(){
            Assert.assertNotNull(WordsCountPanel.getInstance());
        }
}
