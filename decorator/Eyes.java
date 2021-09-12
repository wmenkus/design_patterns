/**
 * @author Walker Menkus
 */

package design_patterns.decorator;

public class Eyes extends CharacterDecorator {

    /**
     * Adds eyes by calling the customize method in the super constructor.
     * @param character the character that will receive eyes
     */
    public Eyes(Character character) {
        super(character);
    }

    /**
     * Replaces the fourth line of the character drawing to add eyes.
     */
    public void customize() {
        sections.set(3, " |  o  o  | ");
    }
}
