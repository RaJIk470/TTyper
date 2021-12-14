import java.awt.*;

/**
 * screen hander class, the class is responsible for handling screen size
 */
public class ScreenHandler {
    /**
     * instance of ScreenHandler class
     */
    private static ScreenHandler instance = new ScreenHandler();

    /**
     * width and heigth of the user's screen
     */
    Dimension screenSize;

    /**
     * width of the user's screen
     */
    int screenWidth;
    /**
     * height of the user's screen
     */
    int screenHeight;
    /**
     * width of the user's screen, but scaled
     */
    int widthScreenScale;
    /**
     * width of the user's screen, but scaled
     */
    int heightScreenScale;

    /**
     * the constructor of ScreenHandler class
     * the constructor defines screen variables
     */
    ScreenHandler(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        screenWidth = screenSize.width;
        screenHeight = screenSize.height;

        widthScreenScale = 2;
        heightScreenScale = 3;
    }

    /**
     * the constructor of ScreenHandler class
     * the constructor defines screen variables
     */
    ScreenHandler(int widthScreenScale, int heightScreenScale){
        super();
        this.widthScreenScale = widthScreenScale;
        this.heightScreenScale = heightScreenScale;
    }

    /**
     * this method returns screen width
     * @return return screen width
     */
    public int getScreenWidth(){
        return screenWidth;
    }
    /**
     * this method returns screen height
     * @return return screen height
     */
    public int getScreenHeight(){
        return screenHeight;
    }
    /**
     * this method returns scaled screen width
     * @return return scald screen width
     */
    public int getScaledScreenWidth(){
        return (int)(screenWidth / widthScreenScale);
    }
    /**
     * this method returns scaled screen height
     * @return return scaled screen height
     */
    public int getScaledScreenHeight(){
        return (int)(screenHeight / widthScreenScale);
    }

    /**
     * this method returns instance of the class
     * @return return instance of the class
     */
    public static synchronized ScreenHandler getInstance(){
        return instance;
    }
}
