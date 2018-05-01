package com.github.bbijelic.chess.piece.move;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.Piece;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * Handles all move mechanics
 *
 * @author Bojan Bijelić
 */
public class MoveHandler implements MoveHandlerInterface {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MoveHandler.class);

    private boolean recursion = false;

    @Override
    public Set<BoardPosition> getPlayableBoardPositions(
            final BoardPosition boardPosition,
            final Board board) {

        LOGGER.debug("ENTER: getPlayableBoardPositions(); boardPosition={}, board={}", boardPosition, board);

        // Initialize playable positions set
        Set<BoardPosition> playablePositions = new HashSet<>();

        try {

            // Check if piece is present on the selected board square
            if (board.getSquare(boardPosition).getPiece().isPresent()) {

                // Get the piece on the board position
                Piece piece = board.getSquare(boardPosition).getPiece().get();
                LOGGER.debug("Piece {} contained on selected board position: {}", boardPosition, piece);

                // Handle the piece on the board position and obtain set of playable positions
                playablePositions = handlePiece(boardPosition, board, piece);
            }

        } catch (BoardException be) {
            LOGGER.warn("Failed to evaulate playable positions: " + be.getMessage(), be);
        }

        LOGGER.debug("LEAVE: getPlayableBoardPositions(); returning: {}",
                playablePositions.toString());
        // Return playable positions set
        return playablePositions;
    }

    /**
     * Handles piece and evaluates all the playable fields on the board
     *
     * @param boardPosition the selected board position
     * @param board         the board snapshot
     * @param piece         the piece
     * @return the playable board positions set
     */
    private Set<BoardPosition> handlePiece(
            final BoardPosition boardPosition,
            final Board board,
            final Piece piece) {
        LOGGER.debug("ENTER: handlePiece()");

        // Initialize playable positions set
        final Set<BoardPosition> playablePositions = new HashSet<>();

        for (MoveVectorDirection moveVectorDirection : Piece.getMoveVectors(piece.getPieceType())) {

            // Normal move type
            if (moveVectorDirection.getMoveType().equals(MoveType.NORMAL)) {
                playablePositions.addAll(handleNormalMoveType(
                        board, boardPosition, piece, moveVectorDirection.getMoveVectors()));

            } else if (moveVectorDirection.getMoveType().equals(MoveType.KING_MOVE)) {
                playablePositions.addAll(handleKingMoveType(
                        board, boardPosition, piece, moveVectorDirection.getMoveVectors()));
            }
        }

        LOGGER.debug("LEAVE: handlePiece(); returning: {}",
                playablePositions.toString());
        return playablePositions;
    }

    /**
     * Handles king move type.
     * <p></p>
     * <p>King move type is normal move type</p>
     * <p>- minus opponents playable positions (for all opponents pieces on the board)</p>
     *
     * @param board         the board
     * @param boardPosition the board position under evaluation
     * @param piece         the piece on the board position
     * @param moveVectors   the move vectors for the piece
     * @return the playable move board positions
     */
    private Set<BoardPosition> handleKingMoveType(
            final Board board,
            final BoardPosition boardPosition,
            final Piece piece,
            final List<MoveVector> moveVectors) {

        LOGGER.debug("ENTER: handleKingMoveType()");

        // Initialize playable positions set
        final Set<BoardPosition> playablePositions = new HashSet<>();

        // Handle moves as normal moves
        playablePositions.addAll(handleNormalMoveType(board, boardPosition, piece, moveVectors));

        if(recursion) return playablePositions;

        // Figure out opponents color
        Color opponentsColor = Color.WHITE;
        if (piece.getColor().equals(Color.WHITE)) opponentsColor = Color.BLACK;

        recursion = true;

        // Get all board positions occupied by opponents pieces
        board.getBoardPositionsByPieceColor(opponentsColor).forEach(opponentsBoardPosition -> {

            // Get playable positions by opponents pieces
            getPlayableBoardPositions(opponentsBoardPosition, board).forEach(opponentsPlayablePosition -> {
                // Remove opponents playable position
                if (playablePositions.contains(opponentsPlayablePosition)) {
                    playablePositions.remove(opponentsPlayablePosition);
                }
            });
        });

        LOGGER.debug("LEAVE: handleKingMoveType(); returning: {}",
                playablePositions.toString());

        return playablePositions;
    }

    /**
     * Handles normal move type
     *
     * @param board         the board
     * @param boardPosition the board position under evaluation
     * @param piece         the piece on the board position
     * @param moveVectors   the move vectors for the piece
     * @return the playable move board positions
     */
    private Set<BoardPosition> handleNormalMoveType(
            final Board board,
            final BoardPosition boardPosition,
            final Piece piece,
            final List<MoveVector> moveVectors) {

        LOGGER.debug("ENTER: handleNormalMoveType()");

        // Initialize playable positions set
        final Set<BoardPosition> playablePositions = new HashSet<>();

        for (MoveVector moveVector : moveVectors) {
            // Apply move vector to the board position
            BoardPosition boardPositionVectored = boardPosition.applyMoveVector(moveVector);

            // When true, means board position is within boundaries of the board
            if (!boardPositionVectored.isValid()) continue;

            try {
                // Check if board position is occupied
                Optional<Piece> pieceOptional = board.getSquare(boardPositionVectored).getPiece();
                if (pieceOptional.isPresent()) {

                    // Check if piece is friend or foe
                    if (!pieceOptional.get().getColor().equals(piece.getColor())) {
                        // Square is occupied by opponents piece, it is playable
                        playablePositions.add(boardPositionVectored);
                    }

                    // Piece breaks this direction
                    break;

                } else {
                    // Square is not occupied, it is playable
                    playablePositions.add(boardPositionVectored);
                }

            } catch (BoardException be) {
                break;
            }
        }

        LOGGER.debug("LEAVE: handleNormalMoveType(); returning: {}",
                playablePositions.toString());

        return playablePositions;
    }
}
