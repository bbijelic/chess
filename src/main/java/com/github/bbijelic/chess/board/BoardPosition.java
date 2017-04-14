package com.github.bbijelic.chess.board;

import java.util.Objects;

import com.github.bbijelic.chess.piece.move.MoveVector;

/**
 * Board position
 * 
 * @author Bojan Bijelić
 */
public class BoardPosition {
        
    /**
     * Constructor
     * 
     * @param rank the board rank
     * @param file the board file
     */
    public BoardPosition(final int rank, final int file) {
        this.rank = rank;
        this.file = file;
    }
    
    /**
     * Board rank
     */
    private int rank;
    
    /**
     * Rank getter
     * 
     * @return the rank
     */
    public int getRank() {
        return rank;
    }
        
    /**
     * File
     */
    private int file;
    
    /**
     * File getter
     * 
     * @return the file
     */
    public int getFile() {
        return file;
    }
    
    /**
     * Applies move vector to the board position and returns new board position
     * 
     * @return the board position with applied move vector
     */
    public BoardPosition applyMoveVector(final MoveVector moveVector){
        return new BoardPosition(
            this.rank + moveVector.getRankVector(), 
            this.file + moveVector.getFileVector());
    }
    
    /**
     * Validates if board position is inside board boundaries
     * 
     * @return true if valid, false otherwise
     */
    public boolean isValid(){
        return (rank >= 0 && rank <= 7 && file >= 0 && file <=7 ) ? true : false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(rank, file);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BoardPosition){
            BoardPosition other = (BoardPosition)obj;
            if(this.rank == other.getRank() && this.file == other.getFile()) return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BoardPosition [rank=");
        builder.append(rank);
        builder.append(", file=");
        builder.append(file);
        builder.append("]");
        return builder.toString();
    }
}
