package de.neuefische.javatwitchicebreakergame.backend;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @PutMapping("/current")
    public void setCurrentQuestion(@RequestBody Question question) {
        questionsService.setCurrentQuestion(question);
    }
}
