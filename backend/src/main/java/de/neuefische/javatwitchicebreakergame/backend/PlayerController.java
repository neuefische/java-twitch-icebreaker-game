package de.neuefische.javatwitchicebreakergame.backend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final GameService gameService;

    public PlayerController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        gameService.addPlayer(player);
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
