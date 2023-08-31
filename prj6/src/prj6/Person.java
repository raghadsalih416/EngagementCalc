//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package prj6;

/**
 * This class creates the Person objects
 * 
 * @author raghadsalih (906394954)
 * @version 2022.17.11
 */
public class Person {
    // ~ Fields ...............................................
    private String month;
    private String userName;
    private String channelName;
    private String country;
    private String mainTopic;
    private int likes;
    private int followers;
    private int posts;
    private int comments;
    private int views;
    private SimpleLinkedList<Person> list;

    /**
     * constructor - creates people objects
     * 
     * @param month
     *            month of entry
     * @param name
     *            username
     * @param chanName
     *            channel name
     * @param country
     *            country of entry
     * @param topic
     *            topic of persons content
     * @param likes
     *            likes of person
     * @param posts
     *            posts of person
     * @param followers
     *            followers of person
     * @param comments
     *            comments of person
     * @param views
     *            views of person
     */
    public Person(
        String month,
        String name,
        String chanName,
        String country,
        String topic,
        int likes,
        int posts,
        int followers,
        int comments,
        int views) {
        this.month = month;
        userName = name;
        channelName = chanName;
        this.country = country;
        mainTopic = topic;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
        list = new SimpleLinkedList<Person>();
    }


    /**
     * gets the posts of influencer
     * 
     * @return the posts
     */
    public int getPosts() {
        return posts;
    }


    /**
     * gets the followers of influencer
     * 
     * @return the followers
     */
    public int getFollowers() {
        return followers;
    }


    /**
     * gets the comments of influencer
     * 
     * @return the comments
     */
    public int getComments() {
        // month.getMonthForPerson();
        return comments;
    }


    /**
     * gets the views of influencer
     * 
     * @return the views
     */
    public int getViews() {
        return views;
    }


    /**
     * gets the likes of influencer
     * 
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }


    /**
     * gets the user name of influencer
     * 
     * @return the username
     */
    public String getUsername() {
        return userName;
    }


    /**
     * gets the country of influencer
     * 
     * @return the country
     */
    public String getCountry() {
        return country;
    }


    /**
     * gets the channel name of influencer
     * 
     * @return gets the channel name
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * gets the topic of influencer
     * 
     * @return the main topic
     */
    public String getMainTopic() {
        return mainTopic;
    }


    /**
     * gets the month of influencer
     * 
     * @return the month
     */
    public String getMonth() {
        return month;
    }


    /**
     * checks to see if current object and
     * param are equal
     * 
     * @param other
     *            the other object to be compared
     * 
     * @return true if equal, false if not
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return (getUsername().equals(((Person)other).getUsername())
            && getCountry().equals(((Person)other).getCountry())
            && getMainTopic().equals(((Person)other).getMainTopic())
            && getChannelName().equals(((Person)other).getChannelName())
            && getFollowers() == ((Person)other).getFollowers()
            && getPosts() == ((Person)other).getPosts()
            && getComments() == ((Person)other).getComments()
            && getViews() == ((Person)other).getViews());
    }


    /**
     * converts the queue to a string
     * 
     * @return a string made up of contents in queue
     */
    public String toString() {
        return getMonth() + ", " + getUsername() + ", " + getChannelName()
            + ", " + getCountry() + ", " + getMainTopic() + ", " + getLikes()
            + ", " + getPosts() + ", " + getFollowers() + ", " + getComments()
            + ", " + getViews();
    }


    /**
     * calculates traditional engagement
     * 
     * @param month
     *            month to get the engagement from
     * @param person
     *            person were looking for
     * @return traditional engagement
     */
    public double getTradEngagement(String month, Person person) {
        // Engagement Rate = ( Total Engagement / Total Followers ) x 100
        for (int i = 0; i < list.getSize(); i++) {
            // find person
            if (list.get(i).getUsername().equals(person.getUsername())) {
                // same person and month
                if (list.get(i).getMonth().equals(month)) {
                    int sums = list.get(i).getComments() + list.get(i)
                        .getLikes();
                    if (sums == 0) {
                        return 0.0;
                    }
                    double follow = list.get(i).getFollowers();
                    return ((sums / follow) * 100.0);
                }
            }
        }
        return 0.0;
    }


    /**
     * calculates traditional engagement
     * WITHOUT MONTH PARAMETER
     * 
     * @return traditional engagement
     */
    public double getTradEngagement() {
        // Engagement Rate = ( Total Engagement / Total Followers ) x 100
        int sums = getComments() + getLikes();
        double follow = getFollowers();
        return ((sums / follow) * 100.0);
    }


    /**
     * calculates reach engagement
     * 
     * @return reach engagement
     */
    public double getReachEngagement() {
        // reach engagement Rate = ( Total Engagement / reach ) x 100%

        int total = getComments() + getLikes();
        double reach = getViews();
        return ((total / reach) * 100.0);

    }
}
