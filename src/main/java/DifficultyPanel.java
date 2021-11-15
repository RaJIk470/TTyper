import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyPanel extends JPanel implements ActionListener {
    private static DifficultyPanel instance = new DifficultyPanel();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Easy") {
            DifficultyHandler.setCurrentDifficulty(Difficulty.Easy); ;
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand() == "Medium") {
            DifficultyHandler.setCurrentDifficulty(Difficulty.Medium);
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand() == "Hard") {
            DifficultyHandler.setCurrentDifficulty(Difficulty.Hard);
            Frame.getInstance().resetWords();
        }
        if (e.getActionCommand() == "Mixed") {
            DifficultyHandler.setCurrentDifficulty(Difficulty.Mixed);
            Frame.getInstance().resetWords();
        }

    }

    public static DifficultyPanel getInstance(){
        return instance;
    }




}
