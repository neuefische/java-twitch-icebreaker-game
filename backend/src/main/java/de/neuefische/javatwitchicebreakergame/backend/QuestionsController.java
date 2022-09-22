package de.neuefische.javatwitchicebreakergame.backend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @PutMapping("/current")
    public Question setCurrentQuestion(@RequestBody Question question) {
        return questionsService.setCurrentQuestion(question);
    }

    @GetMapping("/current")
    public Question getCurrentQuestion() {
        return questionsService.getCurrentQuestion();
    }
}
