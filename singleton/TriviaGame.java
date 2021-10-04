/**
 * @author Walker Menkus
 */

package singleton;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TriviaGame {
    private static TriviaGame triviaGame;
    private int score;
    private Random rand;
    private Scanner reader;
    private ArrayList<Question> questions;

    /**
     * Constructor for the Trivia Game. Constructor is private to ensure
     * that it is not called while an instance of TriviaGame already exists.
     * Sets the inital score to 0 and reader to accept user input.
     * Populates the questions ArrayList from a file using the DataLoader.
     * Also displays a nice little introduction message.
     */
    private TriviaGame() {
        questions = DataLoader.getTriviaQuestions();
        rand = new Random();
        reader = new Scanner(System.in);
        score = 0;
        System.out.println("======== Trivia Game ========");
    }

    /**
     * Singleton method that checks to see if there is already an instance
     * of TriviaGame. If there is not one, one is created. Then, returns the
     * instance of TriviaGame.
     * @return the current instance of TriviaGame.
     */
    public static TriviaGame getInstance() {
        if (triviaGame == null) {
            triviaGame = new TriviaGame();
        }
        return triviaGame;
    }

    /**
     * The macro gameplay loop. Begins by playing a round,
     * and until the user indicates that they want to quit, prompts them
     * to either play again or quit. When the user gets the correct answer, the score is
     * incremented by 1. Upon quit, displays the user's final score and a
     * goodbye message.
     */
    public void play() {
        if(playRound()) {
            score++;
        }
        boolean quit = false;
        while(!quit) {
            System.out.print("(P)lay or (Q)uit: ");
            String response = reader.nextLine();
            if(response.equalsIgnoreCase("Q")) {
                quit = true;
            }
            else if(response.equalsIgnoreCase("P")) {
                if(playRound()) {
                    score++;
                }
            }
            else {
                System.out.println("\nPlease enter P or Q");
            }
        }
        System.out.println("\nYou won " + score + " games! \nGoodbye");
        reader.close();
    }

    /**
     * Plays a round of the trivia game by randomly selecting a question
     * from the list of questions, displaying it to the user, prompting them
     * for an answer, and comparing that answer to the correct answer.
     * Displays a different message based on whether or not the user was correct.
     * @return whether or not the user was correct.
     */
    private boolean playRound() {
        Question question = questions.get(rand.nextInt(questions.size()));
        System.out.println(question.toString());
        System.out.print("\nEnter answer: ");
        while(true) {
            int input = reader.nextInt();
            reader.nextLine();
            if(1 <= input && input <= 5) {
                if(question.isCorrect(input)) {
                    System.out.println("YAY! You got it right!");
                    return true;
                }
                else {
                    System.out.println("You got it wrong!");
                    System.out.println("The correct answer is " + question.getCorrectAnswer());
                    return false;
                }
            }
        }
    }
}
