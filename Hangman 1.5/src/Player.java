public class Player {

    private String name;
    private int guesses;
    private int points;

    public Player(String name){
        this.name = name;
        guesses = 0;
        points = 0;

    }
    public String getName() {
        return name;
    }

    public int increaseGuesses() {
        return guesses++;
    }

    public int increasePoints() {

        return points++;
    }

    public String toString() {
        return name + " har gjort " + guesses + " fel gissningar och har " + points + " rätt gissningar";
    }
}
