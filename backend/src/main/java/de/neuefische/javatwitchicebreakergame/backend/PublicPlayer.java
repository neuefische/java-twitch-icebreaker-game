package de.neuefische.javatwitchicebreakergame.backend;

import lombok.Builder;

@Builder
public record PublicPlayer(
        String id,
        String name,
        Integer guess,
        Boolean answer
) {
}
