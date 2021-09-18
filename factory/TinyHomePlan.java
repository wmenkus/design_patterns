package factory;

public class TinyHomePlan extends HousePlan{

    /**
     * Default constructor for a TinyHomePlan. Passes the values for
     * inherited variables numRooms, numWindows, and squareFeet directly to
     * the superconstructor as raw integers; couldn't find a way to do it
     * with variables. Someone please help me. Thank you.
     * Also generates an ArrayList for materials and features, and sets them to
     * the correct values for a tiny home.
     */
    public TinyHomePlan() {
        super(1, 5, 200);
    }

    /**
     * Sets the materials arraylist to contain the materials of a tiny home.
     */
    protected void setMaterials() {
        materials.add("Lumber");
        materials.add("Insulation");
        materials.add("Metal Roofing");
        materials.add("Hardware");
    }

    /**
     * Sets the materials arraylist to contain the features of a tiny home.
     */
    protected void setFeatures() {
        features.add("Natural Light");
        features.add("Creative Storage");
        features.add("Multipurpose Areas");
        features.add("Multi-use Applications");
    }

    /**
     * Returns "Tiny Home" appended to the beginning of HousePlan's toString.
     * @return all the information about the HousePlan
     */
    public String toString() {
        return "Tiny Home\n" + super.toString();
    }

}
