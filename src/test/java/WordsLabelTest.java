import org.junit.Assert;
import org.junit.Test;

public class WordsLabelTest {
    @Test
    public void isWordsLabelNotNull(){
        Assert.assertNotNull(WordsLabel.getInstance());
    }

    @Test
    public void isTextSetRight(){
        WordsLabel.getInstance().updateText("Hello World");
        Assert.assertEquals("Hello World", WordsLabel.getInstance().getText());
    }
}