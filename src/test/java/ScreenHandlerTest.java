import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class ScreenHandlerTest {
    @Test
    public void isScreenHandlerNotNull(){
        Assert.assertNotNull(ScreenHandler.getInstance());
    }
    @Test
    public void isScreenWidthCorrect(){
        Assert.assertEquals(Toolkit.getDefaultToolkit().getScreenSize().width,
                            ScreenHandler.getInstance().getScreenWidth());
    }
    @Test
    public void isScreenHeightCorrect(){
        Assert.assertEquals(Toolkit.getDefaultToolkit().getScreenSize().height,
                ScreenHandler.getInstance().getScreenHeight());
    }
    @Test
    public void isScaledScreenWidthCorrect(){
        Assert.assertTrue(ScreenHandler.getInstance().getScaledScreenWidth() > 0 &&
                           ScreenHandler.getInstance().getScaledScreenWidth() < ScreenHandler.getInstance().getScreenWidth());
    }
    @Test
    public void isScaledScreenHeightCorrect(){
        Assert.assertTrue(ScreenHandler.getInstance().getScaledScreenHeight() > 0 &&
                ScreenHandler.getInstance().getScaledScreenHeight() < ScreenHandler.getInstance().getScreenHeight());
    }
}
