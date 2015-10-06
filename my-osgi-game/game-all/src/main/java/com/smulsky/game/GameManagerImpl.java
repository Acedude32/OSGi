package com.smulsky.game;

import com.smulsky.game.api.Game;
import com.smulsky.game.api.GameManager;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import java.util.List;

@Component(immediate = true)
@Service
public class GameManagerImpl implements GameManager {

    @Reference(target = "(service.pid=com.smulsky.game.all.HeadsAndTails)")
    private Game game;

    @Override
    public List<Game> getAvailableGames() {
        return null; //TODO: implement
    }

    @Override
    public void play(int gameName) {
        game.start();
    }
}
