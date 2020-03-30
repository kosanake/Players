package org.pingpong.game.remote.runner;

import org.pingpong.game.remote.PingPongServerPlayer;
import org.pingpong.game.remote.PlayerClient;

import java.io.IOException;
import java.rmi.NotBoundException;

/**
 * Application executor
 * Executes RMI client
 */
public class ExecutorClient {

    public static void main(String[] args) throws IOException, NotBoundException {

        try (PlayerClient playerClient = new PlayerClient("Client")) {
            playerClient.startGame(PingPongServerPlayer.PLAYER_SERVER);
        }
    }
}
