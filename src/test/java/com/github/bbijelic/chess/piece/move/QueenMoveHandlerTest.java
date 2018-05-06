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
 * Queen related move handling tests
 * 
 * @author Bojan Bijelić
 */
public class QueenMoveHandlerTest {
    
    @Test
    public void whiteQueenMoveHandlerInitialBoard() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);
        
        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition bishopBoardPositionLeft = BoardPosition.of(7, 3);
        
        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
            moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
    }
    
    @Test
    public void blackQueenMoveHandlerInitialBoard() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);
        
        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition bishopBoardPositionLeft = BoardPosition.of(0, 3);
        
        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
            moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
    }
    
}
