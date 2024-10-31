import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class viewGamesGui {

    private Runnable mainMenuRunnable;
    List<gameAttributes> gamesStored;
    private JFrame viewGamesFrame;
    private JTextField titleTxt, genreTxt, studioTxt, consoleTxt, exit;
    private JTextArea resultArea;


    public viewGamesGui(List<gameAttributes> gamesStored, Runnable mainMenuRunnable) {
        this.gamesStored = gamesStored;
        this.mainMenuRunnable = mainMenuRunnable;
        //buildViewGui();
    }
        // This is the Gui of the view games class
        // I am setting up the basics of the gui
        // such as the size, exiting the gui when i click the X button

        public void buildViewGui() {
            viewGamesFrame = new JFrame("View Games");
            viewGamesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //addGamesFrame.setTitle("Adding Game");
            viewGamesFrame.setSize(800, 600);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6,2,10,10));

            //I have created text fields for the user to enter their attributes
            titleTxt = new JTextField();
            genreTxt = new JTextField();
            studioTxt = new JTextField();
            consoleTxt = new JTextField();
            exit = new JTextField();


            // Here I add the labels and the text fields to the frame
            panel.add(new JLabel("Enter Title"));
            titleTxt = new JTextField();
            panel.add(titleTxt);

            panel.add(new JLabel("Enter Genre"));
            genreTxt = new JTextField();
            panel.add(genreTxt);


            panel.add(new JLabel("Enter Studio"));
            studioTxt = new JTextField();
            panel.add(studioTxt);

            // I used a Jbox on this so the user doesn't have to
            // type in the name of the console.
            panel.add(new JLabel("Enter Console"));
            //String[] consoleOptions = {" ", "Playstation", "Xbox", "Nintendo", "Sega", "Other" };
            consoleTxt = new JTextField();
            panel.add(consoleTxt);

            panel.add(new JLabel("Exit"));
            //consoleTxt = new JTextField();
            //panel.add(consoleTxt);

            // This is the action listener for the button
            JButton searchGamesButton = new JButton("View Games");
            searchGamesButton.addActionListener(e -> theFilters());
            panel.add(searchGamesButton);

            // This is the action listener for the exit button
            JButton exitButton = new JButton("Exit");
            exitButton.addActionListener(e -> exitCall());
            panel.add(exitButton);



            resultArea = new JTextArea(); // Making a text area to display results
            resultArea.setEditable(false); // Makes the text area non-editable
            resultArea.setLineWrap(true); // Wraps text lines that are too long
            resultArea.setWrapStyleWord(true) ;// Wraps lines at word boundaries


            viewGamesFrame.add(panel, BorderLayout.NORTH);
            viewGamesFrame.add(new JScrollPane(resultArea), BorderLayout.CENTER);
            viewGamesFrame.setLocationRelativeTo(null);
            viewGamesFrame.setVisible(true);
        }

        private void theFilters() {
            // Gets user input from text fields, it changes it to lowercase and makes the information case-insensitive
            String title = titleTxt.getText().toLowerCase();
            String genre = genreTxt.getText().toLowerCase();
            String studio = studioTxt.getText().toLowerCase();
            String console = consoleTxt.getText().toLowerCase();

            // Filters gamesStored based on user input; empty fields are ignored
            List<gameAttributes> filteredList = gamesStored.stream()
                .filter(game -> title.isEmpty() || game.getTitle().toLowerCase().contains(title))
                    .filter(game -> genre.isEmpty() || game.getGenre().toLowerCase().contains(genre))
                    .filter(game -> studio.isEmpty() || game.getStudio().toLowerCase().contains(studio))
                    .filter(game -> console.isEmpty() || game.getConsole().toLowerCase().contains(console))

                    .collect(Collectors.toList()); //Collects results

            filteredGames(filteredList); // adds filtered games to the list
        }

        public void filteredGames(List<gameAttributes> games) {
            resultArea.setText(""); // Clears the previous results

            if(games.isEmpty()) {
                resultArea.append("No Games Found");
            } else {
                // Loops through each game in the filtered list and displays its details in resultArea
                for(gameAttributes game : gamesStored) {
                    resultArea.append("Title: " + game.getTitle() + "\n");
                    resultArea.append("Genre: " + game.getGenre() + "\n");
                    resultArea.append("Studio: " + game.getStudio() + "\n");
                    resultArea.append("Console: " + game.getConsole() + "\n");
                    resultArea.append("\n");
                }
            }

        }
    // This is to exit this class
        public void exitCall() {
        viewGamesFrame.dispose();
            if (mainMenuRunnable != null) {
                mainMenuRunnable.run();
            }
        }

}
