package com.github.bbijelic.chess.board;

import java.util.Optional;

import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.Piece;

/**
 * Square
 * 
 * @author Bojan Bijelić
 */
public class Square {
        
    /**
     * Constructor
     * 
     * @param color the square color
     */
    public Square(final Color color){
        this.color = color;
    }
    
    /**
     * Constructor
     * 
     * @param color the square color
     * @param piece the piece occupying the square
     */
    public Square(final Color color, final Piece piece){
        this.color = color;
        this.piece = Optional.of(piece);
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
        
    /**
     * Piece
     */
    private Optional<Piece> piece = Optional.empty();
    
    /**
     * Piece getter
     * 
     * @return the piece optional
     */
    public Optional<Piece> getPiece() {
        return piece;
    }
    
    /**
     * Piece setter
     * 
     * @param piece the piece
     */
    public void setPiece(Piece piece) {
        this.piece = Optional.of(piece);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Square [color=");
        builder.append(color);
        builder.append(", piece=");
        builder.append(piece);
        builder.append("]");
        return builder.toString();
    }
    
}
