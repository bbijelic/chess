package com.github.bbijelic.chess.piece.move;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.piece.Bishop;
import com.github.bbijelic.chess.piece.King;
import com.github.bbijelic.chess.piece.Knight;
import com.github.bbijelic.chess.piece.Pawn;
import com.github.bbijelic.chess.piece.Piece;
import com.github.bbijelic.chess.piece.Queen;
import com.github.bbijelic.chess.piece.Rook;


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

    @Override
    public Set<BoardPosition> getPlayableBoardPositions(
        final BoardPosition boardPosition, 
        final Board board) {
            
        LOGGER.debug("ENTER: getPlayableBoardPositions(); boardPosition={}, board={}", boardPosition, board);
        
        // Initialize playable positions set
        Set<BoardPosition> playablePositions = new HashSet<BoardPosition>();

        try {

            // Check if piece is pressent on the selected board square
            if (board.getSquare(boardPosition).getPiece().isPresent()) {
                Piece piece = board.getSquare(boardPosition).getPiece().get();
                LOGGER.debug("Piece contained on selected board position: {}", piece);

                if (piece instanceof Rook) {
                    playablePositions = handleRookPiece(
                        boardPosition, board, (Rook)piece);

                } else if (piece instanceof Pawn) {
                    playablePositions = handlePawnPiece(
                        boardPosition, board, (Pawn)piece);

                } else if (piece instanceof Knight) {
                    playablePositions = handleKnightPiece(
                        boardPosition, board, (Knight)piece);

                } else if (piece instanceof Bishop) {
                    playablePositions = handleBishopPiece(
                        boardPosition, board, (Bishop)piece);

                } else if (piece instanceof Queen) {
                    playablePositions = handleQueenPiece(
                        boardPosition, board, (Queen)piece);

                } else if (piece instanceof King) {
                    playablePositions = handleKingPiece(
                        boardPosition, board, (King)piece);
                }
            }

        } catch (BoardException be) {
            LOGGER.warn("Failed to evaulate playable positions: " + be.getMessage(), be);
        }

        LOGGER.debug("LEAVE: getPlayableBoardPositions(); returning: {}", 
            playablePositions.toString());
        // Return playable pisitions set
        return playablePositions;
    }

    /**
     * Handles rook piece and evaluates all the playable fields on the board
     * 
     * @param boardPosition the selected board position
     * @param board the board snapshot
     * @param piece the rook piece
     * 
     * @return the playable board positions set
     */
    private Set<BoardPosition> handleRookPiece(
        final BoardPosition boardPosition, 
        final Board board, 
        final Rook piece) {
        
        LOGGER.debug("ENTER: handleRookPiece()");

        // Initialize playable positions set
        final Set<BoardPosition> playablePositions = new HashSet<BoardPosition>();

        for(MoveVectorDirection moveVectorDirection : Rook.MOVE_VECTORS){
            // Normal move type
            if(moveVectorDirection.getMoveType().equals(MoveType.NORMAL)){
                playablePositions.addAll(handleNormalMoveType(
                    board, boardPosition, piece, moveVectorDirection.getMoveVectors()));                
            }
        }

        LOGGER.debug("LEAVE: handleRookPiece(); returning: {}", 
            playablePositions.toString());
        return playablePositions;
    }

    /**
     * Handles pawn piece and evaluates all the playable fields on the board
     * 
     * @param boardPosition the selected board position
     * @param board the board snapshot
     * @param piece the pawn piece
     * 
     * @return the playable board positions set
     */
    private Set<BoardPosition> handlePawnPiece(
        final BoardPosition boardPosition, 
        final Board board, 
        final Pawn piece) {
        
        LOGGER.debug("ENTER: handlePawnPiece()");

        // Initialize playable positions set
        Set<BoardPosition> playablePositions = new HashSet<BoardPosition>();


        LOGGER.debug("LEAVE: handlePawnPiece(); returning: {}", 
            playablePositions.toString());
        return playablePositions;
    }

    /**
     * Handles knight piece and evaluates all the playable fields on the board
     * 
     * @param boardPosition the selected board position
     * @param board the board snapshot
     * @param piece the knight piece
     * 
     * @return the playable board positions set
     */
    private Set<BoardPosition> handleKnightPiece(
        final BoardPosition boardPosition, 
        final Board board, 
        final Knight piece) {
        
        LOGGER.debug("ENTER: handleKnightPiece()");

        // Initialize playable positions set
        Set<BoardPosition> playablePositions = new HashSet<BoardPosition>();

        for(MoveVectorDirection moveVectorDirection : Knight.MOVE_VECTORS){
            // Normal move type
            if(moveVectorDirection.getMoveType().equals(MoveType.NORMAL)){
                playablePositions.addAll(handleNormalMoveType(
                    board, boardPosition, piece, moveVectorDirection.getMoveVectors()));                
            }
        }

        LOGGER.debug("LEAVE: handleKnightPiece(); returning: {}", 
            playablePositions.toString());
        return playablePositions;
    }

    /**
     * Handles bishop piece and evaluates all the playable fields on the board
     * 
     * @param boardPosition the selected board position
     * @param board the board snapshot
     * @param piece the bishop piece
     * 
     * @return the playable board positions set
     */
    private Set<BoardPosition> handleBishopPiece(
        final BoardPosition boardPosition, 
        final Board board, 
        final Bishop piece) {
        
        LOGGER.debug("ENTER: handleBishopPiece()");

        // Initialize playable positions set
        Set<BoardPosition> playablePositions = new HashSet<BoardPosition>();

        for(MoveVectorDirection moveVectorDirection : Bishop.MOVE_VECTORS){
            // Normal move type
            if(moveVectorDirection.getMoveType().equals(MoveType.NORMAL)){
                playablePositions.addAll(handleNormalMoveType(
                    board, boardPosition, piece, moveVectorDirection.getMoveVectors()));                
            }
        }

        LOGGER.debug("LEAVE: handleBishopPiece(); returning: {}", 
            playablePositions.toString());
        return playablePositions;
    }

    /**
     * Handles queen piece and evaluates all the playable fields on the board
     * 
     * @param boardPosition the selected board position
     * @param board the board snapshot
     * @param piece the queen piece
     * 
     * @return the playable board positions set
     */
    private Set<BoardPosition> handleQueenPiece(
        final BoardPosition boardPosition, 
        final Board board, 
        final Queen piece) {
        
        LOGGER.debug("ENTER: handleQueenPiece()");

        // Initialize playable positions set
        Set<BoardPosition> playablePositions = new HashSet<BoardPosition>();

        for(MoveVectorDirection moveVectorDirection : Queen.MOVE_VECTORS){
            // Normal move type
            if(moveVectorDirection.getMoveType().equals(MoveType.NORMAL)){
                playablePositions.addAll(handleNormalMoveType(
                    board, boardPosition, piece, moveVectorDirection.getMoveVectors()));                
            }
        }

        LOGGER.debug("LEAVE: handleQueenPiece(); returning: {}", 
            playablePositions.toString());
        return playablePositions;
    }

    /**
     * Handles king piece and evaluates all the playable fields on the board
     * 
     * @param boardPosition the selected board position
     * @param board the board snapshot
     * @param piece the king piece
     * 
     * @return the playable board positions set
     */
    private Set<BoardPosition> handleKingPiece(
        final BoardPosition boardPosition, 
        final Board board, 
        final King piece) {
        
        LOGGER.debug("ENTER: handleKingPiece()");

        // Initialize playable positions set
        Set<BoardPosition> playablePositions = new HashSet<BoardPosition>();


        LOGGER.debug("LEAVE: handleKingPiece(); returning: {}", 
            playablePositions.toString());
        return playablePositions;
    }
    
    private Set<BoardPosition> handleNormalMoveType(
        final Board board, final BoardPosition boardPosition, 
        final Piece piece, final List<MoveVector> moveVectors){
        
        // Initialize playable positions set
        Set<BoardPosition> playablePositions = new HashSet<BoardPosition>();
        
        for(MoveVector moveVector : moveVectors){
            // Apply move vector to the board position
            BoardPosition boardPositionVectored = boardPosition.applyMoveVector(moveVector);
            
            // When true, means board position is within boudaries of the board
            if(boardPositionVectored.isValid()){
                
                try {
                    // Check if board position is occupied
                    Optional<Piece> pieceOptional = board.getSquare(boardPositionVectored).getPiece();
                    if(pieceOptional.isPresent()){
                        
                        // Check if piece is friend or foe
                        if(!pieceOptional.get().getColor().equals(piece.getColor())){
                            // Square is occupied by opponents piece, it is playable
                            playablePositions.add(boardPositionVectored);
                        }
                        
                        // Piece breaks this direction
                        break;
                        
                    } else {
                        // Square is not occupied, it is playable
                        playablePositions.add(boardPositionVectored);
                    }
                    
                } catch (BoardException be){
                    break;
                }
            }
        }
        
        return playablePositions;
    }
}
