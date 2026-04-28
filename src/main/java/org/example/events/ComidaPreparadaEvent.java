package org.example.events;

public record ComidaPreparadaEvent(
        int pedidoId,
        String plato
) implements Event {
}