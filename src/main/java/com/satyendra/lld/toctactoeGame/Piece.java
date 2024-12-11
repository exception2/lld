package com.satyendra.lld.toctactoeGame;

import lombok.Data;

@Data
public abstract class Piece {
    PieceType pieceType;

    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
