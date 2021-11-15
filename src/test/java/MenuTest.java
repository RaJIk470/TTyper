import org.junit.Assert;
import org.junit.Test;

public class MenuTest {
    @Test
    public void isMenuNotNull(){
        Assert.assertNotNull(Menu.getInstance());
    }
}
