import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Collections;

public class WordsHandlerTest {
    @Test
    public void isWordsHandlerNotNull(){
        Assert.assertNotNull(WordsHandler.getInstance());
    }

    @Test
    public void isWordsSetCorrectly(){
        WordsHandler.getInstance().setCurrentWords(Collections.singletonList(String.join(" ", "Hello World")));
        Assert.assertEquals("Hello World", WordsHandler.getInstance().getCurrentWords());
    }
}