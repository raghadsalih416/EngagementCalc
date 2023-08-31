/**
 * 
 */
package prj6;

/**
 * this class tests the engagement calculator class
 * 
 * @author raghadsalih (906394954)
 * @version 2022.03.12
 */
public class EngagementCalculatorTest extends student.TestCase {
    // ~ Fields ............................................................
    private EngagementCalculator calc;
    private EngagementCalculator calc2;
    private EngagementCalculator calc3;
    private SimpleLinkedList<Person> feb;
    private SimpleLinkedList<Person> people;
    private SimpleLinkedList<Person> jan;
    private SimpleLinkedList<Person> mar;
    private Person mac;
    private Person mac1;
    private Person mac2;
    private Person mac3;
    private Person mac4;
    private Person mac5;
    private Person mac6;
    private Person mac7;
    private Person mac8;
    private Person mac9;
    private Person mac10;
    private Person mac11;

    /**
     * creates objects to use in test
     */
    public EngagementCalculatorTest() {
        people = new SimpleLinkedList<Person>();
        mac = new Person("January", "actionDan", "wizardHighSchool", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        mac1 = new Person("February", "actionDan", "wizardHighSchool", "US",
            "education", 20260, 402, 94300, 3830, 608010);
        mac2 = new Person("March", "actionDan", "wizardHighSchool", "US",
            "education", 53357, 934, 120343, 6902, 802180);
        mac3 = new Person("January", "BigGiantCircles", "JustBeatz", "US",
            "music", 29171, 350, 75043, 27701, 340871);
        mac4 = new Person("February", "BigGiantCircles", "JustBeatz", "US",
            "music", 19075, 367, 78023, 15371, 454132);
        mac5 = new Person("March", "BigGiantCircles", "JustBeatz", "US",
            "music", 30112, 430, 93203, 38021, 416456);
        mac6 = new Person("January", "cryptozoologist", "australian_wildlife",
            " ", "nature", 15654, 702, 1234050, 156548, 6744523);
        mac7 = new Person("January", "mangledPixel", "ArtAllDay", "CA", "art",
            965094, 534, 8131230, 398583, 23267961);
        mac8 = new Person("February", "cryptozoologist", "australian_wildlife",
            " ", "nature", 25574, 809, 1456706, 262398, 7690402);
        mac9 = new Person("February", "mangledPixel", "ArtAllDay", "CA", "art",
            228260, 0, 8300936, 0, 0);
        mac10 = new Person("March", "cryptozoologist", "australian_wildlife",
            " ", "nature", 8552, 1203, 1705335, 120595, 2565870);
        mac11 = new Person("March", "mangledPixel", "ArtAllDay", "CA", "art",
            958214, 654, 7320935, 455632, 42587177);

        people.add(mac);
        people.add(mac1);
        people.add(mac2);
        people.add(mac3);
        people.add(mac4);
        people.add(mac5);
        people.add(mac6);
        people.add(mac7);
        people.add(mac8);
        people.add(mac9);
        people.add(mac10);
        people.add(mac11);

        calc2 = new EngagementCalculator(people);

        jan = new SimpleLinkedList<Person>();
        jan.add(mac);
        jan.add(mac3);
        jan.add(mac6);
        jan.add(mac7);

        

        feb = new SimpleLinkedList<Person>();
        feb.add(mac1);
        feb.add(mac4);
        feb.add(mac8);
        feb.add(mac9);
        calc = new EngagementCalculator(feb);

        mar = new SimpleLinkedList<Person>();
        mar.add(mac2);
        mar.add(mac5);
        mar.add(mac10);
        mar.add(mac11);

        calc3 = new EngagementCalculator(mar);
    }


    /**
     * tests all methods pertaining to January
     */
    public void testCalc() {
        assertEquals(jan, calc2.getListForMonth("January"));
        System.out.println(jan.toString());

        SimpleLinkedList<Person> jan2 = new SimpleLinkedList<Person>();
        jan2.add(mac6);
        jan2.add(mac7);
        jan2.add(mac);
        jan2.add(mac3);

        assertEquals(jan2, calc2.getJanuary1());
        assertEquals(jan2, calc2.getJanuary2());
    }

    /**
     * tests all methods pertaining to Feburary
     */
    public void testCalc2() {
        assertEquals(feb, calc.getListForMonth("February"));
        SimpleLinkedList<Person> feb2 = new SimpleLinkedList<Person>();

        feb2.add(mac9);
        feb2.add(mac8);
        feb2.add(mac1);
        feb2.add(mac4);

        assertEquals(feb2, calc.getFeburary1());

        SimpleLinkedList<Person> feb3 = new SimpleLinkedList<Person>();

        feb3.add(mac8);
        feb3.add(mac1);
        feb3.add(mac4);
        feb3.add(mac9);

        assertEquals(feb3, calc.getFeburary2());

    }

    /**
     * tests all methods pertaining to March
     */
    public void testCalc3() {

        SimpleLinkedList<Person> mar2 = new SimpleLinkedList<Person>();

        mar2.add(mac10);
        mar2.add(mac11);
        mar2.add(mac2);
        mar2.add(mac5);

        assertEquals(mar2, calc3.getMarch1());
        SimpleLinkedList<Person> mar3 = new SimpleLinkedList<Person>();

        mar3.add(mac11);
        mar3.add(mac10);
        mar3.add(mac2);
        mar3.add(mac5);
        assertEquals(mar3, calc3.getMarch2());
    }


    public void testCalc4() {
        SimpleLinkedList<Person> match = new SimpleLinkedList<Person>();

        match.add(mac);
        match.add(mac1);
        match.add(mac2);
        match.add(mac3);
        match.add(mac4);
        match.add(mac5);
        match.add(mac6);
        match.add(mac8);
        match.add(mac10);
        match.add(mac7);
        match.add(mac9);
        match.add(mac11);
 
        assertEquals(match, calc2.sortByNameAll(match));

        SimpleLinkedList<Person> match2 = new SimpleLinkedList<Person>();

        match2.add(mac7);
        match2.add(mac6);
        match2.add(mac3);
        match2.add(mac);

        assertEquals(match2, calc2.sortByName4(match));

    }

}
