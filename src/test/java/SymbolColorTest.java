import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class SymbolColorTest {
    Color rightColor = new Color(255, 0, 0);
    Color incorrectColor = new Color(227, 38, 54);
    Color defaultColor = new Color(144, 0, 32);

    @Test
    public void isSymbolColorNotNull(){
        Assert.assertNotNull(SymbolColor.getInstance());
    }

    @Test
    public void isRightColorSetRight(){
        SymbolColor.getInstance().setNewPalette(defaultColor, rightColor, incorrectColor);
        Assert.assertEquals("#ff0000", SymbolColor.getInstance().getRightSymbolColor());
    }

    @Test
    public void isIncorrectColorSetRight(){
        SymbolColor.getInstance().setNewPalette(defaultColor, rightColor, incorrectColor);
        Assert.assertEquals("#e32636", SymbolColor.getInstance().getIncorrectSymbolColor());
    }

    @Test
    public void isDefaultColorSetRight(){
        SymbolColor.getInstance().setNewPalette(defaultColor, rightColor, incorrectColor);
        Assert.assertEquals("#900020", SymbolColor.getInstance().getDefaultSymbolColor());
    }


}
