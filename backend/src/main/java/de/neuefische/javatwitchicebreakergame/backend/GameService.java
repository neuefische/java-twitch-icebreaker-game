package de.neuefische.javatwitchicebreakergame.backend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private Question currentQuestion;
    private final List<Player> players = new ArrayList<>();

    public Question setCurrentQuestion(Question question) {
        System.out.println("Setting current question to " + question);
        this.currentQuestion = question;
        return question;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void deletePlayer(String name) {
        players.removeIf(player -> player.name().equals(name));
    }
}
