package de.neuefische.javatwitchicebreakergame.backend;

import lombok.Builder;
import lombok.With;

@Builder
@With
public record Player(
        String id,
        String sessionId,
        String name,
        Integer guess,
        boolean answer
) {
}
