import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class allows the user to purchase video games
// the user searches for the game by title and
// selects the game once the game is selected
// then the user can check out the game

    public class BuyGames {
        Scanner scanner = new Scanner(System.in);
        gameDatabase db = new gameDatabase();
        //viewGame view = new viewGame();
        private List<cartSetup> userCart = new ArrayList<>();
        //double theTotal;
        List<gameAttributes> gamesStored;
        viewGame view;
        boolean exit = false;
        //boolean cartReady = false;

        BuyGames buyGame;
        public BuyGames( List<gameAttributes> gamesStored) {
            this.gamesStored = gamesStored;

        }

        public void startBuying() {
            // Ask what game the user wants
            System.out.println("1.Show All Games. 2.Search By title. 3.Exit");
            String gamesToBuy = scanner.nextLine();
            //searchForGames(gamesToBuy, db.gamesStored);


           switch (gamesToBuy) {
                case "1":
                    view.showTheFilter(gamesStored);
                    System.out.println("Type In Your Title");
                    String allGames = scanner.nextLine();
                    searchForGames(allGames, gamesStored);
                    break;

                case "2":
                    System.out.println("Type In Your Title");
                    String gameTitle = scanner.nextLine();
                    searchForGames(gameTitle, gamesStored);
                    break;

               case "3":
                   System.out.println("Exit");
                   exit = true;
                   System.out.println("Returning to main menu");
                   break;

                default:
                    break;
                }
            }


        // This is to find the games by title
        // The updateMethod method has two arguments
        public void searchForGames(String gamesToBuy, List<gameAttributes> gamesStored) {

            // Stores games that match in this list
            List<gameAttributes> games = new ArrayList<>();

            //the for is used to check the gamesStored and it is case-sensitive
            for (gameAttributes myGame : gamesStored) {
                if (myGame.getTitle().toLowerCase().contains(gamesToBuy.toLowerCase())) {
                    //Once game is found you can add it to the games and continue
                    games.add(myGame);

                }
            }
            // When game list is  not empty and found games then the system will get the size of the games list and
            if (!games.isEmpty()) {
                // give each game that is found a number and allow the user to choose which game to buy
                for (int i = 0; i < games.size(); i++) {
                    System.out.println((i + 1) + ". " + games.get(i).getTitle());
                }
                // user selects a number to what game they want to buy
                System.out.println("Select a number");
                int selectedNum = scanner.nextInt();
                scanner.nextLine();





                // this assigns a game found a number
                if(selectedNum >= 0 && selectedNum <= games.size()) {
                    addCart(games.get(selectedNum - 1));
                    //If user input invalid information then this pops up
                } else {
                    System.out.println("Invalid selection");
                }
                //If there are no games in stock this pops up
            }else {
                System.out.println("No Games In Stock");
            }

        }
            //This is the users cart it gets the list from games added and
            // shows what is in there
            public void addCart(gameAttributes games) {
                boolean cartReady = false;

                System.out.println("Enter number of copies: ");
                int copies = scanner.nextInt();
                scanner.nextLine();

                cartSetup ItemsInCart = new cartSetup(games.getTitle(), games.getPrice());
                //userCart.add(ItemsInCart);
                //System.out.println(games.getTitle() + "Has Been added to your cart");

                for(cartSetup itemsINCart : userCart) {
                    if(itemsINCart.getTitle().equalsIgnoreCase(games.getTitle())) {
                        itemsINCart.setQuantity(itemsINCart.getQuantity() + copies);
                        System.out.println(games.getTitle() + "Updated quantity is: " + itemsINCart.getQuantity() + " this is the new quantity");

                        cartReady = true;
                        break;
                        //System.out.println(itemsINCart.getQuantity());
                    }
                }

                    if(!cartReady) {
                        cartSetup newStuff = new cartSetup(games.getTitle(), games.getPrice());
                        newStuff.setQuantity(copies);
                        userCart.add(newStuff);
                        System.out.println(games.getTitle() + " Has Been added to your cart. You have: " +  + copies + " copies");

                    }

                // Asks the user if they want to keep shopping or checkout
                System.out.println("Do you want to Checkout or Keep Shopping? 1. Checkout 2. Keep Shopping");
                int checkoutOption = scanner.nextInt();
                scanner.nextLine();

                // if user selects this then the checkoutFinal method gets called
                if(checkoutOption == 1) {
                    checkoutFinal();

                    //If user selects Keep Shopping then this pops up
                } else if (checkoutOption == 2) {
                    System.out.println("Returning To Buy Games Search");
                    System.out.println("Type In Your Title: ");
                    String anotherSearch = scanner.nextLine();
                    searchForGames(anotherSearch, gamesStored);

                    //If user inputs invalid information then this pops up
                } else {
                    System.out.println("Invalid option. Returning To Buy Games Search");
                    System.out.println("Type In Your Title: ");
                    String anotherSearch = scanner.nextLine();
                    searchForGames(anotherSearch, gamesStored);
                }

                // Returns to the beginning of this class
                //startBuying();
            }
                // This checks to see if the users cart is empty
            public void checkoutFinal() {

            double theTotal = 0;

                if (userCart.isEmpty()) {
                    System.out.println("No Games In Stock");
                    return;
                }
                // This searches the users cart and shows them the items
                for (cartSetup cart : userCart) {

                    double userTotal = cart.getPrice() * cart.getQuantity();
                    System.out.println(cart.getTitle() + " $" + cart.getPrice() + "0" + " Copies: " + cart.getQuantity());
                    theTotal += userTotal;
                }
                // Prompts the user to confirm purchase

                    System.out.println("Total: $" + theTotal);
                    System.out.println("Confirm Purchase" + " 1. Yes 2. No");

                    int answer = scanner.nextInt();
                    scanner.nextLine();

                // If user selects this then it thanks them for their purchase
                    if (answer == 1) {
                        System.out.println("Thank You for your purchase!");
                        //userCart.remove(userCart.size() - 1);
                        userCart.clear();

                    }else {
                        System.out.println("Invalid option");
                        System.out.println("Type In Your Title: ");
                        String anotherSearch = scanner.nextLine();
                        searchForGames(anotherSearch, gamesStored);
                    }
                // When the user is done they will be prompted to return to the
                // Main Menu or if they would like to update another game
                //returnToMainMenu();
            }

        // When the user is done they will be prompted to return to the

      /* // Main Menu or if they would like to update another game
        public void returnToMainMenu()  {;
            int answer = -1;

            while(true) {
                try {
                    System.out.println("Return To Main Menu. Press 1 ?");
                    System.out.println("Buy Another Game. Press 2 ?");

                    answer = Integer.parseInt(scanner.nextLine());
                    //scanner.nextLine();


                    switch(answer) {
                        case 1:
                            MainMenu returnToMainMenu = new MainMenu();
                            returnToMainMenu.menuOptions();
                            break;

                        case 2:
                            startBuying();
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

        public void quantity() {
            System.out.println("Enter number of copies: ");
            int copies = scanner.nextInt();
            scanner.nextLine();



        }
    }