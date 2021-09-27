package iterator;

import java.util.Iterator;

public class FlightIterator implements Iterator<Flight>{
    private Flight[] flights;
    private int position;

    /**
     * Parameterized constructor for the FlightIterator. FlightIterator is used to go through an
     * array of flights and check if there is a next flight in the array. Position is initially
     * set to -1 so that the next index is 0.
     * @param flights the array of Flights to be iterated through
     */
    public FlightIterator(Flight[] flights) {
        this.flights = flights;
        position = -1;
    }

    /**
     * Checks to see if the next element in flights exists.
     * @return whether the next index is within the array and not null
     */
    public boolean hasNext() {
        return position + 1 < flights.length && flights[position + 1] != null;
    }

    /**
     * Returns the next Flight and increments position
     * @return the next Flight if it exists, otherwise null
     */
    public Flight next() {
        if(this.hasNext()) {
            position++;
            return flights[position];
        }
        else {
            return null;
        }       
    }
    
}
