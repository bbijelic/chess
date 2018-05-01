package com.github.bbijelic.chess.board;

import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.BoardSetup;
import com.github.bbijelic.chess.board.setup.NewMatchSetup;
import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.Piece;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Board Test class
 *
 * @author Bojan Bijelić
 */
public class BoardTest {

    @Test(expected = BoardException.class)
    public void testBoardExceptionThrown() throws BoardException {
        Board board = new Board(new NewMatchSetup());
        board.getSquare(8, 8);
    }

    @Test(expected = BoardException.class)
    public void testBoardNotInitialized() throws BoardException {
        BoardSetup boardSetup = new BoardSetup() {

            @Override
            public Map<BoardPosition, Piece> setup() {
                return null;
            }
        };
        new Board(boardSetup);
    }

    @Test
    public void testBoardInitialization() throws BoardException {
        // Initialize board
        Board board = new Board(new NewMatchSetup());

        assertEquals(Color.WHITE, board.getSquare(0, 0).getColor());
        assertTrue(board.getSquare(0, 0).getPiece().isPresent());

        assertEquals(Color.BLACK, board.getSquare(0, 1).getColor());
        assertTrue(board.getSquare(1, 1).getPiece().isPresent());

        assertEquals(Color.WHITE, board.getSquare(7, 7).getColor());
        assertTrue(board.getSquare(7, 7).getPiece().isPresent());

        assertEquals(Color.BLACK, board.getSquare(5, 2).getColor());
        assertTrue(board.getSquare(6, 2).getPiece().isPresent());
    }

    @Test
    public void testGetBoardPositionsByPieceColor() throws BoardException {

        // Initialize board
        final Board board = new Board(new NewMatchSetup());
        // Get piece positions occupied by BLACK pieces
        final Set<BoardPosition> boardPositions = board.getBoardPositionsByPieceColor(Color.BLACK);

        assertEquals(16, boardPositions.size());

    }
}
