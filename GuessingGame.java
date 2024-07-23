import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame extends Game {
    private static final int MAX_ATTEMPTS = 5;

    public GuessingGame(int min, int max) {
        super(min, max);
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(max - min + 1) + min;
        Map<String, Player> players = new HashMap<>();

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName, MAX_ATTEMPTS);
        players.put(playerName, player);

        System.out.println("Welcome to the Guessing Game, " + playerName + "!");
        System.out.println("I have chosen a number between " + min + " and " + max + ". Can you guess it?");

        while (player.getAttempts() > 0) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            player.decrementAttempts();

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }

            if (player.getAttempts() == 0) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess);
            } else {
                System.out.println("You have " + player.getAttempts() + " attempts left.");
            }
        }

        savePlayerData(player);
        scanner.close();
    }

    // Method to save player data to a file
    public void savePlayerData(Player player) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("player_data.txt", true))) {
            writer.write("Player: " + player.getName() + ", Attempts left: " + player.getAttempts());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving player data.");
        }
    }
}