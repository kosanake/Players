package org.pingpong.game.local;

import java.io.Closeable;

/**
 * Base activity rules for ping-pong players
 * It is possible, and in fact common, for a Players to implement PingPongPlayer
 */
public interface PingPongPlayer extends Closeable {

    /**
     * Players stroke towards opponent
     * @param progress is the current progress of game
     */
    void stroke(String progress);

    /**
     * Opponent invitation for game
     * @param opponent is the opposite player
     */
    void inviteOpponent(PingPongPlayer opponent);
}
