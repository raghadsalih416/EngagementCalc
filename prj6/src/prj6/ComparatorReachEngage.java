/**
 * 
 */
package prj6;

import java.util.Comparator;

/**
 * this class compares 2 people objects
 * by their reach engagement
 * 
 * @author raghadsalih (906394954)
 * @version 2022.03.12
 */
public class ComparatorReachEngage implements Comparator<Person> {
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
        if (o1.getReachEngagement() < o2.getReachEngagement()) {
            return -1;
        }
        if (o1.getReachEngagement() == o2.getReachEngagement()) {
            return 0;
        }
        else {
            return 1;
        }
    }

}
