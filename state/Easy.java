/**
 * @author Walker Menkus
 * The state of the game when set to easy mode.
 * 
 * Created 11/21/2021
 */

package state;

import java.util.Random;

public class Easy implements State {
    private ArithmeticGame game;
    private Random randomizer;

    /**
     * Constructor for Easy mode. Initializes the randomizer that will be used
     * in its functions and pairs it to the game that it relates to.
     * @param game the game that it relates to
     */
    public Easy(ArithmeticGame game) {
        this.game = game;
        randomizer = new Random();
    }

    /**
     * Returns a random integer between 1 and 10 to be used in the arithmetic questions.
     * @return a random integer between 1 and 10
     */
    public int getNum() {
        return randomizer.nextInt(10) + 1;
    }

    /**
     * Selects either "+" or "-" randomly and returns it as a String.
     * @return either "+" or "-"
     */
    public String getOperation() {
        int result = randomizer.nextInt(2);
        if(result == 0) {
            return "+";
        }
        else {
            return "-";
        }
    }

    /**
     * Changes the difficulty of the game to Medium and displays text to the user
     * notifying them as such.
     */
    public void levelUp() {
        game.setState(game.getMediumState());
        System.out.println("You've been advanced to medium mode.");
    }

    /**
     * Keeps the difficulty of the game on easy mode but displays to the user that they are
     * struggling. Just like I have been this whole semester.
     */
    public void levelDown() {
        System.out.println("You seem to be struggling, you may want to study.");
    }
}