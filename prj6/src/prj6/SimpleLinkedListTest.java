//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package prj6;

import student.TestCase;

/**
 * This class tests methods in the
 * simple linked list class
 * 
 * @author raghadsalih
 * @version 2022.18.11
 */
public class SimpleLinkedListTest extends TestCase {
    // ~ Fields ...............................................
    private SimpleLinkedList<String> list1;
    private SimpleLinkedList<String> list2;
    private SimpleLinkedList<String> listEmpty;
    

    /**
     * creates new list objects
     */
    public SimpleLinkedListTest() {
        list1 = new SimpleLinkedList<String>();
        list2 = new SimpleLinkedList<String>();
        listEmpty = new SimpleLinkedList<String>();
    }


    /**
     * tests the clear methods
     */
    public void testClear() {
        list1.add("hello");
        list1.add("pop");
        list1.add("hello");
        list1.clear();
        assertEquals(0, list1.getSize());
        listEmpty.clear();
        assertEquals(0, listEmpty.getSize());
    }
    
    /**
     * tests the switch obj methods
     */
    public void testSwitchObj() {
       Person mac = new Person("January", "actionDan", "wizardHighSchool", "US",
            "education", 53882, 431, 95800, 4129, 442422);
       Person mac1 = new Person("February", "actionDan", "wizardHighSchool", "US",
            "education", 20260, 402, 94300, 3830, 608010);
       Person mac2 = new Person("March", "actionDan", "wizardHighSchool", "US",
            "education", 53357, 934, 120343, 6902, 802180);
       Person mac3 = new Person("April", "actionDan", "wizardHighSchool", "US",
            "education", 45321, 1021, 123546, 7604, 3212343);
        SimpleLinkedList<Person> people = new SimpleLinkedList<Person>();
        people.add(mac);
        people.add(mac1);
        people.add(mac2);
        people.add(mac3);
        System.out.println(people.toString());
       // people.switchObj(mac, mac3);
        System.out.println(people.toString());
    }


    /**
     * tests the clear methods
     */
    public void testEquals() {
        list1.add("hello");
        list1.add("pop");
        list1.add("hello");

        list2.add("hello");
        list2.add("pop");

        assertFalse(list1.equals(list2));
        list2.add("hello");
        assertTrue(list1.equals(list2));
        Object obj = new Object();
        assertFalse(list1.equals(obj));
        assertFalse(list1.equals(null));
        assertTrue(list1.equals(list1));
    }


    /**
     * tests the get method
     * out of bounds
     */
    public void testGet() {
        Exception exception = null;
        try {
            listEmpty.get(1);
            fail("listEmpty.get(1) is not throwing "
                + "an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("listEmpty.get(1) is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

    }


    /**
     * tests the contain method
     */
    public void testContains() {
        list1.add("hel");
        list1.add("pop");
        list1.add("hello");

        assertFalse(list1.contains("poof"));
        assertTrue(list1.contains("pop"));
        // list1.remove(2);
        list1.remove(0);
        assertFalse(list1.contains("hel"));
    }


    /**
     * tests the clear methods
     */
    public void testLastIndexOf() {
        list1.add("hello");
        list1.add("pop");
        list1.add("hello");

        assertEquals(-1, list1.lastIndexOf("poof"));
        assertEquals(1, list1.lastIndexOf("pop"));

        list1.add("hello");
        assertEquals(3, list1.lastIndexOf("hello"));
    }


    /**
     * tests the add methods
     */
    public void testAdd5() {
        list1.add("hey");
        list1.add("hi");
        list1.add("poof");
        list1.add("bye");
        assertEquals(4, list1.getSize());
    }




    /**
     * tests the add method when
     * other list is out of bounds
     * and size
     */
    public void testAddBounds() {
        list1.add("hi");
        list1.add("bye");
        list1.add("pop");

        assertEquals(3, list1.getSize());

    }


    /**
     * tests the add method
     */
    public void testAdd() {
        Exception exception = null;
        try {
            list1.add(null);
            fail("list1.add(null) is not throwing an "
                + "exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(
            "list1.add(10, wrong) is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    public void testEquals3() {
        SimpleLinkedList<String> arr = new SimpleLinkedList<String>();
        arr.add("hop");
        list1.add("hop");
        arr.add("fold");
        list1.add("fold");
        arr.add("cap");
        list1.add("hop");
        assertFalse(list1.equals(arr));
    }


    /**
     * tests the remove method
     */
    public void testRemove() {
        list1.add("hey");
        list1.add("hi");
        list1.add("bey");
        list1.add("fey");
        list1.remove(2);
        assertEquals(3, list1.getSize());
        list1.remove(1);
        assertEquals(2, list1.getSize());
        assertEquals("{hey, fey}", list1.toString());
    }


    /**
     * tests the remove method when out
     * CHECK THIS TEST
     * of bounds
     */
    public void testRemoveInvalid() {
        list1.add("hello");
        list1.add("pop");
        assertEquals(2, list1.getSize());
        Exception exception = null;
        try {
            list1.remove(10);
            fail("list1.add(nullString) is not throwing "
                + "an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(
            "list1.add(nullString) is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

    }


    /**
     * tests the remove method when out
     * of bounds
     */
    public void testRemoveInvalid2() {
        list1.add("hello");
        list1.add("pop");
        assertEquals(2, list1.getSize());
        Exception exception = null;
        try {
            list1.remove(-5);
            fail("list1.remove(-5) is not throwing"
                + " an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("list1.remove(-5) is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

    }


    /**
     * tests the remove method when empty
     */
    public void testRemoveInvalid3() {
        Exception exception = null;
        try {
            listEmpty.remove(1);
            fail("listEmpty.remove(1) is not throwing "
                + "an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(
            "listEmpty.remove(1) is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

    }


    /**
     * tests the remove method
     * when trying to remove the head
     */
    public void testRemoveHead() {
        list1.add("hello");
        list1.add("pop");
        list1.removeSpecific("hello");
        assertEquals("{pop}", list1.toString());
    }


    /**
     * tests the remove method
     * when trying to remove the head
     */
    public void testRemoveReal() {
        list1.add("hello");
        list1.add("pop");
        list1.add("you");
        list1.removeSpecific("pop");
        assertEquals("{hello, you}", list1.toString());
        assertEquals("you", list1.get(1));
    } 


    /**
     * tests the add methods
     */
    public void testRemove3() {
        list1.add("hey");
        list1.add("hi");
        list1.add("poof");
        list1.add("bye");
        list1.removeSpecific("hi");
        assertEquals(3, list1.getSize());
        list1.removeSpecific("doo");
        assertEquals(3, list1.getSize());
        // list1.add(null);
        list1.removeSpecific("hi");
        assertEquals(3, list1.getSize());
        list1.removeSpecific("hey");
        assertEquals(2, list1.getSize());
        // listEmpty.remove("hey");
        assertFalse(listEmpty.removeSpecific("hey"));
    }

}
