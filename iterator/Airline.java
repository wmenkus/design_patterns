package iterator;

public class Airline {
    private String title;
    private Flight[] flights;
    private int size;

    /**
     * Constructor for an Airline. Airlines manage a list of flights, which is initially set to
     * an array of size 2.
     * @param title The name of the airline
     */
    public Airline(String title) {
        this.title = title;
        size = 2;
        flights = new Flight[size];
    }

    /**
     * Attempts to add a new Flight to the flights array. Looks through the array and fills
     * the first empty index, and, if the array is full, grows the array and puts the Flight in the
     * next index.
     * @param flightNum These are all attributes of the Flight that is to be added.
     * @param from "
     * @param to "
     * @param duration "
     * @param transfers "
     */
    public void addFlight(String flightNum, String from, String to, int duration, int transfers) {
        Flight newFlight = new Flight(flightNum, from, to, duration, transfers);
        for(int i = 0; i < flights.length; i++) {
            if(flights[i] == null) {
                flights[i] = newFlight;
                return;
            }
            else if(i == flights.length - 1) {
                flights = growArray(flights);
            }
        }
    }

    /**
     * Accessor for the name of the airline.
     * @return The Airline's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Generates a new array with double the size, then copies over the contents of the old array
     * and returns the new one.
     * @param flights The old array to be resized
     * @return The new, bigger array
     */
    private Flight[] growArray(Flight[] flights) {
        size *= 2;
        Flight[] returnArray = new Flight[size];
        for(int i = 0; i < flights.length; i++) {
            returnArray[i] = flights[i];
        }
        return returnArray;
    }

    /**
     * Creates a new instance of FlightIterator to be used by the Airline.
     * @return The FlightIterator
     */
    public FlightIterator createIterator() {
        return new FlightIterator(flights);
    }
}
