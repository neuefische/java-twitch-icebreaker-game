package de.neuefische.javatwitchicebreakergame.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final GameService gameService;
    private final GameWebSocketService gameWebSocketService;

    @PutMapping("/{sessionId}")
    public void updatePlayer(@PathVariable String sessionId, @RequestBody PlayerChange playerChange) {
        gameService.updatePlayer(sessionId, playerChange);
        gameWebSocketService.sendGameToEveryone();
    }

}
