package com.github.bbijelic.chess.board;

import org.junit.Assert;
import org.junit.Test;

import com.github.bbijelic.chess.board.exception.BoardException;

/**
 * Board position test
 * 
 * @author Bojan Bijelić
 */
public class BoardPositionTest {
    
    @Test
    public void testEquals(){ 
        BoardPosition boardPosition1 = new BoardPosition(5, 4);
        BoardPosition boardPosition2 = new BoardPosition(5, 4);
        Assert.assertTrue(boardPosition1.equals(boardPosition2));
    }
    
    @Test
    public void testNotEquals() {
        BoardPosition boardPosition1 = new BoardPosition(5, 5);
        BoardPosition boardPosition2 = new BoardPosition(5, 4);
        Assert.assertFalse(boardPosition1.equals(boardPosition2));
    }
    
}
