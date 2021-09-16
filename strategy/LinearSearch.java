package strategy;

import java.util.ArrayList;

public class LinearSearch implements SearchBehavior {

    /**
     * This method searches through the list to see if it contains
     * the person (the parameter "item"). Uses a for loop with equalsIgnoreCase since
     * the native ArrayList.contains() method was case sensitive. This method
     * could throw an exception if given an ArrayList of size 0.
     * @param data
     * @param item
     * @return whether or not the person was found
     */
    public boolean contains(ArrayList<String> data, String item){
        for (int i = 0; i<data.size(); i++)
        {
            if(data.get(i).equalsIgnoreCase(item))
                return true;
        }
        return false;
    }
}
