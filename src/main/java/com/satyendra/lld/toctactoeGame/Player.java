package com.satyendra.lld.toctactoeGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

    private String name;
    private Piece piece;
}
