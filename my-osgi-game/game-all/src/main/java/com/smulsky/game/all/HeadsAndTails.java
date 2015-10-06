package com.smulsky.game.all;

import com.smulsky.game.api.Game;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component(immediate = true)
@Service
public class HeadsAndTails implements Game {
    public void start() {
        System.out.println("HeadsAndTails started");
    }

    public void stop() {
        System.out.println("HeadsAndTails stopped");
    }
}
