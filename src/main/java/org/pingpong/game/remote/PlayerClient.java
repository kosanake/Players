package org.pingpong.game.remote;

import java.io.Closeable;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static org.pingpong.game.remote.PingPongRemotePlayer.PLAYER_SERVER;

/**
 * <code>Player</code> represents a real game player
 *
 * It contains opponent player object and a stroke counter.
 * Each stroke increments strokeCounter and will influence on game process.
 * After GAME_STROKES number achieved, the game will be over.
 */
public class PlayerClient implements Closeable {

    private static final int GAME_STROKES = 10;

    private int strokeCounter;
    private PingPongRemotePlayer opponent;

    public void startGame(String playerServer) throws RemoteException, MalformedURLException, NotBoundException {
        opponent = (PingPongRemotePlayer) Naming.lookup(playerServer);
        String currentProgress = Integer.toString(++strokeCounter);
        for (int i = 0; i < GAME_STROKES; i++) {
            System.out.println(currentProgress);
            String remoteProgress = opponent.stroke(currentProgress);
            currentProgress = remoteProgress.concat(" ").concat(Integer.toString(++strokeCounter));
        }
        opponent.shutDown();
    }

    @Override
    public void close() {
        strokeCounter = 0;
        opponent = null;
    }
}
