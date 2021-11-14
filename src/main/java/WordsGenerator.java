import java.io.*;
import java.util.*;
import java.security.SecureRandom;

public class WordsGenerator{

    private static WordsGenerator instance;

    static {
        try {
            instance = new WordsGenerator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    List<String> mixedWords;
    List<String> easyWords = new ArrayList<>();
    List<String> mediumWords = new ArrayList<>();
    List<String> hardWords = new ArrayList<>();

    final int easyLowerBorder = 3;
    final int easyHigherBorder = 4;
    final int mediumLowerBorder = 4;
    final int mediumHigherBorder = 6;
    final int hardLowerBorder = 6;
    final int hardHigherBorder = 15;

    WordsGenerator() throws Exception {
        StringBuilder text = new StringBuilder();

        try (FileInputStream wordsFile = new FileInputStream("./src/main/resources/words.txt")) {
            //reading file
            int chr;
            while ((chr = wordsFile.read()) != -1) {
                text.append((char) chr);
            }
        }

        mixedWords = Arrays.asList(text.toString().split("\n"));
        for (String word : mixedWords) {
           if (word.length() >= easyLowerBorder || word.length() <= easyHigherBorder)
               easyWords.add(word);
           if (word.length() >= mediumLowerBorder || word.length() <= mediumHigherBorder)
               mediumWords.add(word);
           if (word.length() >= hardLowerBorder || word.length() <= hardHigherBorder)
               hardWords.add(word);
        }
    }


    public List<String> generateRandomWords(int wordsCount, Difficulty difficulty){
        List<String> wordsToRandomize;
        switch (difficulty){
            case Easy:
                wordsToRandomize = easyWords;
                break;
            case Medium:
                wordsToRandomize = mediumWords;
                break;
            case Hard:
                wordsToRandomize = hardWords;
                break;
            default:
                wordsToRandomize = mixedWords;
                break;

        }
        SecureRandom random = new SecureRandom();
        List<String> generatedWords = new ArrayList<>();

        for (int i = 0; i < wordsCount; i++){
            int randomInt = random.nextInt();
            generatedWords.add((wordsToRandomize.get(Math.abs(randomInt) % wordsToRandomize.size())).replace("\r", ""));
        }

        return generatedWords;
    }

    public static WordsGenerator getInstance(){
        return instance;
    }
}
