package iterator;

public class Flight {
    private String flightNum;
    private String from;
    private String to;
    private int duration;
    private int transfers;

    /**
     * Parameterized constructor for a Flight.
     * @param flightNum the flight number
     * @param from where the flight is leaving from
     * @param to the flight's destination
     * @param duration the length of the flight in minutes
     * @param transfers the number of transfers the flight will have
     */
    public Flight(String flightNum, String from, String to, int duration, int transfers) {
        this.flightNum = flightNum;
        this.from = from;
        this.to = to;
        this.duration = duration;
        this.transfers = transfers;
    }

    /**
     * Accessors
     * @return
     */
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public int getDuration() {
        return duration;
    }
    public int getNumTransfers() {
        return transfers;
    }

    /**
     * Returns a formatted String that lists all of the details of the flight. First checks
     * how many transfers there are to handle the case of 0 transfers or 1 transfer. Separates
     * duration into hours and minutes.
     * @return a formatted string of all of the Flight's information
     */
    public String toString() {
        String transferString;
        if(transfers == 0) {
            transferString = "Direct Flight";
        }
        else if(transfers == 1) {
            transferString = "1 Transfer";
        }
        else {
            transferString = getNumTransfers() + " Transfers";
        }

        return "Flight Number: " + flightNum +
        "\nFrom: " + from +
        "\nTo: " + to +
        "\nDuration: " + getDuration()/60 + " hours " + getDuration()%60 + " minutes" +
        "\n" + transferString;
    }

}
