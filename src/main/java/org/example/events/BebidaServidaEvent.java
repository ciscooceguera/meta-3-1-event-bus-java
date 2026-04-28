package org.example.events;

public record BebidaServidaEvent(
        int mesaId,
        String bebida
) implements Event {
}