package com.github.bbijelic.chess.piece.move;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.github.bbijelic.chess.board.setup.fen.FENBoardSetup;
import com.github.bbijelic.chess.piece.PieceType;
import org.junit.Test;

import static org.junit.Assert.*;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.BoardSetup;
import com.github.bbijelic.chess.board.setup.NewMatchSetup;
import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.Piece;

/**
 * Knight related move handling tests.
 * 
 * <p>One can use https://www.chess.com/analysis-board-editor to prepare various setups via FEN</p>
 * 
 * @author Bojan Bijelić
 */
public class KnightMoveHandlerTest {
    
    @Test
    public void whiteKnightMoveHandlerInitialBoard() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);

        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition knighBoardPositionLeft = BoardPosition.of(7, 1);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions =
            moveHandler.getPlayableBoardPositions(knighBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of(5, 2)));
        assertTrue(playableBoardPositions.contains(BoardPosition.of(5, 0)));
        
        // Board position under test
        final BoardPosition knighBoardPositionRight = BoardPosition.of(7, 6);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knighBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of(5, 7)));
        assertTrue(playableBoardPositions.contains(BoardPosition.of(5, 5)));
        
    }
    
    @Test
    public void blackKnightMoveHandlerInitialBoard() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);
        
        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition knighBoardPositionLeft = BoardPosition.of(0, 1);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knighBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of(2, 2)));
        assertTrue(playableBoardPositions.contains(BoardPosition.of(2, 0)));
        
        // Board position under test
        final BoardPosition knighBoardPositionRight = BoardPosition.of(0, 6);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knighBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of(2, 7)));
        assertTrue(playableBoardPositions.contains(BoardPosition.of(2, 5)));
        
    }
    
    /**
     * Test knight setup
     * FEN: 8/8/5p2/3N4/8/4P3/8/8 w - - 0 1
     */
    @Test
    public void testKnightPositionsSetup1() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/5p2/3N4/8/4P3/8/8 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition whiteKnightD5 = BoardPosition.of("d5");
        
        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
            moveHandler.getPlayableBoardPositions(whiteKnightD5, board);
        
        // Assert position and size
        assertEquals(7, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b6")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("c7")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e7")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f6")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("c3")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b4")));
        
    }
    
    /**
     * Test knight setup
     * FEN: 8/8/8/8/7p/4P3/6N1/8 w - - 0 1
     */
    @Test
    public void testKnightPositionsSetup2() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/8/8/7p/4P3/6N1/8 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition whiteKnightG2 = BoardPosition.of("g2");
        
        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
            moveHandler.getPlayableBoardPositions(whiteKnightG2, board);
        
        // Assert position and size
        assertEquals(3, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e1")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("h4")));
    }
    
    /**
     * Test knight setup
     * FEN: N7/8/1r6/8/8/8/8/8 w - - 0 1
     */
    @Test
    public void testKnightPositionsSetup3() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("N7/8/1r6/8/8/8/8/8 w - - 0 1");
        
        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition knight = BoardPosition.of("a8");
        
        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
            moveHandler.getPlayableBoardPositions(knight, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b6")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("c7")));
    }
    
    /**
     * Test knight setup
     * FEN: N7/2P5/1P6/8/8/8/8/8 w - - 0 1
     */
    @Test
    public void testKnightPositionsSetup4() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("N7/2P5/1P6/8/8/8/8/8 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);
                
        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        final BoardPosition knight = BoardPosition.of("a8");
        
        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
            moveHandler.getPlayableBoardPositions(knight, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
    }
    
}
