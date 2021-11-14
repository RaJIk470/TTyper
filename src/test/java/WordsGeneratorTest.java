import org.junit.Assert;
import org.junit.Test;

public class WordsGeneratorTest {
    @Test
    public void isWordsGeneratorNotNull(){
       Assert.assertNotNull(WordsGenerator.getInstance());
    }
    @Test
    public void isWordsLengthRight(){
        Assert.assertEquals(41, WordsGenerator.getInstance().generateRandomWords(41, Difficulty.Easy).size());
    }
    @Test
    public void isEasyDifficultySetCorrectly(){
        boolean isCorrectly = true;
        for (String word : WordsGenerator.getInstance().generateRandomWords(40, Difficulty.Easy)){
            if (word.length() < WordsGenerator.getInstance().easyLowerBorder ||
                    word.length() > WordsGenerator.getInstance().easyHigherBorder){
                isCorrectly = false;
                break;
            }
        }
        Assert.assertFalse(isCorrectly);
    }
    @Test
    public void isMediumDifficultySetCorrectly(){
        boolean isCorrectly = true;
        for (String word : WordsGenerator.getInstance().generateRandomWords(40, Difficulty.Medium)){
            if (word.length() < WordsGenerator.getInstance().mediumLowerBorder ||
                    word.length() > WordsGenerator.getInstance().mediumHigherBorder){
                isCorrectly = false;
                break;
            }
        }
        Assert.assertFalse(isCorrectly);
    }
    @Test
    public void isHardDifficultySetCorrectly(){
        boolean isCorrectly = true;
        for (String word : WordsGenerator.getInstance().generateRandomWords(40, Difficulty.Hard)){
            if (word.length() < WordsGenerator.getInstance().hardLowerBorder ||
                    word.length() > WordsGenerator.getInstance().hardHigherBorder){
                isCorrectly = false;
                break;
            }
        }
        Assert.assertFalse(isCorrectly);
    }
}
