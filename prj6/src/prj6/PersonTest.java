/**
 * 
 */
package prj6;

/**
 * this class tests methods in the person class
 * 
 * @author raghadsalih (906394954)
 * @version 2022.03.12
 *
 */
public class PersonTest extends student.TestCase {
    // ~ Fields
    private Person mac;
    private Person mac1;
    private Person mac2;
    private Person mac3;
    private SimpleLinkedList<Person> list;

    /**
     * creates objects to test
     */
    public PersonTest() {
        mac = new Person("January", "actionDan", "wizardHighSchool", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        mac1 = new Person("February", "actionDan", "wizardHighSchool", "US",
            "education", 20260, 402, 94300, 3830, 608010);
        mac2 = new Person("March", "actionDan", "wizardHighSchool", "US",
            "education", 53357, 934, 120343, 6902, 802180);
        mac3 = new Person("April", "actionDan", "wizardHighSchool", "US",
            "education", 45321, 1021, 123546, 7604, 3212343);
        list = new SimpleLinkedList<Person>();
        list.add(mac);
        list.add(mac1);
        list.add(mac2);
        list.add(mac3);
        
    }

    /**
     * tests the get methods
     */
    public void testGetMethods() {
        assertEquals("wizardHighSchool", mac.getChannelName());
        assertEquals("actionDan", mac.getUsername());
        assertEquals("US", mac.getCountry());
        assertEquals("education", mac.getMainTopic());
        assertEquals("January", mac.getMonth());
        assertEquals(53882, mac.getLikes());
        assertEquals(431, mac.getPosts());
        assertEquals(95800, mac.getFollowers());
        assertEquals(4129, mac.getComments());
        assertEquals(442422, mac.getViews());
       assertEquals(13.1, mac.getReachEngagement(), .1);
       assertEquals(60.5, mac.getTradEngagement(), .1);
       assertEquals(0.0, mac.getTradEngagement("March", mac), .1);
       assertEquals(0.0, mac.getTradEngagement("January", mac), .1);
       assertEquals("January, actionDan, wizardHighSchool, US, education, 53882, 431, 95800, 4129, 442422", mac.toString());
 
    }

}
