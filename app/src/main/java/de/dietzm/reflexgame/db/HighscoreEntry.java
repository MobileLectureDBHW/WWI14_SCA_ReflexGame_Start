package de.dietzm.reflexgame.db;

/**
 * Created by michael on 10.11.16.
 */
public class HighscoreEntry {

    private String playerName;
    private int level;
    private int points;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
