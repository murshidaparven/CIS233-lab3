import javax.swing.*;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 * I have added a new command 'look'.
 * Added an new command 'drink'.
 * @author  Michael Kölling and David J. Barnes
 * @01/31/2024
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look", "drink"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }
    
     /*** Print all valid commands to System.out.*/
    public void getCommandList()
    {
        JFrame frame1 = new JFrame();
        // setting close operation
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 500);
        frame1.setLayout(null);
        String totalString = "";
        for(String command : validCommands) {
            totalString += command + ", ";
        }
        JTextField t1;
        t1 = new JTextField("Valid commands: "+totalString);
        t1.setBounds(25, 100, 300, 60);
        frame1.add(t1);
        frame1.setVisible(true);
        
    }
    /*** Print all valid commands to System.out.*/
    public void showAll()
    {
        for(String command : validCommands) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
    
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
