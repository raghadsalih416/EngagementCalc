/**
 * 
 */
package prj6;

import java.util.Comparator;

/**
 * this class compares people objects and 
 * their traditional engagement
 * 
 * @author raghadsalih (906394954)
 * @version 2022.03.12
 *
 */
public class ComperatorTradEngage implements Comparator<Person> {  
    /**
     * compares 2 different people and their
     * traditional engagement rates
     * 
     * @param o1
     *            first person to be compared
     * @param o2
     *            second person to be compared
     * 
     * @return 1 if first < next, 0 if ==, -1 if first > next
     */
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getTradEngagement() < o2.getTradEngagement()) {
            return -1;
        }
        if (o1.getTradEngagement() == o2.getTradEngagement()) {
            return 0;
        }
        else {
            return 1;
        }
    }

}
