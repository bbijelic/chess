package com.github.bbijelic.chess.piece.move;

import java.util.Objects;

/**
 * Move vector contains imformation to which board position piece can move.
 * 
 * <p>For example, MoveVector[0,-1] means that piece can move forward one square</p>
 */
public class MoveVector {
    
    /**
     * Constructor
     * 
     * @param rankVector the rank vector
     * @param fileVector the file vector
     * @param moveType move type
     */
    public MoveVector(final int rankVector, final int fileVector, MoveType moveType) {            
        this.rankVector = rankVector;
        this.fileVector = fileVector;
        this.moveType = moveType;
    }
    
    /**
     * Move type. Used to validate move
     */
    private MoveType moveType;
    
    /**
     * Returns move type
     * 
     * @return the move type
     */
    public MoveType getMoveType() {
        return moveType;
    }
    
    /**
     * Rank vector
     */
    private int rankVector;
    
    /**
     * Returns rank vector
     * @return the rank vector
     */
    public int getRankVector() {
        return rankVector;
    }
    
    /**
     * File vector
     */
    private int fileVector;
    
    /**
     * Returns file vector
     * @return the file vector
     */
    public int getFileVector() {
        return fileVector;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(rankVector, fileVector);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MoveVector){
            MoveVector other = (MoveVector)obj;
            if(this.rankVector == other.getRankVector() && this.fileVector == other.getFileVector()) return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MoveVector [rankVector=");
        builder.append(rankVector);
        builder.append(", fileVector=");
        builder.append(fileVector);
        builder.append(", moveType=");
        builder.append(moveType);
        builder.append("]");
        return builder.toString();
    }
}
