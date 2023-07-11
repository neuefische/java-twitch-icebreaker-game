package de.neuefische.javatwitchicebreakergame.backend;

import lombok.With;

@With
public record PlayerChange(
        String name,
        Integer guess,
        boolean answer
) {
}
