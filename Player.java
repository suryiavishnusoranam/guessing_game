public class Player {
    private String name; //Name of Player
    private int attempts; //Number of attempts left

    public Player(String name, int attempts) { //Gets the player's name
        this.name = name;
        this.attempts = attempts;
    }

    public String getName() { //Gets the player's name
        return name;
    }

    public int getAttempts() {//Gets the number of attempts left

        return attempts;
    }

    public void decrementAttempts() {// Decrements the number of attempts by one

        attempts--;
    }
}
