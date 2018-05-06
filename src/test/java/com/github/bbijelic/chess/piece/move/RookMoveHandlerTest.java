package com.github.bbijelic.chess.piece.move;

import java.util.Set;

import com.github.bbijelic.chess.board.setup.fen.FENBoardSetup;
import org.junit.Test;

import static org.junit.Assert.*;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.BoardSetup;
import com.github.bbijelic.chess.board.setup.NewMatchSetup;

/**
 * Rook move handling tests
 * 
 * @author Bojan Bijelić
 */
public class RookMoveHandlerTest {
    
    @Test
    public void whiteRookMoveHandlerInitialBoard() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);
        
        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition bishopBoardPositionLeft = BoardPosition.of(7, 0);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
        // Board position under test
        final BoardPosition bishopBoardPositionRight = BoardPosition.of(7, 7);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
    }
    
    @Test
    public void blackRookMoveHandlerInitialBoard() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);
        
        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition bishopBoardPositionLeft = BoardPosition.of(0, 0);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
        // Board position under test
        final BoardPosition bishopBoardPositionRight = BoardPosition.of(0, 7);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
    }
    
}
