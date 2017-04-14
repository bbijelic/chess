package com.github.bbijelic.chess.piece;

import com.github.bbijelic.chess.core.Color;

/**
 * Piece
 * 
 * @author Bojan Bijelić
 */
public abstract class Piece {
    
    /**
     * Constructor
     * 
     * @param color the piece color
     */
    public Piece(Color color){
        this.color = color;
    }
    
    /**
     * Color
     */
    protected Color color;
    
    /**
     * Color getter
     * 
     * @return the color
     */
    public Color getColor() {
        return color;
    }
        
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Piece [color=");
        builder.append(color);
        builder.append("]");
        return builder.toString();
    }
    
}
