/**
 * @author Walker Menkus
 * A class to handle the main logic for the Arithmetic Game.
 * 
 * Created 11/21/2021
 */

package state;

import java.util.Scanner;

public class ArithmeticGame {
    private State easyState;
    private State mediumState;
    private State hardState;
    private State state;
    private int score;
    private Scanner reader;

    /**
     * Constructor for the arithmetic game. Creates the various difficulty modes as States,
     * sets the default state to Easy, and initializes the score to 0.
     */
    public ArithmeticGame() {
        easyState = new Easy(this);
        mediumState = new Medium(this);
        hardState = new Hard(this);
        state = easyState;
        score = 0;
        reader = new Scanner(System.in);
    }

    /**
     * The main logic for the arithmetic game. Determines the question that will be asked to the user
     * by receiving two integers and an operator from the current state, presents
     * that question to the user, calculates the correct result, then compares the user's answer
     * to that result to determine if the user is correct.
     * 
     * Notifies the user if they are correct or not, and increments or decrements score accordingly.
     * If the score reaches 3 the game will increase in difficulty, and if the score reaches -3
     * the game will decrease in difficulty. Score resets when difficulty changes.
     */
    public void pressQuestionButton() {
        //Calculating question and the correct result
        int leftHandSide = state.getNum();
        int rightHandSide = state.getNum();
        String operator = state.getOperation();
        int result;
        System.out.print(leftHandSide + " " + operator + " " + rightHandSide + ": ");
        if(operator.equals("+")) {
            result = leftHandSide + rightHandSide;
        }
        else if(operator.equals("-")) {
            result = leftHandSide - rightHandSide;
        }
        else if(operator.equals("*")) {
            result = leftHandSide * rightHandSide;
        }
        else {
            result = leftHandSide / rightHandSide;
        }

        //Checking if user's answer is correct
        int answer = reader.nextInt();
        reader.nextLine();
        if(answer == result) {
            System.out.println("Correct");
            score++;
        }
        else {
            System.out.println("Incorrect");
            score--;
        }

        //Adjusting difficulty if necessary
        if(score >= 3) {
            state.levelUp();
            score = 0;
        }
        else if(score <= -3) {
            state.levelDown();
            score = 0;
        }
    }

    /**
     * Mutator for state. This is used when changing difficulty.
     * @param state the new difficulty mode
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Accessor for the Easy difficulty
     * @return the easyState
     */
    public State getEasyState() {
        return easyState;
    }

    /**
     * Accessor for the Medium difficulty
     * @return the mediumState
     */
    public State getMediumState() {
        return mediumState;
    }

    /**
     * Accessor for the Hard difficulty
     * @return the hardState
     */
    public State getHardState() {
        return hardState;
    }
}
