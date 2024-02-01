
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *  I have created new rooms, upadate the game and change the exits.
 *  Impleamented a new function printLocationInfo.
 *  I have implemented the direction of the exits.
 *  I have implemented the getLongDerection function.
 *  added a look command in the game.
 *  Added a new command in the game.
 *  Print all comand words.
 *  If press help button it will show a text field in a window.
 *  
 * @author Murshida Parven and Michael Kölling and David J. Barnes
 * @version 01/30/2024
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Item item;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * I have created new rooms, upadate the game and change the exits.
     */
    private void createRooms()
    {
        Room gym, indoorGame, library, cafeteria, music, foodCorner;
      
        // create the rooms
        gym = new Room("In the gym, at the east : Indoor game");
        indoorGame = new Room("in the indoor game room,at the east: library,west: gym");
        library = new Room("in the library room,at the west: indoor game,south:cafe");
        cafeteria = new Room("in the campus cafeteria,at the north:library, south: music");
        music = new Room("in the music room,at the north:cafeteria, east: foodCorner ");
        foodCorner = new Room("in the food corner,at the west :music");
        
        // initialise room exits
        gym.setExit("east" , indoorGame );
        Item i0 = new Item("gym1",25);
        gym.addItem(i0);
        indoorGame.setExit("east", library);
        indoorGame.setExit("west", gym);
        Item i1 = new Item("indGame1",50);
        Item i2 = new Item("indGame2",10);
        indoorGame.addItem(i1);
        indoorGame.addItem(i2);
        library.setExit("west",  indoorGame);
        library.setExit("south",  cafeteria);
        cafeteria.setExit("south", music);
        cafeteria.setExit("north", library);
        music.setExit("north",cafeteria);
        music.setExit("east",foodCorner);
        foodCorner.setExit("east", music);
        currentRoom = gym;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     * Impleamenting a new function printLocationInfo.
     * Print all comand words
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type'go :east or west or south or north ' command to exit ");
        System.out.println("Your command words are:");
        System.out.println("go , help, quit, look, drink");
        System.out.println("first 'look' command for current location");
        System.out.println();
        //System.out.println(currentRoom.getLongDescription());
        
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if(commandWord.equals("look")) {
            look();
        }
        else if(commandWord.equals("drink")) {
            drink();
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        parser.showCommands();
        System.out.println();

        
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     * Impleamenting a new function printLocationInfo.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        
        Room nextRoom = currentRoom.getExit(direction);
        
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            
        currentRoom = nextRoom;
        }
        
    
        printLocationInfo();
        
            
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()){
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    private void look(){
        System.out.println(currentRoom.getLongDescription());
    }
    private void drink(){
        System.out.println(currentRoom.getLongDescription());
        System.out.println("You are not tharsty any more.");
    }
    /*
     * creating a new function printLocationInfo.
     * implemented the getLongDerection function.
     */
    private void printLocationInfo()
    {
        /*
        System.out.println("You are " + currentRoom.getDescription());
        System.out.println(currentRoom.getExitString());*/
        
        System.out.println(currentRoom.getLongDescription());        
        System.out.println();
    }
    
}