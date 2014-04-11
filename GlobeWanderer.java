/**
 * GlobeWanderer.java
 * Gregory Fox
 *
 */

import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class GlobeWanderer {

    //Globals

    public static localeClass[] locations;
    public static globeWandererItems[] itemsArray;
    public static int[][] localeMatrix;
    public static int currentLocale = 0;
    public static String currentLocaleList;
    public static boolean stillPlaying = true;
    public static String input;
    public static int direction;
    public static float score = 0;
    public static float moves = 1;
    public static String[] inventory;
    public static int idNum = 4;
    public static int id = 4;
    public static double money = 0;
    public static boolean isFound;


    public static void main(String[] args) {

        System.out.println("Welcome to Globe Wanderer. You mission is about to begin.");
        run();

        display();


        while (stillPlaying) {

            getCommand();
            move();

        }
    }

    //This makes the 6 items in the game and the map
    private static void run() {

        globeWandererItems item2 = new globeWandererItems(2);
        item2.setItemName("Ice Pickaxe");
        item2.setLocale(2);

        globeWandererItems item3 = new globeWandererItems(3);
        item3.setItemName("Throwing Knife");
        item3.setLocale(4);

        globeWandererItems item4 = new globeWandererItems(4);
        item4.setItemName("Poison Dart");
        item4.setLocale(6);

        globeWandererItems item5 = new globeWandererItems(5);
        item5.setItemName("Silenced PPK Pistol");
        item5.setLocale(8);

        globeWandererItems item0 = new globeWandererItems(0);
        item0.setItemName("Secret Agent Handbook");

        globeWandererItems item1 = new globeWandererItems(1);
        item1.setItemName("Dapper Suit");


        localeClass loc0 = new localeClass(0);
        loc0.setName("North America");
        loc0.setItem("map");
        loc0.setHasVisited(true);

        localeClass loc1 = new localeClass(1);
        loc1.setName("South America");

        localeClass loc2 = new localeClass(2);
        loc2.setName("Arctic Circle");
        loc2.setItem(item2.getItemName());

        localeClass loc3 = new localeClass(3);
        loc3.setName("Magick Shoppe");

        localeClass loc4 = new localeClass(4);
        loc4.setName("Asia");
        loc4.setItem(item3.getItemName());

        localeClass loc5 = new localeClass(5);
        loc5.setName("Magick Shoppe");

        localeClass loc6 = new localeClass(6);
        loc6.setName("Africa");
        loc6.setItem(item4.getItemName());

        localeClass loc7 = new localeClass(7);
        loc7.setName("Australia");

        localeClass loc8 = new localeClass(8);
        loc8.setName("Russia");
        loc8.setItem(item5.getItemName());

        localeClass loc9 = new localeClass(9);
        loc9.setName("You died");


        locations = new localeClass[10];
/*North America*/
        locations[0] = loc0;
/*South America*/
        locations[1] = loc1;
/*Arctic Circle*/
        locations[2] = loc2;
/*Magick Shoppe*/
        locations[3] = loc3;
/*Asia*/
        locations[4] = loc4;
/*Scandinavia*/
        locations[5] = loc5;
/*Africa*/
        locations[6] = loc6;
/*Australia*/
        locations[7] = loc7;
/*Russia*/
        locations[8] = loc8;
/*Ocean*/
        locations[9] = loc9;


// Inventory for items

        inventory = new String[6];
        inventory[2] = null;  //Ice pickaxe
        inventory[3] = null;  //Throwing knife
        inventory[4] = null;  //Poison dart
        inventory[5] = null;  //Silenced PPK pistol
        inventory[0] = null;  //Secret Agent Handbook
        inventory[1] = null;  //Dapper Suit

        // directional matrix
        localeMatrix = new int[][]{
                //N  S  E  W
/*North America*/{2, 1, 3, 4},
/*South America*/{0, 9, 6, 7},
/*Arctic Circle*/{9, 0, 5, 8},
/*Magick Shoppe*/{5, 6, 9, 0},
/*Asia*/         {8, 7, 0, 9},
/*Scandinavia*/  {9, 3, 9, 2},
/*Africa*/       {3, 9, 9, 1},
/*Australia*/    {5, 9, 2, 9},
/*Russia*/       {9, 4, 2, 9}
        };

    }

    //Gives current game status

    private static void display() {
        System.out.println(locations[currentLocale].getName());
        System.out.println(" Your score is: " + score + ". Your move count is " + moves + ". Your level of skill is " + score / moves + ". " + "The item in this location is " + locations[currentLocale].getItem() + ". Your money is " + money + ". The cash in this location is " + locations[currentLocale].getCash() + "." );
        
        nextMove();
    }

    //Allows players to pick up items into their inventory

    private static void pickUpItem() {
        if (locations[currentLocale].getItem() != null) {
            inventory[locations[currentLocale].getId()] = locations[currentLocale].getItem();
            System.out.println("You picked up an item!");
        } else {
            System.out.println("There is nothing to pick up.");
        }
        
        money = money + locations[currentLocale].getCash();
        if(locations[currentLocale].getCash() == 0){
        	System.out.println("There is no cash here");
        }
        locations[currentLocale].setCash(0);
    }

    //Ends the game

    private static void quitGame() {
        stillPlaying = false;

    }


    private static void nextMove() {
        if (localeMatrix[currentLocale][0] != 9) {
            System.out.println("You can move North, South, East, or West");
        }
        if (localeMatrix[currentLocale][1] != 9) {
            System.out.println("You can move North, East, or West");
        }
        if (localeMatrix[currentLocale][2] != 9) {
            System.out.println("You can move South, East, or West");
        }
        if (localeMatrix[currentLocale][3] != 9) {
            System.out.println("You can move South, North, or West");
        }

    }



    private static void getCommand() {

        Scanner inputReader = new Scanner(System.in);
/*Global*/
        input = inputReader.nextLine();
    }

    private static void move() {
    	
    	localeListMan localeList = new localeListMan();
    	
    	localeClass locale0 = new localeClass(0);
    	locale0.setName("North America");
		localeList.add(locale0);
		
        localeClass locale1 = new locationClass(0);
        locale1.setName("South America");
        locationList.add(locale1);

        localeClass locale2 = new localeClass(0);
        locale2.setName("Arctic Circle");
        locationList.add(locale2);

        localeClass locale3 = new localeClass(0);
        locale3.setName("Magick Shoppe");
        locationList.add(locale3);

        localeClass locale4 = new localeClass(0);
        locale4.setName("Asia");
        locationList.add(locale4);

        localeClass locale5 = new localeClass(0);
        locale5.setName("Scandinavia");
        locationList.add(locale5);

        localeClass locale6 = new localeClass(0);
        locale6.setName("Africa");
        locationList.add(locale6);

        localeClass locale7 = new localeClass(0);
        locale7.setName("Australia");
        localeList.add(locale7);

        localeClass locale8 = new localeClass(0);
        locale8.setName("Russia");
        localeList.add(locale8);
        
        localeClass locale9 = new localeClass(0);
        locale9.setName("You died.");
        localeList.add(locale9);
    	
    	
    	if(currentLocaleList == "North America"){
            localeList.setHead(locale0);
        }

        if(currentLocaleList == "South America"){
            localeList.setHead(locale1);
        }

        if(currentLocaleList == "Arctic Circle"){
            localeList.setHead(locale2);
        }

        if(currentLocaleList == "Magick Shoppe"){
            localeList.setHead(locale3);
        }

        if(currentLocaleList == "Asia"){
            localeList.setHead(locale4);
        }

        if(currentLocaleList == "Scandinavia"){
            localeList.setHead(locale5);
        }

        if(currentLocaleList == "Africa"){
            localeList.setHead(locale6);
        }

        if(currentLocaleList == "Australia"){
            localeList.setHead(locale7);
        }

        if(currentLocaleList == "Russia"){
            localeList.setHead(locale8);
        }
        
        if)(currentLocaleList == "You died."){
        	localeList.setHead(locale9);
        }
    	

        if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("north")) {
            direction = 0;
			locale0.setNext(locale2);
            locale1.setNext(locale0);
            locale3.setNext(locale5);
            locale4.setNext(locale8);
            locale6.setNext(locale3);
            locale7.setNext(locale5);
        
        }
        else if (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("south")){
            direction = 1;
            locale0.setNext(locale4);
            locale2.setNext(locale0);
            locale3.setNext(locale2);
            locale4.setNext(locale5);
            locale5.setNext(locale8);
            locale8.setNext(locale4);
        }

        else if (input.equalsIgnoreCase("e") || input.equalsIgnoreCase("east")){
            direction = 2;
            locale0.setNext(locale3);
            locale1.setNext(locale6);
            locale2.setNext(locale5);
            locale4.setNext(locale0);
            locale7.setNext(locale2);
            locale8.setNext(locale2);

        }

        else if (input.equalsIgnoreCase("w") || input.equalsIgnoreCase("west")){
            direction = 3;
            locale0.setNext(locale4);
            locale1.setNext(locale7);
            locale2.setNext(locale8);
            locale3.setNext(locale0);
            locale5.setNext(locale2);
            locale6.setNext(locale1);
            
        }

        } else if (input.equalsIgnoreCase("h") || input.equalsIgnoreCase("help")) {
            System.out.println("Use directional commands to move (n,north,s,south, etc.) and use i or inventory to see your inventory, and p or pick up to get items. Also, if the mission is too hard, use q or quit to end the game.");
            return;
        } else if (input.equalsIgnoreCase("i") || input.equalsIgnoreCase("inventory")) {
            System.out.println(Arrays.toString(inventory));
            return;
        } else if (input.equalsIgnoreCase("p") || input.equalsIgnoreCase("pick up")) {
            pickUpItem();
            return;
        } else if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
            quitGame();
        } else if (input.equalsIgnoreCase("m") || input.equalsIgnoreCase("map")) {
            map();
        } else {
            System.out.println("Agent, please enter a valid command");
        }

		
		int newLocale = 0;

        if(direction >= 0){
         newLocale = localeMatrix[currentLocale][direction];
        } else{
            System.out.println("error, will be fixed");
        }
        
        
         if (newLocale >= 0 && newLocale < 9 ){

            currentLocale = newLocale; 
            moveCount = moveCount + 1; //add to move count

            if (locations[currentLocale].getHasVisited() == false ){
                locations[currentLocale].setHasVisited(true);
                score = score + 5;
                System.out.println("You are now in a new location");
                display();
            } else{
                display();
            }

            if (locations[currentLocale].getName().equals("Magick Shoppe")){

                createMagicItems();
                display();

            }

        } else if(newLoc == 9){
            System.out.println("You died and cannot go this way.");

        }
        

   if (localeList.getHead().getId() >= 0 && localeList.getHead().getNext().getName() != "You died." ){

        localeList.setHead(localeList.getHead().getNext());
        System.out.println("Your current location is " + localeList.getHead().getName());
        currentLocaleList = localeList.getHead().getName();
        }
        else{
            System.out.println("You died and cannot go this way.");
        }
}

     private static void createMagicItems() {


        System.out.print("What would you like to buy? Or type q or quit.");
        listMan magicItems  = new listMan();
        Scanner inputReader = new Scanner(System.in);


        String targetItem = new String();
        targetItem = inputReader.nextLine();
        System.out.println();

        if (targetItem.equalsIgnoreCase("q") || targetItem.equalsIgnoreCase("quit")){
            return;
        }

        final String fileName;
        fileName = "C:\Users\Greg\Documents\GitHub\Project3-Java\items.txt";
        
        
        File myFile = new File(filename)
        
        try{
        	Scanner input = new Scanner(myFile);
        	while (input.hasNext()) {
        		
        		String itemName = input.nextLine();
        		
        		globeWandererItems fileItem = new globeWandererItems(idNum);
        		fileItem.setItemName(itemName);
        		fileItem.setCost(Math.floor(Math.random() * 50));
        		fileItem.setNext(null);
        		
        		magicItems.add(fileItem);
        		
        		idNum ++;
        		
        	}
        }
        
        input.close();
        System.out.println(magicItems.toString());
        
     }
     
     catch (FileNotFoundException ex) {
     	System.out.println("File not found. " + ex.toString());
     	createMagicItems();
     	
     }
        
        gameItems gi = new gameItems(idNum);
        gi = sequentialSearch(magicItems, targetItem);
        
        if (gi != null) {
        	System.out.println(li.toString());
        	
        }
        
        if(isFound){
        	System.out.println("Would you like to buy?);
        	
        	
        	Scanner input = new Scanner(System.in);
        	String next = new String();
        	next = input.nextLine();
        	System.out.println();
        	if (next.equals("yes") && money >= gi.getCost()){
        		System.out.println("ok");
        		if(id != 6){
        			inventory[id] = gi.getItemName();
        			id = id + 1;
        			
        		}
        		else{
        			System.out.println("You cannot hold anything else.);
        		}
        		else{
        			System.out.println(money);
        			System.out.println(next);
        			System.out.println(gi.getCost());
        			System.out.println("Thank you, goodbye");
        		}
        		else{
        			System.out.println("Nothing was found.");
        		}
        		
        		createMagicItems();
        	}
        	
        }
        
        private static globeWandererItems sequentialSearch(listMan lm, String target) {
        	
        	globeWandererItems retVal = null;
        	System.out.println("Searching for " + target + ".");
        	int counter = 0;
        	globeWandererItems currentItem = new globeWandererItems(idNum)
        		currentItem = lm.getHead();
        	
        	isFound = false;
            while ( (!isFound) && (currentItem != null) ) 
            	{
            		counter = counter +1;
            		if (currentItem.getItemName().equalsIgnoreCase(target)) {
                
                	isFound = true;
                	retVal = currentItem;
            } else {
                
                currentItem = currentItem.getNext();
            }
        }
        
        if (isFound) {

            System.out.println("Found " + target + " after " + counter + " checks." );
            return currentItem;

        } else {
            System.out.println("Did not find " + target + " after " + counter + " checks.");

        }

        return retVal;


    }

    private static void map() {

        if (inventory[0].equals("map")) {
            System.out.println("             Map of the Globe");
            System.out.println("                 ");
            System.out.println(" Russia -------- Arctic Circle -------- Scandinavia");
            System.out.println("    |                 |                      |");
            System.out.println("    |                 |                      |");
            System.out.println("  Asia  -------- North America -------- Magick Shoppe");
            System.out.println("    |                 |                      |");
            System.out.println("    |                 |                      |");
            System.out.println("Australia ------ South America --------   Africa");

        } else {
            System.out.println("You have not acquired the map yet.");
        }
    }
}