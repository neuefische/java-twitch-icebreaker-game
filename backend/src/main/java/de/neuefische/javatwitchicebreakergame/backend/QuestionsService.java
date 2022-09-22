package de.neuefische.javatwitchicebreakergame.backend;

import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
    private Question currentQuestion;

    public void setCurrentQuestion(Question question) {
        System.out.println("Setting current question to " + question);
        this.currentQuestion = question;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }
}
