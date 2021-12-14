import java.security.SecureRandom;
import java.util.List;
import java.util.ArrayList;

/**
 * words handler class, the class is responding for handling words
 * the class performs the action of
 * returning formatted words (with color)
 */
public class WordsHandler {
    /**
     * instance of WordsHandler class
     */
    private static WordsHandler instance = new WordsHandler();
    /**
     * current words that user will be typing (or is typing)
     */
    private String currentWords;
    /**
     * mask of the words is needed to define how to fill the symbols (by which color)
     */
    private List<SymbolMarker> wordsMask;

    /**
     * the method returns the string of the formatted words (with color)
     * @return returns the string of the formatted words (with color)
     */
    public String formatWords() {
        String formattedWords = "";
        for (int i = 0; i < currentWords.length(); i++){
            String colorType = "color";
            if (wordsMask.get(i) == SymbolMarker.DefaultSymbol){
                formattedWords += String.format("<font style=\"%s:%s;\">%s</font>",
                        colorType, SymbolColor.getInstance().getDefaultSymbolColor(), currentWords.charAt(i));
            }
            if (wordsMask.get(i) == SymbolMarker.RightSymbol){
                formattedWords += String.format("<font style=\"%s:%s;\">%s</font>",
                        colorType, SymbolColor.getInstance().getRightSymbolColor(), currentWords.charAt(i));
            }
            if (wordsMask.get(i) == SymbolMarker.IncorrectSymbol){
                if (currentWords.charAt(i) == ' ')
                    colorType = "background-color";
                formattedWords += String.format("<font style=\"%s:%s;\">%s</font>",
                        colorType, SymbolColor.getInstance().getIncorrectSymbolColor(), currentWords.charAt(i));
            }
        }

        int bodyWidth = ScreenHandler.getInstance().getScaledScreenWidth() / 3 * 2;
        formattedWords = String.format("<html><body style=\"width:%dpx\">" + formattedWords + "</body></html>", bodyWidth);


        return formattedWords;
    }

    /**
     * this method sets new words
     * @param words new words to replace the old one
     */
    public void setCurrentWords(List<String> words){
        String correctSpecSymbols = "!@#$^&*()[]':;?/.";
        currentWords = "";
        List<String> newWords = new ArrayList<>();
        for(String word: words){
            String modifiedWord = word;
            SecureRandom random = new SecureRandom();
            if (WordsOptionsHandler.getUpperSymbols())
                modifiedWord = modifiedWord.substring(0, 1).toUpperCase() + modifiedWord.substring(1);
            if (WordsOptionsHandler.getDigits()){
                int rand = random.nextInt();
                if (rand < 0)
                    rand *= -1;
                modifiedWord = (char)(rand % 10 + 48) + modifiedWord;
            }
            if (WordsOptionsHandler.getSpecialSymbols()){
                char specSym = correctSpecSymbols.charAt(Math.abs(random.nextInt()) % correctSpecSymbols.length());
                modifiedWord = specSym + modifiedWord;
            }
            if (WordsOptionsHandler.getCommas())
                modifiedWord = modifiedWord + ',';
            newWords.add(modifiedWord);
        }
        currentWords = String.join(" ", newWords);
        generateWordsMask(currentWords.length());
    }

    /**
     * this method returns current words
     * @return return current words
     */
    public String getCurrentWords(){
        return currentWords;
    }

    /**
     * this method returns current words length
     * @return return current words length
     */
    public int getWordsLength(){
        return currentWords.length();
    }

    /**
     * this method generates mask for the words
     * @param size size of the mask
     */
    private void generateWordsMask(int size){
        wordsMask = new ArrayList<>();
        for(int i = 0; i < size; i++)
            wordsMask.add(SymbolMarker.DefaultSymbol);
    }

    /**
     * this method return mask element at index 'index'
     * @param index index of an element that is needed to return
     * @return return an element of the mask at index 'index'
     */
    public SymbolMarker getMaskElementAt(int index){
        return wordsMask.get(index);
    }

    /**
     * this method sets mask element at index 'index'
     * @param index index of an element
     * @param type default, right or incorrect symbol
     */
    public void setMaskElementAt(int index, SymbolMarker type){
        wordsMask.set(index, type);
    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static WordsHandler getInstance(){
        return instance;
    }
}