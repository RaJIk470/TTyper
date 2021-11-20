public class WordsOptionsHandler {
    private static boolean isCommasSet = false;
    private static boolean isUpperSymbolsSet = false;
    private static boolean isSpecialSymbolsSet = false;
    private static boolean isDigitsSet = false;

    public static void setCommas(){
        isCommasSet = true;
    }
    public static void setSpecialSymbols(){
        isSpecialSymbolsSet = true;
    }
    public static void setUpperSymbols(){
        isUpperSymbolsSet = true;
    }
    public static void setDigits(){
        isDigitsSet = true;
    }

    public static void unsetCommas(){
        isCommasSet = false;
    }
    public static void unsetSpecialSymbols(){
        isSpecialSymbolsSet = false;
    }
    public static void unsetUpperSymbols(){
        isUpperSymbolsSet = false;
    }
    public static void unsetDigits(){
        isDigitsSet = false;
    }

    public static boolean getCommas(){
        return isCommasSet;
    }
    public static boolean getSpecialSymbols(){
        return isSpecialSymbolsSet;
    }
    public static boolean getUpperSymbols(){
        return isUpperSymbolsSet;
    }
    public static boolean getDigits(){
        return isDigitsSet;
    }

}
