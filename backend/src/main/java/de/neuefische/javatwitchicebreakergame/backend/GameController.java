package de.neuefische.javatwitchicebreakergame.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final GameWebSocketService gameWebSocketService;

    @PostMapping("/switch-state")
    public void switchState() {
        gameService.switchState();
        gameWebSocketService.sendGameToEveryone();
    }

}
