import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for main window with text to type
 */
public class Frame extends JFrame{
    /**
     * instance for Frame class
     */
    private static Frame instance = new Frame();
    /**
     * size of the layout for main Frame with coordinate X
     */
    int layoutSizeX = 1;
    /**
     * size of the layout for main Frame with coordinate Y
     */
    int layoutSizeY = 1;

    /**
     * panels for location main label on it
     */
    JPanel[][] layoutPanels = new JPanel[layoutSizeY][layoutSizeX];

    /**
     * Constructor for Frame class
     * the constructor generates layout and put main label on it
     * also calls methods for generating words
     */
    Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(layoutSizeY, layoutSizeX));
        this.setSize(ScreenHandler.getInstance().getScaledScreenWidth(), ScreenHandler.getInstance().getScaledScreenHeight());
        this.setJMenuBar(Menu.getInstance().menuBar);

        for (int i = 0; i < layoutSizeY; i++)
            for (int j = 0; j < layoutSizeX; j++) {
                layoutPanels[i][j] = new JPanel();
                layoutPanels[i][j].setBackground(new Color(44, 44, 44));
                this.add(layoutPanels[i][j]);
            }

        this.addKeyListener(TypingListener.getInstance());
        layoutPanels[0][0].add(WordsLabel.getInstance());
        WordsHandler.getInstance().setCurrentWords(WordsGenerator.getInstance().generateRandomWords(30, DifficultyHandler.getCurrentDifficulty()));
        WordsLabel.getInstance().updateText(WordsHandler.getInstance().formatWords());
    }

    /**
     * This method resets words in main label by calling corresponding methods
     */
    public void resetWords(){
        int wordsCount;
        switch (WordsCountHandler.getCurrentWordsCount()){
            case ThirtyWords:
                wordsCount = 30;
                break;
            case FortyFiveWords:
                wordsCount = 45;
                break;
            case SixtyWords:
                wordsCount = 60;
                break;
            default:
                wordsCount = 15;
                break;
        }

        WordsHandler.getInstance().setCurrentWords(WordsGenerator.getInstance().generateRandomWords(wordsCount, DifficultyHandler.getCurrentDifficulty()));
        WordsLabel.getInstance().updateText(WordsHandler.getInstance().formatWords());
        TypingListener.getInstance().reset();
        AppTimer.getInstance().reset();
    }

    /**
     * This method returns instance of Frame class
     * @return return instance of Frame class
     */
    public static Frame getInstance(){
        return instance;
    }
}
