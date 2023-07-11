package de.neuefische.javatwitchicebreakergame.backend;

import lombok.Builder;

@Builder
public record Player(
        String id,
        String name,
        Integer guess,
        boolean answer
) {
}
