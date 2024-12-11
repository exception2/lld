package com.satyendra.lld.snakeLadderGame;

public class MoveCommand implements Command {
    private Player player;
    private Board board;
    private int steps;

    public MoveCommand(Player player, Board board, int steps) {
        this.player = player;
        this.board = board;
        this.steps = steps;
    }

    @Override
    public void execute() {
        int newPosition = player.getPosition() + steps;
        if(newPosition > board.size) {
            newPosition = player.getPosition();
        }
        if(board.getSnakes().containsKey(newPosition)) {
            newPosition = board.getSnakes().get(newPosition);
        }
        if(board.getLadders().containsKey(newPosition)) {
            newPosition = board.getLadders().get(newPosition);
        }
        player.setPosition(newPosition);
    }
}
