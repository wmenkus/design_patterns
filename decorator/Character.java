/**
 * @author Walker Menkus
 */
package decorator;

import java.util.ArrayList;

public abstract class Character {
    protected ArrayList<String> sections;

    /**
     * Default constructor for abstract class Character, creates an array list of
     * strings to be printed out line by line to draw the character.
     */
    public Character() {
        this.sections = new ArrayList<String>();
    }

    /**
     * Draws the character by printing out the contents of the sections ArrayList line by line.
     */
    public void draw() {
        for(String section : sections) {
            System.out.println(section);
        }
    }
}