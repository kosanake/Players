package org.pingpong.game.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * <code>Player</code> represents a real game player
 *
 * It contains opponent player object and a stroke counter.
 * Each stroke increments strokeCounter and will influence on game process.
 * After GAME_STROKES number achieved, the game will be over.
 */
public class PlayerServer extends UnicastRemoteObject implements PingPongRemotePlayer {

    private int strokeCounter;

    public PlayerServer() throws RemoteException {
        super(0);
    }

    @Override
    public String stroke(String progress) {
        strokeCounter++;
        String currentProgress = progress.concat(" ").concat(Integer.toString(strokeCounter));
        System.out.println(currentProgress);
        return currentProgress;
    }

    @Override
    public void shutDown() throws RemoteException, NotBoundException, MalformedURLException {
        Naming.unbind(PLAYER_SERVER);
        UnicastRemoteObject.unexportObject(this, true);
    }

    @Override
    public void close() {
        strokeCounter = 0;
    }
}