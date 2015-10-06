package com.smulsky.game.command;

import com.smulsky.game.api.GameManager;
import org.apache.felix.scr.annotations.*;

@Component
@Service(Object.class)
@Properties({
        @Property(name = "osgi.command.scope", value = "game"),
        @Property(name = "osgi.command.function", value = "play")
})
public class GameStartCommand {
    @Reference
    private GameManager gameManager;

    public void play(){
        System.out.println("Suppose you've chosen game #1...");
        gameManager.play(1);
    }
}
