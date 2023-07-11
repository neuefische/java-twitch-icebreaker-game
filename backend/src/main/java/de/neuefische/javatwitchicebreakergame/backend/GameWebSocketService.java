package de.neuefische.javatwitchicebreakergame.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameWebSocketService extends TextWebSocketHandler {

    private final GameService gameService;
    private final ObjectMapper objectMapper;
    private final Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        gameService.addPlayer(Player.builder()
                .id(session.getId())
                .name("Player " + session.getId().substring(0, 4))
                .guess(0)
                .answer(false)
                .build());
        sendGameToEveryone();
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        sessions.forEach(s -> {
            try {
                s.sendMessage(new TextMessage(payload));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void sendGameToEveryone() throws JsonProcessingException {
        Game game = Game.builder()
                .currentQuestion(gameService.getCurrentQuestion())
                .players(gameService.getPlayers().stream().map(p -> new PublicPlayer(p.id(), p.name())).collect(Collectors.toList()))
                .build();
        String json = objectMapper.writeValueAsString(game);
        sessions.forEach(s -> {
            try {
                s.sendMessage(new TextMessage(json));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        gameService.deletePlayer(session.getId());
    }
}
