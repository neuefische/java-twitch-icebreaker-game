package de.neuefische.javatwitchicebreakergame.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionsController {

    private final GameService gameService;

    @PutMapping("/current")
    public Question setCurrentQuestion(@RequestBody Question question) {
        return gameService.setCurrentQuestion(question);
    }

    @GetMapping("/current")
    public Question getCurrentQuestion() {
        return gameService.getCurrentQuestion();
    }
}
