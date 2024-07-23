public abstract class Game {
    protected int min;
    protected int max;

    public Game(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public abstract void play();
}
