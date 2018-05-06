package com.github.bbijelic.chess.board.setup.fen;

import com.github.bbijelic.chess.board.BoardPosition;
import com.github.bbijelic.chess.board.setup.BoardSetupException;
import com.github.bbijelic.chess.core.Color;
import com.github.bbijelic.chess.piece.Piece;
import com.github.bbijelic.chess.piece.PieceType;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class FENBoardSetupTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FENBoardSetupTest.class);

    @Test
    public void setup() throws BoardSetupException{

        // Initialize FEN setup
        final FENBoardSetup fenBoardSetup = new FENBoardSetup("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Map<BoardPosition, Piece> map = fenBoardSetup.setup();

        Assert.assertEquals(new Piece(PieceType.ROOK, Color.BLACK), map.get(new BoardPosition("a8")));
        Assert.assertEquals(new Piece(PieceType.KNIGHT, Color.BLACK), map.get(new BoardPosition("b8")));
        Assert.assertEquals(new Piece(PieceType.BISHOP, Color.BLACK), map.get(new BoardPosition("c8")));
        Assert.assertEquals(new Piece(PieceType.QUEEN, Color.BLACK), map.get(new BoardPosition("d8")));
        Assert.assertEquals(new Piece(PieceType.KING, Color.BLACK), map.get(new BoardPosition("e8")));
        Assert.assertEquals(new Piece(PieceType.BISHOP, Color.BLACK), map.get(new BoardPosition("f8")));
        Assert.assertEquals(new Piece(PieceType.KNIGHT, Color.BLACK), map.get(new BoardPosition("g8")));
        Assert.assertEquals(new Piece(PieceType.ROOK, Color.BLACK), map.get(new BoardPosition("h8")));
        for (int file = 0; file < 8; file++)
            Assert.assertEquals(new Piece(PieceType.PAWN, Color.BLACK), map.get(new BoardPosition(1, file)));

        Assert.assertEquals(new Piece(PieceType.ROOK, Color.WHITE), map.get(new BoardPosition("a1")));
        Assert.assertEquals(new Piece(PieceType.KNIGHT, Color.WHITE), map.get(new BoardPosition("b1")));
        Assert.assertEquals(new Piece(PieceType.BISHOP, Color.WHITE), map.get(new BoardPosition("c1")));
        Assert.assertEquals(new Piece(PieceType.QUEEN, Color.WHITE), map.get(new BoardPosition("d1")));
        Assert.assertEquals(new Piece(PieceType.KING, Color.WHITE), map.get(new BoardPosition("e1")));
        Assert.assertEquals(new Piece(PieceType.BISHOP, Color.WHITE), map.get(new BoardPosition("f1")));
        Assert.assertEquals(new Piece(PieceType.KNIGHT, Color.WHITE), map.get(new BoardPosition("g1")));
        Assert.assertEquals(new Piece(PieceType.ROOK, Color.WHITE), map.get(new BoardPosition("h1")));
        for (int file = 0; file < 8; file++)
            Assert.assertEquals(new Piece(PieceType.PAWN, Color.WHITE), map.get(new BoardPosition(6, file)));
    }

    @Test
    public void setup1() throws BoardSetupException{

        final Map<BoardPosition, Piece> map = new FENBoardSetup("8/8/8/8/8/3B4/8/8 w - - 0 1").setup();
        Assert.assertEquals(new Piece(PieceType.BISHOP, Color.WHITE), map.get(BoardPosition.of("d3")));
    }

    @Test
    public void setup2() throws BoardSetupException{

        // Setup the map
        final Map<BoardPosition, Piece> map = new FENBoardSetup("8/8/8/p7/3p4/2B5/1p1n4/8 w - - 0 1").setup();

        // Assert pieces
        Assert.assertEquals(new Piece(PieceType.PAWN, Color.BLACK), map.get(BoardPosition.of("a5")));
        Assert.assertEquals(new Piece(PieceType.PAWN, Color.BLACK), map.get(BoardPosition.of("d4")));
        Assert.assertEquals(new Piece(PieceType.PAWN, Color.BLACK), map.get(BoardPosition.of("b2")));
        Assert.assertEquals(new Piece(PieceType.KNIGHT, Color.BLACK), map.get(BoardPosition.of("d2")));
        Assert.assertEquals(new Piece(PieceType.BISHOP, Color.WHITE), map.get(BoardPosition.of("c3")));
    }

    @Test
    public void setup3() throws BoardSetupException{

        // Setup the map
        final Map<BoardPosition, Piece> map = new FENBoardSetup("8/8/8/8/8/8/1p1n4/8 w - - 0 1").setup();

        // Assert pieces
        Assert.assertEquals(new Piece(PieceType.PAWN, Color.BLACK), map.get(BoardPosition.of("b2")));
        Assert.assertEquals(new Piece(PieceType.KNIGHT, Color.BLACK), map.get(BoardPosition.of("d2")));
    }
}