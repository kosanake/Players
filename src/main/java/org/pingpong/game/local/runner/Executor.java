package org.pingpong.game.local.runner;

import org.pingpong.game.local.PingPongPlayer;
import org.pingpong.game.local.Player;

import java.io.IOException;

/**
 * Application executor
 * mvn clean compile exec:java
 */
public class Executor {
    public static void main(String[] args) throws IOException {

        try (PingPongPlayer player1 = new Player();
             PingPongPlayer player2 = new Player()) {

            player1.inviteOpponent(player2);
            player2.inviteOpponent(player1);

            player1.stroke("Game: ");
        }
    }
}
