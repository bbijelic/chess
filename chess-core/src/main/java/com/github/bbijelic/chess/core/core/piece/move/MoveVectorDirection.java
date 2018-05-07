package com.github.bbijelic.chess.core.core.piece.move;

import java.util.List;

/**
 * Move vector direction.
 *
 * @author Bojan Bijelić
 */
public class MoveVectorDirection {

    /**
     * Constructor
     *
     * @param moveVectors the move vectors
     * @param moveType    the move type
     */
    public MoveVectorDirection(final List<MoveVector> moveVectors, final MoveType moveType){
        this.moveVectors = moveVectors;
        this.moveType = moveType;
    }

    /**
     * Move vectors
     */
    private List<MoveVector> moveVectors;

    /**
     * Returns list of move vectors
     *
     * @return the move vectors
     */
    public List<MoveVector> getMoveVectors(){
        return moveVectors;
    }

    /**
     * Move type
     */
    private MoveType moveType;

    /**
     * Returns the move type
     *
     * @return the move type
     */
    public MoveType getMoveType(){
        return moveType;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("MoveVectorDirection [moveVectors=");
        builder.append(moveVectors);
        builder.append(", moveType=");
        builder.append(moveType);
        builder.append("]");
        return builder.toString();
    }
}
