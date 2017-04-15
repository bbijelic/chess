package com.github.bbijelic.chess.piece.move;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.BoardSetup;
import com.github.bbijelic.chess.board.setup.NewMatchSetup;
import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.Bishop;
import com.github.bbijelic.chess.piece.Knight;
import com.github.bbijelic.chess.piece.Pawn;
import com.github.bbijelic.chess.piece.Piece;

/**
 * Bishop related move handling tests
 * 
 * @author Bojan Bijelić
 */
public class BishopMoveHandlerTest {
    
    @Test
    public void whiteBishopMoveHandlerInitialBoard() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new NewMatchSetup();
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopBoardPositionLeft = new BoardPosition(7, 2);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
        // Board position under test
        BoardPosition bishopBoardPositionRight = new BoardPosition(7, 5);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
    }
    
    @Test
    public void blackBishopMoveHandlerInitialBoard() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new NewMatchSetup();
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopBoardPositionLeft = new BoardPosition(0, 2);
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
        // Board position under test
        BoardPosition bishopBoardPositionRight = new BoardPosition(0, 5);
        
        // Get playable board positions
        playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopBoardPositionRight, board);
        
        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
        
    }
    
    /**
     * Bishop setup test
     * FEN: 8/8/8/8/8/3B4/8/8 w - - 0 1
     */
    @Test
    public void testPositionSetup1() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(1);
                boardSetup.put(new BoardPosition("d3"), new Bishop(Color.WHITE));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopPosition = new BoardPosition("d3");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopPosition, board);
        
        // Assert position and size
        assertEquals(11, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("c2")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("b1")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("c4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("b5")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("a6")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("e4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("f5")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("g6")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("h7")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("e2")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("f1")));
    }
    
    /**
     * Bishop setup test
     * FEN: 8/8/8/5p2/2P5/3B4/8/8 w - - 0 1
     */
    @Test
    public void testPositionSetup2() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(3);
                boardSetup.put(new BoardPosition("d3"), new Bishop(Color.WHITE));
                boardSetup.put(new BoardPosition("c4"), new Pawn(Color.WHITE));
                boardSetup.put(new BoardPosition("f5"), new Pawn(Color.BLACK));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopPosition = new BoardPosition("d3");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopPosition, board);
        
        // Assert position and size
        assertEquals(6, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("c2")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("b1")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("e4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("f5")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("e2")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("f1")));
    }
    
    /**
     * Bishop setup test
     * FEN: 8/8/8/8/8/2P5/P7/B7 w - - 0 1
     */
    @Test
    public void testPositionSetup3() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(3);
                boardSetup.put(new BoardPosition("a1"), new Bishop(Color.WHITE));
                boardSetup.put(new BoardPosition("a2"), new Pawn(Color.WHITE));
                boardSetup.put(new BoardPosition("c3"), new Pawn(Color.WHITE));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopPosition = new BoardPosition("a1");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopPosition, board);
        
        // Assert position and size
        assertEquals(1, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("b2")));
    }
    
    /**
     * Bishop setup test
     * FEN: 8/8/8/p7/3p4/2B5/1p1n4/8 w - - 0 1
     */
    @Test
    public void testPositionSetup4() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(5);
                boardSetup.put(new BoardPosition("c3"), new Bishop(Color.WHITE));
                boardSetup.put(new BoardPosition("b2"), new Pawn(Color.BLACK));
                boardSetup.put(new BoardPosition("d4"), new Pawn(Color.BLACK));
                boardSetup.put(new BoardPosition("d2"), new Knight(Color.BLACK));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopPosition = new BoardPosition("c3");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopPosition, board);
        
        // Assert position and size
        assertEquals(5, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("b2")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("b4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("a5")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("d4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("d2")));
    }
    
    /**
     * Bishop setup test
     * FEN: 8/1P6/8/8/8/8/8/7B w - - 0 1
     */
    @Test
    public void testPositionSetup5() throws BoardException {
        
        // Initialize board setup
        BoardSetup boardSetup = new BoardSetup() {
            
            @Override
            public Map<BoardPosition, Piece> setup() {
                Map<BoardPosition, Piece> boardSetup = new HashMap<BoardPosition, Piece>(2);
                boardSetup.put(new BoardPosition("h1"), new Bishop(Color.WHITE));
                boardSetup.put(new BoardPosition("b7"), new Pawn(Color.WHITE));
                
                return boardSetup;
            }
        };
        
        // Initialize Board
        Board board = new Board(boardSetup);
                
        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();
        
        // Board position under test
        BoardPosition bishopPosition = new BoardPosition("h1");
        
        // Get playable board positions
        Set<BoardPosition> playableBoardPositions = 
            moveHandler.getPlayableBoardPositions(bishopPosition, board);
        
        // Assert position and size
        assertEquals(5, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("g2")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("f3")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("e4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("d5")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("c6")));
    }
    
}
