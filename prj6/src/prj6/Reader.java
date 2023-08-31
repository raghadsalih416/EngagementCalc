// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- bhargav panchal (barry22)
package prj6;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Reader Class that takes in a file
 * and reads it
 * 
 * @author raghad silah (906394954)
 * @version 11.18.2022
 */
public class Reader {

    /**
     * Fields
     */
    private SimpleLinkedList<Person> list;
    // private Data[] data;

    /**
     * Default Constructor
     * 
     * @param fileName
     *            - name of the file
     * @throws FileNotFoundException
     *             - throws exception if file not found
     * @throws ParseException
     *             - throws exception for incorrect argument
     */
    public Reader(String fileName)
        throws FileNotFoundException,
        ParseException {
        list = readLinkedList(fileName);
        // data = readData(fileName);
        EngagementCalculator cal = new EngagementCalculator(list); 
        GUI window = new GUI(cal);
    }


    /**
     * Reads file and collects person information
     * 
     * @param fileName
     *            - name of the file
     * @return linked list of all person on file
     * @throws FileNotFoundException
     *             - throws exception if file not found
     * @throws ParseException
     *             - throws exception for incorrect argument
     */
    private SimpleLinkedList<Person> readLinkedList(String fileName)
        throws FileNotFoundException {
        SimpleLinkedList<Person> store = new SimpleLinkedList<Person>();
        Scanner file = new Scanner(new File(fileName));

        while (file.hasNextLine()) {
            String read = file.nextLine();
            Scanner line = new Scanner(read).useDelimiter(",\\s*");
            String[] tokens = new String[10];
            int tokenCount = 0;

            while (line.hasNext() && tokenCount < 10) {
                tokens[tokenCount++] = line.next();
            }
            line.close();
            // if theres 10 arguments and if their in 1st quarter
            if (tokenCount == 10 && validMonths(tokens[0])) {
                Person person = new Person(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], Integer.valueOf(tokens[5]), Integer
                        .valueOf(tokens[6]), Integer.valueOf(tokens[7]), Integer
                            .valueOf(tokens[8]), Integer.valueOf(tokens[9]));
                store.add(person);
            } 


        }
        file.close();
        System.out.println(store.toString());
        
        return store;
    }

    /**
     * check to see if the months were valid
     * 
     * @param str
     *            month name
     * @return true if its a valid month
     */
    public boolean validMonths(String str) {
        if (str.equals("January") || str.equals("Feburary") || str.equals(
            "March")) {
            return true;
        }
        return false;
    }

}
