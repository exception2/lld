package com.satyendra.lld.snakeLadderGame;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Board {

    private static Board board;
    int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    private Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public static Board getInstance(int size) {
        if(board == null) {
            board = new Board(size);
        }
        return board;
    }
}
