public abstract class Game {
    protected int min; // Minimum number for the range
    protected int max; // Maximum number for the range

    /**
     * Constructs a new Game with a specified range.
     */
    public Game(int min, int max) {
        this.min = min;
        this.max = max;
    }

    // Abstract method to play the game, to be implemented by subclasses
    public abstract void play();
}