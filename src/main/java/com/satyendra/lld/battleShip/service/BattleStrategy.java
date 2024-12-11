package com.satyendra.lld.battleShip.service;

public interface BattleStrategy {
    int[] getMissileCoordinate(int lowerBound, int upperBound, int N);
}
