import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// This test if the view game methods are working

public class viewGameTest1 {

    private viewGame viewGame;
    private List<gameAttributes> gamesStored;
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        gamesStored = new ArrayList<>();

        // Add sample games for testing
        gamesStored.add(new gameAttributes(1, "Call Of Duty 1", "Action", "10 - 9 - 2003", "Playstation", "Activision", "Disk", "Yes", 59.00));

        viewGame = new viewGame(gamesStored);

        // Capture console output for verification
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testFilterByTitle_Found() {
        // Test for a title that exists
        String title = "Adventure";

        viewGame.filterByTitle(title, gamesStored);

        // Verify the output contains the filtered title
        String output = outputStream.toString();
        assertTrue(output.contains("Call Of Duty 1"), "Expected to find 'Adventure Quest' in the output.");
        assertTrue(output.contains("Mystic Adventure"), "Expected to find 'Mystic Adventure' in the output.");
        //assertFalse(output.contains("Space Invaders"), "Did not expect to find 'Space Invaders' in the output.");
    }

    @Test
    void testFilterByTitle_NotFound() {
        // Test for a title that does not exist
        String title = "Nonexistent Game";

        viewGame.filterByTitle(title, gamesStored);

        // Verify the output shows all games when no title matches
        String output = outputStream.toString();
        assertTrue(output.contains("Title not found Nonexistent Game"), "Expected 'Title not found' message.");
        assertTrue(output.contains("Call Of Duty 1"), "Expected game to be displayed.");

    }
}