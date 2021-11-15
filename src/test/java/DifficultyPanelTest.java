import org.junit.Assert;
import org.junit.Test;

public class DifficultyPanelTest {
    @Test
    public void isDifficultyPanelNotNull(){
        Assert.assertNotNull(DifficultyPanel.getInstance());
    }
}