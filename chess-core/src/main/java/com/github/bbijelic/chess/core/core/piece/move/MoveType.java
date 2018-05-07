package com.github.bbijelic.chess.core.core.piece.move;

/**
 * Type of the move
 */
public enum MoveType {
    
    /**
     * Used for all pieces but pawn
     */
    NORMAL,
    
    /**
     * Pawn normal capture
     */
    PAWN_CAPTURE,
    
    /**
     * Pawn single step move forward
     */
    PAWN_SINGLE_STEP_MOVE, 
    
    /**
     * Pawn first move; double step forward
     */
    PAWN_DOUBLE_STEP_MOVE,
    
    /**
     * Pawn en passant move
     */
    PAWN_EN_PASSANT, 
    
    /**
     * Castling on the king side; Only king and rook
     */
    KING_SIDE_CASTILING, 
    
    /**
     * Castling on the queen side; Only king and rook
     */
    QUEEN_SIDE_CASTLING,
    
    /**
     * King move
     */
    KING_MOVE;
    
}
