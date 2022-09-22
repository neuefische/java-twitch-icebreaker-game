package de.neuefische.javatwitchicebreakergame.backend;

import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
    private Question currentQuestion;

    public Question setCurrentQuestion(Question question) {
        System.out.println("Setting current question to " + question);
        this.currentQuestion = question;
        return question;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }
}
