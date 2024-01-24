import java.util.HashMap;
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
 * 
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

}
