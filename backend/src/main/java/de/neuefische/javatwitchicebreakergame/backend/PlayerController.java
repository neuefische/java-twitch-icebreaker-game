package de.neuefische.javatwitchicebreakergame.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final GameService gameService;
    private final GameWebSocketService gameWebSocketService;

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable String id, @RequestBody Player player) throws JsonProcessingException {
        gameService.updatePlayer(player);
        gameWebSocketService.sendGameToEveryone();
        return player;
    }

}
