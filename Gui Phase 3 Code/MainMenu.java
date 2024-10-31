import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;
//This class allows the user to login and select one
// of six choices on the main menu
// when a user is done with a class
// they are then returned to here

    public class MainMenu {

        Scanner scanner = new Scanner(System.in);

        String password = "1234";
        String userName = "Login";
        List<gameAttributes> gamesStored;

        JFrame mainMenuFrame;

        public MainMenu() {
            gameDatabase db = new gameDatabase();
            db.gamesStoredHere();
            this.gamesStored = db.getGameStored();
        }

        //This is the login method.

        public void Login() {
            while (true) {
                System.out.println("Username: Login");
                System.out.println("Password: 1234");

                System.out.println("Type In Your Username");
                String userNameAccess = scanner.nextLine();

                System.out.println("Type In Your Password");
                String passwordAccess = scanner.nextLine();

                if (userName.equals(userNameAccess) && passwordAccess.equals(password)) {
                    System.out.println("Login Successful");
                    menuOptions();
                    break;

                } else {
                    System.out.println("Login Failed");
                }

            }

        }

        //Once user passes the login method.
        // Then they need to choose an option from the main menu

        public void menuOptions() {
            addGame addingTheGame = new addGame(this.gamesStored);
            viewGame viewingTheGame = new viewGame(this.gamesStored);
            updateGames UDG = new updateGames(this.gamesStored);
            deleteGames deleteGame = new deleteGames(this.gamesStored);
            BuyGames buyGame = new BuyGames(this.gamesStored);

            while (true) {
                try {
                    System.out.println("1. Add Video Games");
                    System.out.println("2. View Video Games");
                    System.out.println("3. Update Video Games");
                    System.out.println("4. Delete Video Games");
                    System.out.println("5. Buy Video Games");
                    System.out.println("6. Exit");

                    String option = scanner.nextLine();

                    switch (option) {
                        case "1":
                            System.out.println("Add Video Game");
                            //gameDatabase db = new gameDatabase();
                            addingTheGame.start();
                            break;
                        case "2":
                            System.out.println("View Video Games");
                            //gameDatabase db = new gameDatabase();
                            //viewGame viewGame = new viewGame(db);
                            viewingTheGame.startView();
                            break;

                        case "3":
                            System.out.println("Update Video Games");
                            //updateGames UDG = new updateGames(db);
                            UDG.startUpdate();
                            break;
                        case "4":
                            System.out.println("Delete Video Games");
                            //deleteGames delGame = new deleteGames(db);
                            //delGame.startToDeleteGames();
                            deleteGame.startToDeleteGames();
                            break;
                        case "5":
                            System.out.println("Buy Video Games");
                            //BuyGames buyGame = new BuyGames();
                            buyGame.startBuying();
                            break;
                        case "6":
                            System.out.println("Exit");
                            System.out.println("Goodbye!");
                            break;

                        default:
                            System.out.println("Invalid Option");
                            break;
                    }

                } catch (Exception e) {
                    System.out.println("Invalid Choice. Returning To Main Menu");

                }
            }
        }
    }


