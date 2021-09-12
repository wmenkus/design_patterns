/**
 * @author Walker Menkus
 */

package design_patterns.decorator;

public class Hat extends CharacterDecorator {

    /**
     * Adds a hat by calling the customize method in the super constructor.
     * @param character the character to receive the hat
     */
    public Hat(Character character) {
        super(character);
    }

    /**
     * Replaces the first and second lines of the character drawing to add a hat.
     */
    public void customize() {
        sections.set(0, "    ____");
        sections.set(1, "___|____|___");
    }
}
