package com.satyendra.lld.battleShip.service;

import com.satyendra.lld.battleShip.entity.BattleField;
import com.satyendra.lld.battleShip.entity.Player;
import com.satyendra.lld.battleShip.entity.Ship;
import com.satyendra.lld.battleShip.enums.BattleStatus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Data
@Slf4j
public class BattleFieldGame {

    private BattleField battleField;
    private Player playerOne;
    private Player playerTwo;
    private BattleStatus battleStatus;
    private Set<String> playerOneHits;
    private Set<String> playerTwoHits;
    private BattleStrategy battleStrategy;

    public BattleFieldGame(BattleField battleField, Player playerOne, Player playerTwo, BattleStrategy battleStrategy) {
        this.battleField = battleField;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.battleStatus = BattleStatus.NOT_STARTED;
        playerOneHits = new HashSet<>();
        playerTwoHits = new HashSet<>();
        this.battleStrategy = battleStrategy;
    }

    public void initGame(int N) throws Exception {
        battleField.createBoard(N);
        if(BattleStatus.NOT_STARTED == battleStatus) {
            battleStatus = BattleStatus.INITIALIZED;
        } else {
            throw new Exception("[initGame] Battle Status is not in correct status : " + battleStatus);
        }
    }

    public void addShip(String id, int size, int x1, int y1, int x2, int y2) throws Exception {
        if(BattleStatus.INITIALIZED != battleStatus) {
            throw new Exception("[addShip] Battle Status is not in correct status : " + battleStatus);
        }
        Ship shipOne = null, shipTwo = null;
        if(playerOneCoordinateValidation(size, battleField.getN(), x1, y1)) {
            shipOne = new Ship(id, size, x1, y1);
        } else {
            throw new Exception("Ship coordinate or size is not correct for player one");
        }
        if(playerTwoCoordinateValidation(size, battleField.getN(), x2, y2)) {
            shipTwo = new Ship(id, size, x2, y2);
        } else {
            throw new Exception("Ship coordinate or size is not correct for player two");
        }

        playerOne.addShip(shipOne);
        playerTwo.addShip(shipTwo);

        battleField.addShipLocation(shipOne, playerOne.getName());
        battleField.addShipLocation(shipTwo, playerTwo.getName());
    }

    public void startGame() throws Exception {
        if (BattleStatus.INITIALIZED != battleStatus) {
            throw new Exception("[addShip] Battle Status is not in correct status : " + battleStatus);
        } else {
            battleStatus = BattleStatus.RUNNING;
        }
        Player currentPlayer = playerOne;
        int n = battleField.getN();
        while (true) {
            if(currentPlayer.getName().equals(playerOne.getName())) {
                int lowerBound = n/2;
                int upperBound = n-1;
                int[] coordinate = battleStrategy.getMissileCoordinate(lowerBound, upperBound, battleField.getN());
                String coord = coordinate[0] + "," + coordinate[1];
                while(playerOneHits.contains(coord)) {
                    coordinate = battleStrategy.getMissileCoordinate(lowerBound, upperBound, battleField.getN());
                    coord = coordinate[0] + "," + coordinate[1];
                }
                Ship deestroyedShip = playerTwo.checkHit(coord);
                if(deestroyedShip != null) {
                    playerTwo.getShips().remove(deestroyedShip);
                    battleField.updateDestroy(deestroyedShip);
                    System.out.println("PlayerA’s turn : Missile fired at " + coord + " Hits " + " PlayerB’s ship with id " + deestroyedShip.getName() + " destroyed");
                } else {
                    System.out.println("PlayerA’s turn : Missile fired at " + coord + " Miss! ");
                }
                playerOneHits.add(coord);
                if(playerTwo.getShips().isEmpty()) {
                    System.out.println("GameOver. PlayerA wins.");
                    break;
                }
                currentPlayer = playerTwo;
            } else {
                int lowerBound = 0;
                int upperBound = n/2-1;
                int[] coordinate = battleStrategy.getMissileCoordinate(lowerBound, upperBound, battleField.getN());
                String coord = coordinate[0] + "," + coordinate[1];
                while(playerTwoHits.contains(coord)) {
                    coordinate = battleStrategy.getMissileCoordinate(lowerBound, upperBound, battleField.getN());
                    coord = coordinate[0] + "," + coordinate[1];
                }
                Ship deestroyedShip = playerOne.checkHit(coord);
                if(deestroyedShip != null) {
                    playerOne.getShips().remove(deestroyedShip);
                    battleField.updateDestroy(deestroyedShip);
                    System.out.println("PlayerB’s turn : Missile fired at " + coord + " Hits! " + " PlayerA’s ship with id " + deestroyedShip.getName() + " destroyed");
                } else {
                    System.out.println("PlayerB’s turn : Missile fired at " + coord + " Miss! ");
                }
                playerTwoHits.add(coord);
                if(playerOne.getShips().isEmpty()) {
                    System.out.println("GameOver. PlayerB wins!");
                    break;
                }
                currentPlayer = playerOne;
            }

        }
        battleStatus = BattleStatus.ENDED;
    }

    private boolean playerOneCoordinateValidation(int size, int n, int x, int y) {
        return (size >= 1 && size <= n/2 && x>=0 && y>=0 && x<n/2 && y<n && x>=(size-1) && y>=(size-1));
    }

    private boolean playerTwoCoordinateValidation(int size, int n, int x, int y) {
        return (size >= 1 && size <= n/2 && x>=n/2 && y>=0 && x<n && y<n && x>=(size-1) && y>=(size-1));
    }
}

