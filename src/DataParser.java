import java.util.ArrayList;
import java.util.List;


public class DataParser {

    public List<Question> parseText(String s) {
        List<Question> ls = new ArrayList<Question>();

        String[] lines = s.split("\\?");

        for(String line : lines) {
            if (line.isEmpty()) { continue;}
            String CorrectAnswer = "";
            String[] questionsnanswers = line.split("\\n");
            String question = questionsnanswers[0];
            List<String> Answers = new ArrayList<String>();
            for(String answer : questionsnanswers){
                if (question == answer){
                    continue;
                }
                if (answer.contains("*")){
                    answer = answer.replaceAll("\\*", "");
                    CorrectAnswer = answer;
                }
                answer = answer.replaceAll("\\*", "");
                Answers.add(answer);

            }
            Question q = new Question(CorrectAnswer, Answers);
            ls.add(q);
        }

        return ls;
    }
}
