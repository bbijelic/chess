package com.github.bbijelic.chess.board;

import java.util.Objects;

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
