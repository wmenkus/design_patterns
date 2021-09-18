package factory;

public class ContemporaryHome extends HousePlan {
    
    /**
     * Default constructor for a ContemporaryHome. Passes the values for
     * inherited variables numRooms, numWindows, and squareFeet directly to
     * the superconstructor as raw integers; couldn't find a way to do it
     * with variables. Someone please help me. Thank you.
     */
    public ContemporaryHome() {
        super(5, 40, 3000);
    }

    /**
     * Sets the materials arraylist to contain the materials of a contemporary home.
     */
    protected void setMaterials() {
        materials.add("Ceramics");
        materials.add("High-Strength Alloys");
        materials.add("Composites");
    }
    
    /**
     * Sets the features arraylist to contain the features of a contemporary home.
     */
    protected void setFeatures() {
        features.add("Oversized Windows");
        features.add("Unconventional Roofs");
        features.add("Minimalism");
        features.add("Open Floor Plan");
    }

    /**
     * Returns "Contemporary Home" appended to the beginning of HousePlan's toString.
     * @return all the information about the HousePlan
     */
    public String toString() {
        return "Contemporary Home\n" + super.toString();
    }
}
