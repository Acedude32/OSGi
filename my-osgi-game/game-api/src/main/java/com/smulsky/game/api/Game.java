package com.smulsky.game.api;

public abstract class Game {
    public abstract void start();
    public abstract void stop();
    public String getName() {
        return this.getClass().getName();
    }
}
