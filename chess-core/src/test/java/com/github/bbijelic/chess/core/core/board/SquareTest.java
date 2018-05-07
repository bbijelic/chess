package com.github.bbijelic.chess.core.core.board;

import com.github.bbijelic.chess.core.core.piece.Piece;
import com.github.bbijelic.chess.core.core.piece.PieceType;
import org.junit.Test;

import com.github.bbijelic.chess.core.core.Color;

import static org.junit.Assert.*;

/**
 * Square test class
 *
 * @author Bojan Bijelić
 */
public class SquareTest {

    @Test
    public void testSingleParamConstructor() {
        // Initialize square with color only
        final Square square = new Square(Color.BLACK);

        assertEquals(Color.BLACK, square.getColor());
        assertFalse(square.getPiece().isPresent());
    }

    @Test
    public void testTwoParamConstructor() {
        // Initialize square with color and a piece
        final Square square = new Square(Color.WHITE, new Piece(PieceType.PAWN, Color.WHITE));

        assertEquals(Color.WHITE, square.getColor());
        assertTrue(square.getPiece().isPresent());
    }
}
