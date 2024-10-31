import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

//This Class is the main menu Gui. This class allows the
// user to decide what they would like to do.

public class MainMenuGui {
    Scanner scanner = new Scanner(System.in);

    String password = "1234";
    String userName = "Login";
    List<gameAttributes> gamesStored;

    JFrame mainMenuFrame;

    public MainMenuGui() {
        gameDatabase db = new gameDatabase();
        db.gamesStoredHere();
        this.gamesStored = db.getGameStored();
    }

    // I am building the game frame and setting the size, layout and to exit
    // the main menu when you click the X button
    public void mainMenuGUI() {
        mainMenuFrame = new JFrame();
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setTitle("Main Menu");
        mainMenuFrame.setSize(800, 600);
        mainMenuFrame.setLayout(new GridLayout(6,1));

        // I've created new buttons

        JButton addGameButton = new JButton("Add Game");
        JButton viewingButton = new JButton("View Games");
        JButton updateGameButton = new JButton("Update Game");
        JButton deleteGameButton = new JButton("Delete Game");
        JButton buyGameButton = new JButton("Buy Games");
        JButton exitButton = new JButton("Exit");


        // These are the actions that the button calls when
        // The user clicks on them
        addGameButton.addActionListener(e -> addGame());
        viewingButton.addActionListener(e -> viewGames());
        updateGameButton.addActionListener(e -> updateGame());
        deleteGameButton.addActionListener(e -> deleteGame());
        buyGameButton.addActionListener(e -> buyGame());
        exitButton.addActionListener(e -> System.exit(0));

        // I am adding the buttons to the gui
        mainMenuFrame.add(addGameButton);
        mainMenuFrame.add(viewingButton);
        mainMenuFrame.add(updateGameButton);
        mainMenuFrame.add(deleteGameButton);
        mainMenuFrame.add(buyGameButton);
        mainMenuFrame.add(exitButton);

        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);
    }

        // These are the choices that I give the user
        // each choice has their own class and the mainmenu frame
        // stays hidden when the user makes a selection

    public void addGame() {
        //addGame addingTheGame = new addGame(this.gamesStored);
        //addingTheGame.start();
        //mainMenuFrame.dispose();
        mainMenuFrame.setVisible(false);
        addGameGui addGui = new addGameGui(gamesStored, this::mainMenuGUI);
        addGui.addGames();

    }
    public void viewGames() {
        mainMenuFrame.setVisible(false);
        viewGamesGui viewingTheGame = new viewGamesGui(this.gamesStored, this::mainMenuGUI);
        viewingTheGame.buildViewGui();
    }
    public void updateGame() {
        mainMenuFrame.setVisible(false);
        UpdateGamesGui UDG = new UpdateGamesGui(this.gamesStored, this::mainMenuGUI);
        UDG.buildUpdateGamesGui();
    }
    public void deleteGame() {
        mainMenuFrame.setVisible(false);
        deleteGameGui deleteGame = new deleteGameGui(this.gamesStored, this::mainMenuGUI);
        deleteGame.buildDeleteGamesGui();
    }
    public void buyGame() {
        mainMenuFrame.setVisible(false);
        buyGamesGui buyGame = new buyGamesGui(this.gamesStored, this::mainMenuGUI);
        buyGame.buildBuyGamesGui();
    }
    public void shutDown(JFrame mainMenuFrame) {
        mainMenuFrame.dispose();
        System.out.println("Goodbye!");

    }
}