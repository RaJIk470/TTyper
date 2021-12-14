import java.awt.*;

/**
 * symbol color class, the class is responsible for getting and setting symbol colors
 */
public class SymbolColor {
    /**
     * instance of SybmolColor class
     */
    private static SymbolColor instance = new SymbolColor(new Color(128, 128, 128), new Color(255, 216, 255), new Color(200, 20, 40));

    /**
     * color of symbol that isn't typed
     */
    Color defaultSymbolColor;
    /**
     * color of symbol that is typed correctly
     */
    Color rightSymbolColor;
    /**
     * color of symbol that isn't typed correctly
     */
    Color incorrectSymbolColor;

    /**
     * the constructor of the class
     * whice defines color variables
     * @param defaultSymbolColor color of symbol that isn't typed
     * @param rightSymbolColor color of symbol that is typed correctly
     * @param incorrectSymbolColor color of symbol that isn't typed correctly
     */
    SymbolColor(Color defaultSymbolColor, Color rightSymbolColor, Color incorrectSymbolColor){
        this.defaultSymbolColor = defaultSymbolColor;
        this.rightSymbolColor = rightSymbolColor;
        this.incorrectSymbolColor = incorrectSymbolColor;
    }

    /**
     * this method returns hex value of default color
     * @return return hex value of default color
     */
    public String getDefaultSymbolColor(){
        return "#" + Integer.toHexString(defaultSymbolColor.getRGB()).substring(2);
    }
    /**
     * this method returns hex value of right color
     * @return return hex value of right color
     */
    public String getRightSymbolColor(){
        return "#" + Integer.toHexString(rightSymbolColor.getRGB()).substring(2);
    }
    /**
     * this method returns hex value of incorrect color
     * @return return hex value of incorrect color
     */
    public String getIncorrectSymbolColor(){
        return "#" + Integer.toHexString(incorrectSymbolColor.getRGB()).substring(2);
    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static SymbolColor getInstance() {
        return instance;
    }

    /**
     * this method sets new palette for symbols
     * @param defaultSymbolColor color of symbol that isn't typed
     * @param rightSymbolColor color of symbol that is typed correctly
     * @param incorrectSymbolColor color of symbol that isn't typed correctly
     */
    public void setNewPalette (Color defaultSymbolColor, Color rightSymbolColor, Color incorrectSymbolColor){
        this.defaultSymbolColor = defaultSymbolColor;
        this.rightSymbolColor = rightSymbolColor;
        this.incorrectSymbolColor = incorrectSymbolColor;
    }
}
