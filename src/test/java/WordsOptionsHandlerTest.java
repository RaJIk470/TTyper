import org.junit.Assert;
import org.junit.Test;

public class WordsOptionsHandlerTest {
    @Test
    public void isCommasSetCorrectly(){
        WordsOptionsHandler.setCommas();
        Assert.assertTrue(WordsOptionsHandler.getCommas());
    }
    @Test
    public void isUpperSymbolsSetCorrectly(){
        WordsOptionsHandler.setUpperSymbols();
        Assert.assertTrue(WordsOptionsHandler.getUpperSymbols());
    }
    @Test
    public void isSpecialSymbolsSetCorrectly(){
        WordsOptionsHandler.setSpecialSymbols();
        Assert.assertTrue(WordsOptionsHandler.getSpecialSymbols());
    }
    @Test
    public void isDigitsSetCorrectly(){
        WordsOptionsHandler.setDigits();
        Assert.assertTrue(WordsOptionsHandler.getDigits());
    }
    @Test
    public void isCommasUnsetCorrectly(){
        WordsOptionsHandler.unsetCommas();
        Assert.assertFalse(WordsOptionsHandler.getCommas());
    }
    @Test
    public void isUpperSymbolsUnsetCorrectly(){
        WordsOptionsHandler.unsetUpperSymbols();
        Assert.assertFalse(WordsOptionsHandler.getUpperSymbols());
    }
    @Test
    public void isSpecialSymbolsUnsetCorrectly(){
        WordsOptionsHandler.unsetSpecialSymbols();
        Assert.assertFalse(WordsOptionsHandler.getSpecialSymbols());
    }
    @Test
    public void isDigitsUnsetCorrectly(){
        WordsOptionsHandler.unsetDigits();
        Assert.assertFalse(WordsOptionsHandler.getDigits());
    }
}
