package com.satyendra.lld.toctactoeGame;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {

    private int size;
    Piece[][] board;

    public Board(int size) {
        this.size = size;
    }

    public void initialize() {
        board = new Piece[size][size];
    }

    public boolean placePiece(int row, int col, Player player) {
        if(board[row][col] == null) {
            board[row][col] = player.getPiece();
            return true;
        }
        return false;
    }

    public List<int[]> findAllFreePiece() {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length; j++) {
                if(board[i][j] == null) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }

    public boolean isWinner(Player player) {
        for(int i = 0 ; i < size ; i++) {
            boolean winner = true;
            for(int j = 0 ; j < size ; j++) {
                if(!winner) {
                    break;
                } else if(board[i][j] == null) {
                    winner = false;
                    break;
                } else if(board[i][j] != player.getPiece()) {
                    winner = false;
                }
            }
            if(winner) return true;
        }
        for(int i = 0 ; i < size ; i++) {
            boolean winner = true;
            for(int j = 0 ; j < size ; j++) {
                if(!winner) {
                    break;
                } else if(board[j][i] != null ) {
                    winner = false;
                    break;
                }
                if(board[j][i] != player.getPiece()) {
                    winner = false;
                }
            }
            if(winner) return true;
        }
        int row = 0, col = 0;
        boolean winner = true;
        for(int i = 0 ; i < size ; i++) {
            if(!winner) {
                break;
            }
            else if(board[i+row][i+col] == null) {
                winner = false;
                break;
            }
            else if (board[i+row][i+col] != player.getPiece()) {
                winner = false;
            }
        }
        if(winner) {
            return true;
        }

        row = 0;
        col = size - 1;
        winner = true;
        for(int i = 0 ; i < size ; i++) {
            if(!winner) {
                break;
            }
            else if(board[i+row][col-i] == null) {
                winner = false;
                break;
            }
            else if (board[i+row][col-i] != player.getPiece()) {
                winner = false;
            }
        }
        if(winner) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        for(int i = 0; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length; j++) {
                if(board[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(board[i][j].getPieceType());
                }
                if(j != size - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
}
