import org.junit.Assert;
import org.junit.Test;

public class WordsCountHandlerTest {
    @Test
    public void isWordsCountSetCorrectly(){
        WordsCountHandler.setWordsCount(WordsCount.ThirtyWords);
        Assert.assertEquals(WordsCount.ThirtyWords, WordsCountHandler.getCurrentWordsCount());
    }
}
