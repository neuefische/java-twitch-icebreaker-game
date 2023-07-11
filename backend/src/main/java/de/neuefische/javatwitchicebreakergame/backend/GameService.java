package de.neuefische.javatwitchicebreakergame.backend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private Question currentQuestion;
    private List<Player> players = new ArrayList<>();

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

    public void deletePlayer(String sessionId) {
        players.removeIf(player -> player.sessionId().equals(sessionId));
    }

    public void updatePlayer(String sessionId, PlayerChange playerChange) {
        this.players = players.stream()
                .map(currentPlayer -> currentPlayer.sessionId().equals(sessionId) ? currentPlayer
                        .withName(playerChange.name())
                        .withGuess(playerChange.guess())
                        .withAnswer(playerChange.answer())
                        : currentPlayer)
                .collect(Collectors.toList());
    }
}
