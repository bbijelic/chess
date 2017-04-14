package com.github.bbijelic.chess.board.setup;

import java.util.HashMap;
import java.util.Map;

import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.King;
import com.github.bbijelic.chess.piece.Knight;
import com.github.bbijelic.chess.piece.Pawn;
import com.github.bbijelic.chess.piece.Piece;
import com.github.bbijelic.chess.piece.Queen;
import com.github.bbijelic.chess.piece.Rook;
import com.github.bbijelic.chess.piece.Bishop;

/**
 * New Match Setup
 */
public class NewMatchSetup implements BoardSetup {
    
    @Override
    public Map<BoardPosition, Piece> setup() {
        // Initialize map
        Map<BoardPosition, Piece> pieceSetup = new HashMap<BoardPosition, Piece>(28);
        
        // White player
        pieceSetup.put(new BoardPosition(7, 0), new Rook(Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 7), new Rook(Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 1), new Knight(Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 6), new Knight(Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 2), new Bishop(Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 5), new Bishop(Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 3), new Queen(Color.WHITE));
        pieceSetup.put(new BoardPosition(7, 4), new King(Color.WHITE));
        for(int file = 0; file < 8; file++) pieceSetup.put(new BoardPosition(6, file), new Pawn(Color.WHITE));
        
        // Black player
        pieceSetup.put(new BoardPosition(0, 0), new Rook(Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 7), new Rook(Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 1), new Knight(Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 6), new Knight(Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 2), new Bishop(Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 5), new Bishop(Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 3), new Queen(Color.BLACK));
        pieceSetup.put(new BoardPosition(0, 4), new King(Color.BLACK));
        for(int file = 0; file < 8; file++) pieceSetup.put(new BoardPosition(1, file), new Pawn(Color.BLACK));
        
        return pieceSetup;
    }
    
}
