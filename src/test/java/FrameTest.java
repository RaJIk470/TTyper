import org.junit.Assert;
import org.junit.Test;

public class FrameTest {
    @Test
    public void isFrameNotNull(){
        Assert.assertNotNull(Frame.getInstance());
    }
}
