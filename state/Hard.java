/**
 * @author Walker Menkus
 * The state of the game when set to hard mode.
 * 
 * Created 11/21/2021
 */

package state;

import java.util.Random;

public class Hard implements State {
    private ArithmeticGame game;
    private Random randomizer;

    /**
     * Constructor for Hard mode. Initializes the randomizer that will be used
     * in its functions and pairs it to the game that it relates to.
     * @param game the game that it relates to
     */
    public Hard(ArithmeticGame game) {
        this.game = game;
        randomizer = new Random();
    }

    /**
     * Returns a random integer between 1 and 100 to be used in the arithmetic questions.
     * @return a random integer between 1 and 100
     */
    public int getNum() {
        return randomizer.nextInt(100) + 1;
    }

    /**
     * Selects either "+", "-", "*", or "/" randomly and returns it as a String.
     * @return either "+", "-", "*", or "/"
     */
    public String getOperation() {
        int result = randomizer.nextInt(4);
        if(result == 0) {
            return "+";
        }
        else if(result == 1) {
            return "-";
        }
        else if(result == 2) {
            return "*";
        }
        else {
            return "/";
        }
    }

    /**
     * Keeps the difficulty of the game the same but displays text to the user
     * notifying them that they're doing well.
     */
    public void levelUp() {
        System.out.println("You are doing so well!!!");
    }

    /**
     * Changes the difficulty of the game to Medium and displays text to the user
     * notifying them as such.
     */
    public void levelDown() {
        game.setState(game.getMediumState());
        System.out.println("You are struggling, let's go to medium mode.");
    }
}