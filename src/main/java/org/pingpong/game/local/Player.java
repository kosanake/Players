package org.pingpong.game.local;

/**
 * <code>Player</code> represents a real game player
 *
 * It contains opponent player object and a stroke counter.
 * Each stroke increments strokeCounter and will influence on game process.
 * After GAME_STROKES number achieved, the game will be over.
 */
public class Player implements PingPongPlayer {

    private static final int GAME_STROKES = 10;

    private int strokeCounter;
    private PingPongPlayer opponent;

    @Override
    public void stroke(String progress) {
        strokeCounter++;
        if (strokeCounter > GAME_STROKES) {
            return;
        }
        String newProgress = progress.concat(" ").concat(Integer.toString(strokeCounter));
        System.out.println(newProgress);
        opponent.stroke(newProgress);
    }

    @Override
    public void inviteOpponent(PingPongPlayer opponent) {
        this.opponent = opponent;
    }

    @Override
    public void close() {
        strokeCounter = 0;
        opponent = null;
    }
}
