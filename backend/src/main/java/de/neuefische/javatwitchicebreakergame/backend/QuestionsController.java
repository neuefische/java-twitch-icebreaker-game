package de.neuefische.javatwitchicebreakergame.backend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {

    private final GameService gameService;

    public QuestionsController(GameService gameService) {
        this.gameService = gameService;
    }

    @PutMapping("/current")
    public Question setCurrentQuestion(@RequestBody Question question) {
        return gameService.setCurrentQuestion(question);
    }

    @GetMapping("/current")
    public Question getCurrentQuestion() {
        return gameService.getCurrentQuestion();
    }
}
