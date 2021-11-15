import org.junit.Assert;
import org.junit.Test;

import java.awt.event.KeyEvent;
import java.util.Collections;

public class TypingListenerTest {
    @Test
    public void isTypingListenerNotNull(){
        Assert.assertNotNull(TypingListener.getInstance());
    }

    @Test
    public void isListeningCorrect(){
        TypingListener.getInstance().reset();
        WordsHandler.getInstance().setCurrentWords(Collections.singletonList(String.join(" ", "Hello World")));
        KeyEvent keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, (int)'H', 'H');

        TypingListener.getInstance().keyPressed(keyEvent);
        Assert.assertEquals("H", TypingListener.getInstance().getTypedText());
    }

    @Test
    public void isRightSymbolsCountingCorrect(){
        TypingListener.getInstance().reset();
        WordsHandler.getInstance().setCurrentWords(Collections.singletonList(String.join(" ", "Hello World")));
        KeyEvent keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, (int)'H', 'H');

        TypingListener.getInstance().keyPressed(keyEvent);

        keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, (int)'q', 'q');
        TypingListener.getInstance().keyPressed(keyEvent);

        Assert.assertEquals(1, TypingListener.getInstance().getRightSymbolsCounter());
    }

    @Test
    public void isBackspaceWorkingCorrectly(){
        TypingListener.getInstance().reset();
        WordsHandler.getInstance().setCurrentWords(Collections.singletonList(String.join(" ", "Hello World")));
        KeyEvent keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, (int)'H', 'H');

        TypingListener.getInstance().keyPressed(keyEvent);

        keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, (int)'q', 'q');
        TypingListener.getInstance().keyPressed(keyEvent);

        keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, 8, (char)8);
        TypingListener.getInstance().keyPressed(keyEvent);

        Assert.assertEquals("H", TypingListener.getInstance().getTypedText());
    }

    @Test
    public void isEnterWorkingCorrectly(){
        TypingListener.getInstance().reset();
        WordsHandler.getInstance().setCurrentWords(Collections.singletonList(String.join(" ", "Hello World")));
        KeyEvent keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, (int)'H', 'H');

        TypingListener.getInstance().keyPressed(keyEvent);

        keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, (int)'q', 'q');
        TypingListener.getInstance().keyPressed(keyEvent);

        keyEvent = new KeyEvent(Frame.getInstance(), 1, 20, 1, 10, (char)10);
        TypingListener.getInstance().keyPressed(keyEvent);

        Assert.assertEquals("", TypingListener.getInstance().getTypedText());
    }

    @Test
    public void isCheckSymbolWorkingCorrectlyForSimilarSymbols(){
        Assert.assertEquals(SymbolMarker.RightSymbol, TypingListener.getInstance().checkSymbol('a', 'a'));
    }

    @Test
    public void isCheckSymbolWorkingCorrectlyForDifferentSymbols(){
        Assert.assertEquals(SymbolMarker.IncorrectSymbol, TypingListener.getInstance().checkSymbol('b', 'a'));
    }

}
