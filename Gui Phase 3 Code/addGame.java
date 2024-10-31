import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

// This class allows the user to add games
// it also allows them to upload games
// with batching

public class addGame {
    Scanner scanner = new Scanner(System.in);
    String Yes = "Y";
    String No = "N";
    String title, genre, studio, console, releaseDate, multiplayer, productType, releaseDMYear;
    int gameId;
    double price;
    //gameDatabase db = new gameDatabase();
    //gameDatabase db;
    List<gameAttributes> gamesStored;
    String regex = "\\d{2}-\\d{2}-\\d{4}";

    public addGame(List<gameAttributes> gamesStored) {
        this.gamesStored = gamesStored;
    }

    public void start() {
        gameId = -1;
        price = -0.1;
        int answer2;
        String multiplayerAnswer;

//List<gameAttributes> games = new ArrayList<>();

//This is to make sure that the user can only enter an int
// That's why the gameID is set at -1 once the user enters
// a positive number greater than 0 the program will keep that number
// If the user enters anything other than an int the Integer.parseInt(gameId1);
// will trigger the (Exception e)
// I have added an if else statement to check the game id and if the
// game id already exist then a error message will pop up
// if the game id is not found in the system then we can add it
        boolean gamesHere = true;

        while (gamesHere) {
            boolean gameFound = false;

            while (true) {
                try {
                    System.out.println("Enter Game Id; ");
                    String gameId1 = scanner.nextLine();
                    gameId = Integer.parseInt(gameId1);

                    if (gameId > 0) {
                        gameFound = false;

                        for (gameAttributes thisGame : gamesStored) {
                            if (thisGame.getGameid() == gameId) {
                                gameFound = true;
                                break;
                            }
                        }
                        if (gameFound) {
                            System.out.println("Game Id "+ gameId + " already exist");
                        } else {
                            System.out.println("Game Id " + gameId1 + " can be added");
                            break;
                        }
                    } else {
                        System.out.println("Invalid number ");
                    }
                } catch (Exception e) {
                    System.out.println("Enter a valid number ");
                }
            }

            // We are just gathering information
            //from the user to add to database
            System.out.println("Enter Title");
            title = scanner.nextLine();

            System.out.println("Enter Genre");
            genre = scanner.nextLine();

            while (true) {
                try {
                    System.out.println("Enter Release Month, Day, Year");
                    releaseDMYear = scanner.nextLine();
                    //releaseMonth = releaseDate;

                    if (Pattern.matches(regex, releaseDMYear)) {
                        System.out.println("The date " + releaseDMYear + " was added.");
                        break;
                    } else {
                        System.out.println("The date " + releaseDMYear + " is not a valid year.");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid date.");
                }
            }

            while (true) {
                try {
                    System.out.println("Select a Console Manufacture\n" + "1. Playstation, 2. Xbox, 3. Nintendo, 4. Sega, 5. Other.");
                    console = scanner.nextLine();

                    if (console.equals("1")) {
                        console = "Playstation";
                        System.out.println("The console." + console);
                        break;

                    } else if (console.equals("2")) {
                        console = "Xbox";
                        System.out.println("The console." + console);
                        break;

                    } else if (console.equals("3")) {
                        console = "Nintendo";
                        System.out.println("The console." + console);
                        break;

                    } else if (console.equals("4")) {
                        console = "Sega";
                        System.out.println("The console." + console);
                        break;

                    } else if (console.equals("5")) {
                        System.out.println("Type the name of your console.");
                        String console2 = scanner.nextLine();
                        //console2 = "Other.";
                        console = console2;
                        System.out.println("The console." + console);

                        break;
                    } else {
                        System.out.println("Please enter a valid Console Manufacture");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid Console Manufacture");
                }
            }

            System.out.println("Enter Studio");
            studio = scanner.nextLine();

            System.out.println("Enter Product Type");
            productType = scanner.nextLine();

            while (true) {
                String yes = "1";
                String no = "2";
                try {
                    System.out.println("Does this game have Multiplayer");
                    System.out.println("1. Yes 2. No");
                    multiplayer = scanner.nextLine();

                    //scanner.nextLine();


                    if (multiplayer.equals("1")) {
                        System.out.println("This game does have Multiplayer");
                        multiplayer = "Yes";
                        break;
                    } else if (multiplayer.equals("2")) {
                        System.out.println("This game doesnt Multiplayer ");
                        multiplayer = "No";
                        break;
                    } else {
                        System.out.println("Invalid multiplayer choice ");
                    }

                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                }
            }


            //This is to make sure that the user can only enter an double
            // That's why the price is set at -1.0 once the user enters
            // a positive number greater than 0 the program will keep that number
            // If the user enters anything other than an int the Double.parseDouble(gamePrice);;
            // will trigger the (Exception e)
            while (true) {
                try {
                    System.out.println("Enter The Price: ");
                    String gamePrice = scanner.nextLine();
                    price = Double.parseDouble(gamePrice);
                    if (price > 0) {
                        break;
                    } else {
                        System.out.println("Please enter a valid game ID");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                }

            }


            //This is to confirm the user wants to add the game to the database
            System.out.println("Are you sure you want to add a new game (Y/N) ?");
            String answer = scanner.nextLine();
            //answer = answer.toLowerCase();

            if (answer.equalsIgnoreCase("Y")) {
                gameAttributes newGames = new gameAttributes(gameId, title, genre, releaseDMYear, console, studio, productType, multiplayer, price);
                gamesStored.add(newGames);
                System.out.println("The Game" + newGames + "has been added");


            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Returning To Main Menu");

                return;

            } else {
                System.out.println("Invalid answer");

            }
            // When the user is done they will be prompted to return to the
            // Main Menu or if they would like to add another game
            System.out.println("1. Main Menu 2. Add another game");
            answer2 = scanner.nextInt();
            scanner.nextLine();
            if (answer2 == 1) {
                System.out.println("Returning To Main Menu");
                gamesHere = false;

            } else if (answer2 == 2) {
                System.out.println("Returning To adding games");

            } else {
                System.out.println("Invalid answer");
                gamesHere = false;
            }
        }
    }
}