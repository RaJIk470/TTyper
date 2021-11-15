import javax.swing.*;
import java.awt.*;

public class SettingsFrame extends JFrame {
    private static SettingsFrame instance = new SettingsFrame();

    SettingsFrame() {
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(ScreenHandler.getInstance().getScaledScreenWidth(), ScreenHandler.getInstance().getScaledScreenHeight());
        this.setLayout(new GridLayout(5,1));
        this.add(DifficultyPanel.getInstance());

    }

    public void showFrame() {
        this.setVisible(true);
    }

    public static SettingsFrame getInstance() {
        return instance;
    }


}
