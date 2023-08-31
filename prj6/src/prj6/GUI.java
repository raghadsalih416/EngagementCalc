/**
 * 
 */
package prj6;

import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;


/**
 * This class displays all of the 
 * social media visuals
 * 
 * @author raghadsalih (906394954)
 * @version 2022.03.12
 */
public class GUI {
    // ~ Fields ............................................................
    private Window window;
    private EngagementCalculator calc;
    private Button sortByChannelName;
    private Button sortByEngageRate;
    private Button jan;
    private Button feb;
    private Button march;
    private Button firstQ;
    private Button tradEngaeRate;
    private Button reachEngageRate;
    private Button quit;
    private SimpleLinkedList<Person> list;
    private String timePeriod;
    private String sortView;
    private String formula;
    private String sortViewLabel;
    private String periodLabel;
    private String formulaLabel;
    private TextShape firstEngage;
    private TextShape secondEngage;
    private TextShape thirdEngage;
    private TextShape fourthEngage;
    private TextShape firstName;
    private TextShape secondName;
    private TextShape thirdName;
    private TextShape fourthName;
    private Shape firstBar;
    private Shape secondBar;
    private Shape thirdBar;
    private Shape fourthBar;

    /**
     * Creates a graphical user interface to display
     * social media visuals
     * 
     * @param calc
     *            calculator that gets and calculates data
     */
    public GUI(EngagementCalculator calc) {
        // variable to keep track of combonations
        timePeriod = "";
        sortView = "";
        formula = "";
        // top right labels
        sortViewLabel = "Sort view: ";
        periodLabel = "Time Period: ";
        formulaLabel = "Formula: ";

        this.calc = calc;
        list = calc.getList();
        window = new Window();
        window.setSize(800, 600);
        window.setTitle("Social Media Visuals");

        // Initialize buttons
        sortByChannelName = new Button("Sort by Channel Name");
        sortByChannelName.onClick(this, "clickedSortByName");

        sortByEngageRate = new Button("Sort By Engagement Rate");
        sortByEngageRate.onClick(this, "clickedSortByEngagement");

        jan = new Button("January");
        jan.onClick(this, "clickedJan");

        feb = new Button("February");
        feb.onClick(this, "clickedFeb");

        march = new Button("March");
        march.onClick(this, "clickedMar");

        firstQ = new Button("FirstQuarter (Jan - March)");

        tradEngaeRate = new Button("Traditional Engagement Rate");
        tradEngaeRate.onClick(this, "clickedTrad");

        reachEngageRate = new Button("Reach Engagement Rate");
        reachEngageRate.onClick(this, "clickedReach");


        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        window.addButton(sortByChannelName, WindowSide.NORTH);
        window.addButton(sortByEngageRate, WindowSide.NORTH);
        window.addButton(jan, WindowSide.SOUTH);
        window.addButton(feb, WindowSide.SOUTH);
        window.addButton(march, WindowSide.SOUTH);
        window.addButton(firstQ, WindowSide.SOUTH);
        window.addButton(tradEngaeRate, WindowSide.WEST);
        window.addButton(reachEngageRate, WindowSide.WEST);
        window.addButton(quit, WindowSide.NORTH);
    }

    /**
     * shows the names sorted by their names
     * 
     * @param button
     *            button thats pressed
     */
    public void clickedSortByName(Button button) {
        sortView = "Channel Name";
        getter(sortView, timePeriod, formula);
    }


    /**
     * helper method that formates the engagement rates
     * when the list is there.
     * 
     * @param llist
     *            sorted list
     * @param str
     *            1 if trad rate, 2 if reach and sorted by name 
     *            3, if trad rate, 4 if reach and sorted by engagement
     */
    private void formatNums(SimpleLinkedList<Person> llist, String str) {
        DecimalFormat form = new DecimalFormat("#.#");
        if (str.equals("1")) { // 35 415
            firstEngage = new TextShape(35, 415, form.format(llist.get(3)
                .getTradEngagement()));
            secondEngage = new TextShape(115, 415, form.format(llist.get(2)
                .getTradEngagement()));
            thirdEngage = new TextShape(255, 415, form.format(llist.get(1)
                .getTradEngagement()));
            fourthEngage = new TextShape(340, 415, form.format(llist.get(0)
                .getTradEngagement()));
        }
        else if (str.equals("2")) {
            firstEngage = new TextShape(35, 415, form.format(llist.get(0)
                .getReachEngagement()));
            secondEngage = new TextShape(115, 415, form.format(llist.get(1)
                .getReachEngagement()));
            thirdEngage = new TextShape(255, 415, form.format(llist.get(2)
                .getReachEngagement()));
            fourthEngage = new TextShape(340, 415, form.format(llist.get(3)
                .getReachEngagement()));
        }        
    }

    /**
     * This method is used when the button
     * sort by engage is pushed.
     * 
     * @param button
     *          button that is pressed
     */
    public void clickedSortByEngagement(Button button) {
        //update();
        sortView = "Engagement Rate";
        getter(sortView, timePeriod, formula);      
    }
    


    public void clickedJan(Button button) {
        timePeriod = "January";
        getter(sortView, timePeriod, formula);
    }

    /**
     * This method is used when the button
     * Feburary is pushed.
     * 
     * @param button
     *          button that is pressed
     */
    public void clickedFeb(Button button) {
        timePeriod = "Feburary";
        getter(sortView, timePeriod, formula);        
    }

    /**
     * This method is used when the button
     * March is pushed.
     * 
     * @param button
     *          button that is pressed
     */
    public void clickedMar(Button button) {
        timePeriod = "March";
        getter(sortView, timePeriod, formula);      
    }

    
    /**
     * This method does all of the work
     * to put the combinations together
     * 
     * @param sortMethod
     *          sortMethod that is used
     * @param months
     *          month of the button thats pressed
     * @param rateType
     *          the type of equation that will be used                
     */
    public void getter(String sortMethod, String months, String rateType)
    {
        sortMethod = sortView;
        months = timePeriod;
        rateType = formula;
        SimpleLinkedList<Person> llist = new SimpleLinkedList<Person>();
        // LABELS
        update();
        TextShape text1 = new TextShape(10, 10, periodLabel + timePeriod);
        window.addShape(text1);
        TextShape text2 = new TextShape(10, 30, sortViewLabel + sortView);
        window.addShape(text2);
        TextShape text3 = new TextShape(10, 50, formulaLabel + formula);
        window.addShape(text3);

        if (months.equals("January"))
        {
            if (sortView.equals("Channel Name"))
            {
                llist = calc.sortByName4(calc.getListForMonth("January"));
                 firstName = new TextShape(35, 400, llist.get(0)
                    .getChannelName());
                secondName = new TextShape(145, 400, llist.get(1)
                    .getChannelName());
                thirdName = new TextShape(290, 400, llist.get(2)
                    .getChannelName());
                fourthName = new TextShape(360, 400, llist.get(3)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName);
                window.addShape(fourthName);
                barsHeight();
                reset();
                
            }
            else if (sortView.equals("Engagement Rate"))
            {
                // list = list of only jan entries sorted in engagement order
                llist = calc.getJanuary1();
                firstName = new TextShape(35, 400, llist.get(3)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(2)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(1)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(0)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName);
                window.addShape(fourthName);
                formatNums(llist, "1");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();
                reset();
               
            }   
            
            if (formula.equals("Reach Rate"))
            {
                update();
                //reset
                llist = calc.getJanuary2();
                firstName = new TextShape(35, 400, llist.get(3)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(2)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(1)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(0)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName); 
                window.addShape(thirdName);
                window.addShape(fourthName);
                formatNums(llist, "2");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();
            }
            else if (formula.equals("Trad Rate"))
            {
                llist = calc.getJanuary1();
                firstName = new TextShape(35, 400, llist.get(3)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(2)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(1)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(0)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName);
                window.addShape(fourthName);
                formatNums(llist, "1");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();

                reset();
            }
                  
               
        }
        if (months.equals("Feburary")) 
        {
            if (sortView.equals("Channel Name"))
            {
                llist = calc.sortByName4(calc.getListForMonth("Feburary"));
                 firstName = new TextShape(35, 400, llist.get(0)
                    .getChannelName());
                secondName = new TextShape(145, 400, llist.get(1)
                    .getChannelName());
                thirdName = new TextShape(290, 400, llist.get(2)
                    .getChannelName());
                fourthName = new TextShape(360, 400, llist.get(3)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName);
                window.addShape(fourthName);
                barsHeight();
                reset();
            }
            else if (sortView.equals("Engagement Rate"))                
            {
                System.out.println(llist); 
                llist = calc.getFeburary1();
                
                firstName = new TextShape(35, 400, llist.get(1)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(1)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(2)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(3)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName);
                window.addShape(fourthName);
                formatNums(llist, "1");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();

                reset();
            }      
            
            if (formula.equals("Trad Rate"))
            {
                llist = calc.getFeburary1();
                firstName = new TextShape(35, 400, llist.get(0)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(1)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(2)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(3)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName);
                window.addShape(fourthName);
                formatNums(llist, "1");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();

                reset();
            }
            else if (formula.equals("Reach Rate"))
            {
                update();
                list = calc.getFeburary2();

                firstName = new TextShape(35, 400, llist.get(0)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(1)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(2)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(3)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName); 
                window.addShape(fourthName);
                formatNums(list, "2");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();

            }
        }
        if (months.equals("March"))
        {
            if (sortView.equals("Channel Name"))
            {
                llist = calc.sortByName4(calc.getListForMonth("March"));
                firstName = new TextShape(35, 400, llist.get(0)
                   .getChannelName());
               secondName = new TextShape(145, 400, llist.get(1)
                   .getChannelName());
               thirdName = new TextShape(290, 400, llist.get(2)
                   .getChannelName());
               fourthName = new TextShape(360, 400, llist.get(3)
                   .getChannelName());
               window.addShape(firstName);
               window.addShape(secondName);
               window.addShape(thirdName);
               window.addShape(fourthName);
               barsHeight();
               reset();
            }
            else if (sortView.equals("Engagement Rate"))
            {
                llist = calc.getMarch1();
                firstName = new TextShape(35, 400, llist.get(3)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(2)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(1)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(0)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName);
                window.addShape(fourthName);
                formatNums(llist, "1");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();
                reset();
            }
            
            if (formula.equals("Trad Rate"))
            {
                llist = calc.getMarch1();
                firstName = new TextShape(35, 400, llist.get(3)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(2)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(1)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(0)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName);
                window.addShape(thirdName);
                window.addShape(fourthName);
                formatNums(llist, "1");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();

                reset();
            }
            else if (formula.equals("Reach Rate"))
            {
                update();
                //reset
                llist = calc.getMarch2();
                firstName = new TextShape(35, 400, llist.get(0)
                    .getChannelName());
                secondName = new TextShape(115, 400, llist.get(1)
                    .getChannelName());
                thirdName = new TextShape(260, 400, llist.get(2)
                    .getChannelName());
                fourthName = new TextShape(340, 400, llist.get(3)
                    .getChannelName());
                window.addShape(firstName);
                window.addShape(secondName); 
                window.addShape(thirdName);
                window.addShape(fourthName);
                formatNums(llist, "2");
                window.addShape(firstEngage);
                window.addShape(secondEngage);
                window.addShape(thirdEngage);
                window.addShape(fourthEngage);
                barsHeight();
            }
        }
       
    }
 
    /**
     * This method is used when the button
     * trad Engagement rate is pushed.
     * 
     * @param button
     *          button that is pressed
     */
    public void clickedTrad(Button button) {
        formula = "Trad Rate";     
        getter(sortView, timePeriod, formula);
       

    }
    
    /**
     * This method is used to format
     * the bars height
     * 
     */
    private void barsHeight()
    {
        int x = 150;
        int y; 
        firstBar = new Shape(30, 250, 50, x, Color.blue);
        secondBar = new Shape (160, 250 + 10, 50, x - 10, Color.cyan);
        thirdBar = new Shape(295, 250 + 20, 50, x - 20, Color.red);
        fourthBar = new Shape(375, 250 + 30, 50, x - 30, Color.green);
        
        window.addShape(firstBar);
        window.addShape(secondBar);
        window.addShape(thirdBar);
        window.addShape(fourthBar);
    }
    
    /**
     * This method is used when the window
     * is being reset
     * 
     */
    private void reset()
    {
        firstName = new TextShape(35, 400, "");
        secondName = new TextShape(145, 400, "");
        thirdName = new TextShape(290, 400, "");
        fourthName = new TextShape(360, 400, "");
        
        firstEngage = new TextShape(35, 415, "");
        secondEngage = new TextShape(115, 415, "");
        thirdEngage = new TextShape(255, 415, "");
        fourthEngage = new TextShape(340, 415, "");

        window.addShape(firstName);
        window.addShape(secondName);
        window.addShape(thirdName);
        window.addShape(fourthName);
        window.addShape(firstEngage);       
        window.addShape(firstEngage);
        window.addShape(firstEngage);        
        window.addShape(firstEngage);
    }

    /**
     * This method is used when the button
     * trad Engagement rate is pushed.
     * 
     * @param button
     *          button that is pressed
     */
    public void clickedReach(Button button) {
        formula = "Reach Rate";
        getter(sortView, timePeriod, formula);
    }
    
    /**
     * quits program
     * 
     * @param button
     *            when clicked system exits
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Update everything. Wipes the screen and resets.
     */
    private void update() {
        window.removeAllShapes();
    }
    
   
}
