package com.github.bbijelic.chess.piece.move;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.BoardSetup;
import com.github.bbijelic.chess.board.setup.fen.FENBoardSetup;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Bishop related move handling tests
 *
 * @author Bojan Bijelić
 */
public class BishopMoveHandlerTest {

    @Test
    public void whiteBishopMoveHandlerInitialBoard() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        final BoardPosition bishopBoardPositionLeft = BoardPosition.of(7, 2);

        // Get playable board positions
        Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);

        // Assert position and size
        assertEquals(0, playableBoardPositions.size());

        // Board position under test
        final BoardPosition bishopBoardPositionRight = BoardPosition.of(7, 5);

        // Get playable board positions
        playableBoardPositions =
                moveHandler.getPlayableBoardPositions(bishopBoardPositionRight, board);

        // Assert position and size
        assertEquals(0, playableBoardPositions.size());

    }

    @Test
    public void blackBishopMoveHandlerInitialBoard() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        final BoardPosition bishopBoardPositionLeft = BoardPosition.of(0, 2);

        // Get playable board positions
        Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(bishopBoardPositionLeft, board);

        // Assert position and size
        assertEquals(0, playableBoardPositions.size());

        // Board position under test
        final BoardPosition bishopBoardPositionRight = BoardPosition.of(0, 5);

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
    public void testPositionSetup1() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/8/8/8/3B4/8/8 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        final BoardPosition bishopPosition = BoardPosition.of("d3");

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(bishopPosition, board);

        // Assert position and size
        assertEquals(11, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("c2")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b1")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("c4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b5")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("a6")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f5")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("g6")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("h7")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e2")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f1")));
    }

    /**
     * Bishop setup test
     * FEN: 8/8/8/5p2/2P5/3B4/8/8 w - - 0 1
     */
    @Test
    public void testPositionSetup2() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/8/5p2/2P5/3B4/8/8 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        final BoardPosition bishopPosition = BoardPosition.of("d3");

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(bishopPosition, board);

        // Assert position and size
        assertEquals(6, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("c2")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b1")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f5")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e2")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f1")));
    }

    /**
     * Bishop setup test
     * FEN: 8/8/8/8/8/2P5/P7/B7 w - - 0 1
     */
    @Test
    public void testPositionSetup3() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/8/8/8/2P5/P7/B7 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        final BoardPosition bishopPosition = BoardPosition.of("a1");

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(bishopPosition, board);

        // Assert position and size
        assertEquals(1, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b2")));
    }

    /**
     * Bishop setup test
     * FEN: 8/8/8/p7/3p4/2B5/1p1n4/8 w - - 0 1
     */
    @Test
    public void testPositionSetup4() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/8/p7/3p4/2B5/1p1n4/8 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        final BoardPosition bishopPosition = BoardPosition.of("c3");

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(bishopPosition, board);

        // Assert position and size
        assertEquals(5, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b2")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("b4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("a5")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("d4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("d2")));
    }

    /**
     * Bishop setup test
     * FEN: 8/1P6/8/8/8/8/8/7B w - - 0 1
     */
    @Test
    public void testPositionSetup5() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/1P6/8/8/8/8/8/7B w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        final BoardPosition bishopPosition = BoardPosition.of("h1");

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(bishopPosition, board);

        // Assert position and size
        assertEquals(5, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("g2")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f3")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("d5")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("c6")));
    }

}
