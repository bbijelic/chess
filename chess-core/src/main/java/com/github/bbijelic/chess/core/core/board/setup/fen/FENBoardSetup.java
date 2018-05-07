package com.github.bbijelic.chess.core.core.board.setup.fen;

import com.github.bbijelic.chess.core.core.board.BoardPosition;
import com.github.bbijelic.chess.core.core.board.setup.BoardSetup;
import com.github.bbijelic.chess.core.core.board.setup.BoardSetupException;
import com.github.bbijelic.chess.core.core.Color;
import com.github.bbijelic.chess.core.core.piece.Piece;
import com.github.bbijelic.chess.core.core.piece.PieceType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FEN Setup uses Forsyth–Edwards Notation (FEN) to initialize board setup
 */
public class FENBoardSetup implements BoardSetup {

    /**
     * Initial board setup, used usualy throughout the tests
     */
    public static final String INITIAL_SETUP = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    /**
     * The FEN string
     */
    private final String fen;

    /**
     * Constructor
     *
     * @param fen the FEN string
     */
    public FENBoardSetup(final String fen){
        this.fen = fen;
    }

    /**
     * Helper method to get FEN board setup instance
     *
     * @param fen the FEN string
     * @return the FEN board setup instance
     */
    public static FENBoardSetup of(final String fen){
        return new FENBoardSetup(fen);
    }

    @Override
    public Map<BoardPosition, Piece> setup() throws BoardSetupException{

        // Initialize map
        final Map<BoardPosition, Piece> map = new HashMap<>();

        // Get the fields
        final List<String> fields = Arrays.asList(fen.split(" "));

        if (fields.size() != 6) {
            throw new BoardSetupException("Number of FEN fields has to be 6, but it is " + fields.size());
        }

        // Get the piece placement field
        final String piecePlacementField = fields.get(0);

        // Get list of ranks
        final List<String> ranks = Arrays.asList(piecePlacementField.split("/"));

        if (ranks.size() != 8) {
            throw new BoardSetupException(
                    "Number of ranks in the piece placement field has to be 8, but is " + ranks.size());
        }

        // Iterate ranks
        for (int r = 0; r < ranks.size(); r++) {

            // Get the rank string
            handleRank(ranks.get(r), r, map);

        }

        // Return the map
        return map;
    }

    /**
     * Handles single rank
     *
     * @param rank the rank string
     * @param r    the rank index
     * @param map  the board position to piece map
     * @throws BoardSetupException the board setup exception
     */
    private void handleRank(
            final String rank,
            final int r,
            final Map<BoardPosition, Piece> map)
            throws BoardSetupException{

        int f = 0;
        boolean previousIsDigit = false;

        for (int i = 0; i < rank.length(); i++) {

            // Get one char at a time
            final char rankChar = rank.charAt(i);

            if (Character.isDigit(rankChar)) {

                // When number, increment file by that number
                f = f + Character.getNumericValue(rankChar);
                previousIsDigit = true;

            } else if (Character.isAlphabetic(rankChar)) {

                // Get the piece and put it in the map
                map.put(new BoardPosition(r, f), handlePiece(rankChar));

                f++;

                previousIsDigit = false;
            }
        }
    }

    /**
     * For a given alphabetic char, returnes piece instance
     *
     * @param alphabeticChar the alphabetic rank char
     * @return the piece instance
     */
    private Piece handlePiece(
            final char alphabeticChar)
            throws BoardSetupException{

        // Piece color
        Color pieceColor;

        // Piece type
        PieceType pieceType;

        // Determine piece color
        // Upercase chars are white, and lowercase black piece
        pieceColor = (Character.isUpperCase(alphabeticChar)) ? Color.WHITE : Color.BLACK;

        // Determine piece type
        if (Character.toString(alphabeticChar).equalsIgnoreCase("p")) pieceType = PieceType.PAWN;
        else if (Character.toString(alphabeticChar).equalsIgnoreCase("n")) pieceType = PieceType.KNIGHT;
        else if (Character.toString(alphabeticChar).equalsIgnoreCase("b")) pieceType = PieceType.BISHOP;
        else if (Character.toString(alphabeticChar).equalsIgnoreCase("r")) pieceType = PieceType.ROOK;
        else if (Character.toString(alphabeticChar).equalsIgnoreCase("q")) pieceType = PieceType.QUEEN;
        else if (Character.toString(alphabeticChar).equalsIgnoreCase("k")) pieceType = PieceType.KING;
        else throw new BoardSetupException("Unhandled character: " + alphabeticChar);

        // Return instance of the piece
        return new Piece(pieceType, pieceColor);
    }

}
