package com.satyendra.lld.snakeLadderGame;

import java.util.Arrays;

public class SnakeLadderGame {
    public static void main(String[] args) {
        int size = 100;
        Board board = Board.getInstance(size);
        JumpFactory.createSnakes(board, Arrays.asList(new int[][]{{16, 6}, {48, 26}, {49, 11}, {56, 53}, {62, 19}, {64, 60}, {87, 24}, {93, 73}, {95, 75}, {98, 78}}));
        JumpFactory.createLadders(board, Arrays.asList(new int[][]{{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {80, 100}}));

        Game game = new Game();
        Player player1 = new Player("Satyendra");
        Player player2 = new Player("Mahendra");

        game.addPlayer(player1);
        game.addPlayer(player2);

        DiceStrategy dice = new NormalDice();

        while(true) {
            Player currentPlayer = game.getCurrentPlayer();
            int diceRoll = dice.rollDice();
            Command move = new MoveCommand(currentPlayer, board, diceRoll);
            String message = currentPlayer.getName() + " got " + diceRoll + " and moved " + currentPlayer.getPosition() + " to ";
            move.execute();
            message += currentPlayer.getPosition();
            game.notifyPlayers(message);

            if(currentPlayer.getPosition() == board.size) {
                game.notifyPlayers(currentPlayer.getName() + " wins!!");
                break;
            }
            game.nextTurn();
        }
    }
}
