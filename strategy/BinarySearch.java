package design_patterns.strategy;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch implements SearchBehavior{

    /**
     * This method clones the guest list, sorts the cloned list, and returns the boolean result
     * of a recursive helper method, BinarySearch.partition().
     * @param data the ArrayList of guests
     * @param item the name of the person being searched for
     * @return whether or not the person was found
     */
    public boolean contains(ArrayList<String> data, String item){
        ArrayList<String> tempAL = new ArrayList<String>();
        for(int i=0; i<data.size(); i++)
            tempAL.add(data.get(i));
        Collections.sort(data);
        return partition(data, item);

    }
    
    /**
     * This method recursively divides the sorted ArrayList from BinarySearch.contains()
     * into smaller ArrayLists to perform a binary search. Could potentially throw a logic error
     * based on how names are capitalized in the list. (for example, a name stored as BRenda could
     * come before Brad).
     * @param data the sorted, temporary ArrayList of guests
     * @param item the name of the person being searched for
     * @return whether or not the person was found
     */
    public boolean partition(ArrayList<String> data, String item){
        int partition = data.size()/2;
        if(data.get(partition).equalsIgnoreCase(item))
            return true;
        else if (data.size() == 1 || data.size() == 0)
            return false;
        else if(item.compareToIgnoreCase(data.get(partition)) < 0)
        {
            ArrayList<String> lowerHalf = new ArrayList<String>();
            for(int i=0; i<partition;i++)
                lowerHalf.add(data.get(i));
            return partition(lowerHalf, item);
        }
        else
        {
            ArrayList<String> upperHalf = new ArrayList<String>();
            for(int i=partition;i<data.size();i++)
                upperHalf.add(data.get(i));
            return partition(upperHalf, item);
        }
    }
}
