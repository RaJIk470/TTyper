import org.junit.Assert;
import org.junit.Test;

public class ScreenHandlerTest {
    @Test
    public void isScreenHandlerNotNull(){
        Assert.assertNotNull(ScreenHandler.getInstance());
    }
    @Test
    public void isScreenWidthANumber(){
        Assert.assertNotNull(ScreenHandler.getInstance().getScreenWidth());
    }
    @Test
    public void isScreenHeightANumber(){
        Assert.assertNotNull(ScreenHandler.getInstance().getScreenHeight());
    }
    @Test
    public void isScaledScreenWidthANumber(){
        Assert.assertNotNull(ScreenHandler.getInstance().getScaledScreenWidth());
    }
    @Test
    public void isScaledScreenHeightANumber(){
        Assert.assertNotNull(ScreenHandler.getInstance().getScaledScreenHeight());
    }
}
