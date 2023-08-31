// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- bhargav panchal (barry22)
package prj6;

/**
 * this class calculates the numbers
 * 
 * @author Raghad Salih (906394954)
 * @version 11.18.2022
 * 
 */
public class EngagementCalculator {
    // ~ Fields ............................................................
    private SimpleLinkedList<Person> list; 

    /**
     * creates a engagement calculator object
     * 
     * @param list
     *            list of people
     */
    public EngagementCalculator(SimpleLinkedList<Person> list) {
        this.list = list;
    }

    
    /**
     * gets the list associated with the calculator
     * 
     * @return the list
     */
    public SimpleLinkedList<Person> getList()
    {
        return list;
    }

    /**
     * calculates first quarter traditional engagement
     * 
     * @param person
     *            person were looking for
     * @return traditional engagement for first Quarter
     */
    public double firstQTrad(Person person) {
        // reach engagement Rate = ( Total Engagement / reach ) x 100%
        /// total engagement across all months
        double total = 0;
        double marchFollow = 0;
        for (int i = 0; i < list.getSize(); i++) {
            // find person
            if (list.get(i).getUsername().equals(person.getUsername())) {
                // same person and either feb, jan, march
                if (list.get(i).getMonth().equals("January") || list.get(i)
                    .getMonth().equals("February") || list.get(i).getMonth()
                        .equals("March")) {
                    total = total + list.get(i).getComments() + list.get(i)
                        .getLikes();
                    if (list.get(i).getMonth().equals("March")) {
                        marchFollow = list.get(i).getFollowers();
                    }
                }
            }
        }
        return ((total / marchFollow) * 100.0);
    }

    /**
     * helper method that gets the march followers 
     * 
     * @param llist
     *            list of people
     * @return array of all march followers
     */
    private int[] findMarchFollowers(SimpleLinkedList<Person> llist) {
        SimpleLinkedList<Person> copy = sortByNameAll(getListForMonth("March"));

        int[] followers = new int[4];
        for (int i = 0; i < copy.getSize(); i++) {

            followers[i] = copy.get(i).getFollowers();

        }
        return followers;
    }


    /**
     * calculates first quarter total engagement
     * 
     * @param likes
     *          array of all likes
     * @param comments
     *          array of all comments
     * @return 
     *      the first quarter traditional engagement
     * 
     */
    private int[] getFirstQTotalEngage(int[] likes, int[] comments) {
        int[] totalEngagement = new int[4];
        int person1Likes = likes[0] + likes[1] + likes[2];
        int person2Likes = likes[3] + likes[4] + likes[5];
        int person3Likes = likes[6] + likes[7] + likes[8];
        int person4Likes = likes[9] + likes[10] + likes[11];

        int person1Comments = comments[0] + comments[1] + comments[2];
        int person2Comments = comments[3] + comments[4] + comments[5];
        int person3Comments = comments[6] + comments[7] + comments[8];
        int person4Comments = comments[9] + comments[10] + comments[11];

        totalEngagement[0] = person1Likes + person1Comments;
        totalEngagement[1] = person2Likes + person2Comments;
        totalEngagement[2] = person3Likes + person3Comments;
        totalEngagement[3] = person4Likes + person4Comments;

        return totalEngagement; 

    }

    /**
     * calculates first quarter traditional engagement
     * 
     * @param llist
     *              list used to find calculations
     * @return 
     *      the first quarter traditional engagement
     * 
     */
    public SimpleLinkedList<Person> getFirstQuarter(
        SimpleLinkedList<Person> llist) {
        // sort passed in list by name
        SimpleLinkedList<Person> copy = sortByNameAll(llist);

        // make arrays for likes comments and int for march followers
        int[] likes = new int[12];
        int[] comments = new int[12];

        // go through the list and seperate all of the likes and commments
        for (int i = 0; i < copy.getSize(); i++) {
            // get followers likes and comments for one peson across 3 months
            likes[i] = copy.get(i).getLikes();
            comments[i] = copy.get(i).getComments(); 

        }

        // sum of all likes + comments
        int[] totalEngagement = getFirstQTotalEngage(likes, comments);

        // find march followers
        int[] marchFollowers = findMarchFollowers(copy);

        // total engagemnt / march followers
        double[] result = new double[4];
        for (int i = 0; i < 4; i++)
        {
            //System.out.println(totalEngagement[i] + " " + marchFollowers[i]);
            result[i] = (100.0 * totalEngagement[i] / marchFollowers[i])  ;
        }
        
        return copy;

    }


    /**
     * calculates first quarter reach engagement
     * 
     * @param person
     *            person were looking for
     * @return reach engagement for first Quarter
     */
    public double firstQReach(Person person) {
        // reach engagement Rate = ( Total Engagement / reach ) x 100%
        /// reach engagement across all months
        double total = 0;
        double reach = 0;
        for (int i = 0; i < list.getSize(); i++) {
            // find person
            if (list.get(i).getUsername().equals(person.getUsername())) {
                // same person and either feb, jan, march
                if (list.get(i).getMonth().equals("January") || list.get(i)
                    .getMonth().equals("February") || list.get(i).getMonth()
                        .equals("March")) {
                    total = total + list.get(i).getComments() + list.get(i)
                        .getLikes();
                    reach = reach + list.get(i).getViews();

                }
            }
        }
        return ((total / reach) * 100);
    }


    /**
     * calculates the sorted list by name
     * has all of the names in it
     * 
     * @param llist
     *          the list to be sorted
     * 
     * @return sorted list of names
     */
    public SimpleLinkedList<Person> sortByNameAll(SimpleLinkedList<Person> llist)
    {
        llist.insertionSort(new ComparatorByName());
        
        return llist; 
    }
    
    /**
     * calculates the sorted list by name
     * has all of the names in it
     * 
     * @param llist
     *          the list to be sorted
     * @param person
     *          person thats being checked
     * @return true if person is in list, false otherwise
     */
  private boolean isThere(SimpleLinkedList<Person> llist, Person person)
  {
      for (int i = 0; i < llist.getSize(); i++)
      {
          if (llist.get(i).getChannelName().equals(person.getChannelName()))
          {
              return true;
          }
      }
      return false;
  }
    
    /**
     * calculates the sorted list by name
     * only one distinct person 
     * so list of 4 people
     * 
     * @param llist
     *          list that will be sorted
     * @return sorted list of names
     */
    public SimpleLinkedList<Person> sortByName4(SimpleLinkedList<Person> llist) {
        SimpleLinkedList<Person> result = new SimpleLinkedList<Person>();
        llist.insertionSort(new ComparatorByName());
        
        for (int i = 0; i < llist.getSize(); i++)
        {
            if (!isThere(result, llist.get(i)))
            {
                result.add(llist.get(i));
            }
        }

        return result;
    }


    /**
     * calculates the trad engagement for march
     * 
     * @return sorted list of names by traditional engament
     *         for march
     */
    public SimpleLinkedList<Person> getMarch1() {
        SimpleLinkedList<Person> copy = getListForMonth("March");

        copy.insertionSort(new ComperatorTradEngage());

        return copy;

    }


    /**
     * calculates the reach engagement for march
     * 
     * @return sorted list of names by reach engament
     *         for march
     */
    public SimpleLinkedList<Person> getMarch2() {
        SimpleLinkedList<Person> copy = getListForMonth("March");

        copy.insertionSort(new ComparatorReachEngage());

        return copy;

    }


    /**
     * calculates the trad engagement for Feburary
     * 
     * @return sorted list of names by traditional engament
     *         for Feburary
     */
    public SimpleLinkedList<Person> getFeburary1() {
        SimpleLinkedList<Person> copy = getListForMonth("February");

        copy.insertionSort(new ComperatorTradEngage());

        return copy;

    }
 

    /**
     * calculates the trad engagement for Feburary
     * 
     * @return sorted list of names by traditional engament
     *         for Feburary
     */
    public SimpleLinkedList<Person> getFeburary2() {
        SimpleLinkedList<Person> copy = getListForMonth("February");

        copy.insertionSort(new ComparatorReachEngage());

        return copy;

    }


    /**
     * calculates the trad engagement for january
     * 
     * @return sorted list of names by traditional engament
     *         for January
     */
    public SimpleLinkedList<Person> getJanuary1() {
        SimpleLinkedList<Person> copy = getListForMonth("January");

        copy.insertionSort(new ComperatorTradEngage());


        return copy;

    }
 

    /**
     * calculates the trad engagement for january
     * 
     * @return sorted list of names by reach engament
     *         for January
     */
    public SimpleLinkedList<Person> getJanuary2() {
        SimpleLinkedList<Person> copy = getListForMonth("January");

        copy.insertionSort(new ComparatorReachEngage());

        return copy;

    }


    /**
     * calculates the sorted list by engagement
     * for specific months
     * 
     * @param month
     *          the month that the method returns pertains to
     * 
     * @return sorted list of names by traditional engament
     *         for a specific month
     */
    public SimpleLinkedList<Person> getListForMonth(String month) {
        // if month is January sort January, etc..
        if (month.equals("January")) {
            return indiMonth("January");
        }
        else if (month.equals("February")) {
            return indiMonth("February");
        }
        else
        {
            return indiMonth("March");
        }
    }


    /**
     * creates a linked list only containing
     * certain entries that are a specific month
     * 
     * @param month
     *            the month were looking for
     * @return list of all entries dealing w specific month
     */
    private SimpleLinkedList<Person> indiMonth(String month) {
        SimpleLinkedList<Person> newList = new SimpleLinkedList<Person>();
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).getMonth().equals(month)) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }


}
