package com.github.bbijelic.chess.board;

import com.github.bbijelic.chess.piece.move.MoveVector;

import java.util.Objects;

/**
 * Board position
 *
 * @author Bojan Bijelić
 */
public class BoardPosition {

    /**
     * Constructor
     *
     * @param rank the board rank
     * @param file the board file
     */
    public BoardPosition(final int rank, final int file){

        this.rank = rank;
        this.file = file;
    }

    /**
     * Constructor
     *
     * @param squareName the human readable square name, e.g. h3
     */
    public BoardPosition(final String squareName){
        final String fileStr = String.valueOf(squareName.charAt(0));
        for (int f = 0; f < 8; f++) {
            if (FILE_LETTERS[f].equalsIgnoreCase(fileStr)) {
                this.file = f;
            }
        }

        this.rank = 8 - Character.getNumericValue(squareName.charAt(1));
    }

    /**
     * Helper method to get the instance of the board position from the square name
     *
     * @param squareName the square name
     * @return the board position instance
     */
    public static BoardPosition of(final String squareName){
        return new BoardPosition(squareName);
    }

    /**
     * Helper method to get the instance of board position from the rank and file index number
     *
     * @param rank the rank
     * @param file the file
     * @return the board position instance
     */
    public static BoardPosition of(
            final int rank,
            final int file){

        return new BoardPosition(rank, file);
    }

    /**
     * Board rank
     */
    private final int rank;

    /**
     * Rank getter
     *
     * @return the rank
     */
    public int getRank(){
        return rank;
    }

    /**
     * File
     */
    private int file;

    /**
     * File getter
     *
     * @return the file
     */
    public int getFile(){
        return file;
    }

    /**
     * Applies move vector to the board position and returns new board position
     *
     * @return the board position with applied move vector
     */
    public BoardPosition applyMoveVector(
            final MoveVector moveVector){

        return new BoardPosition(
                this.rank + moveVector.getRankVector(),
                this.file + moveVector.getFileVector());
    }

    /**
     * Validates if board position is inside board boundaries
     *
     * @return true if valid, false otherwise
     */
    public boolean isValid(){
        return (rank >= 0 && rank <= 7 && file >= 0 && file <= 7) ? true : false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(rank, file);
    }

    /**
     * File letters
     */
    private static final String[] FILE_LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h"};

    /**
     * Returns human readable name of the square,e.g. f4
     *
     * @return the name of the square
     */
    public String getSquareName(){
        final StringBuilder squareName = new StringBuilder(2);

        try {
            squareName.append(FILE_LETTERS[file]);
            squareName.append(8 - rank);
        } catch (final IndexOutOfBoundsException iofbe){
            squareName.append("xx");
        }

        return squareName.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof BoardPosition) {
            BoardPosition other = (BoardPosition) obj;
            if (this.rank == other.getRank() && this.file == other.getFile()) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("BoardPosition (");
        builder.append(getSquareName());
        builder.append(")[rank=");
        builder.append(rank);
        builder.append(", file=");
        builder.append(file);
        builder.append("]");
        return builder.toString();
    }
}
