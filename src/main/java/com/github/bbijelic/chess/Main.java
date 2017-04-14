package com.github.bbijelic.chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.NewMatchSetup;

/**
 * Main application class
 */
public class Main {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        LOGGER.info("Started chess application");
        
        try {
            
            // Initialize board for the new match
            Board board = new Board(new NewMatchSetup());
            LOGGER.debug("Board: {}", board.toString());
            
        } catch (BoardException be){
            LOGGER.error(be.getMessage(), be);
        }
    }
    
}
