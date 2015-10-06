package com.smulsky.game.api;

import java.util.List;

public interface GameManager {
    List<Game> getAvailableGames();
    void play(int gameName);
}
