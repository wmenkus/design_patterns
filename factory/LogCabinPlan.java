package factory;

public class LogCabinPlan extends HousePlan {

    /**
     * Default constructor for a LogCabinPlan. Passes the values for
     * inherited variables numRooms, numWindows, and squareFeet directly to
     * the superconstructor as raw integers; couldn't find a way to do it
     * with variables. Someone please help me. Thank you.
     * Also generates an ArrayList for materials and features, and sets them to
     * the correct values for a log cabin.
     */
    public LogCabinPlan() {
        super(2, 10, 1800);
    }

    /**
     * Sets the materials arraylist to contain the materials of a log cabin.
     */
    protected void setMaterials() {
        materials.add("Log Siding");
        materials.add ("Board and Batten Siding");
        materials.add("White Pine");
    }

    /**
     * Sets the features arraylist to contain the features of a log cabin
     */
    protected void setFeatures() {
        features.add("Timbered Roof");
        features.add("High Insulation");
        features.add("Rustic Effect");
    }

    /**
     * Returns "Log Cabin" appended to the beginning of HousePlan's toString.
     * @return all the information about the HousePlan
     */
    public String toString() {
        return "Log Cabin\n" + super.toString();
    }
}
