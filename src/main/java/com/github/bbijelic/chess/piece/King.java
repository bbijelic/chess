package com.github.bbijelic.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.move.MoveType;
import com.github.bbijelic.chess.piece.move.MoveVector;

/**
 * King
 * 
 * @author Bojan Bijelić
 */
@SuppressWarnings("serial")
public class King extends Piece {
    
    /**
     * Move vectors for the King
     */
    public static List<MoveVector> MOVE_VECTORS = new ArrayList<MoveVector>(){
        {
            add(new MoveVector(-1, 0, MoveType.KING_MOVE));
            add(new MoveVector(-1, -1, MoveType.KING_MOVE));
            add(new MoveVector(0, 1, MoveType.KING_MOVE));
            add(new MoveVector(1, 1, MoveType.KING_MOVE));
            add(new MoveVector(1, 0, MoveType.KING_MOVE));
            add(new MoveVector(1, -1, MoveType.KING_MOVE));
            add(new MoveVector(0, -1, MoveType.KING_MOVE));
            add(new MoveVector(-1, -1, MoveType.KING_MOVE));
            add(new MoveVector(0, 3, MoveType.KING_SIDE_CASTILING));
            add(new MoveVector(0, -4, MoveType.QUEEN_SIDE_CASTLING));
        }
    };
    
    /**
     * Constructor
     * 
     * @param color the King color
     */
    public King(Color color) {
        super(color);
    }
        
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("King [piece=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
