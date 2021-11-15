import org.junit.Assert;
import org.junit.Test;

public class SettingsFrameTest {
    @Test
    public void isSettingsFrameNotNull(){
        Assert.assertNotNull(SettingsFrame.getInstance());
    }
}