import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * words count panel class, the class is responsible for panel that stores radio buttons for changing words count
 */
public class WordsCountPanel extends JPanel implements ActionListener {
    /**
     * instance of WordsCountPanel class
     */
    private static WordsCountPanel instance = new WordsCountPanel();

    /**
     * constructor of WordsCountPanel class, the constructor defines buttons for changing words count
     */
    WordsCountPanel(){
        JRadioButton easyButton = new JRadioButton("15");
        //easyButton.setSelected(true);
        JRadioButton mediumButton = new JRadioButton("30");
        mediumButton.setSelected(true);
        JRadioButton hardButton = new JRadioButton("45");
        JRadioButton insaneButton = new JRadioButton("60");

        ButtonGroup group = new ButtonGroup();
        group.add(easyButton);
        group.add(mediumButton);
        group.add(hardButton);
        group.add(insaneButton);

        this.setLayout(new GridLayout());

        this.add(easyButton);
        this.add(mediumButton);
        this.add(hardButton);
        this.add(insaneButton);

        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);
        insaneButton.addActionListener(this);
    }

    /**
     * action of the buttons
     * when button presses words count changes and words in main label resets
     * @param e ActionEvent parameter that stores name of the buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("15")) {
            WordsCountHandler.setWordsCount(WordsCount.FifteenWords);
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand().equals("30")) {
            WordsCountHandler.setWordsCount(WordsCount.ThirtyWords);
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand().equals("45")) {
            WordsCountHandler.setWordsCount(WordsCount.FortyFiveWords);
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand().equals("60")) {
            WordsCountHandler.setWordsCount(WordsCount.SixtyWords);
            Frame.getInstance().resetWords();
        }

    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static WordsCountPanel getInstance(){
        return instance;
    }

}
