package quizgenerator;
 import java.util.*;
 public class QuizGenerator {


    private static Map<String, Quiz1> quizzes = new HashMap<>();

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	            OUTER:
	            while (true) {
	                System.out.println("Enter a command from : (create, take, show, list, exit)");
	                String command = scanner.nextLine();
	                switch (command) {
	                    case "create":
	                        createQuiz(scanner);
	                        break;
	                    case "take":
	                        takeQuiz(scanner);
	                        break;
	                    case "show":
	                        viewQuiz(scanner);
	                        break;
	                    case "list":
	                        listQuizzes();
	                        break;
	                    case "exit":
	                        break OUTER;
	                    default:
	                        System.out.println("Invalid command.");
	                        break;
	                }
	            }
	}

	private static void createQuiz(Scanner scanner) {
	    System.out.println("Enter the name of the quiz:");
	    String quizName = scanner.nextLine();
	    Quiz1 quiz = new Quiz1(quizName);
	    System.out.println("Enter the number of questions:");
	    int numQuestions = Integer.parseInt(scanner.nextLine());
	    for (int i = 0; i < numQuestions; i++) {
	        System.out.println("Enter the question:");
	        String question = scanner.nextLine();
	        System.out.println("Enter the number of choices:");
	        int numChoices = Integer.parseInt(scanner.nextLine());
	        List<String> choices = new ArrayList<>();
	        for (int j = 0; j < numChoices; j++) {
	            System.out.println("Enter choices " + (j+1) + ":");
	            String choice = scanner.nextLine();
	            choices.add(choice);
	        }
	        System.out.println("Enter the index of the correct choices:");
	        int correctChoice = Integer.parseInt(scanner.nextLine()) - 1;
	        quiz.addQuestion(new QuizQue(question, choices, correctChoice));
	    }
	    quizzes.put(quizName, quiz);
	    System.out.println("Quiz created.");
	}
	private static void takeQuiz(Scanner scanner) {
	    System.out.println("Enter the name of the quiz:");
	    String quizName = scanner.nextLine();
	    Quiz1 quiz = quizzes.get(quizName);
	    if (quiz == null) {
	        System.out.println("Quiz not found.");
	        return;
	    }
	    int score = 0;
	    for (int i = 0; i < quiz.getNumQuestions(); i++) {
	        QuizQue question = quiz.getQuestion(i);
	        System.out.println("Question " + (i+1) + ": " + question.getQuestion());
	       List<String> choices = question.getChoices();
	        for (int j = 0; j < choices.size(); j++) {
	            System.out.println((j+1) + ": " + choices.get(j));
	        }
	        System.out.println("Enter your answer:");
	        int userAnswer = Integer.parseInt(scanner.nextLine()) - 1;
	        if (userAnswer == question.getCorrectChoice()) {
	            System.out.println("Correct!");
	            score++;
	        } else {
	            System.out.println("Answer Incorrect. The correct answer is " + (question.getCorrectChoice()+1) + ".");
	        }
	    }
	    System.out.println("Your score is " + score + " out of " + quiz.getNumQuestions() + ".");
	}

	private static void viewQuiz(Scanner scanner) {
	    System.out.println("Enter the name of the quiz:");
	    String quizName = scanner.nextLine();
	    Quiz1 quiz = quizzes.get(quizName);
	    if (quiz == null) {
	        System.out.println("Quiz not found.");
	        return;}
	    System.out.println("Quiz: " + quiz.getName());
	    for (int i = 0; i < quiz.getNumQuestions(); i++) {
	        QuizQue question = quiz.getQuestion(i);
	        System.out.println("Question " + (i+1) + ": " + question.getQuestion());
	        List<String> choices = question.getChoices();
	        for (int j = 0; j < choices.size(); j++) {
	            System.out.println((j+1) + ": " + choices.get(j));
	        }
	        System.out.println("Answer: " + (question.getCorrectChoice()+1));
	    }
	}

	private static void listQuizzes() {
	    System.out.println("Quizzes:");
	    for (String quizName : quizzes.keySet()) {
	        System.out.println("- " + quizName);
	    }
	}
	    }


