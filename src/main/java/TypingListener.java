import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * typing listener class, the class is responsible for pressing keys and counting symbols that is typed
 */
public class TypingListener extends KeyAdapter{
    /**
     * instance of TypingListener class
     */
    private static TypingListener instance = new TypingListener();

    /**
     * backspace code
     */
    final int BACKSPACE = 8;

    /**
     * enter code
     */
    final int ENTER = 10;

    /**
     * text that has already typed
     */
    private String typedText;

    /**
     * counter for right symbols
     */
    private int rightSymbolsCounter;

    /**
     * is user typing the text
     */
    private boolean isTyping = false;

    /**
     * constructor of the class
     */
    TypingListener(){
        reset();
    }

    /**
     * this method is responsible for key pressing
     * it handles any symbol that is typed
     * when a user presses the enter key the text resets
     * when a user presses the backspace key one letter deletes
     * @param e KeyEvent parameter that stores symbol, code of the symbol
     */
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
            if (!isTyping){
                isTyping = true;
                AppTimer.getInstance().start();
            }
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
        if (typedText.length() == WordsHandler.getInstance().getWordsLength()){
            AppTimer.getInstance().stop();
            double spm = rightSymbolsCounter * (60 / AppTimer.getInstance().currentTime);
            ResultFrame.getInstance().setSpm(spm);
            ResultFrame.getInstance().showFrame();
            Frame.getInstance().resetWords();
        }
    }

    /**
     * this method checks if the symbol typed correctly
     * @param a first symbol
     * @param b second symbol
     * @return returns marker for the symbol
     */
    public SymbolMarker checkSymbol(char a, char b){
        if (a == b){
           return SymbolMarker.RightSymbol;
        }
        return SymbolMarker.IncorrectSymbol;
    }

    /**
     * this method returns typed text
     * @return return typed text
     */
    public String getTypedText(){
        return typedText;
    }

    /**
     * this method returns right symbols counter
     * @return return right symbols counter
     */
    public int getRightSymbolsCounter(){
        return rightSymbolsCounter;
    }

    /**
     * this method resets all variables in the class
     */
    public void reset(){
        typedText = "";
        rightSymbolsCounter = 0;
        isTyping = false;
    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static TypingListener getInstance() {
        return instance;
    }
}
