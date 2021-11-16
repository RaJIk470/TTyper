import org.junit.Assert;
import org.junit.Test;

public class ResultFrameTest {
    @Test
    public void isResultFrameNotNull(){
        Assert.assertNotNull(ResultFrame.getInstance());
    }

    @Test
    public void isSpmSetCorrectly(){
        ResultFrame.getInstance().setSpm(1231.1231);
        Assert.assertEquals(1231.1231, ResultFrame.getInstance().getSpm(), 0.00001);
    }
}
