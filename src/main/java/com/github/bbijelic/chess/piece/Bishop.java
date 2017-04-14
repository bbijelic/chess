package com.github.bbijelic.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.move.MoveType;
import com.github.bbijelic.chess.piece.move.MoveVector;

/**
 * Bishop piece
 * 
 * @author Bojan Bijelić
 */
@SuppressWarnings("serial")
public class Bishop extends Piece {
    
    /**
     * Move vectors for the bishop
     */
    public static List<MoveVector> MOVE_VECTORS = new ArrayList<MoveVector>(){
        {
            // Down Right
            add(new MoveVector(1, 1, MoveType.NORMAL));
            add(new MoveVector(2, 2, MoveType.NORMAL));
            add(new MoveVector(3, 3, MoveType.NORMAL));
            add(new MoveVector(4, 4, MoveType.NORMAL));
            add(new MoveVector(5, 5, MoveType.NORMAL));
            add(new MoveVector(6, 6, MoveType.NORMAL));
            add(new MoveVector(7, 7, MoveType.NORMAL));
            
            // Down Left
            add(new MoveVector(1, -1, MoveType.NORMAL));
            add(new MoveVector(2, -2, MoveType.NORMAL));
            add(new MoveVector(3, -3, MoveType.NORMAL));
            add(new MoveVector(4, -4, MoveType.NORMAL));
            add(new MoveVector(5, -5, MoveType.NORMAL));
            add(new MoveVector(6, -6, MoveType.NORMAL));
            add(new MoveVector(7, -7, MoveType.NORMAL));
            
            // Up Left
            add(new MoveVector(-1, -1, MoveType.NORMAL));
            add(new MoveVector(-2, -2, MoveType.NORMAL));
            add(new MoveVector(-3, -3, MoveType.NORMAL));
            add(new MoveVector(-4, -4, MoveType.NORMAL));
            add(new MoveVector(-5, -5, MoveType.NORMAL));
            add(new MoveVector(-6, -6, MoveType.NORMAL));
            add(new MoveVector(-7, -7, MoveType.NORMAL));
            
            // Up Right
            add(new MoveVector(-1, 1, MoveType.NORMAL));
            add(new MoveVector(-2, 2, MoveType.NORMAL));
            add(new MoveVector(-3, 3, MoveType.NORMAL));
            add(new MoveVector(-4, 4, MoveType.NORMAL));
            add(new MoveVector(-5, 5, MoveType.NORMAL));
            add(new MoveVector(-6, 6, MoveType.NORMAL));
            add(new MoveVector(-7, 7, MoveType.NORMAL));
            
        }
    };
    
    /**
     * Constructor
     * 
     * @param color the bishop color
     */
    public Bishop(Color color) {
        super(color);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Bishop [piece=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
