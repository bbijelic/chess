package com.github.bbijelic.chess.piece.move;

import java.util.Set;

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
        
        // Initialize board setup
        BoardSetup boardSetup = new NewMatchSetup();
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopBoardPositionLeft = new BoardPosition(7, 0);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
        // Board position under test
        BoardPosition bishopBoardPositionRight = new BoardPosition(7, 7);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
    }
    
    @Test
    public void blackRookMoveHandlerInitialBoard() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new NewMatchSetup();
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopBoardPositionLeft = new BoardPosition(0, 0);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
        // Board position under test
        BoardPosition bishopBoardPositionRight = new BoardPosition(0, 7);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
    }
    
}
