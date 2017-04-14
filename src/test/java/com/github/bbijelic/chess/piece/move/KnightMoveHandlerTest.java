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
 * Knight related move handling tests
 * 
 * @author Bojan Bijelić
 */
public class KnightMoveHandlerTest {
    
    @Test
    public void whiteKnightMoveHandlerInitialBoard() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new NewMatchSetup();
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition knighBoardPositionLeft = new BoardPosition(7, 1);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knighBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition(5, 2)));
        assertTrue(playableBoardPositions.contains(new BoardPosition(5, 0)));
        
        // Board position under test
        BoardPosition knighBoardPositionRight = new BoardPosition(7, 6);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knighBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition(5, 7)));
        assertTrue(playableBoardPositions.contains(new BoardPosition(5, 5)));
        
    }
    
    @Test
    public void blackKnightMoveHandlerInitialBoard() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new NewMatchSetup();
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition knighBoardPositionLeft = new BoardPosition(0, 1);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knighBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition(2, 2)));
        assertTrue(playableBoardPositions.contains(new BoardPosition(2, 0)));
        
        // Board position under test
        BoardPosition knighBoardPositionRight = new BoardPosition(0, 6);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knighBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition(2, 7)));
        assertTrue(playableBoardPositions.contains(new BoardPosition(2, 5)));
        
    }
    
}
