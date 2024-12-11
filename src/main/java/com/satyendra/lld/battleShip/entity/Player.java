package com.satyendra.lld.battleShip.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {

    private String name;
    private List<Ship> ships;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public void addShip(Ship ship) throws Exception {
        if (validateNewShip(ship)) {
            ships.add(ship);
        } else {
            throw new Exception("Already one ship at same position");
        }
    }

    private boolean validateNewShip(Ship ship) {

        for (Ship existingShip : ships) {
            for (String coordinate : ship.getShipOccupied()) {
                if (existingShip.getShipOccupied().contains(coordinate)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Ship checkHit(String coordinate) {

        for (Ship existingShip : ships) {
            if (existingShip.getShipOccupied().contains(coordinate)) {
                return existingShip;
            }
        }
        return null;
    }
}

