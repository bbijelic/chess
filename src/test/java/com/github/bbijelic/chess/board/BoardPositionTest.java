package com.github.bbijelic.chess.board;

import static org.junit.Assert.*;
import org.junit.Test;

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
        assertTrue(boardPosition1.equals(boardPosition2));
    }
    
    @Test
    public void testNotEquals() {
        BoardPosition boardPosition1 = new BoardPosition(5, 5);
        BoardPosition boardPosition2 = new BoardPosition(5, 4);
        assertFalse(boardPosition1.equals(boardPosition2));
    }
    
    @Test
    public void testSquareNameToFileRank(){
        BoardPosition boardPosition = new BoardPosition("d6");
        assertEquals(3, boardPosition.getFile());
        assertEquals(2, boardPosition.getRank());
        assertEquals("d6", boardPosition.getSquareName());
    }
    
    @Test
    public void testFileRankToSquareName(){
        BoardPosition boardPosition = new BoardPosition(4, 4);
        assertEquals("e4", boardPosition.getSquareName());
    }
    
}
