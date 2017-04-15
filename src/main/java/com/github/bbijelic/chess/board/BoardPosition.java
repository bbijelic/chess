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
     * Constructor
     * 
     * @param squareName the human readable square name, e.g. h3
     */
    public BoardPosition(final String squareName){
        final String fileStr = String.valueOf(squareName.charAt(0));
        for(int f = 0; f < 8; f++) {
            if(FILE_LETTERS[f].equalsIgnoreCase(fileStr)){
                this.file = f;
            }
        }
        
        this.rank = 8 - Character.getNumericValue(squareName.charAt(1)); 
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
    
    /**
     * File letters
     */
    private static final String[] FILE_LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h"};
    
    /**
     * Returns human readable name of the square,e.g. f4
     * 
     * @return the name of the square
     */
    public String getSquareName(){
        StringBuilder squareName = new StringBuilder(2);
        squareName.append(FILE_LETTERS[file]);
        squareName.append(8-rank);
        return squareName.toString();
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
