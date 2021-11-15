import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordsCountPanel extends JPanel implements ActionListener {
    private static WordsCountPanel instance = new WordsCountPanel();

    WordsCountPanel(){
        JRadioButton easyButton = new JRadioButton("15");
        easyButton.setSelected(true);
        JRadioButton mediumButton = new JRadioButton("30");
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
        this.setBackground(new Color(44, 44, 44));
    }

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

    public static WordsCountPanel getInstance(){
        return instance;
    }




}
