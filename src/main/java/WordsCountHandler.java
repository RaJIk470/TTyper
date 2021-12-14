/**
 * words count handler class, the class is responsible for setting and getting words count
 */
public class WordsCountHandler {
    /**
     * instance of WordsCountHandler class
     */
    private static WordsCount wordsCount = WordsCount.ThirtyWords;

    /**
     * this method sets a new words count
     * @param newWordsCount new words count to replace old one
     */
    public static void setWordsCount(WordsCount newWordsCount) {
        wordsCount = newWordsCount;
    }

    /**
     * this method returns current words count
     * @return return current words count
     */
    public static WordsCount getCurrentWordsCount() {
        return wordsCount;
    }
}
