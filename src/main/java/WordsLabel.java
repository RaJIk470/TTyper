import javax.swing.*;
import java.awt.*;

/**
 * words label class, the class is responding for storing words that is needed to type
 */
public class WordsLabel extends JLabel{
    /**
     * instance of WordsLabel class
     */
    private static WordsLabel instance = new WordsLabel();

    /**
     * constructor of WorsdLabel class, the constructor sets the font for label
     */
    WordsLabel(){
        this.setFont(new Font("Serif", Font.BOLD, 20));
        this.setAlignmentY(CENTER_ALIGNMENT);
    }

    /**
     * this method sets new text to the label
     * @param text new text to replace the old one
     */
    public void updateText(String text){
        this.setText(text);
    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static WordsLabel getInstance() {
        return instance;
    }

}
