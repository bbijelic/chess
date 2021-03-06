package com.github.bbijelic.chess.core.core.board.setup;

import com.github.bbijelic.chess.core.core.board.BoardPosition;
import com.github.bbijelic.chess.core.core.Color;
import com.github.bbijelic.chess.core.core.piece.Piece;
import com.github.bbijelic.chess.core.core.piece.PieceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * New Match Setup
 */
public class NewMatchSetup implements BoardSetup {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewMatchSetup.class);

    @Override
    public Map<BoardPosition, Piece> setup() {
        // Initialize map
        Map<BoardPosition, Piece> pieceSetup = new HashMap<>(28);

        // White player
        pieceSetup.put(new BoardPosition(7, 0), new Piece(PieceType.ROOK, Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 7), new Piece(PieceType.ROOK, Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 1), new Piece(PieceType.KNIGHT, Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 6), new Piece(PieceType.KNIGHT, Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 2), new Piece(PieceType.BISHOP, Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 5), new Piece(PieceType.BISHOP, Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 3), new Piece(PieceType.QUEEN, Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 4), new Piece(PieceType.KING, Color.WHITE));
        for (int file = 0; file < 8; file++)
            pieceSetup.put(new BoardPosition(6, file), new Piece(PieceType.PAWN, Color.WHITE));

        // Black player
        pieceSetup.put(new BoardPosition(0, 0), new Piece(PieceType.ROOK, Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 7), new Piece(PieceType.ROOK, Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 1), new Piece(PieceType.KNIGHT, Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 6), new Piece(PieceType.KNIGHT, Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 2), new Piece(PieceType.BISHOP, Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 5), new Piece(PieceType.BISHOP, Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 3), new Piece(PieceType.QUEEN, Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 4), new Piece(PieceType.KING, Color.BLACK));
        for (int file = 0; file < 8; file++)
            pieceSetup.put(new BoardPosition(1, file), new Piece(PieceType.PAWN, Color.BLACK));

        pieceSetup.forEach(((boardPosition, piece) -> {
            LOGGER.debug("Initialized piece {} on {}", piece, boardPosition);
        }));

        return pieceSetup;
    }

}
