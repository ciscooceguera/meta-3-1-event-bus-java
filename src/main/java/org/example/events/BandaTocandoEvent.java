package org.example.events;

public record BandaTocandoEvent(
        String nombreBanda,
        String nombreCancion,
        int duracion
) implements Event {
}