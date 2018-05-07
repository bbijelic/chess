package com.github.bbijelic.chess.core.core.match;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.github.bbijelic.chess.core.core.board.Board;
import com.github.bbijelic.chess.core.core.board.exception.BoardException;
import com.github.bbijelic.chess.core.core.board.setup.NewMatchSetup;
import com.github.bbijelic.chess.core.core.Color;

/**
 * Match test
 * 
 * @author Bojan Bijelić
 */
public class MatchTest {
    
    @Test
    public void testNewMatch(){
        
        // Initialize players
        final Set<Player> players = new HashSet<Player>();
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
        final Set<Spectator> spectators = new HashSet<Spectator>();
        spectators.add(new Spectator("spectator1"));
        spectators.add(new Spectator("spectator2"));
        spectators.add(new Spectator("spectator3"));
        
        // Unique match id
        final String uuid = UUID.randomUUID().toString();
        
        // Initialize match
        final Match match = new Match(uuid, players, board, spectators);
        
        Assert.assertEquals(uuid, match.getMatchId());
        Assert.assertEquals(players, match.getPlayers());
        Assert.assertEquals(board, match.getBoard());
        Assert.assertEquals(spectators, match.getSpectators());
        
    }
    
}
