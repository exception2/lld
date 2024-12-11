package com.satyendra.lld.battleShip.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Data
@Slf4j
public class BattleField {

    private int n;
    private String[][] board;

    public BattleField() {

    }

    public void createBoard(int n) {
        this.n = n;
        board = new String[n][n];
        for(int i = 0 ; i < n ; i++) {
            Arrays.fill(board[i], "empty");
        }
    }

    public void addShipLocation(Ship ship, String playerName) {
        for(String coordinate : ship.getShipOccupied()) {
            String[] coo = coordinate.split(",");
            int x = Integer.parseInt(coo[0]);
            int y = Integer.parseInt(coo[1]);
            this.board[x][y] = playerName + "-"+ ship.getName();
        }
    }

    public void updateDestroy(Ship deestroyedShip) {
        for(String coordinate : deestroyedShip.getShipOccupied()) {
            String[] arr = coordinate.split(",");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);

            board[x][y] = "destroy";
        }
    }

    public void viewBattleField() {
        for(int i = 0 ; i < n ; i++) {
            for( int j = 0 ; j < n ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

