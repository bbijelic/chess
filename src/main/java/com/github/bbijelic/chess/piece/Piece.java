package com.github.bbijelic.chess.piece;

import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.move.MoveType;
import com.github.bbijelic.chess.piece.move.MoveVector;
import com.github.bbijelic.chess.piece.move.MoveVectorDirection;

import java.util.*;

/**
 * Piece
 *
 * @author Bojan Bijelić
 */
public class Piece {

    /**
     * Move vectors for all the types
     */
    private static final Map<PieceType, List<MoveVectorDirection>> MOVE_VECTORS;

    static{

        // Move vectors map initialization
        MOVE_VECTORS = new HashMap<>();

        // Pawn move vectors
        MOVE_VECTORS.put(PieceType.PAWN, new ArrayList<MoveVectorDirection>() {
            {
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, 0));
                }}, MoveType.PAWN_SINGLE_STEP_MOVE));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-2, 0));
                }}, MoveType.PAWN_DOUBLE_STEP_MOVE));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, -1));
                }}, MoveType.PAWN_EN_PASSANT));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, 1));
                }}, MoveType.PAWN_EN_PASSANT));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, -1));
                }}, MoveType.PAWN_CAPTURE));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, 1));
                }}, MoveType.PAWN_CAPTURE));
            }
        });

        // Rook move vectors
        MOVE_VECTORS.put(PieceType.ROOK, new ArrayList<MoveVectorDirection>() {
            {
                // Left
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(0, -1));
                    add(new MoveVector(0, -2));
                    add(new MoveVector(0, -3));
                    add(new MoveVector(0, -4));
                    add(new MoveVector(0, -5));
                    add(new MoveVector(0, -6));
                    add(new MoveVector(0, -7));
                }}, MoveType.NORMAL));

                // Right
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(0, 1));
                    add(new MoveVector(0, 2));
                    add(new MoveVector(0, 3));
                    add(new MoveVector(0, 4));
                    add(new MoveVector(0, 5));
                    add(new MoveVector(0, 6));
                    add(new MoveVector(0, 7));
                }}, MoveType.NORMAL));

                // Up
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, 0));
                    add(new MoveVector(-2, 0));
                    add(new MoveVector(-3, 0));
                    add(new MoveVector(-4, 0));
                    add(new MoveVector(-5, 0));
                    add(new MoveVector(-6, 0));
                    add(new MoveVector(-7, 0));
                }}, MoveType.NORMAL));

                // Down
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, 0));
                    add(new MoveVector(2, 0));
                    add(new MoveVector(3, 0));
                    add(new MoveVector(4, 0));
                    add(new MoveVector(5, 0));
                    add(new MoveVector(6, 0));
                    add(new MoveVector(7, 0));
                }}, MoveType.NORMAL));
            }
        });

        // Knight move vectors
        MOVE_VECTORS.put(PieceType.KNIGHT, new ArrayList<MoveVectorDirection>() {
            {
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-2, 1));
                }}, MoveType.NORMAL));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, 2));
                }}, MoveType.NORMAL));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, 2));
                }}, MoveType.NORMAL));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(2, 1));
                }}, MoveType.NORMAL));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(2, -1));
                }}, MoveType.NORMAL));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, -2));
                }}, MoveType.NORMAL));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, -2));
                }}, MoveType.NORMAL));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-2, -1));
                }}, MoveType.NORMAL));
            }
        });

        // Bishop move vectors
        MOVE_VECTORS.put(PieceType.BISHOP, new ArrayList<MoveVectorDirection>() {
            {
                // Down Right
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, 1));
                    add(new MoveVector(2, 2));
                    add(new MoveVector(3, 3));
                    add(new MoveVector(4, 4));
                    add(new MoveVector(5, 5));
                    add(new MoveVector(6, 6));
                    add(new MoveVector(7, 7));
                }}, MoveType.NORMAL));

                // Down Left
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, -1));
                    add(new MoveVector(2, -2));
                    add(new MoveVector(3, -3));
                    add(new MoveVector(4, -4));
                    add(new MoveVector(5, -5));
                    add(new MoveVector(6, -6));
                    add(new MoveVector(7, -7));
                }}, MoveType.NORMAL));

                // Up Left
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, -1));
                    add(new MoveVector(-2, -2));
                    add(new MoveVector(-3, -3));
                    add(new MoveVector(-4, -4));
                    add(new MoveVector(-5, -5));
                    add(new MoveVector(-6, -6));
                    add(new MoveVector(-7, -7));
                }}, MoveType.NORMAL));

                // Up Right
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, 1));
                    add(new MoveVector(-2, 2));
                    add(new MoveVector(-3, 3));
                    add(new MoveVector(-4, 4));
                    add(new MoveVector(-5, 5));
                    add(new MoveVector(-6, 6));
                    add(new MoveVector(-7, 7));
                }}, MoveType.NORMAL));
            }
        });

        // King move vectors
        MOVE_VECTORS.put(PieceType.KING, new ArrayList<MoveVectorDirection>() {
            {
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, 0));
                }}, MoveType.KING_MOVE));
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, -1));
                }}, MoveType.KING_MOVE));
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(0, 1));
                }}, MoveType.KING_MOVE));
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, 1));
                }}, MoveType.KING_MOVE));
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, 0));
                }}, MoveType.KING_MOVE));
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(1, -1));
                }}, MoveType.KING_MOVE));
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(0, -1));
                }}, MoveType.KING_MOVE));
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(-1, 1));
                }}, MoveType.KING_MOVE));

                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(0, 3));
                }}, MoveType.KING_SIDE_CASTILING));
                add(new MoveVectorDirection(new ArrayList<MoveVector>() {{
                    add(new MoveVector(0, -4));
                }}, MoveType.QUEEN_SIDE_CASTLING));
            }
        });

        // Queen move vectors
        // Queens movement is combination of ROOK's and BISHOP's
        MOVE_VECTORS.put(PieceType.QUEEN, new ArrayList<MoveVectorDirection>() {
            {
                addAll(MOVE_VECTORS.get(PieceType.ROOK));
                addAll(MOVE_VECTORS.get(PieceType.BISHOP));
            }
        });
    }

    /**
     * Returns move vectors for the given piece type
     *
     * @param pieceType the piece type
     * @return the move vectors for the given piece type
     */
    public static List<MoveVectorDirection> getMoveVectors(final PieceType pieceType){
        return MOVE_VECTORS.get(pieceType);
    }

    /**
     * Constructor
     *
     * @param pieceType the piece type
     * @param color     the piece color
     */
    public Piece(final PieceType pieceType, Color color){
        this.pieceType = pieceType;
        this.color = color;
    }

    /**
     * Color
     */
    private final Color color;

    /**
     * Color getter
     *
     * @return the color
     */
    public Color getColor(){
        return color;
    }

    /**
     * Piece type
     */
    private final PieceType pieceType;

    /**
     * Piece type getter
     *
     * @return the piece type
     */
    public PieceType getPieceType(){
        return pieceType;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color &&
                pieceType == piece.pieceType;
    }

    @Override
    public int hashCode(){

        return Objects.hash(color, pieceType);
    }

    @Override
    public String toString(){
        final StringBuffer sb = new StringBuffer("Piece{");
        sb.append("color=").append(color);
        sb.append(", pieceType=").append(pieceType);
        sb.append('}');
        return sb.toString();
    }

}
