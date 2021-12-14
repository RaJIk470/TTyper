import javax.swing.*;
import java.awt.*;

/**
 * settings frame class, the class is responsible for settings frame
 * which contains different options for user
 */
public class SettingsFrame extends JFrame {
    /**
     * instance of SettingsFrame class
     */
    private static SettingsFrame instance = new SettingsFrame();

    /**
     * constructor of SettingsFrame class which adds option panels to this frame
     */
    SettingsFrame() {
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(ScreenHandler.getInstance().getScaledScreenWidth(), ScreenHandler.getInstance().getScaledScreenHeight());
        this.setLayout(new GridLayout(3,1));

        this.getContentPane().setBackground(new Color(44, 44, 44));

        this.add(DifficultyPanel.getInstance());
        this.add(WordsCountPanel.getInstance());
        this.add(WordsOptionsPanel.getInstance());
        //this.add(GameModePanel.getInstance());

    }

    /**
     * this method shows settings frame
     */
    public void showFrame() {
        this.setVisible(true);
    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static SettingsFrame getInstance() {
        return instance;
    }
}
