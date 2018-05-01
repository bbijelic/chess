package com.github.bbijelic.chess.piece.move;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    
    /**
     * Test knight setup
     * FEN: 8/8/5p2/3N4/8/4P3/8/8 w - - 0 1
     */
    @Test
    public void testKnightPositionsSetup1() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(3);
                boardSetup.put(new BoardPosition("d5"), new Piece(PieceType.KNIGHT, Color.WHITE));
                boardSetup.put(new BoardPosition("e3"), new Piece(PieceType.PAWN, Color.WHITE));
                boardSetup.put(new BoardPosition("f6"), new Piece(PieceType.PAWN, Color.BLACK));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition whiteKnightD5 = new BoardPosition("d5");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(whiteKnightD5, board);
        
        // Assert position and size
        assertEquals(7, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("b6")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("c7")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("e7")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("f6")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("f4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("c3")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("b4")));
        
    }
    
    /**
     * Test knight setup
     * FEN: 8/8/8/8/7p/4P3/6N1/8 w - - 0 1
     */
    @Test
    public void testKnightPositionsSetup2() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(3);
                boardSetup.put(new BoardPosition("g2"), new Piece(PieceType.KNIGHT, Color.WHITE));
                boardSetup.put(new BoardPosition("e3"), new Piece(PieceType.PAWN, Color.WHITE));
                boardSetup.put(new BoardPosition("h4"), new Piece(PieceType.PAWN, Color.BLACK));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition whiteKnightG2 = new BoardPosition("g2");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(whiteKnightG2, board);
        
        // Assert position and size
        assertEquals(3, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("e1")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("f4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("h4")));
    }
    
    /**
     * Test knight setup
     * FEN: N7/8/1r6/8/8/8/8/8 w - - 0 1
     */
    @Test
    public void testKnightPositionsSetup3() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(2);
                boardSetup.put(new BoardPosition("a8"), new Piece(PieceType.KNIGHT, Color.WHITE));
                boardSetup.put(new BoardPosition("b6"), new Piece(PieceType.ROOK, Color.BLACK));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition knight = new BoardPosition("a8");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knight, board);
        
        // Assert position and size
        assertEquals(2, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("b6")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("c7")));
    }
    
    /**
     * Test knight setup
     * FEN: N7/2P5/1P6/8/8/8/8/8 w - - 0 1
     */
    @Test
    public void testKnightPositionsSetup4() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(3);
                boardSetup.put(new BoardPosition("a8"), new Piece(PieceType.KNIGHT, Color.WHITE));
                boardSetup.put(new BoardPosition("b6"), new Piece(PieceType.PAWN, Color.WHITE));
                boardSetup.put(new BoardPosition("c7"), new Piece(PieceType.PAWN, Color.WHITE));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition knight = new BoardPosition("a8");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(knight, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
    }
    
}
