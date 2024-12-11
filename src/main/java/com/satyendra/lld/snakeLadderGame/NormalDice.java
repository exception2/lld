package com.satyendra.lld.snakeLadderGame;

import java.util.Random;

public class NormalDice implements DiceStrategy {
    Random random = new Random();
    @Override
    public int rollDice() {
        return random.nextInt(1, 7);
    }
}
