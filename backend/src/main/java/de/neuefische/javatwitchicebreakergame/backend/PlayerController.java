package de.neuefische.javatwitchicebreakergame.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final GameService gameService;
    private final GameWebSocketService gameWebSocketService;

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        gameService.addPlayer(player);
        return player;
    }

    @PutMapping("/{name}")
    public Player updatePlayer(@PathVariable String name, @RequestBody Player player) throws JsonProcessingException {
        gameService.deletePlayer(name);
        gameService.addPlayer(player);
        gameWebSocketService.sendPlayerListToEveryone();
        return player;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return gameService.getPlayers();
    }

    @DeleteMapping("{name}")
    public void deletePlayer(@PathVariable String name) {
        gameService.deletePlayer(name);
    }

}
