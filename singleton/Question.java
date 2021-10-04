/**
 * @author Walker Menkus
 */

package singleton;

public class Question {
    private String question;
    private String[] answers;
    private int correctAnswer;

    /**
     * Parameterized constructor for a question to be used in the Trivia Game.
     * Populates a String array of answers using the given parameters.
     * @param question the text of the question that the user will be prompted with
     * @param ans1 the first answer choice
     * @param ans2 the second
     * @param ans3 the third
     * @param ans4 the fourth
     * @param correctAnswer the index of the correct answer. If answer 1 is correct, correctAnswer is 0
     */
    public Question(String question, String ans1, String ans2, String ans3, String ans4, int correctAnswer) {
        this.question = question;
        answers = new String[]{ans1, ans2, ans3, ans4};
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns the question as a formatted string laid out in the form:
     * Question text
     * 1. Answer 1
     * 2. Answer 2
     * 3. Answer 3
     * 4. Answer 4
     */
    public String toString() {
        return ("\n" + question + "\n1. " + answers[0] + "\n2. "
         + answers[1] + "\n3. " + answers[2] + "\n4. " + answers[3]);
    }

    /**
     * Checks to see if the user's answer is correct, adjusting for the
     * fact that correctAnswer is zero based
     * @param userAnswer the guess that the user input
     * @return whether or not the user is correct
     */
    public boolean isCorrect(int userAnswer){
        return userAnswer == correctAnswer + 1;
    }

    /**
     * Returns the correct answer choice.
     * @return the text of the correct answer
     */
    public String getCorrectAnswer() {
        return answers[correctAnswer];
    }
}
