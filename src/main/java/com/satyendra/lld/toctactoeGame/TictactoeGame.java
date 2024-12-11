package com.satyendra.lld.toctactoeGame;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TictactoeGame {

    private Deque<Player> players;
    private Board board;
    private int size;
    private boolean status = false;
    private Scanner scanner;

    public TictactoeGame(int size) {
        players = new LinkedList<>();
        board = new Board(size);
        scanner = new Scanner(System.in);
    }

    public void startGame() throws Exception {
        board.initialize();
        if(status) {
            throw new Exception("Already game running");
        }
        status = true;
        while(true) {
            board.printBoard();
            Player currentPlayer = players.removeFirst();
            System.out.print(currentPlayer.getName() + "'s turn : Please enter X and Y coordinate -> ");
            String[] input = scanner.nextLine().split(",");
            int x = Integer.parseInt(input[0].trim());
            int y = Integer.parseInt(input[1].trim());
            if(!board.placePiece(x, y, currentPlayer)) {
                System.out.println("Wrong move, try again");
                players.addFirst(currentPlayer);
            }
            if(board.isWinner(currentPlayer)) {
                System.out.println(currentPlayer.getName() + "'s won!!");
                break;
            } else {
                players.addLast(currentPlayer);
            }
            if(board.findAllFreePiece().isEmpty()) {
                System.out.println("Game tie!!");
                break;
            }
        }
        board.printBoard();
    }

    public void addPlayer(Player player) {
        if(status) System.out.println("Game is running, so can't add player now");
        players.add(player);
    }

}
