package com.satyendra.lld.snakeLadderGame;

import java.util.List;

public class JumpFactory {
    public static void createSnakes(Board board, List<int[]> snakes) {
        for(int[] snake : snakes) {
            board.getSnakes().put(snake[0], snake[1]);
        }
    }

    public static void createLadders(Board board, List<int[]> ladders) {
        for(int[] ladder : ladders) {
            board.getSnakes().put(ladder[0], ladder[1]);
        }
    }
}
