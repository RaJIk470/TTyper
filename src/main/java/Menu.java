import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * menu class, the class is responsible for creating the menu of the main window
 */
public class Menu extends JMenu implements ActionListener{
    /**
     * the instance of menu class
     */
    private static Menu instance = new Menu();

    /**
     * menu bar instance
     */
    JMenuBar menuBar;

    /**
     * settings option is the first item of menu bar
     */
    JMenuItem settings;

    /**
     * exit option is the second item of menu bar
     */
    JMenuItem exit;

    /**
     * Menu class constructor which defines menu bar and options
     */
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

    /**
     * action that is performed by options
     * @param e ActionEvent parameter that stores the name of option that was performed
     */
    public void actionPerformed(ActionEvent e){
       if (e.getActionCommand().equals("Settings")){
           SettingsFrame.getInstance().showFrame();
       }
       if (e.getActionCommand().equals("Exit")){
           System.exit(0);
       }
    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static Menu getInstance (){
        return instance;
    }
}
