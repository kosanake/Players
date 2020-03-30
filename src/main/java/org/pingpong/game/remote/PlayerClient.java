package org.pingpong.game.remote;

import java.io.Closeable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * <code>Player</code> represents a real game player
 *
 * It contains it's name, opponent player object and a stroke counter.
 * Each stroke increments strokeCounter and will influence on game process.
 * After GAME_STROKES number achieved, the game will be over.
 */
public class PlayerClient implements Closeable {

    private static final int GAME_STROKES = 10;

    private String name;
    private int strokeCounter;
    private PingPongServerPlayer opponent;

    public PlayerClient(String name) {
        this.name = name;
    }

    public void startGame(String playerServer) throws RemoteException, MalformedURLException, NotBoundException {
        opponent = (PingPongServerPlayer) Naming.lookup(playerServer);
        String currentProgress = Integer.toString(++strokeCounter);
        for (int i = 0; i < GAME_STROKES; i++) {
            String remoteProgress = opponent.stroke(currentProgress);
            System.out.println(this + ", message : " + remoteProgress);
            currentProgress = remoteProgress.concat(" ").concat(Integer.toString(++strokeCounter));
        }

    }

    @Override
    public void close() {
        // "disposing" resources
        try {
            opponent.shutDown();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        strokeCounter = 0;
        opponent = null;
    }

    @Override
    public String toString() {
        return name + " - progress: " + strokeCounter;
    }
}
