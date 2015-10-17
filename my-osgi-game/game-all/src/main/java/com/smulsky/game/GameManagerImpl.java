package com.smulsky.game;

import com.smulsky.game.api.Game;
import com.smulsky.game.api.GameManager;
import com.smulsky.game.exception.NowSuchGameException;
import org.apache.felix.scr.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true)
@Service
public class GameManagerImpl implements GameManager {

   @Reference(cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
            bind = "setGame",
            unbind = "unsetGame",
            referenceInterface = Game.class,
            policy = ReferencePolicy.DYNAMIC)
    private List<Game> availableGames;

    @Override
    public List<Game> getAvailableGames() {
        System.out.println("availableGames size: " + availableGames.size());
        return availableGames;
    }

    @Override
    public void play(int index) {
        if (index >= availableGames.size()) {
            throw new NowSuchGameException();
        }
        availableGames.get(index).start();
    }

    protected void setGame(Game game) {
        if (availableGames == null) {
            availableGames = new ArrayList<>();
        }
        availableGames.add(game);
    }

    protected void unsetGame(Game game) {
        availableGames.remove(game);
    }
}
