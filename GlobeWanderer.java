/**
 * GlobeWanderer.java
 * Gregory Fox
 *
 */

import java.util.Scanner;
import java.util.Arrays;

public class globeWanderer {

    //Globals

    public static localeClass[] locations;
    public static globeWandererItems[] itemsArray;
    public static int[][] localeMatrix;
    public static int currentLocale = 0;
    public static boolean stillPlaying = true;
    public static String input;
    public static int direction;
    public static float score = 0;
    public static float moves = 1;
    public static String[] inventory;


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
        System.out.println(" Your score is: " + score + ". Your move count is " + moves + ". Your level of skill is " + score / moves + ". " + "The item in this location is " + locations[currentLocale].getItem() + ".");
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

        if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("north")) {
            direction = 0;
        } else if (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("south")) {
            direction = 1;
        } else if (input.equalsIgnoreCase("e") || input.equalsIgnoreCase("east")) {
            direction = 2;
        } else if (input.equalsIgnoreCase("w") || input.equalsIgnoreCase("west")) {
            direction = 3;

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
        } else if (input.equalsIgnoreCase("m")) {
            map();
        } else {
            System.out.println("Agent, please enter a valid command");
        }

        int newLocale = localeMatrix[currentLocale][direction];

        if (newLocale >= 0 && newLocale < 8) {
            currentLocale = newLocale;
            moves = moves + 1;

            if (!locations[currentLocale].getHasVisited()) {
                locations[currentLocale].setHasVisited(true);
                score = score + 5;
                System.out.println("You have never been here before.");
                display();
            } else {
                display();
            }

            if (locations[currentLocale].getName().equals("Magick Shoppe")) {
                createMagicItems();
            }

        } else if (newLocale == 9) {
            System.out.println("You cannot go this way.");

        }
    }

    private static void createMagicItems() {

        listMan magicItems = new listMan();
        magicItems.setName("Magic Items");
        magicItems.setDesc("These are the items sold in the Magick Shoppe.");
        magicItems.setHead(null);

        globeWandererItems item0 = new globeWandererItems(0);
        item0.setItemName("Secret Agent Handbook");
        item0.setDesc("This item will help you on your mission. It is $20");

        globeWandererItems item1 = new globeWandererItems(1);
        item1.setItemName("Dapper Suit");
        item1.setDesc("This will help you succeed in all areas of life. It is $4000");

        magicItems.setHead(item0);
        item0.setNext(item1);
        item1.setNext(null);

        System.out.println(magicItems.toString());
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