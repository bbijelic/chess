package com.github.bbijelic.chess.core.core.match;

import java.util.Objects;

import com.github.bbijelic.chess.core.core.Color;

/**
 * Player
 * 
 * @author Bojan Bijelić
 */
public class Player {
    
    /**
     * Constructor
     * 
     * @param username the username
     * @param color the color
     */
    public Player(final String username, final Color color) {
        this.username = username;
        this.color = color;
    }
    
    /**
     * Username
     */
    private String username;
    
    /**
     * Returns username
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Color
     */
    private Color color;
    
    /**
     * Returns player color
     * 
     * @return the player color
     */
    public Color getColor() {
        return color;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(username, color);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Player){
            Player other = (Player)obj;
            if(this.username == other.getUsername() 
                && this.color == other.getColor()) return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Player [color=");
        builder.append(color);
        builder.append(", username=");
        builder.append(username);
        builder.append("]");
        return builder.toString();
    }
}
