package com.github.bbijelic.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.move.MoveType;
import com.github.bbijelic.chess.piece.move.MoveVector;
import com.github.bbijelic.chess.piece.move.MoveVectorDirection;

/**
 * Rook piece
 * 
 * @author Bojan Bijelić
 */
@SuppressWarnings("serial")
public class Rook extends Piece {
    
    /**
     * Move vectors for the rook
     */
    public static List<MoveVectorDirection> MOVE_VECTORS = new ArrayList<MoveVectorDirection>(){
        {
            add(new MoveVectorDirection(new ArrayList<MoveVector>(){{
                add(new MoveVector(0, -3));
            }}, MoveType.KING_SIDE_CASTILING));
            
            add(new MoveVectorDirection(new ArrayList<MoveVector>(){{
                add(new MoveVector(0, 4));
            }}, MoveType.QUEEN_SIDE_CASTLING));
            
            // Left
            add(new MoveVectorDirection(new ArrayList<MoveVector>(){{
                add(new MoveVector(0, -1));
                add(new MoveVector(0, -2));
                add(new MoveVector(0, -3));
                add(new MoveVector(0, -4));
                add(new MoveVector(0, -5));
                add(new MoveVector(0, -6));
                add(new MoveVector(0, -7));
            }}, MoveType.NORMAL));
            
            // Right
            add(new MoveVectorDirection(new ArrayList<MoveVector>(){{
                add(new MoveVector(0, 1));
                add(new MoveVector(0, 2));
                add(new MoveVector(0, 3));
                add(new MoveVector(0, 4));
                add(new MoveVector(0, 5));
                add(new MoveVector(0, 6));
                add(new MoveVector(0, 7));
            }}, MoveType.NORMAL));
            
            // Up
            add(new MoveVectorDirection(new ArrayList<MoveVector>(){{
                add(new MoveVector(-1, 0));
                add(new MoveVector(-2, 0));
                add(new MoveVector(-3, 0));
                add(new MoveVector(-4, 0));
                add(new MoveVector(-5, 0));
                add(new MoveVector(-6, 0));
                add(new MoveVector(-7, 0));
            }}, MoveType.NORMAL));
            
            // Down
            add(new MoveVectorDirection(new ArrayList<MoveVector>(){{
                add(new MoveVector(1, 0));
                add(new MoveVector(2, 0));
                add(new MoveVector(3, 0));
                add(new MoveVector(4, 0));
                add(new MoveVector(5, 0));
                add(new MoveVector(6, 0));
                add(new MoveVector(7, 0));
            }}, MoveType.NORMAL));
        }
    };
    
    /**
     * Constructor
     * 
     * @param color the rook color
     */
    public Rook(Color color) {
        super(color);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rook [piece=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
