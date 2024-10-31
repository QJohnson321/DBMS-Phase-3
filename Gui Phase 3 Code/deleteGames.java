import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class is for the user to delete their video games.
// The user can search by title or see the list
// once they find their game they can proceed
// to delete it



public class deleteGames {
    //MainMenu returnToMainMenu = new MainMenu();
    Scanner scanner = new Scanner(System.in);
    gameDatabase db;
    //viewGame view = new viewGame();
    String password = "1234";
    String userName = "Login";
    List<gameAttributes> gamesStored;


    public deleteGames(List<gameAttributes> gamesStored) {
        this.gamesStored = gamesStored;
    }
    public void startToDeleteGames() {
        //Searches if game is in stock if not then it prints There are no games in the database

        if(gamesStored.isEmpty()) {
            System.out.println("There are no games in the database");

            // If a game list is not empty then we prompt the user to enter the name of a game
        } else {
            System.out.println("Enter the name of the game: ");
            String gameName = scanner.nextLine();
            deleteGame(gameName, gamesStored);
        }
    }
        // This is to filter the games by title
        // The filterByTitle method has two arguments
    public void deleteGame(String gameName, List<gameAttributes> gamesStored) {
        boolean foundTheGame = false;

        List<gameAttributes> gamesDeleted = new ArrayList<>();

        //the for is used to check the gamesStored and it is case-sensitive
        for (gameAttributes deleteList : gamesStored) {
            if (deleteList.getTitle().toLowerCase().contains(gameName.toLowerCase())) {
                //Once game is found you can add it to the gamesDeleted and continue
                gamesDeleted.add(deleteList);
            }
        }
            //If game is empty this will show up
        if (gamesDeleted.isEmpty()) {
            System.out.println("There are no games in the database");
        } else {
            // When game list is  not empty and found games then the system will get the size of the games list and

            System.out.println("Games Found");
            // give each game that is found a number and allow the user to choose which game to delete
            for (int i = 0; i < gamesDeleted.size(); i++) {
                System.out.println((i + 1) + ". " + gamesDeleted.get(i).getTitle());
            }

            // user selects a number to what game they want to update
            System.out.println("Select a number");
            int answer = scanner.nextInt();
            scanner.nextLine();


            // user selects a number to what game they want to delete this shows
            // this assigns a game found a number
            if (answer >= 1 && answer <= gamesDeleted.size()) {
                int one = 1;
                int two = 2;
                int three = 3;
                int four = 4;

                // Gets the most recent list.
                gameAttributes selectedGame = gamesDeleted.get(answer - 1);
                System.out.println("You selected: " + selectedGame.getTitle());
                // When game is found then we give the user the option to delete the game.
                System.out.println("What Do you want to delete " + selectedGame.getTitle() + " 1. Yes 2. No");

                int answer2 = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Username: Login");
                System.out.println("Password: 1234");

                System.out.println("Type In Your Username");
                String userNameAccess = scanner.nextLine();

                System.out.println("Type In Your Password");
                String passwordAccess = scanner.nextLine();


                // User needs to enter their username and password to continue
                if (userName.equals(userNameAccess) && passwordAccess.equals(password)) {
                    gamesStored.remove(selectedGame);
                    System.out.println("The Game: " + selectedGame.getTitle()+ " has been deleted");

                    //If user selects no then this pops up
                } else {
                    System.out.println("Delete Game Canceled");
                }

            } else {
                // This will pop up if username and password don't match
                System.out.println("You do not have access to delete this game");
            }
        }
        // When the user is done they will be prompted to return to the
        // Main Menu or if they would like to update another game
                //returnToMainMenu();
    }

    /*
    // When the user is done they will be prompted to return to the
    // Main Menu or if they would like to update another game
    public void returnToMainMenu()  {;
        int answer = -1;

        while(true) {
            try {
            System.out.println("Return To Main Menu. Press 1 ?");
            System.out.println("Delete Another Game. Press 2 ?");

            answer = Integer.parseInt(scanner.nextLine());
            //scanner.nextLine();


        switch(answer) {
            case 1:
                MainMenu returnToMainMenu = new MainMenu();
                returnToMainMenu.menuOptions();
                break;

            case 2:
                startToDeleteGames();
                break;

            default:
                System.out.println("Invalid Choice. Returning To Main Menu");
                MainMenu returnToMainMenu2 = new MainMenu();
                returnToMainMenu2.menuOptions();
                break;
            }
            break;

                }catch(Exception e) {
                System.out.println("Invalid Choice. Returning To Main Menu");
                returnToMainMenu();
            }
        }
    }

     */
}


