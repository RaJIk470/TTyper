import java.io.*;
import java.util.*;
import java.security.SecureRandom;
import java.util.List;

/**
 * words generator class, the class is responsible for generating random words to type
 */
public class WordsGenerator{

    /**
     * instance of WordsGenerator class
     */
    private static WordsGenerator instance;

    static {
        try {
            instance = new WordsGenerator();
        } catch (Exception e) {
            //empty
        }
    }

    /**
     * list that contains all the words
     */
    List<String> mixedWords;
    /**
     * list that contains all easy words
     */
    List<String> easyWords = new ArrayList<>();
    /**
     * list that contains all medium words
     */
    List<String> mediumWords = new ArrayList<>();
    /**
     * list that contains all hard words
     */
    List<String> hardWords = new ArrayList<>();

    /**
     * lower bound for easy words
     */
    final int easyLowerBorder = 3;
    /**
     * higher bound for easy words
     */
    final int easyHigherBorder = 4;
    /**
     * lower bound for medium words
     */
    final int mediumLowerBorder = 4;
    /**
     * higher bound for medium words
     */
    final int mediumHigherBorder = 6;
    /**
     * lower bound for hard words
     */
    final int hardLowerBorder = 6;
    /**
     * higher bound for hard words
     */
    final int hardHigherBorder = 15;

    /**
     * constructor of WordsGenerator class, the constructor reads the file of the words
     * and adds the corresponding word to their lists
     * @throws Exception
     */
    WordsGenerator() throws Exception {

        StringBuilder text = new StringBuilder();

        File file = new File("target/classes/words.txt");

        //try (FileInputStream wordsFile = new FileInputStream("./src/main/resources/words.txt")) {
        try (FileInputStream wordsFile = new FileInputStream(file.getAbsolutePath())) {
            //reading file
            int chr;
            while ((chr = wordsFile.read()) != -1) {
                text.append((char) chr);
            }
        }

        mixedWords = Arrays.asList(text.toString().split("\n"));
        for (String word : mixedWords) {
           if (word.length() >= easyLowerBorder && word.length() <= easyHigherBorder)
               easyWords.add(word);
           if (word.length() >= mediumLowerBorder && word.length() <= mediumHigherBorder)
               mediumWords.add(word);
           if (word.length() >= hardLowerBorder && word.length() <= hardHigherBorder)
               hardWords.add(word);
        }
    }


    /**
     * this method generate random words and returns their
     * @param wordsCount the number of the words that is needed to generate
     * @param difficulty difficulty of the words
     * @return return the list of random words
     */
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
            if (randomInt < 0)
                randomInt *= -1;
            generatedWords.add((wordsToRandomize.get(randomInt % wordsToRandomize.size())).replace("\r", ""));
        }

        return generatedWords;
    }

    /**
     * this method returns the instance of the class
     * @return return the instance of the class
     */
    public static WordsGenerator getInstance(){
        return instance;
    }
}