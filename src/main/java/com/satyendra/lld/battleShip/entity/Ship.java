package com.satyendra.lld.battleShip.entity;

import jakarta.annotation.PostConstruct;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Ship {

    private String name;
    private int size;
    private int x;
    private int y;
    private Set<String> shipOccupied;

    public Ship(String name, int size, int x, int y) {
        this.name = name;
        this.size = size;
        this.x = x;
        this.y = y;
        shipOccupied = new HashSet<>();
        for(int i = x ; i > (x-size) ; i--) {
            for(int j = y ; j > (y-size) ; j--) {
                shipOccupied.add(i + "," + j);
            }
        }
        //setShipOccupied(size, x, y);
    }

    private void setShipOccupied(int size, int x, int y) {
        // Assuming x, y is right top coordinate
        for(int i = x ; i > (x-size) ; i--) {
            for(int j = y ; j > (y-size) ; j--) {
                shipOccupied.add(x + "," + y);
            }
        }
    }
}

