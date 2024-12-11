package com.satyendra.lld.snakeLadderGame;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {

    private List<Player> players;
    private int currentPlayerTurn;

    public Game() {
        this.currentPlayerTurn = 0;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void notifyPlayers(String message) {
        for(Player player : players) {
            player.logPrint(message);
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerTurn);
    }

    public void nextTurn() {
        currentPlayerTurn = (currentPlayerTurn + 1) % players.size();
    }
}
