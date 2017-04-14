package com.github.bbijelic.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.move.MoveVector;

/**
 * Queen
 * 
 * @author Bojan Bijelić
 */
@SuppressWarnings("serial")
public class Queen extends Piece {
    
    /**
     * Move vectors for the queen
     */
    public static List<MoveVector> MOVE_VECTORS = new ArrayList<MoveVector>(){
        {
            addAll(Rook.MOVE_VECTORS);
            addAll(Bishop.MOVE_VECTORS);
        }
    };
    
    /**
     * Constructor
     * 
     * @param color the queen color
     */
    public Queen(Color color) {
        super(color);
    }
        
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queen [piece=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
