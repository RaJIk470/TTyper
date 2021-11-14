import java.awt.*;

public class ScreenHandler {
    private static ScreenHandler instance = new ScreenHandler();
    Dimension screenSize;

    int screenWidth;
    int screenHeight;
    int widthScreenScale;
    int heightScreenScale;

    ScreenHandler(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        screenWidth = screenSize.width;
        screenHeight = screenSize.height;

        widthScreenScale = 3;
        heightScreenScale = 3;
    }

    ScreenHandler(int widthScreenScale, int heightScreenScale){
        super();
        this.widthScreenScale = widthScreenScale;
        this.heightScreenScale = heightScreenScale;
    }

    public int getScreenWidth(){
        return screenWidth;
    }
    public int getScreenHeight(){
        return screenHeight;
    }
    public int getScaledScreenWidth(){
        return (int)(screenWidth / widthScreenScale);
    }
    public int getScaledScreenHeight(){
        return (int)(screenHeight / widthScreenScale);
    }

    public static synchronized ScreenHandler getInstance(){
        return instance;
    }
}
