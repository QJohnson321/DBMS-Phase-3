import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//This test that displays an example of a game being added to the
// database.

import static org.junit.jupiter.api.Assertions.*;


public class addGameTest {
    private gameDatabase gameDatabase1;
    private List<gameAttributes> gamesStored;


    // Testing the database class
    private gameDatabase db;


    @BeforeEach
    public void setUp() {
        gameDatabase1 = new gameDatabase();
        gamesStored = new ArrayList<>();

    }




// This test adding a game
    @Test
    public void testAddGame() {
        // Create a new game
        gameAttributes newGame = new gameAttributes(21, "New Game Title", "Action", "10-10-2024",
                "PlayStation", "Studio Name", "Disk", "Yes", 59.99);

        // Add the game to the database
        gamesStored.add(newGame);

        // Assert that the game was added
        assertTrue(gameDatabase1.getGameStored().stream()
                .anyMatch(game -> game.getTitle().equals("New Game Title")));
    }

}


