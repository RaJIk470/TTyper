import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class WordsOptionsPanelTest {
    @Test
    public void isWordsOptionsPanelNotNull(){
        Assert.assertNotNull(WordsOptionsPanel.getInstance());
    }

    @Test
    public void isCheckBCommasWorkingCorrectly(){
        JCheckBox checkBox = new JCheckBox("Commas");
        ItemEvent event = new ItemEvent(checkBox, 1, "Commas", ItemEvent.SELECTED);

        WordsOptionsPanel.getInstance().itemStateChanged(event);
        Assert.assertTrue(WordsOptionsHandler.getCommas());
    }
    @Test
    public void isCheckBSpecialSymbolsWorkingCorrectly(){
        JCheckBox checkBox = new JCheckBox("Special symbols");
        ItemEvent event = new ItemEvent(checkBox, 1, "Special symbols", ItemEvent.SELECTED);

        WordsOptionsPanel.getInstance().itemStateChanged(event);
        Assert.assertTrue(WordsOptionsHandler.getSpecialSymbols());
    }
    @Test
    public void isCheckBUpperSymbolsWorkingCorrectly(){
        JCheckBox checkBox = new JCheckBox("Upper symbols");
        ItemEvent event = new ItemEvent(checkBox, 1, "Upper symbols", ItemEvent.SELECTED);

        WordsOptionsPanel.getInstance().itemStateChanged(event);
        Assert.assertTrue(WordsOptionsHandler.getUpperSymbols());
    }
    @Test
    public void isCheckBDigitsWorkingCorrectly(){
        JCheckBox checkBox = new JCheckBox("Digits");
        ItemEvent event = new ItemEvent(checkBox, 1, "Digits", ItemEvent.SELECTED);

        WordsOptionsPanel.getInstance().itemStateChanged(event);
        Assert.assertTrue(WordsOptionsHandler.getDigits());
    }
}
