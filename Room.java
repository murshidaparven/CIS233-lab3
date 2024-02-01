import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * I have created a new getLongFunction to return the derections.
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    public String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    
    public String getExitString()
    {
       String returnString = "Exit: ";
       Set<String> keys = exits.keySet();
       for(String exit : keys){
           returnString += " " + exit; 
        }
        
       return returnString;
       
    }
    
    
    
    /*** Define an exit from this room.* @param direction The direction of the exit.
       * @param neighbor The room in the given direction.
        */
      
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    
    
    
    /**
     * Defineing the exit direction
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /** * Return a long description of this room, of the form: 
    *     You are in the gym. 
    *     Exits: north west * @return A description of the room, including exits. 
    */ 
   public String getLongDescription() 
   {  
       //return "You are " + description + ".\n" + getExitString(); 
       String result = "You are " + description + ".\n" + getExitString(); 
       //+ "Items in Room " + getItemString();
       
       if (!items.isEmpty()){
           result += " items: ";
           for (Item i : items){
                // Printing the elements of ArrayList
                result += i.getItemString() + " ";
            }
        }
       return result;
    }
    /**
     * add an item to the room when it is created
     */
    public void addItem(Item item)
    {
        items.add (item);
    }
}
