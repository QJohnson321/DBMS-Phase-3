import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class allows the user to update games
// they can update games by Title, Genre, Studio, Console


public class updateGames {

    Scanner scanner = new Scanner(System.in);
    //gameDatabase db = new gameDatabase();
    //gameDatabase db;
    viewGame view;
    List<gameAttributes> gamesStored;

    public updateGames( List<gameAttributes> gamesStored) {
        this.gamesStored = gamesStored;
    }
    public void startUpdate() {
        String one = "1";
        String two = "2";


        //List<gameAttributes> games = new ArrayList<gameAttributes>();
        //This is to start the search method for the user.
        // The user can select an option, and it will call
        // the selected method

        System.out.println("1.Show All Games. 2.Search By title ");
        String updatedGame = scanner.nextLine();


        switch (updatedGame) {
            case "1":
                view.showTheFilter(gamesStored);
                System.out.println("Type In Your Title");
                String updatedNewGame = scanner.nextLine();
                updateMethod(updatedNewGame, gamesStored);
                break;

            case "2":
                System.out.println("Type In Your Title");
                String updatedTitle = scanner.nextLine();
                updateMethod(updatedTitle, gamesStored);
                break;

            default:
                break;

        }


    }

    // This is to find the games by title
    // The updateMethod method has two arguments
    public void updateMethod(String updatedGame, List<gameAttributes> gamesStored) {
        boolean gotIt = false;

        // Stores games that match in this list
        List<gameAttributes> games = new ArrayList<>();

        //the for is used to check the gamesStored and it is case-sensitive
        for (gameAttributes myGame : gamesStored) {
            if (myGame.getTitle().toLowerCase().contains(updatedGame.toLowerCase())) {
                //Once game is found you can add it to the games and continue
                games.add(myGame);

            }
        }
        // When game list is  not empty and found games then the system will get the size of the games list and
        if (!games.isEmpty()) {
            System.out.println("Games Found");
            // give each game that is found a number and allow the user to choose which game to update
            for (int i = 0; i < games.size(); i++) {
                System.out.println((i + 1) + " . " + games.get(i).getTitle() + "(" + games.get(i).getGenre() + ")");
            }
            // user selects a number to what game they want to update
            System.out.println("Select a number");
            int answer = scanner.nextInt();
            scanner.nextLine();

            // user selects a number to what game they want to update this shows
            // this assigns a game found a number
            if (answer >= 1 && answer <= games.size()) {
                int one = 1;
                int two = 2;
                int three = 3;
                int four = 4;

                // Gets the most recent list.
                gameAttributes settingTitle = games.get(answer - 1);
                System.out.println("You selected: " + settingTitle.getTitle());

                // When game is found then we give the user the option to change the games attributes.
                System.out.println("What Do you want to change. 1. Title, 2. Genre, 3. Studio, 4. Console");

                //get user input
                int answer2 = scanner.nextInt();
                scanner.nextLine();

                // user selects a number to what they attribute they want to update.
                // This is for the title
                switch (answer2) {
                    case 1:
                        String previousTitle = settingTitle.getTitle();
                        System.out.println("Enter a new title: ");
                        String newTitle = scanner.nextLine();
                        settingTitle.setTitle(newTitle);
                        System.out.println("Your game: " + previousTitle + " The Title has been changed to: " + settingTitle.getTitle());
                        //returnToMainMenu();
                        break;

                    // user selects a number to what they attribute they want to update.
                    // This is for the genre
                    case 2:
                        System.out.println("Enter a new genre: ");
                        String newGenre = scanner.nextLine();
                        settingTitle.setGenre(newGenre);
                        System.out.println("Your game: " + settingTitle.getTitle() + " The Genre has been changed to: " + settingTitle.getGenre());
                       // returnToMainMenu();
                        break;

                    // user selects a number to what they attribute they want to update.
                    // This is for the studio
                    case 3:
                        System.out.println("Enter a new studio: ");
                        String newStudio = scanner.nextLine();
                        settingTitle.setStudio(newStudio);
                        System.out.println("Your game: " + settingTitle.getTitle() + " The Studio has been changed to: " + settingTitle.getStudio());
                       // returnToMainMenu();
                        break;

                    // user selects a number to what they attribute they want to update.
                    // This is for the Console
                    case 4:
                        System.out.println("Enter a new Console: ");
                        String newConsole = scanner.nextLine();
                        settingTitle.setConsole(newConsole);
                        System.out.println("Your game : " + settingTitle.getTitle() + "The console has been changed to: " + settingTitle.getConsole());
                        //returnToMainMenu();
                        break;

                    // user selects a number to what they attribute they want to update.
                    // This is to leave this class
                    case 5:
                        System.out.println("Exit: ");
                        //returnToMainMenu();
                        break;

                // This will take you back to the main menu if your enter the wrong information
                    default:
                        System.out.println("Invalid Input");
                        //returnToMainMenu();
                        break;

                }

            }

        } else {
            // This will take you back to the main menu if no game is found
            System.out.println("No game found " + updatedGame);
        }
        //takes you back to the main menu
        //returnToMainMenu();
    }


    // When the user is done they will be prompted to return to the
    // Main Menu or if they would like to update another game
    /*
    public void returnToMainMenu(){
        int answer = -1;

        while(true) {
            try {
                System.out.println("Return To Main Menu. Press 1 ?");
                System.out.println("Update Another Game. Press 2 ?");

                answer = Integer.parseInt(scanner.nextLine());
                //scanner.nextLine();


                switch(answer) {
                    case 1:
                        MainMenu returnToMainMenu = new MainMenu();
                        returnToMainMenu.menuOptions();
                        break;

                    case 2:
                        startUpdate();
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


