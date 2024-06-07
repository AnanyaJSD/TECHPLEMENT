package quizgenerator;
import java.util.List;


public class QuizQue {
 private String question; private List choices; private int correctChoice;
  
  public QuizQue(String question, List<String> choices, int correctChoice) {
    this.question = question;
    this.choices = choices;
    this.correctChoice = correctChoice;
}

public String getQuestion() {
    return question;
}

public List<String> getChoices() {
    return choices;
}

public int getCorrectChoice() {
    return correctChoice;
}
  
  
}

