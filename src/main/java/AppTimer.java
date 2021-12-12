import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Timer class that calculates time which passed after typing the first symbol of the text
 */
public class AppTimer implements ActionListener {
    /**
     * instance of AppTimer class
     */
    private static AppTimer instance = new AppTimer();

    /**
     * how many ticks do the processor in one second
     */
    final int TICKS_PER_SECOND = 1000;

    /**
     * how often timer add delta time to overall time
     * in this case every 100 ticks timer adds
     * 0.1 second to overall time
     */
    int speed = 100;

    /**
     * overall time
     */
    double currentTime = 0;

    /**
     * timer instance
     */
    Timer timer;

    /**
     * constructor of AppTimer class that defines timer instance
     * and sets speed to the timer
     */
    AppTimer(){
        timer = new Timer(speed,  this);
    }

    /**
     * action of the timer that adds delta time to overall time
     */
    @Override
    public void actionPerformed(ActionEvent e) {
       currentTime += (double)speed / (double)TICKS_PER_SECOND;
    }

    /**
     * this method starts the timer
     */
    public void start(){
        timer.start();
    }

    /**
     * this method resets overall timer and stops the timer
     */
    public void reset(){
        currentTime = 0;
        timer.stop();
    }

    /**
     * this method stops the timer
     */
    public void stop(){
        timer.stop();
    }

    /**
     * This method returns instance of AppTimer class
     * @return return instance of AppTimer class
     */
    public static AppTimer getInstance(){
        return instance;
    }
}
