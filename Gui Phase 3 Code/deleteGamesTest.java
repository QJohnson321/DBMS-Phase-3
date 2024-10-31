import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class deleteGamesTest {

    private deleteGames deleteGamesInstance;
    private List<gameAttributes> gamesStored;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        gamesStored = new ArrayList<>();

        // Add sample games for testing
        gamesStored.add(new gameAttributes(1, "Call Of Duty", "Action", "10 - 9 - 2003", "Playstation", "Activision", "Disk", "Yes", 59.00));
        gamesStored.add(new gameAttributes(2, "Halo", "Shooter", "10 - 11 - 2001", "Xbox", "Bungie", "Disk", "Yes", 49.00));
        gamesStored.add(new gameAttributes(3, "Call Of Duty 2", "Action", "02 - 10 - 2005", "Playstation", "Activision", "Disk", "Yes", 69.00));

        deleteGamesInstance = new deleteGames(gamesStored);

        // Capture console output for verification
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testStartToDeleteGames_NoGamesInStock() {
        // Clear the games list so it read that there are not games in stock
        gamesStored.clear();

        deleteGamesInstance.startToDeleteGames();

        // Verify output when no games are in stock
        String output = outputStream.toString().trim();
        assertTrue(output.contains("There are no games in the database"), "Expected message when no games are available.");
    }

    @Test
    void testDeleteGame_GameFound() {
        // Simulate deleting a game with "Call Of Duty" in the title
        String gameName = "Call Of Duty";

        deleteGamesInstance.deleteGame(gameName, gamesStored);

        // Verify that matching games are listed
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Games Found"), "Expected 'Games Found' message in the output.");
        assertTrue(output.contains("1. Call Of Duty"), "Expected 'Call Of Duty' to be listed as an option.");
        assertTrue(output.contains("2. Call Of Duty 2"), "Expected 'Call Of Duty 2' to be listed as an option.");
    }
}
