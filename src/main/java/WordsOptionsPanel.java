import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * words options panel class, the class is responding for storing buttons of words options
 */
public class WordsOptionsPanel extends JPanel implements ItemListener{
    /**
     * instance of WordsOptionsPanel class
     */
    private static WordsOptionsPanel instance = new WordsOptionsPanel();

    /**
     * construction of WordsOptionPanel class, the constructor defines check boxes of words options
     */
    WordsOptionsPanel(){
        JCheckBox commasBox = new JCheckBox("Commas");
        JCheckBox specialSymbolsBox = new JCheckBox("Special symbols");
        JCheckBox upperSymbolsBox = new JCheckBox("Upper symbols");
        JCheckBox digitsBox = new JCheckBox("Digits");

        commasBox.addItemListener(this);
        specialSymbolsBox.addItemListener(this);
        upperSymbolsBox.addItemListener(this);
        digitsBox.addItemListener(this);

        this.setLayout(new GridLayout());

        this.add(commasBox);
        this.add(specialSymbolsBox);
        this.add(upperSymbolsBox);
        this.add(digitsBox);

        this.setBackground(new Color(44, 44, 44));
    }

    /**
     * action of check boxes that sets necessary option and resets the words
     * @param e ItemEvent parameter that contains the name of the button
     */
    @Override
    public void itemStateChanged(ItemEvent e){
        JCheckBox check = (JCheckBox)e.getSource();

        if (check.getActionCommand().equals("Commas")) {
            if (e.getStateChange() == ItemEvent.SELECTED)
                WordsOptionsHandler.setCommas();
            else
                WordsOptionsHandler.unsetCommas();
        }
        if (check.getActionCommand().equals("Special symbols")) {
            if (e.getStateChange() == ItemEvent.SELECTED)
                WordsOptionsHandler.setSpecialSymbols();
            else
                WordsOptionsHandler.unsetSpecialSymbols();
        }
        if (check.getActionCommand().equals("Digits")) {
            if (e.getStateChange() == ItemEvent.SELECTED)
                WordsOptionsHandler.setDigits();
            else
                WordsOptionsHandler.unsetDigits();
        }
        if (check.getActionCommand().equals("Upper symbols")) {
            if (e.getStateChange() == ItemEvent.SELECTED)
                WordsOptionsHandler.setUpperSymbols();
            else
                WordsOptionsHandler.unsetUpperSymbols();
        }
        Frame.getInstance().resetWords();
    }


    /**
     * the method returns the instance of the class
     * @return return the instance of the class
     */
    public static WordsOptionsPanel getInstance(){
        return instance;
    }
}
