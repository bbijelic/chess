package com.github.bbijelic.chess.board.setup;

import java.util.Map;

import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.piece.Piece;

public interface BoardSetup {
    
    Map<BoardPosition, Piece> setup();
    
}
