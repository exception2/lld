package com.satyendra.lld.snakeLadderGame;

import lombok.Data;

@Data
public class Player implements Observer{

    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void logPrint(String message) {
        System.out.println(name + " -> " + message);
    }
}
