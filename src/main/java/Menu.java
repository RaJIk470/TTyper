import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenu implements ActionListener{
    private static Menu instance = new Menu();
    JMenuBar menuBar;

    JMenuItem settings;
    JMenuItem exit;

    Menu(){
        this.setText("Menu");
        menuBar = new JMenuBar();

        settings = new JMenuItem("Settings");
        settings.addActionListener(this);

        exit = new JMenuItem("Exit");
        exit.addActionListener(this);

        this.add(settings);
        this.add(exit);
        menuBar.add(this);
    }

    public void actionPerformed(ActionEvent e){
       if (e.getSource() == settings){
           SettingsFrame.getInstance().showFrame();
       }
       if (e.getSource() == exit){
           System.exit(0);
       }
    }

    public static Menu getInstance (){
        return instance;
    }
}
