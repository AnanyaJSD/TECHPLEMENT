
package quizgenerator;

	import java.util.ArrayList;
	import java.util.List;



	public class Quiz1 {
	    private String name; private List questions = new ArrayList<>();
	    public Quiz1(String name) {
	    this.name = name;
	}

	public String getName() {
	    return name;
	}

	public void addQuestion(QuizQue question) {
	    questions.add(question);
	}

	public QuizQue getQuestion(int index) {
	    return (QuizQue) questions.get(index);
	}

	public int getNumQuestions() {
	    return questions.size();
	}

    
    }
	


