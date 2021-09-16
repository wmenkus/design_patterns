package strategy;

import java.util.ArrayList;

public class GuestList {
    private String title;
    private ArrayList<String> people;
    private SearchBehavior searchBehavior;

    /**
     * This constructs the guest list with an empty array list and
     * uses linear search as the default search behavior.
     * @param title the name of the guest list
     */
    public GuestList(String title){
        this.title = title;
        this.people = new ArrayList<String>();
        this.searchBehavior = new LinearSearch();
    }

    /**
     * These are the accessors
     * @return the name of the guest list or the list itself for use in other methods
     */
    public String getTitle(){
        return this.title;
    }
    public ArrayList<String> getList(){
        return this.people;
    }

    /**
     * These are the mutators
     * @param searchBehavior the new search behavior to be used
     */
    public void setSearchBehavior(SearchBehavior searchBehavior){
        this.searchBehavior = searchBehavior;
    }

    /**
     * This adds a person to the guest list but first checks if a person
     * is already on the guest list. If they are, it returns false to
     * signify that no one was added. If they are not, it adds them and
     * returns true to signify that a person was added.
     * @param person the person being added
     * @return whether or not the person was able to be added
     */
    public boolean add(String person){
        if(searchBehavior.contains(people, person))
            return false;
        else
        {
            people.add(person);
            return true;
        }
    }

    /**
     * This removes a person from the guest list but first checks if a person
     * is on the guest list to begin with. If they are, they are removed and
     * it returns true to signify that someone was removed. If they are not,
     * it returns false to signify that no one was removed.
     * @param person the person being removed
     * @return whether or not the person was able to be removed
     */
    public boolean remove(String person){
        if(searchBehavior.contains(people, person))
        {
            people.remove(person);
            return true;
        }
        else
            return false;
    }


}