import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Write a description of class Item here.
 *
 * @author (Murshida Parven)
 * @version (01/30/2024)
 */

public class Item
{
    private String description;
    private int weight;
    //private ArrayList<Item> items;
    
     public Item(String description, int weight)
    {
        // initialise instance variables
        this.description = description;
        this.weight = weight;
        //this.items = new ArrayList<Item>();

    }
   
     public String getShortDescription()
    {
        return description;
    }
    
    public int getweight()
    {
        return weight;
    }
    
    

    public String getLongDescription()
    {
        return "Item " + description + " Weight " + weight;
    }
    
    


    /*public ArrayList<Item> getItems()
    {
        return items;
    }*/
    

    public String getItemString()
    {
        String returnString = "";

        {
            returnString += " " + description;
        }
        return returnString;
    }

    
    
}

