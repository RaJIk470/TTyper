import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is responsible for panel which stores radio buttons of choosing difficulty
 */
public class DifficultyPanel extends JPanel implements ActionListener {
    /**
     * instance of difficultyPanel class
     */
    private static DifficultyPanel instance = new DifficultyPanel();

    /**
     * constructor of difficultyPanel class
     * the class defines radio buttons of choosing difficulties
     */
    DifficultyPanel(){
        JRadioButton easyButton = new JRadioButton("Easy");
        JRadioButton mediumButton = new JRadioButton("Medium");
        mediumButton.setSelected(true);
        JRadioButton hardButton = new JRadioButton("Hard");
        JRadioButton mixedButton = new JRadioButton("Mixed");

        ButtonGroup group = new ButtonGroup();
        group.add(easyButton);
        group.add(mediumButton);
        group.add(hardButton);
        group.add(mixedButton);

        this.setLayout(new GridLayout());

        this.add(easyButton);
        this.add(mediumButton);
        this.add(hardButton);
        this.add(mixedButton);

        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);
        mixedButton.addActionListener(this);
        this.setBackground(new Color(44, 44, 44));
    }

    /**
     * action of radio buttons
     * when option choose the difficulty changes on a new one
     * also the words in main label resets
     * @param e ActionEvent parameter which stores name of a button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Easy")) {
            DifficultyHandler.setCurrentDifficulty(Difficulty.Easy);
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand().equals("Medium")) {
            DifficultyHandler.setCurrentDifficulty(Difficulty.Medium);
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand().equals("Hard")) {
            DifficultyHandler.setCurrentDifficulty(Difficulty.Hard);
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand().equals("Mixed")) {
            DifficultyHandler.setCurrentDifficulty(Difficulty.Mixed);
            Frame.getInstance().resetWords();
        }

    }

    /**
     * this method returns instance of the class
     * @return return instance of the class
     */
    public static DifficultyPanel getInstance(){
        return instance;
    }




}
