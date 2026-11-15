package footballmanagementsystem;

import java.util.*;

public class Player {
    private String playerName;
    private final String playerID;
    private String position;
    private int goalsScored;
    private static final HashTable playerTable = new HashTable(100);

    public Player(String playerName, String playerID, String position, int goalsScored) {
        this.playerName = playerName;
        this.playerID = UUID.randomUUID().toString();
        this.position = position;
        this.goalsScored = 0;
    }

    public String getPlayerName() { return playerName; }
    public String getPlayerID() { return playerID; }
    public String getPosition() { return position; }
    public int getGoalsScored() { return goalsScored; }

    public void setGoalsScored(int goalsScored) { this.goalsScored = goalsScored; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public void setPosition(String position) { this.position = position; }

    public static void addPlayer(Player player) {
        if (!playerTable.searchLinear(player.getPlayerID().hashCode())) {
            playerTable.putLinear(player.getPlayerID().hashCode());
            System.out.println("Player added: " + player.getPlayerName());
        } else {
            System.out.println("Player with ID " + player.getPlayerID() + " already exists.");
        }
    }

    public static void updatePlayerProfile(String newPlayerName, String newPosition, int newGoalsScored, Player player) {
        if (player != null) {
            if (player.getPlayerName() == null ? newPlayerName != null : !player.getPlayerName().equals(newPlayerName)) {
                player.setPlayerName(newPlayerName);
            }
            if (player.getPosition() == null ? newPosition != null : !player.getPosition().equals(newPosition)) {
                player.setPosition(newPosition);
            }
            if (player.getGoalsScored() != newGoalsScored) {
                player.setGoalsScored(newGoalsScored);
            }
        }
    }
}