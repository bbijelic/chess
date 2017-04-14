package com.github.bbijelic.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.move.MoveType;
import com.github.bbijelic.chess.piece.move.MoveVector;

/**
 * Pawn
 * 
 * @author Bojan Bijelić
 */
@SuppressWarnings("serial")
public class Pawn extends Piece {
    
    /**
     * Move vectors for the pawn
     */
    public static List<MoveVector> MOVE_VECTORS = new ArrayList<MoveVector>(){
        {
            add(new MoveVector(-1, 0, MoveType.PAWN_SINGLE_STEP_MOVE));
            add(new MoveVector(-2, 0, MoveType.PAWN_DOUBLE_STEP_MOVE));
            add(new MoveVector( 1, -1, MoveType.PAWN_EN_PASSANT));
            add(new MoveVector( 1, 1, MoveType.PAWN_EN_PASSANT));
            add(new MoveVector(-1, -1, MoveType.PAWN_CAPTURE));
            add(new MoveVector(-1, 1, MoveType.PAWN_CAPTURE));
        }
    };
    
    /**
     * Constructor
     * 
     * @param color the pawn color
     */
    public Pawn(Color color) {
        super(color);
    }
        
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pawn [piece=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
