/**
 * @author Walker Menkus
 * An adapter class to convert a UofSC Health Record into a South Carolina Medical Record.
 * 
 * Created 12/1/2021
 */

package adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MedicalRecordAdapter implements MedicalRecord {

    private HealthRecord record;
    
    /**
     * Adapter constructor
     * @param record the HealthRecord to be adapted to a MedicalRecord
     */
    public MedicalRecordAdapter(HealthRecord record) {
        this.record = record;
    }

    /**
     * Returns a first name by splitting the HealthRecord's name based on where the space is.
     * @return the first name of the patient
     */
    public String getFirstName() {
        String[] name = record.getName().split(" ");
        return name[0];
    }

    /**
     * Returns a last name by splitting the full name on the space
     * @return the last name of the patient
     */
    public String getLastName() {
        String[] name = record.getName().split(" ");
        return name[1];
    }

    public Date getBirthday() {
        return record.getBirthdate();
    }

    /**
     * Converts gender from a String to its related enum in Gender.java.
     * @return the gender of the patient as an enum
     */
    public Gender getGender() {
        String gender = record.getGender();
        if(gender.equalsIgnoreCase("Male")) {
            return Gender.MALE;
        }
        else if(gender.equalsIgnoreCase("Female")) {
            return Gender.FEMALE;
        }
        else {
            return Gender.OTHER;
        }
    }

    public void addVisit(Date date, boolean well, String description) {
        record.addHistory(date, well, description);
    }

    /**
     * Converts the record of the patient's visits.
     * HealthRecord stores patient visits as a list of Strings, while MedicalRecord
     * stores them as a java Date, a boolean for whether or not it was a well checkup,
     * and a String to describe the visit. This is the same information as in the HealthRecord,
     * but the String must be converted into data the MedicalRecord can use.
     */
    public ArrayList<Visit> getVisitHistory() {
        ArrayList<String> history = record.getHistory();
        ArrayList<Visit> visits = new ArrayList<Visit>();
        for(String s : history) {
            String[] split = s.split("\n");

            String[] dateString = split[0].split(" ");
            String day = dateString[2].substring(0, 2);
            String month = dateString[3].substring(0, 2);
            String year = dateString[4];

            Date date = makeDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            boolean well = split[1].contains("true");
            String description = split[2].substring(9);
            Visit visit = new Visit(date, well, description);
            visits.add(visit);
        }
        return visits;
    }

    /**
     * Converts the HealthRecord's information into a String that matches the format of a MedicalRecord.
     */
    public String toString() {
        String result = "***** " + getFirstName()+ " " + getLastName() + " *****\n";
        result += "Birthday: " + getFormattedBirthday() + "\n";
        result += "Gender: " + getFormattedGender() + "\n";
        result += "Medical Visit History: \n";

        ArrayList<Visit> visits = getVisitHistory();
        if(visits.size() == 0){
            result += "No visits yet";
        } else {
            for(Visit visit : visits){
                result += visit.toString() + "\n";
            }
        }

        return result;
    }

    /**
     * Creates a java.util.Date from a given year, month, and day.
     * @param year
     * @param month
     * @param day
     * @return the corresponding Date object
     */
    private Date makeDate(int year, int month, int day) {
        Calendar myCalendar = new GregorianCalendar(year, month - 1, day);
        return myCalendar.getTime();
    }

    /**
     * A method to convert the Date object returned from getBirthday into a String.
     * @return the patient's birthday as a String
     */
    private String getFormattedBirthday(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return simpleDateFormat.format(getBirthday());
    }

    /**
     * A method to convert the Gender enum into a String. Capitalizes the first letter and lowercases
     * the rest.
     * @return the patient's gender as a String
     */
    private String getFormattedGender(){
        String genderText = getGender().toString();
        return genderText.substring(0,1).toUpperCase() + genderText.substring(1).toLowerCase();
    }
}
