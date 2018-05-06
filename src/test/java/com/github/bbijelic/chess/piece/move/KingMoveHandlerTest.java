package com.github.bbijelic.chess.piece.move;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.BoardSetup;
import com.github.bbijelic.chess.board.setup.NewMatchSetup;
import com.github.bbijelic.chess.board.setup.fen.FENBoardSetup;
import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.Piece;
import com.github.bbijelic.chess.piece.PieceType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * King related move handler test
 */
public class KingMoveHandlerTest {

    @Test
    public void whiteKingMoveHandlerInitialBoard() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of(FENBoardSetup.INITIAL_SETUP);

        // Initialize Board
        Board board = new Board(boardSetup);

        // Move handler instance
        MoveHandlerInterface moveHandler = new MoveHandler();

        // Board position under test
        BoardPosition kingBoardPosition = new BoardPosition(7, 4);

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
    public void testPlayablePositionsUnderChess() throws BoardException {

        // Initial board setup
        final BoardSetup boardSetup = FENBoardSetup.of("8/5q2/2n5/8/8/4K3/8/2k5 w - - 0 1");

        // Initialize Board
        final Board board = new Board(boardSetup);

        // Board position under test
        final BoardPosition kingBoardPosition = new BoardPosition("e3");

        // Move handler instance
        final MoveHandlerInterface moveHandler = new MoveHandler();

        // Get playable board positions
        final Set<BoardPosition> playableBoardPositions =
                moveHandler.getPlayableBoardPositions(kingBoardPosition, board);

        // Assert position and size
        assertEquals(3, playableBoardPositions.size());
        assertTrue(playableBoardPositions.contains(new BoardPosition("e4")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("d3")));
        assertTrue(playableBoardPositions.contains(new BoardPosition("e2")));
    }

}
