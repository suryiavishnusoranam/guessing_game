/**
 * Main class to run the Guessing Game.
 */
public class Main {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame(1, 100); // Create a new game with a range of 1 to 100
        game.play(); // Start the game
    }
}
