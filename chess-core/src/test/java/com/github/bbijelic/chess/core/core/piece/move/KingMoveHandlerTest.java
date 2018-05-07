package com.github.bbijelic.chess.core.core.piece.move;

import com.github.bbijelic.chess.core.core.board.Board;
import com.github.bbijelic.chess.core.core.board.BoardPosition;
import com.github.bbijelic.chess.core.core.board.exception.BoardException;
import com.github.bbijelic.chess.core.core.board.setup.BoardSetup;
import com.github.bbijelic.chess.core.core.board.setup.fen.FENBoardSetup;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * King related move handler test
 */
public class KingMoveHandlerTest {

    @Test
    public void whiteKingMoveHandlerInitialBoard() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);

        // Initialize Board
        Board board = new Board(boardSetup);

        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        BoardPosition kingBoardPosition = BoardPosition.of("e1");

        // Get playable board positions
        Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(kingBoardPosition, board);

        // Assert position and size
        assertEquals(0, playableBoardPositions.size());
    }

    /**
     * FEN: 8/5q2/2n5/8/8/4K3/8/2k5 w - - 0 1
     */
    @Test
    public void testPlayablePositionsUnderChess() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/5q2/2n5/8/8/4K3/8/2k5 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Board position under test
        final BoardPosition kingBoardPosition = BoardPosition.of("e3");

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(kingBoardPosition, board);

        // Assert position and size
        assertEquals(3, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("d3")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e2")));
        assertFalse(playableBoardPositions.contains(BoardPosition.of("d2")));
    }

    @Test
    public void testSetup1() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/8/8/8/2k5/4K3/8 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Board position under test
        final BoardPosition kingBoardPosition = BoardPosition.of("e2");

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(kingBoardPosition, board);

        // Assert position and size
        assertEquals(6, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("d1")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e1")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f1")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f2")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f3")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e3")));

    }

    @Test
    public void testSetup2() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/8/8/8/2k5/3PK3/8 b - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Board position under test
        final BoardPosition kingBoardPosition = BoardPosition.of("e2");

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(kingBoardPosition, board);

        // Assert position and size
        assertEquals(6, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("d1")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f1")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f2")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f3")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e3")));
    }

    @Test
    public void testSetup3() throws BoardException{

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/8/8/3P1P2/4K3/3P1P2/8/8 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Board position under test
        final BoardPosition kingBoardPosition = BoardPosition.of("e4");

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(kingBoardPosition, board);

        // Assert position and size
        assertEquals(4, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e5")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("f4")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("e3")));
        assertTrue(playableBoardPositions.contains(BoardPosition.of("d4")));
    }

}
