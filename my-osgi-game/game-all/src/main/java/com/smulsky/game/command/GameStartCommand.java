package com.smulsky.game.command;

import com.smulsky.game.api.Game;
import com.smulsky.game.api.GameManager;
import org.apache.felix.scr.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
@Service(Object.class)
@Properties({
        @Property(name = "osgi.command.scope", value = "game"),
        @Property(name = "osgi.command.function", value = "play")
})
public class GameStartCommand {

    @Reference
    GameManager gameManager;

    public void play() throws IOException {
        List<Game> availableGames = gameManager.getAvailableGames();
        System.out.println("Choose game:");
        for (int i = 0; i < availableGames.size(); i++) {
            System.out.println(i + ": " + availableGames.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.next();

            if (!commandIsValid()) {
                System.out.println("Wrong game number");
                continue;
            }

            if (command.equals("stop")) {
                break;
            }

            int gameNumber = Integer.valueOf(command);
            availableGames.get(gameNumber).start();
            break;
        }
    }

    private boolean commandIsValid() {
        return true;
    }
}
