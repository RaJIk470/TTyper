/**
 * Words options handler class, the class is responding for setting and getting
 * options for text
 */
public class WordsOptionsHandler {
    /**
     * is commas option set
     */
    private static boolean isCommasSet = false;
    /**
     * is upper symbols option set
     */
    private static boolean isUpperSymbolsSet = false;
    /**
     * is special symbols  option set
     */
    private static boolean isSpecialSymbolsSet = false;
    /**
     * is digit option set
     */
    private static boolean isDigitsSet = false;

    /**
     * this method sets the commas option
     */
    public static void setCommas(){
        isCommasSet = true;
    }
    /**
     * this method sets the special symbols option
     */
    public static void setSpecialSymbols(){
        isSpecialSymbolsSet = true;
    }
    /**
     * this method sets the upper symbols option
     */
    public static void setUpperSymbols(){
        isUpperSymbolsSet = true;
    }
    /**
     * this method sets the digit option
     */
    public static void setDigits(){
        isDigitsSet = true;
    }

    /**
     * this method unsets the commas option
     */
    public static void unsetCommas(){
        isCommasSet = false;
    }
    /**
     * this method unsets the special symbols option
     */
    public static void unsetSpecialSymbols(){
        isSpecialSymbolsSet = false;
    }
    /**
     * this method unsets the upper symbols option
     */
    public static void unsetUpperSymbols(){
        isUpperSymbolsSet = false;
    }
    /**
     * this method unsets the digit option
     */
    public static void unsetDigits(){
        isDigitsSet = false;
    }

    /**
     * this method returns current commas option
     * @return return current commas option
     */
    public static boolean getCommas(){
        return isCommasSet;
    }
    /**
     * this method returns current special symbols option
     * @return return current special symbols option
     */
    public static boolean getSpecialSymbols(){
        return isSpecialSymbolsSet;
    }
    /**
     * this method returns current upper symbols option
     * @return return current upper symbols option
     */
    public static boolean getUpperSymbols(){
        return isUpperSymbolsSet;
    }
    /**
     * this method returns current digit option
     * @return return current digit option
     */
    public static boolean getDigits(){
        return isDigitsSet;
    }

}
