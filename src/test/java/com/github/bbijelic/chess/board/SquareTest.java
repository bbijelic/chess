package com.github.bbijelic.chess.board;

import com.github.bbijelic.chess.piece.Piece;
import com.github.bbijelic.chess.piece.PieceType;
import org.junit.Test;

import com.github.bbijelic.chess.core.Color;

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
        Square square = new Square(Color.BLACK);
        assertEquals(Color.BLACK, square.getColor());
        assertFalse(square.getPiece().isPresent());
    }

    @Test
    public void testTwoParamConstructor() {
        // Initialize square with color and a piece
        Square square = new Square(Color.WHITE, new Piece(PieceType.PAWN, Color.WHITE));
        assertEquals(Color.WHITE, square.getColor());
        assertTrue(square.getPiece().isPresent());
    }
}
