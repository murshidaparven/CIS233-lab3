import java.util.HashMap;
import java.util.Set;
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
    
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
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
       return "You are " + description + ".\n" + getExitString(); 
    }
}
