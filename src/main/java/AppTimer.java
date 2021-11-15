import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class AppTimer implements ActionListener {
    private static AppTimer instance = new AppTimer();

    final int TICKS_PER_SECOND = 1000;

    int speed = 100;
    double currentTime = 0;
    Timer timer;

    AppTimer(){
        timer = new Timer(speed,  this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       currentTime += (double)speed / (double)TICKS_PER_SECOND;
    }

    public void start(){
        timer.start();
    }

    public void reset(){
        currentTime = 0;
        timer.stop();
    }

    public void stop(){
        timer.stop();
    }

    public static AppTimer getInstance(){
        return instance;
    }
}
