/**
 * @author Walker Menkus
 * An interface to be implemented by the different difficulty states of the ArithmeticGame.
 * 
 * Created 11/21/2021
 */

package state;

public interface State {

    /**
     * Will return some random number with a range based on difficulty.
     * @return a random integer
     */
    public int getNum();

    /**
     * Will return a mathematical operator randomly as a String, with more operators included
     * at higher difficulties.
     * @return a random math operator
     */
    public String getOperation();

    /**
     * Will change game to a higher difficulty and display some text to the
     * user notifying them as such.
     */
    public void levelUp();

    /**
     * Will change game to a higher difficulty and display some text to the
     * user notifying them as such.
     */
    public void levelDown();
    
}
