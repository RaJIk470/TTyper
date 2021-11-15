import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TypingListener extends KeyAdapter{
    private static TypingListener instance = new TypingListener();
    final int BACKSPACE = 8;
    final int ENTER = 10;

    private String typedText;
    private int rightSymbolsCounter;

    TypingListener(){
        reset();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == BACKSPACE && typedText.length() != 0) {
            if (WordsHandler.getInstance().getMaskElementAt(typedText.length() - 1) == SymbolMarker.RightSymbol)
                rightSymbolsCounter -= 1;
            WordsHandler.getInstance().setMaskElementAt(typedText.length() - 1, SymbolMarker.DefaultSymbol);
            typedText = typedText.substring(0, typedText.length() - 1);

            WordsLabel.getInstance().updateText(WordsHandler.getInstance().formatWords());
        }
        else if (e.getKeyCode() == ENTER){
            Frame.getInstance().resetWords();
        }
        else if (e.getKeyCode() >= 31 && e.getKeyChar() <= 122){ //if key char is a symbol
            if (typedText.length() < WordsHandler.getInstance().getWordsLength()) {
                typedText += e.getKeyChar();
                SymbolMarker sm = checkSymbol(e.getKeyChar(),
                        WordsHandler.getInstance().getCurrentWords().charAt(typedText.length()-1));
                if(sm == SymbolMarker.RightSymbol)
                    rightSymbolsCounter += 1;
                WordsHandler.getInstance().setMaskElementAt(typedText.length() - 1, sm);
                WordsLabel.getInstance().updateText(WordsHandler.getInstance().formatWords());
            }
        }
    }

    public SymbolMarker checkSymbol(char a, char b){
        if (a == b){
           return SymbolMarker.RightSymbol;
        }
        return SymbolMarker.IncorrectSymbol;
    }

    public String getTypedText(){
        return typedText;
    }

    public int getRightSymbolsCounter(){
        return rightSymbolsCounter;
    }

    public void reset(){
        typedText = "";
        rightSymbolsCounter = 0;
    }

    public static TypingListener getInstance() {
        return instance;
    }
}
