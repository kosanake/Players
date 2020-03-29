package org.pingpong.game.remote;

import java.io.Closeable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Base activity rules for ping-pong players
 *
 * It is possible, and in fact common, for a Players to implement
 * PingPongPlayer even if someone wants to play by their own rules
 */
public interface PingPongRemotePlayer extends Remote, Closeable {

    String PLAYER_SERVER = "//localhost:2020/PlayerServer";

    /**
     * Players stroke towards opponent
     * @param progress is the current progress of game
     */
    String stroke(String progress) throws RemoteException;

    /**
     * Shut down  process remotely
     */
    void shutDown() throws RemoteException, NotBoundException, MalformedURLException;
}
