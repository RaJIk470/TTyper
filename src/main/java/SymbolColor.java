import java.awt.*;

public class SymbolColor {
    private static SymbolColor instance = new SymbolColor(new Color(128, 128, 128), new Color(255, 216, 255), new Color(200, 20, 40));
    Color defaultSymbolColor;
    Color rightSymbolColor;
    Color incorrectSymbolColor;

    SymbolColor(Color defaultSymbolColor, Color rightSymbolColor, Color incorrectSymbolColor){
        this.defaultSymbolColor = defaultSymbolColor;
        this.rightSymbolColor = rightSymbolColor;
        this.incorrectSymbolColor = incorrectSymbolColor;
    }

    public String getDefaultSymbolColor(){
        return "#" + Integer.toHexString(defaultSymbolColor.getRGB()).substring(2);
    }
    public String getRightSymbolColor(){
        return "#" + Integer.toHexString(rightSymbolColor.getRGB()).substring(2);
    }
    public String getIncorrectSymbolColor(){
        return "#" + Integer.toHexString(incorrectSymbolColor.getRGB()).substring(2);
    }

    public static SymbolColor getInstance() {
        return instance;
    }

    public void setNewPalette (Color defaultSymbolColor, Color rightSymbolColor, Color incorrectSymbolColor){
        this.defaultSymbolColor = defaultSymbolColor;
        this.rightSymbolColor = rightSymbolColor;
        this.incorrectSymbolColor = incorrectSymbolColor;
    }
}
