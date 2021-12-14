import javax.swing.*;
import java.awt.*;

/**
 * result frame class, the class is responsible for displaying results of typed text
 */
public class ResultFrame extends JFrame{
    /**
     * the instance of ResultFrame class
     */
    private static ResultFrame instance = new ResultFrame();

    /**
     * this label is responsible for storing information about symbols per minute
     */
    JLabel spmLabel;

    /**
     * this label is responsible for storing information about words per minute
     */
    JLabel wpmLabel;

    /**
     * this label is responsible for storing information about right symbols that typed
     */
    JLabel rightSymbolsLabel;

    /**
     * this label is responsible for storing information about user's accuracy
     */
    JLabel accuracyLabel;

    /**
     * current symbols per minute (speed of a user)
     */
    double currentSpm;

    /**
     * size of the layout for result frame with coordinate X
     */
    int layoutSizeX = 2;

    /**
     * size of the layout for result frame  with coordinate Y
     */
    int layoutSizeY = 2;

    /**
     * panels for location result labels on it
     */
    JPanel[][] layoutPanels = new JPanel[layoutSizeY][layoutSizeX];
    /**
     * constructor of the class that defines result label, layout panels
     */
    ResultFrame(){
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(ScreenHandler.getInstance().getScaledScreenWidth(), ScreenHandler.getInstance().getScaledScreenHeight());
        this.setLayout(new GridLayout(layoutSizeY, layoutSizeX));

        for (int i = 0; i < layoutSizeY; i++)
            for (int j = 0; j < layoutSizeX; j++) {
                layoutPanels[i][j] = new JPanel();
                layoutPanels[i][j].setBackground(new Color(128, 128, 128));
                this.add(layoutPanels[i][j]);
            }


        spmLabel = new JLabel();
        wpmLabel = new JLabel();
        rightSymbolsLabel = new JLabel();
        accuracyLabel = new JLabel();

        spmLabel.setFont(new Font("Serif", Font.BOLD, 20));
        wpmLabel.setFont(new Font("Serif", Font.BOLD, 20));
        rightSymbolsLabel.setFont(new Font("Serif", Font.BOLD, 20));
        accuracyLabel.setFont(new Font("Serif", Font.BOLD, 20));

        layoutPanels[0][0].add(spmLabel);
        layoutPanels[1][0].add(wpmLabel);
        layoutPanels[0][1].add(rightSymbolsLabel);
        layoutPanels[1][1].add(accuracyLabel);

    }

    /**
     * this method is responsible for showing the result label
     */
    public void showFrame() {
        this.setVisible(true);
    }

    /**
     * this method writes the results in corresponding labels
     * @param spm the speed of a user
     */
    public void setSpm(double spm){
        currentSpm = spm;
        spmLabel.setText("Symbols per minute: " + String.format("%,.0f", currentSpm));
        wpmLabel.setText("Words per minute: " + String.format("%,.0f", currentSpm / 5));
        rightSymbolsLabel.setText("correct symbols/symbols: " + String.valueOf(TypingListener.getInstance().getRightSymbolsCounter()) +
                " / " + String.valueOf(TypingListener.getInstance().getTypedText().length()));
        double accuracy;
        if (TypingListener.getInstance().getTypedText().length() == 0)
            accuracy = 0;
        else
            accuracy = (double)(TypingListener.getInstance().getRightSymbolsCounter()) / (double)(TypingListener.getInstance().getTypedText().length()) * 100;
        accuracyLabel.setText("Accuracy: " + String.format("%,.0f", accuracy) + "%");

    }

    /**
     * this method returns the speed of a user
     * @return return the speed of a user
     */
    public double getSpm(){
        return currentSpm;
    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static ResultFrame getInstance(){
        return instance;
    }
}
