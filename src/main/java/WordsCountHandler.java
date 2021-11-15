public class WordsCountHandler {
    private static WordsCount wordsCount = WordsCount.FifteenWords;

    public static void setWordsCount(WordsCount newWordsCount) {
        wordsCount = newWordsCount;
    }

    public static WordsCount getCurrentWordsCount() {
        return wordsCount;
    }
}
