import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class DataParserTest {

    private String inputWithTwo =
            "?Which of these animals is a mammal\n" +
            "Ant\n" +
            "Bee\n" +
            "*Cat\n" +
            "?What is the sum of 2+3\n" +
            "2\n" +
            "*5\n" +
            "6\n";
    private String inputWithThreeQuestions =
            "?Which of these animals is a mammal\n" +
            "Ant\n" +
            "Bee\n" +
            "*Cat\n" +
            "?What is the sum of 2+3\n" +
            "2\n" +
            "*5\n" +
            "?What is the sum of 2+3\n" +
            "2\n" +
            "5\n" +
            "*6\n";

    @Test
    public void testNumberofQuestionsGiven(){
        DataParser dr = new DataParser();
        List<Question> qs = dr.parseText(inputWithTwo);
        assertEquals("wrong number returned: ", 2, qs.size());
    }

    @Test
    public void testReadsFirstQuestionAnswer(){
        DataParser dr = new DataParser();
        List<Question> qs = dr.parseText(inputWithTwo);
        assertEquals ("Cat", qs.get(0).RightAnswer());
    }

    @Test
    public void testReadsSecondQuestionAnswer(){
        DataParser dr = new DataParser();
        List<Question> qs = dr.parseText(inputWithTwo);
        assertEquals ("5", qs.get(1).RightAnswer());
    }

    @Test
    public void GivenShouldbeThree(){
        DataParser dr = new DataParser();
        List<Question> qs = dr.parseText(inputWithThreeQuestions);
        assertEquals("wrong number returned: ", 3, qs.size());
    }


    @Test
    public void AllThreeAnswers(){
        DataParser dr = new DataParser();
        List<Question> qs = dr.parseText(inputWithThreeQuestions);
        assertEquals("Ant" ,qs.get(0).PossibleAnswers().get(0));
        assertEquals("Bee" ,qs.get(0).PossibleAnswers().get(1));
        assertEquals("Cat" ,qs.get(0).PossibleAnswers().get(2));
    }

    @Test
    public void AllThreeAnswersOnSecondQuestion(){
        DataParser dr = new DataParser();
        List<Question> qs = dr.parseText(inputWithThreeQuestions);
        assertEquals("2" ,qs.get(1).PossibleAnswers().get(0));
        assertEquals("5" ,qs.get(1).PossibleAnswers().get(1));
    }

    @Test
    public void ThreeQuestionsAnswers(){
        DataParser dr = new DataParser();
        List<Question> qs = dr.parseText(inputWithThreeQuestions);
        assertEquals ("Cat", qs.get(0).RightAnswer());
        assertEquals ("5", qs.get(1).RightAnswer());
        assertEquals ("6", qs.get(2).RightAnswer());

    }




}
