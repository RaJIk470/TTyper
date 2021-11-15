import java.util.List;
import java.util.ArrayList;

public class WordsHandler {
    private static WordsHandler instance = new WordsHandler();
    private String currentWords;
    private List<SymbolMarker> wordsMask;

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

    public void setCurrentWords(List<String> words){
        currentWords = String.join(" ", words);
        generateWordsMask(currentWords.length());
    }

    public String getCurrentWords(){
        return currentWords;
    }

    public int getWordsLength(){
        return currentWords.length();
    }

    private void generateWordsMask(int size){
        wordsMask = new ArrayList<>();
        for(int i = 0; i < size; i++)
            wordsMask.add(SymbolMarker.DefaultSymbol);
    }

    public SymbolMarker getMaskElementAt(int index){
        return wordsMask.get(index);
    }

    public void setMaskElementAt(int index, SymbolMarker type){
        wordsMask.set(index, type);
    }

    public static WordsHandler getInstance(){
        return instance;
    }
}
