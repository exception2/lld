package com.satyendra.lld.toctactoeGame;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PieceFactory {

    public static Piece getPiece(PieceType type) {
        return switch (type) {
            case X -> new PieceX(PieceType.X);
            case O -> new PieceX(PieceType.O);
            default -> null;
        };
    }
}
