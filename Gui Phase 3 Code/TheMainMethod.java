/*
Quintin Johnson
Oct 30, 2024
Cen 3024

This Starts the program

 */

import javax.swing.*;

public class TheMainMethod {
    public static void main(String[] args) {
        // This for the main menu in the terminal

        //TO CHECK MY PREVIOUS CODE COMMENT OUT MY GUI
        // CALL AND REMOVE THE // FROM THE CODE BELOW ME.

       //MainMenu calling = new MainMenu();
        //calling.Login();


        // This is calling the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui gui = new Gui();
                gui.startGui();
            }
        });

        }
    }
