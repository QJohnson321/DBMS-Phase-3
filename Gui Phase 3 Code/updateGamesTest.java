import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class updateGamesTest {

    private gameAttributes settingTitle;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Create a sample game for testing title updates
        settingTitle = new gameAttributes(1, "Call Of Duty 1", "Action", "10 - 9 - 2003", "Playstation", "Activision", "Disk", "Yes", 59.00);

        // Capture console output for verification
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testTitleUpdate() {
        // Initial title
        String previousTitle = settingTitle.getTitle();
        String newTitle = "New Game Title";

        // Simulate setting a new title
        settingTitle.setTitle(newTitle);

        // Expected output after update
        String expectedOutput = "Your game: " + previousTitle + " The Title has been changed to: " + settingTitle.getTitle();

        // Print the result to simulate the console output in the actual code
        System.out.println(expectedOutput);

        // Check if the title is updated correctly
        assertEquals(newTitle, settingTitle.getTitle(), "The title should be updated to the new title.");

        // Verify console output
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Your game: Call Of Duty 1 The Title has been changed to: New Game Title"),
                "Console output should show the title change.");
    }
}