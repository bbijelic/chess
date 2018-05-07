package com.github.bbijelic.chess.core.core.match;

import java.util.Objects;

/**
 * Match spectator
 * 
 * @author Bojan Bijelić
 */
public class Spectator {
    
    /**
     * Constructor
     * 
     * @param username the spectator username
     */
    public Spectator(String username){
        this.username = username;
    }
    
    /**
     * Username
     */
    private String username;
    
    /**
     * Username getter
     * 
     * @return the spectator username
     */
    public String getUsername() {
        return username;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Spectator){
            Spectator other = (Spectator)obj;
            if(this.username == other.getUsername()) return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Spectator [username=");
        builder.append(username);
        builder.append("]");
        return builder.toString();
    }
    
}
