import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateGamesGui {
    private JFrame UpdateGamesFrame;
    private JTextField titleTxt, genreTxt, studioTxt, consoleTxt, searchTxt;
    private JTextArea resultArea;
    private JList<String> gamesList;
    private JButton searchButton, updateButton, exitButton;
    private DefaultListModel<String> gamesListModel;
    List<gameAttributes> gamesStored;
    List<gameAttributes> search;
    private gameAttributes selectedGame;
    private Runnable mainMenuRunnable;


    public UpdateGamesGui(List<gameAttributes> gamesStored, Runnable mainMenuRunnable) {
        this.gamesStored = gamesStored;
        this.mainMenuRunnable = mainMenuRunnable;
        //buildUpdateGamesGui();
    }


    public void buildUpdateGamesGui() {
        UpdateGamesFrame = new JFrame("Update Games");
        UpdateGamesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UpdateGamesFrame.setSize(800, 600);
        UpdateGamesFrame.setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel(new GridLayout(7,2,10,10));
        //panel.setLayout(new GridLayout(7,2,10,10));

        searchTxt = new JTextField();
        //searchButton = new JButton("Search by Title");
        //gamesList = new JComboBox<>();


        titleTxt = new JTextField();
        searchButton = new JButton("Search by Title");
        genreTxt = new JTextField();
        studioTxt = new JTextField();
        consoleTxt = new JTextField();
        //exit = new JTextField();




        panel.add(new JLabel("Search Game:"));
        panel.add(searchTxt);
        panel.add(new JLabel(""));
        panel.add(searchButton);

        //panel.add(new JLabel("Select Game:"));
        //panel.add(gamesList);


        panel.add(new JLabel("Enter Title"));
        //titleTxt = new JTextField();
        panel.add(titleTxt);

        panel.add(new JLabel("Enter Genre"));
        //genreTxt = new JTextField();
        panel.add(genreTxt);


        panel.add(new JLabel("Enter Studio"));
        //studioTxt = new JTextField();
        panel.add(studioTxt);

        panel.add(new JLabel("Enter Console"));
        //consoleTxt = new JTextField();
        panel.add(consoleTxt);

        //JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        updateButton = new JButton("Update Game");
        exitButton = new JButton("Exit");
        panel.add(updateButton);
        panel.add(exitButton);

        gamesListModel = new DefaultListModel<>();
        gamesList = new JList<>(gamesListModel);
        gamesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane gamesListScroller = new JScrollPane(gamesList);


        resultArea = new JTextArea(5, 30); // Making a text area to display results
        resultArea.setEditable(false); // Makes the text area non-editable
        resultArea.setLineWrap(true); // Wraps text lines that are too long
        resultArea.setWrapStyleWord(true); // Wraps lines at word boundaries

        JScrollPane resultScroller = new JScrollPane(resultArea); // Used to scroll the results

        UpdateGamesFrame.add(panel, BorderLayout.NORTH);
        UpdateGamesFrame.add(gamesListScroller, BorderLayout.WEST);
        UpdateGamesFrame.add(resultScroller, BorderLayout.CENTER);

        //panel.add(new JLabel("Exit"));
        //consoleTxt = new JTextField();
        //panel.add(consoleTxt);

        //gamesList = new JComboBox<>();
        //upDPanel1.add(new JLabel("Select Game:"));
        //upDPanel1.add(gamesList);

        //updateButton = new JButton("Update Games");

        // THis is the action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchForGames();
            }
        });

        // This is the action listener for the updating the games button
        gamesList.addListSelectionListener(e -> selectedGame());

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGames();
            }
        });

        // This is the action listener for the exiting the class
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitHere();
            }
        });


        //UpdateGamesFrame.add(panel, BorderLayout.NORTH);
       // UpdateGamesFrame.add(upDPanel1, BorderLayout.CENTER);
       // UpdateGamesFrame.add(updateButton, BorderLayout.SOUTH);

        UpdateGamesFrame.setLocationRelativeTo(null); // Centers the frame on screen
        UpdateGamesFrame.setVisible(true); // Makes the frame visible

    }
    // Get the title to search for from the text field and change it to lowercase
        private void searchForGames() {
            String searchForTitle = searchTxt.getText().toLowerCase();

            // Filter gamesStored list to find games with titles containing the search term
            search = gamesStored.stream().filter(game -> game.getTitle()
            .toLowerCase().contains(searchForTitle)).collect(Collectors.toList());

            // Clear the gamesListModel to prepare for new results
            gamesListModel.clear();

            // Add each found game's title to the gamesListModel
            for (gameAttributes game : search) {
                gamesListModel.addElement(game.getTitle());
            }
            if (search.isEmpty()) {
                resultArea.setText("No Games Found");
            } else {
                resultArea.setText("Select a game to Update");
            }
        }
            private void selectedGame() {
                int selectedIndex = gamesList.getSelectedIndex();

                // Check that a selection was made within bounds of the search list
                if (selectedIndex >= 0 && selectedIndex < search.size()) {

                    // Shows the selected game's details in the text fields for editing
                    selectedGame = search.get(selectedIndex);
                    titleTxt.setText(selectedGame.getTitle());
                    genreTxt.setText(selectedGame.getGenre());
                    studioTxt.setText(selectedGame.getStudio());
                    consoleTxt.setText(selectedGame.getConsole());
                }
            }
            private void updateGames() {
                // Check if a game has been selected before trying to update
                if(selectedGame != null) {
                    // Update the selected game's details
                    selectedGame.setTitle(titleTxt.getText());
                    selectedGame.setGenre(genreTxt.getText());
                    selectedGame.setStudio(studioTxt.getText());
                    selectedGame.setConsole(consoleTxt.getText());


                    // Confirm the update in resultArea
                    resultArea.setText("Game updated");
                    //searchForGames();
                } else {
                    resultArea.setText("Select a game to update");
                }
            }
            // This is to exit this class
            private void exitHere() {
                UpdateGamesFrame.dispose();
                if (mainMenuRunnable != null) {
                    mainMenuRunnable.run();
                }
            }
}
