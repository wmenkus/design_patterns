/**
 * @author Walker Menkus
 */

package design_patterns.decorator;

public class Mouth extends CharacterDecorator {

    /**
     * Adds a mouth by calling the customize method in the super constructor.
     * @param character the character to receive the mouth
     */
    public Mouth(Character character) {
        super(character);
    }

    /**
     * Replaces the sixth line of the character drawing to add a mouth.
     */
    public void customize() {
        sections.set(5, "  \\ ---- / ");
    }
}
