package com.github.bbijelic.chess.core.core.board.setup;

import java.util.Map;

import com.github.bbijelic.chess.core.core.board.BoardPosition;
import com.github.bbijelic.chess.core.core.piece.Piece;

public interface BoardSetup {

    /**
     * Setup method
     *
     * @return the map containing board setup
     * @throws BoardSetupException the board setup exception
     */
    Map<BoardPosition, Piece> setup() throws BoardSetupException;

}
