package com.github.bbijelic.chess.match;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.github.bbijelic.chess.board.Board;
import com.github.bbijelic.chess.board.exception.BoardException;
import com.github.bbijelic.chess.board.setup.NewMatchSetup;
import com.github.bbijelic.chess.core.Color;

/**
 * Match test
 * 
 * @author Bojan Bijelić
 */
public class MatchTest {
    
    @Test
    public void testNewMatch(){
        
        // Initialize players
        Set<Player> players = new HashSet<Player>();
        players.add(new Player("John", Color.WHITE));
        players.add(new Player("Jane", Color.BLACK));
        
        Board board = null;
        try {
            // Initialize Board
            board = new Board(new NewMatchSetup());
            
        } catch (BoardException be){
            Assert.fail(be.getMessage());
        }
        
        // Spectators
        Set<Spectator> spectators = new HashSet<Spectator>();
        spectators.add(new Spectator("spectator1"));
        spectators.add(new Spectator("spectator2"));
        spectators.add(new Spectator("spectator3"));
        
        // Unique match id
        String uuid = UUID.randomUUID().toString();
        
        // Initialize match
        Match match = new Match(uuid, players, board, spectators);
        
        Assert.assertEquals(uuid, match.getMatchId());
        Assert.assertEquals(players, match.getPlayers());
        Assert.assertEquals(board, match.getBoard());
        Assert.assertEquals(spectators, match.getSpectators());
        
    }
    
}
