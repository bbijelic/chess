package com.github.bbijelic.chess.core.core.board.setup;

/**
 * Board setup exception
 */
public class BoardSetupException extends Exception {

    /**
     * Constructor
     *
     * @param message the message
     */
    public BoardSetupException(final String message) {
        super( message );
    }

    /**
     * Constructor
     *
     * @param message the message
     * @param cause   the cause
     */
    public BoardSetupException(final String message, final Throwable cause) {
        super( message, cause );
    }

}
