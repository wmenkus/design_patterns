/**
 * @author Walker Menkus
 */

package design_patterns.decorator;

public class Nose extends CharacterDecorator {

    /**
     * Adds a nose by calling the customize method in the super constructor.
     * @param character the character that will receive a nose
     */
    public Nose(Character character) {
        super(character);
    }

    /**
     * Replaces the fifth line of the character drawing to add a nose.
     */
    public void customize() {
        sections.set(4,  " |    >   | " );
    }
}
