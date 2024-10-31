import java.util.ArrayList;
import java.util.List;
// The game database

public class gameDatabase {

    // This shows the list of games stored
    List<gameAttributes> gamesStored = new ArrayList<>();

    public void gamesStoredHere(){
        //gamesStored.add(new gameAttributes(1, "Call Of Duty 1", "Action", "10 - 9 - 2003", "Playstation", "Activision", "Disk", "Yes", 59.00));
       // gamesStored.add(new gameAttributes(2, "Call Of Duty Black Ops", "Action", "11 - 9 - 2010", "Playstation", "Treyarch", "Disk", "Yes", 59.00));
       // gamesStored.add(new gameAttributes(3, "Tony Hawk's Underground", "Sports", "10 - 27 - 2003", "Xbox", "Activision", "Disk", "Yes", 29.00));
       // gamesStored.add(new gameAttributes(4, "Sonic the Fighters", "Fighting", "10 - 9 - 2003", "Xbox", "Sega", "Disk", "Yes", 39.00));
       // gamesStored.add(new gameAttributes(5, "Super Mario 64", "Action", "6 - 23 - 1996", "Nintendo", "Nintendo", "Cartridge", "NO", 39.00));
       // gamesStored.add(new gameAttributes(6, "Tony Hawk's Pro Skater", "Sports", "9 - 29 - 1999", "Nintendo", "Activision", "Cartridge", "Yes", 59.00));
    }

    public List<gameAttributes> getGameStored() {
        return gamesStored;
    }
}



  /*  // This is to call my list
    public gameDatabase() {
        gameDatabase2();
    }

   */


   /* public void gameDatabase2() {
    if(gamesStored.isEmpty()){

        gamesStored.add(new gameAttributes(1, "Call Of Duty", "Action", "10 - 9 - 2003", "Playstation", "Activision", "Disk", "Yes", 59.00));
        gamesStored.add(new gameAttributes(2, "Call Of Duty Black Ops", "Action", "11 - 9 - 2010", "Playstation", "Treyarch", "Disk", "Yes", 59.00));
        gamesStored.add(new gameAttributes(3, "Tony Hawk's Underground", "Sports", "10 - 27 - 2003", "Xbox", "Activision", "Disk", "Yes", 29.00));
        gamesStored.add(new gameAttributes(4, "Sonic the Fighters", "Fighting", "10 - 9 - 2003", "Xbox", "Sega", "Disk", "Yes", 39.00));
        gamesStored.add(new gameAttributes(5, "Super Mario 64", "Action", "6 - 23 - 1996", "Nintendo", "Nintendo", "Cartridge", "NO", 39.00));
        gamesStored.add(new gameAttributes(6, "Tony Hawk's Pro Skater", "Sports", "9 - 29 - 1999", "Nintendo", "Activision", "Cartridge", "Yes", 59.00));
        gamesStored.add(new gameAttributes(7, "Call Of Duty Modern Warfare", "Action", "10 - 5 - 2007", "Playstation", "Activision", "Disk", "Yes", 59.00));
        gamesStored.add(new gameAttributes(8, "Call Of Duty Black Ops 2", "Action", "11 - 13 - 2012", "Playstation", "Treyarch", "Disk", "Yes", 59.00));
        gamesStored.add(new gameAttributes(9, "NBA 2k20 ", "Sports", "9 - 6 - 2019", "Xbox", "Activision", "Disk", "Yes", 49.00));
        gamesStored.add(new gameAttributes(10, "Pokemon Yellow", "RPG", "9 - 12 - 1998", "Nintendo", "Game Freak", "Cartridge", "NO", 39.00));
        gamesStored.add(new gameAttributes(11, "Pokemon Crystal", "RPG", "10 - 15 - 2000", "Nintendo", "Game Freak", "Cartridge", "NO", 39.00));
        gamesStored.add(new gameAttributes(12, "Tony Hawk's Pro Skater 2", "Sports", "9 - 19 - 2000", "Nintendo", "Activision", "Cartridge", "Yes", 59.00));
        gamesStored.add(new gameAttributes(13, "Call Of Duty Modern Warfare 2", "Action", "11 - 10 - 2009", "Playstation", "Activision", "Disk", "Yes", 59.00));
        gamesStored.add(new gameAttributes(14, "Call Of Duty Black Ops 3", "Action", "11 - 6 - 2015", "Playstation", "Treyarch", "Disk", "Yes", 59.00));
        gamesStored.add(new gameAttributes(15, "NBA 2k24 ", "Sports", "9 - 8 - 2003", "Xbox", "Activision", "Disk", "Yes", 49.00));
        gamesStored.add(new gameAttributes(16, "Pokemon Yellow", "RPG", "9 - 12 - 1998", "Nintendo", "Game Freak", "Cartridge", "NO", 39.00));
        gamesStored.add(new gameAttributes(17, "Pokemon Red", "RPG", "11 - 9 - 1999", "Nintendo", "Game Freak", "Cartridge", "NO", 39.00));
        gamesStored.add(new gameAttributes(18, "Pokemon Blue", "RPG", "11 - 9 - 1999", "Nintendo", "Game Freak", "Cartridge", "Yes", 59.00));
        gamesStored.add(new gameAttributes(19, "Pokemon Gold", "RPG", "10 - 15 - 2000", "Nintendo", "Game Freak", "Cartridge", "NO", 39.00));
        gamesStored.add(new gameAttributes(20, "Tony Hawk's Pro Skater 3", "Sports", "10 - 30 - 2001", "Nintendo", "Activision", "Cartridge", "Yes", 59.00));



    }
}

    */
    /*
        // This is used when a games are added to the gamesStored list
        public void addingGamesToDatabase(gameAttributes gamesToList) {
            gamesStored.add(gamesToList);
            System.out.println(gamesToList + " \nHas been added to the database");

        }

     */

    // shows the games in the list


