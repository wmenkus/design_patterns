/**
 * @author Walker Menkus
 * The state of the game when set to medium difficulty.
 * 
 * Created 11/21/2021
 */

package state;

import java.util.Random;

public class Medium implements State {
    private ArithmeticGame game;
    private Random randomizer;

    /**
     * Constructor for Medium mode. Initializes the randomizer that will be used
     * in its functions and pairs it to the game that it relates to.
     * @param game the game that it relates to
     */
    public Medium(ArithmeticGame game) {
        this.game = game;
        randomizer = new Random();
    }

    /**
     * Returns a random integer between 1 and 50 to be used in the arithmetic questions.
     * @return a random integer between 1 and 50
     */
    public int getNum() {
        return randomizer.nextInt(50) + 1;
    }

    /**
     * Selects either "+", "-", or "*" randomly and returns it as a String.
     * @return either "+", "-", or "*"
     */
    public String getOperation() {
        int result = randomizer.nextInt(3);
        if(result == 0) {
            return "+";
        }
        else if(result == 1) {
            return "-";
        }
        else {
            return "*";
        }
    }

    /**
     * Changes the difficulty of the game to Hard and displays text to the user
     * notifying them as such.
     */
    public void levelUp() {
        game.setState(game.getHardState());
        System.out.println("You've been advanced to the hardest mode.");
    }

    /**
     * Changes the difficulty of the game to Easy and displays text to the user
     * notifying them as such.
     */
    public void levelDown() {
        game.setState(game.getEasyState());
        System.out.println("You are struggling, let's go to easy mode.");
    }
}