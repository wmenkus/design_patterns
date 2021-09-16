/**
 * @author Walker Menkus
 */

package decorator;

public class PotatoeHead extends Character {
    
    /**
     * Constructs a blank potato head by filling the sections ArrayList with the parts of
     * a potato.
     */
    public PotatoeHead() {
        super();
        sections.add("    ____");
        sections.add("   /    \\");
        sections.add("  /      \\");
        sections.add(" |        |");
        sections.add(" |        |");
        sections.add("  \\      /");
        sections.add("   \\____/");
    }
}