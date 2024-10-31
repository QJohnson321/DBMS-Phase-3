import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class allows the user to search for the games in stock
// This allows the user to search by title, console, genre, studio
// Tip: If you press the search games without entering a title
// it will display all the games

public class viewGame {

   Scanner scanner = new Scanner(System.in);
   //gameDatabase db;
    List<gameAttributes> gamesStored;
    boolean found = false;

   public viewGame(List<gameAttributes> gamesStored) {
       this.gamesStored = gamesStored;
   }
   //This is to start the search method for the user.
   // The user can select an option, and it will call
   // the selected method
    public void startView() {
        System.out.println("Welcome to View Video Games");
        System.out.println("Choose a Search Option");

        System.out.println("1. Title ");
        System.out.println("2. Genre ");
        System.out.println("3. Console ");
        System.out.println("4. Studio ");
        System.out.println("0. Exit");

        String choice = scanner.nextLine();


        switch (choice) {
            case "1":
                System.out.println("Title: ");
                String title = scanner.nextLine();
                //System.out.println("Title: ");
                //db.gameDatabase2();
                filterByTitle(title, gamesStored);
                break;

            case "2":
                System.out.println("Genre: ");
                String genre = scanner.nextLine();
                //db.gameDatabase2();
                filterByGenre(genre, gamesStored);
                break;

            case "3":
                System.out.println("Console: ");
                String console = scanner.nextLine();
                //db.gameDatabase2();
                filterByConsole(console,gamesStored);
                break;
            case "4":
                System.out.println("Studio: ");
                String studio = scanner.nextLine();
                //db.gameDatabase2();
                filterByStudio(studio, gamesStored);
                break;

            case "0":
                System.out.println("Exit");
                //returnToMainMenu();
                break;

            default:
                System.out.println("Invalid Choice");
                startView();
                break;

        }

    }
            // This is to filter the games by title
            // The filterByTitle method has two arguments
            public void filterByTitle(String title, List<gameAttributes> gamesStored) {


                // a string for the user to type in the game they are
                //System.out.println("Filtering by Title: " + title);

                // Stores games that match in this list
                //List<gameAttributes> viewListByTitle = new ArrayList<>();

                //the for is used to check the gamesStored and it is case-sensitive
                for(gameAttributes theGame : gamesStored) {

                    //Once game is found you can add it to the viewListByTitle and continue
                    if (theGame.getTitle().toLowerCase().contains(title.toLowerCase())) {
                        //gamesStored.add(theGame);
                       //gamesStored.add(theGame);
                        //showTheFilter(gamesStored);
                        //System.out.println("Here are the names of the Title: " + theGame.getTitle());
                        showTheFilter(List.of(theGame));
                        found = true;

                    }
                }
                if(!found) {
                    System.out.println("Title not found " + title + " Here are all the games in stock");
                    showTheFilter(gamesStored);
                    /*
                    for(gameAttributes theGame : gamesStored) {
                        //System.out.println(theGame);
                        showTheFilter(gamesStored);
                    }
                    */
                }
            }


            // This is to filter the games by Genre
            // The filterByGenre method has two arguments
            public void filterByGenre(String genre,  List<gameAttributes> gamesStored) {
                // a string for the user to type in the Genre they are looking for
                //System.out.println("Filtering by Genre: " + genre);

                // Stores games that match in this list
                //List<gameAttributes> viewGenreList = new ArrayList<>();
                //the for is used to check the gamesStored and it is case-sensitive
                for(gameAttributes theGame : gamesStored ) {

                    //Once game is found you can add it to the viewGenreList and continue
                    if(theGame.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                        //viewGenreList.add(theGame);
                        //System.out.println("Here are the names of the Genre: " + theGame.getGenre());
                        showTheFilter(List.of(theGame));
                        found = true;
                    }
                }
                if(!found) {
                    System.out.println("Genre not found " + genre + " Here are all the games in stock");

                    for(gameAttributes theGame : gamesStored) {
                        //System.out.println(theGame);
                        showTheFilter(gamesStored);
                    }
                }
            }



                // This is to filter the games by console
                // The filterByConsole method has two arguments
            public void filterByConsole(String console, List<gameAttributes> gamesStored) {

                // a string for the user to type in the console they are looking for
                //System.out.println("Filtering by Genre: " + console);

                // Stores games that match in this list
                //List<gameAttributes> viewByConsole = new ArrayList<>();

                //the for is used to check the gamesStored and it is case-sensitive
                for(gameAttributes theGame3: gamesStored) {
                    if(theGame3.getConsole().toLowerCase().contains(console.toLowerCase())) {
                        //Once game is found you can add it to the viewByConsole and continue
                        //viewByConsole.add(theGame3);
                        //System.out.println("Here are the names of the Console: " + theGame3.getConsole());
                        showTheFilter(List.of(theGame3));
                        found = true;

                    }
                }
                if(!found) {
                    System.out.println("Console not found " + console + " Here are all the games in stock");

                    for(gameAttributes theGame : gamesStored) {
                       // System.out.println(theGame);
                        showTheFilter(gamesStored);
                    }
                }
            }

                // This is to filter the games by studio
                // The filterByStudio method has two arguments
           public void filterByStudio(String studio, List<gameAttributes> gamesStored) {
               // a string for the user to type in the console they are looking for
               //System.out.println("Filtering by studio: " + studio);

               // Stores games that match in this list
                //List<gameAttributes> viewByStudio = new ArrayList<>();

               //the for is used to check the gamesStored and it is case-sensitive
                for(gameAttributes theGame4: gamesStored) {
                    if(theGame4.getStudio().toLowerCase().contains(studio.toLowerCase())) {

                //Once game is found you can add it to the viewByConsole and continue
                        //gamesStored.add(theGame4);
                        //System.out.println("Here are the names of the Studio: " + theGame4.getStudio());
                        showTheFilter(List.of(theGame4));
                        found = true;

                    }
                }
               if(!found) {
                   System.out.println("Studio not found " + studio + " Here are all the games in stock");

                   for(gameAttributes theGame : gamesStored) {
                       //System.out.println(theGame);
                       showTheFilter(gamesStored);
                   }
               }
           }
                // This prints out the search results for the user.
            public static void showTheFilter(List<gameAttributes> gamesStored) {
               // List<gameAttributes> allGames = gamesStored();

                for (gameAttributes allThegames : gamesStored) {
                    System.out.println("-----------------------");
                    System.out.println("Title: " + allThegames.getTitle());
                    System.out.println("Genre: " + allThegames.getGenre());
                    System.out.println("Console: " + allThegames.getConsole());
                    System.out.println("Studio: " + allThegames.getStudio());
                    System.out.println("-----------------------");

                }
            }
        }










