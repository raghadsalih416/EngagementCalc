/**
 * 
 */
package prj6;

import java.util.Comparator;

/**
 * this class compares people based 
 * on their name 
 * 
 * @author raghadsalih (906394954)
 * @version 2022.03.12
 *
 */
public class ComparatorByName implements Comparator<Person>{

    /**
     * this class compares people based 
     * on their name 
     * 
     * @param o1
     *          first person to be compared to
     * @param o2
     *          second person to be compared to
     * @return 1 if before, -1 if after, 0 if same
     */
    @Override
    public int compare(Person o1, Person o2) {
       return (o1.getChannelName().toLowerCase().compareTo(o2.getChannelName().toLowerCase())); 
    }

}
