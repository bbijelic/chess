package com.github.bbijelic.chess.core.core.board.exception;

/**
 * Board exception
 * 
 * @author Bojan Bijelić
 */
public class BoardException extends Exception {
    
    /**
     * Constructor
     * 
     * @param message the exception message
     */
    public BoardException(String message){
        super(message);
    }
    
    /**
     * Constructor
     * 
     * @param message the exception message
     * @param cause the exception cause
     */
    public BoardException(String message, Throwable cause){
        super(message, cause);
    }
}
