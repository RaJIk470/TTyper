import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    private static Frame instance = new Frame();
    int layoutSizeX = 1;
    int layoutSizeY = 1;

    JPanel[][] layoutPanels = new JPanel[layoutSizeY][layoutSizeX];

    Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(layoutSizeY, layoutSizeX));
        this.setSize(ScreenHandler.getInstance().getScaledScreenWidth(), ScreenHandler.getInstance().getScaledScreenHeight());

        for (int i = 0; i < layoutSizeY; i++)
            for (int j = 0; j < layoutSizeX; j++) {
                layoutPanels[i][j] = new JPanel();
                layoutPanels[i][j].setBackground(new Color(44, 44, 44));
                this.add(layoutPanels[i][j]);
            }

        this.addKeyListener(TypingListener.getInstance());
        layoutPanels[0][0].add(WordsLabel.getInstance());
        WordsHandler.getInstance().setCurrentWords(WordsGenerator.getInstance().generateRandomWords(40, DifficultyHandler.getCurrentDifficulty()));
        WordsLabel.getInstance().updateText(WordsHandler.getInstance().formatWords());
    }

    public void resetWords(){
        WordsHandler.getInstance().setCurrentWords(WordsGenerator.getInstance().generateRandomWords(30, DifficultyHandler.getCurrentDifficulty()));
        WordsLabel.getInstance().updateText(WordsHandler.getInstance().formatWords());
        TypingListener.getInstance().reset();
    }

    public static  Frame getInstance(){
        return instance;
    }
}
