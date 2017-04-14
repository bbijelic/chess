package com.github.bbijelic.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.move.MoveType;
import com.github.bbijelic.chess.piece.move.MoveVector;

/**
 * Knight piece
 * 
 * @author Bojan Bijelić
 */
@SuppressWarnings("serial")
public class Knight extends Piece {
    
    /**
     * Move vectors for the knight
     */
    public static List<MoveVector> MOVE_VECTORS = new ArrayList<MoveVector>(){
        {
            add(new MoveVector(-2, 1, MoveType.NORMAL));
            add(new MoveVector(-1, 2, MoveType.NORMAL));
            add(new MoveVector(1, 2, MoveType.NORMAL));
            add(new MoveVector(2, 1, MoveType.NORMAL));
            add(new MoveVector(2, -1, MoveType.NORMAL));
            add(new MoveVector(1, -2, MoveType.NORMAL));
            add(new MoveVector(-1, -2, MoveType.NORMAL));
            add(new MoveVector(-2, -1, MoveType.NORMAL));
        }
    };
    
    /**
     * Constructor
     * 
     * @param color the knight color
     */
    public Knight(Color color) {
        super(color);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Knight [piece=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
