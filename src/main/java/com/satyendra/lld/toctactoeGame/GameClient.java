package com.satyendra.lld.toctactoeGame;

public class GameClient {
    public static void main(String[] args) throws Exception {
        TictactoeGame game = new TictactoeGame(3);
        game.addPlayer(new Player("Satyendra", PieceFactory.getPiece(PieceType.X)));
        game.addPlayer(new Player("Mahendra", PieceFactory.getPiece(PieceType.O)));

        game.startGame();
    }
}
