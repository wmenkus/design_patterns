/**
 * @author Walker Menkus
 */

package decorator;

public abstract class CharacterDecorator extends Character{
    protected Character character;

    /**
     * Constructs a new Character by copying a character's sections and
     * editing them with the customize function.
     * @param character the character to be edited
     */
    public CharacterDecorator(Character character) {
        super();
        for(String section : character.sections) {
            this.sections.add(section);
        }
        customize();
    }

    /**
     * Empty method to be inherited, will replace lines of the sections ArrayList
     */
    public abstract void customize();

}
