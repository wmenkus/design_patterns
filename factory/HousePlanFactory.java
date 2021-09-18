package factory;

public class HousePlanFactory {

    /**
     * The factory method. Takes in a string that specifies which kind of house to be built,
     * creates the correct HousePlan, and returns it. Returns null if given an invalid input.
     * @param type The type of HousePlan to be created
     * @return the corresponding HousePlan or null
     */
    public static HousePlan createHousePlan(String type) {
        if(type.equalsIgnoreCase("log cabin")) {
            return new LogCabinPlan();
        }
        else if(type.equalsIgnoreCase("tiny home")) {
            return new TinyHomePlan();
        }
        else if(type.equalsIgnoreCase("contemporary home")) {
            return new ContemporaryHome();
        }
        else return null;
    }
}