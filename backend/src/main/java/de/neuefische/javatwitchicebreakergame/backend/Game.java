package de.neuefische.javatwitchicebreakergame.backend;

import lombok.Builder;

import java.util.List;

@Builder
public record Game(
    Question currentQuestion,
    List<PublicPlayer> players,
    String myId,
    String mySessionId,
    GameState gameState
) {
}
