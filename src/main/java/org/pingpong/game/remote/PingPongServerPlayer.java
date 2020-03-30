package org.pingpong.game.remote;

import java.io.Closeable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Base activity rules for ping-pong players
 * It is possible, and in fact common, for a server Players to implement PingPongServerPlayer
 */
public interface PingPongServerPlayer extends Remote, Closeable {

    String PLAYER_SERVER = "//localhost:2020/PlayerServer";

    /**
     * Players stroke towards opponent
     * @param progress is the current progress of game
     * @return message to opponent
     * @throws RemoteException if communication failed
     */
    String stroke(String progress) throws RemoteException;

    /**
     * Shut down server process remotely
     */
    void shutDown() throws RemoteException, NotBoundException, MalformedURLException;
}
