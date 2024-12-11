package com.satyendra.lld.battleShip;

import com.satyendra.lld.battleShip.entity.BattleField;
import com.satyendra.lld.battleShip.entity.Player;
import com.satyendra.lld.battleShip.service.BattleFieldGame;
import com.satyendra.lld.battleShip.service.BattleStrategy;
import com.satyendra.lld.battleShip.service.NormalMissileStrategy;

import java.util.Random;

public class BattleShipGameClient {
    public static void main(String[] args) throws Exception {
        Player one = new Player("A");
        Player two = new Player("B");
        BattleField battleField = new BattleField();

        BattleStrategy battleStrategy = new NormalMissileStrategy(new Random());
        BattleFieldGame battleFieldGame = new BattleFieldGame(battleField, one , two, battleStrategy);
        battleFieldGame.initGame(6);
        battleFieldGame.addShip("SH1", 2, 2, 5, 4, 4);
        battleField.viewBattleField();
        battleFieldGame.startGame();
        battleField.viewBattleField();
    }

	/*
	Player
	Ship
	BattleField
	FireStrategy
	BattleShipGame
	* */

	/*
	player
	 - name

	ship
	 - name
	 - player_id

	game_board
	coordinate
	 - x
	 - y
	 - status
	 - ship_id
	fire_history
	- x
	- y
	- player_id
	- action

	enum
	* */
}
