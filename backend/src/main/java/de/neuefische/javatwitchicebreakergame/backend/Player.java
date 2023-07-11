package de.neuefische.javatwitchicebreakergame.backend;

public record Player(
    String name,
    Integer guess,
    boolean answer
) {
}
