package com.github.bbijelic.chess.board;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.BoardSetup;
import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.Piece;

/**
 * Board
 * 
 * @author Bojan Bijelić
 */
public class Board {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Board.class);
    
    /**
     * Board squares
     */
    private Map<BoardPosition, Square> squares = new HashMap<BoardPosition, Square>(64);
        
    /**
     * Constructor
     * 
     * @param boardSetup the board setup
     * @throws BoardException
     */
    public Board(BoardSetup boardSetup) throws BoardException {
        // Initializing the board
        for(int rank = 0; rank < 8; rank++){
            for(int file = 0; file < 8; file++){
                
                // Determine square color
                Color squareColor = Color.WHITE;
                if( (rank % 2 == 1 && file % 2 == 0) || ( rank % 2 == 0 && file % 2 == 1 ) ) {
                    squareColor = Color.BLACK;
                } 
                
                // Board position
                BoardPosition boardPosition = new BoardPosition(rank, file);
                // Board square
                Square square = new Square(squareColor);
                
                // Initialize square
                squares.put(boardPosition, square);
                
                LOGGER.debug("Initialized square on {}: {}", boardPosition, square);
            }
        }
        
        // Get the board setup
        Map<BoardPosition, Piece> boardSetupMap = boardSetup.setup();
        if(boardSetupMap == null) throw new BoardException("Board setup is null");
        if(boardSetupMap.isEmpty()) throw new BoardException("Board setup must contain at least one piece");
        
        Iterator<Map.Entry<BoardPosition, Piece>> it = boardSetupMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<BoardPosition, Piece> pair = (Map.Entry<BoardPosition, Piece>)it.next();
            // Set the piece to the position
            squares.get(pair.getKey()).setPiece(pair.getValue());
            it.remove();
        }
    }
        
    /**
     * Returns square for the given rank and file
     * 
     * @param rank the board rank
     * @param file the board file
     * @return Square the square
     * @throws BoardException
     */
    public Square getSquare(final int rank, final int file) throws BoardException {
        return getSquare(new BoardPosition(rank, file));  
    }
    
    /**
     * Returns square for the given board position
     * 
     * @param boardPosition the board rank
     * @return Square the square
     * @throws BoardException
     */
    public Square getSquare(BoardPosition boardPosition) throws BoardException {
        // Return the square on the position
        if(this.squares.containsKey(boardPosition)) {
            return squares.get(boardPosition);
        } else {
            // Square not initialize
            throw new BoardException("Square not initialized at board position: " + boardPosition.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Board [squares=");
        builder.append(squares);
        builder.append("]");
        return builder.toString();
    }
}
