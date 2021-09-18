package factory;

import java.util.ArrayList;

public abstract class HousePlan {

    protected ArrayList<String> materials;
    protected ArrayList<String> features;
    private int numRooms;
    private int numWindows;
    private int squareFeet;

    /**
     * Constructor for a HousePlan. Takes in numbers of rooms, windows, and square footage from
     * the default constructors of child classes, then generates arraylists for materials and features
     * to be populated with the correct values by setMaterials and setFeatures methods in child classes.
     * @param numRooms the number of rooms in the house
     * @param numWindows the number of windows in the house
     * @param squareFeet the square footage of the house
     */
    public HousePlan(int numRooms, int numWindows, int squareFeet) {
        this.numRooms = numRooms;
        this.numWindows = numWindows;
        this.squareFeet = squareFeet;
        materials = new ArrayList<String>();
        setMaterials();
        features = new ArrayList<String>();
        setFeatures();
    }

    /**
     * Child classes will have these methods to populate their materials and features arraylists
     * with the correct values upon construction
     */
    protected abstract void setMaterials();
    protected abstract void setFeatures();

    /**
     * Accessor for protected arraylist "materials"
     * @return the list of materials
     */
    public ArrayList<String> getMaterials() {
        return materials;
    }

    /**
     * Accessor for protected arraylist "features"
     * @return the list of features
     */
    public ArrayList<String> getFeatures() {
        return features;
    }

    /**
     * Accessor for private int numRooms
     * @return the number of rooms
     */
    public int getNumRooms() {
        return numRooms;
    }

    /**
     * Accessor for private int numWindows
     * @return the number of windows
     */
    public int getNumWindows() {
        return numWindows;
    }

    /**
     * Accessor for private int squareFeet
     * @return the square footage
     */
    public int getSquareFeet() {
        return squareFeet;
    }

    /**
     * Returns a string that contains all the information about the HousePlan, formatted with
     * materials and features in a bulleted list. DOES NOT CONTAIN THE TYPE OF HOUSE ITSELF; this
     * is added to the beginning of this toString in child classes.
     * @return all the internal information about the HousePlan
     */
    public String toString() {
        String result = "Square feet: " + getSquareFeet() + "\n" +
        "Room: " + getNumRooms() + "\n" +
        "Windows: " + getNumWindows() + "\n" +
        "\n" +
        "Materials:\n";
        for(String s : getMaterials()) {
            result += " - " + s + "\n";
        }
        result += "\n" +
        "Features:\n";
        for(String s : getFeatures()) {
            result += " - " + s + "\n";
        }
        result += "\n";
        return result;
    }
}
