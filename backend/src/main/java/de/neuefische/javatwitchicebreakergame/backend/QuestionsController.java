package de.neuefische.javatwitchicebreakergame.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionsController {

    private final GameService gameService;
    private final GameWebSocketService gameWebSocketService;

    @PutMapping("/current")
    public void setCurrentQuestion(@RequestBody Question question) throws JsonProcessingException {
        gameService.setCurrentQuestion(question);
        gameWebSocketService.sendGameToEveryone();
    }

    @GetMapping("/current")
    public Question getCurrentQuestion() {
        return gameService.getCurrentQuestion();
    }
}
