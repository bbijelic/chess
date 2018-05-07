package com.github.bbijelic.chess.core.core.match;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bbijelic.chess.core.core.board.Board;

/**
 * Match class
 *
 * @author Bojan Bijelić
 */
public class Match {

    private static final Logger LOGGER = LoggerFactory.getLogger(Match.class);

    /**
     * Constructor
     *
     * @param matchId    the match id
     * @param players    the player set
     * @param board      the board
     * @param spectators the match spectators
     */
    public Match(final String matchId,
                 final Set<Player> players,
                 final Board board,
                 final Set<Spectator> spectators){

        LOGGER.info("Initializing match with ID: {}", matchId);

        this.players = players;
        this.board = board;
        this.matchId = matchId;
        this.spectators = spectators;
    }

    /**
     * Unique match ID
     */
    private String matchId;

    /**
     * Returns match id
     *
     * @return the match id
     */
    public String getMatchId(){
        return this.matchId;
    }

    /**
     * Player set
     */
    private Set<Player> players = new HashSet<Player>(2);

    /**
     * Returns player set
     *
     * @return the players
     */
    public Set<Player> getPlayers(){
        return players;
    }

    /**
     * Spectators
     */
    private Set<Spectator> spectators = new HashSet<Spectator>();

    /**
     * Spectator set getter
     *
     * @return the spectator set
     */
    public Set<Spectator> getSpectators(){
        return spectators;
    }

    /**
     * Match board
     */
    private Board board;

    /**
     * Returns match board
     *
     * @return the board
     */
    public Board getBoard(){
        return board;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Match [matchId=");
        builder.append(matchId);
        builder.append(", players=");
        builder.append(players);
        builder.append(", board=");
        builder.append(board);
        builder.append(", spectators=");
        builder.append(spectators);
        builder.append("]");
        return builder.toString();
    }

}
