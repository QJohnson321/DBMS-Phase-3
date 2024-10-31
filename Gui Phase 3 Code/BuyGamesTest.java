import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

// This test show examples of checking items in the cart are empty and
// test the checkout method

public class BuyGamesTest {
    private BuyGames buyGames;
    private List<gameAttributes> gamesStored;
    private List<cartSetup> userCart;
    private double theTotal;

    @BeforeEach
    public void setUp() {
        // Initialize an empty cart and set total balance to zero
        userCart = new ArrayList<>();
        gamesStored = new ArrayList<>();  // Initialize gamesStored if it’s required by BuyGames
        theTotal = 0.0;

        // Initialize BuyGames instance with necessary parameters
        buyGames = new BuyGames(gamesStored);  // Adjust constructor if needed
    }

    // Test for empty cart checkout
    @Test
    public void testCheckoutWithEmptyCart() {
        // Simulate user input to select checkout option
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run checkoutFinal
        buyGames.checkoutFinal();

        // Verify that the cart is empty
        assertTrue(userCart.isEmpty(), "The cart should be empty.");

        // Optionally, you can capture System.out output if checkoutFinal prints a message
    }
}

