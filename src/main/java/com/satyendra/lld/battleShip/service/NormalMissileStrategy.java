package com.satyendra.lld.battleShip.service;

import java.util.Random;

public class NormalMissileStrategy implements BattleStrategy {

    Random random;

    public NormalMissileStrategy(Random random) {
        this.random = random;
    }

    @Override
    public int[] getMissileCoordinate(int lowerBound, int upperBound, int N) {

        int x = random.nextInt(lowerBound, upperBound + 1);
        int y = random.nextInt(0, N);
        return new int[]{x, y};
    }
}

