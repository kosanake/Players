package org.pingpong.game.remote.runner;

import org.pingpong.game.remote.PingPongRemotePlayer;
import org.pingpong.game.remote.PlayerClient;

import java.io.IOException;
import java.rmi.NotBoundException;

/**
 * Application executor
 * mvn clean compile exec:java@remote-client
 */
public class ExecutorClient {

    public static void main(String[] args) throws IOException, NotBoundException {

        try (PlayerClient playerClient = new PlayerClient()) {
            playerClient.startGame(PingPongRemotePlayer.PLAYER_SERVER);
        }
    }
}
