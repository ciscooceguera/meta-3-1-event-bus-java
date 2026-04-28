package org.example.bus;

import org.example.events.Event;

import java.util.*;

public class EventBus {

    private final Map<Class<? extends Event>, List<EventSubscriber<? extends Event>>> suscriptores = new HashMap<>();

    public <T extends Event> void suscribir(Class<T> tipoEvento, EventSubscriber<T> suscriptor) {
        suscriptores
                .computeIfAbsent(tipoEvento, k -> new ArrayList<>())
                .add(suscriptor);
    }

    public <T extends Event> void desuscribir(Class<T> tipoEvento, EventSubscriber<T> suscriptor) {
        List<EventSubscriber<? extends Event>> lista = suscriptores.get(tipoEvento);

        if (lista != null) {
            lista.remove(suscriptor);
        }
    }

    public <T extends Event> void publicar(T evento) {
        List<EventSubscriber<? extends Event>> lista = suscriptores.get(evento.getClass());

        if (lista != null) {
            for (EventSubscriber<? extends Event> suscriptor : lista) {
                @SuppressWarnings("unchecked")
                EventSubscriber<T> suscriptorTipado = (EventSubscriber<T>) suscriptor;
                suscriptorTipado.onEvent(evento);
            }
        }
    }
}