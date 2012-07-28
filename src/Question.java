import java.util.List;

public class Question {


    private String answer;
    private List<String> answers;

    public Question(String correctAnswer, List<String> answers) {
        this.answer = correctAnswer;
        this.answers = answers;
    }

    public String RightAnswer() {
        return answer;
    }


    public List<String> PossibleAnswers() {
        return answers;
    }
}
