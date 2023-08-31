/**
 * 
 */
package prj6;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * this is the main runner page of the project
 * 
 * @author raghadsalih (906394954)
 * @version 2022.03.12
 *
 */
public class Input {
    /**
     * this is the main runner page of the project
     * 
     * @param args
     *          if theres a str passed through its the file to look at
     */
    public static void main(String args[])
        throws FileNotFoundException,
        java.io.IOException, ParseException {
        
        if (args.length == 1) {
             Reader read = new Reader(args[0]);
        }
        else { 
             Reader read = new Reader("SampleInput1_2022.csv");
        }   
    }

}