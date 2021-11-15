import javax.swing.*;
import java.awt.*;

public class WordsLabel extends JLabel{
    private static WordsLabel instance = new WordsLabel();
    WordsLabel(){
        this.setFont(new Font("Serif", Font.BOLD, 20));
        this.setAlignmentY(CENTER_ALIGNMENT);
    }

    public void updateText(String text){
        this.setText(text);
    }


    public static WordsLabel getInstance() {
        return instance;
    }

}
