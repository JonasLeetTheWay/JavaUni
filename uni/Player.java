public class Player {

    private static int counter;
    private int id;
    private String playerName;
    private Player nextPlayer;

    public Player(String playerName) {
        this.playerName = playerName;
        this.id = getCounter();
        counter++;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getID() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }
}
