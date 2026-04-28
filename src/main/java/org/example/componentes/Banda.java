package org.example.componentes;

import org.example.bus.EventBus;
import org.example.events.BandaTocandoEvent;

public class Banda {

    private final EventBus eventBus;

    public Banda(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void tocarCancion(String nombreBanda, String nombreCancion, int duracion) {
        System.out.println("[BANDA] " + nombreBanda + " toca: " + nombreCancion);
        eventBus.publicar(new BandaTocandoEvent(nombreBanda, nombreCancion, duracion));
    }
}