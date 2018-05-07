package com.github.bbijelic.chess.core.core.piece.move;

import java.util.Set;

import com.github.bbijelic.chess.core.core.board.Board;
import com.github.bbijelic.chess.core.core.board.BoardPosition;

/**
 * Move handler interface
 * 
 * @author Bojan Bijelić
 */
public interface MoveHandlerInterface {
    
    /**
     * Evaulates piece on the given board position and returns set of board
     * positions which are playable by the piece at the moment
     * 
     * @param boardPosition the selected board position
     * @param board the board snapshot
     * 
     * @return the playable board positions set
     */
    public Set<BoardPosition> getPlayableBoardPositions(final BoardPosition boardPosition, final Board board);
    
}
