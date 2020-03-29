package org.pingpong.game.remote.runner;

import org.pingpong.game.remote.PingPongRemotePlayer;
import org.pingpong.game.remote.PlayerServer;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Application executor
 * mvn clean compile exec:java@remote-server
 */
public class ExecutorServer {

    public static void main(String[] args) throws IOException {

        try (PingPongRemotePlayer playerServer = new PlayerServer()) {
            LocateRegistry.createRegistry(2020);
            Naming.rebind(PingPongRemotePlayer.PLAYER_SERVER, playerServer);
            System.out.println("Server player ready!");
        }
    }
}