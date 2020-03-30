package org.pingpong.game.remote.runner;

import org.pingpong.game.remote.PingPongServerPlayer;
import org.pingpong.game.remote.PlayerServer;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Application executor
 * Executes RMI server
 */
public class ExecutorServer {

    public static void main(String[] args) throws IOException {

        try (PingPongServerPlayer playerServer = new PlayerServer("Server")) {
            LocateRegistry.createRegistry(2020);
            Naming.rebind(PingPongServerPlayer.PLAYER_SERVER, playerServer);
            System.out.println("Server player ready!");
        }
    }
}