package org.example.componentes;

import org.example.bus.EventBus;
import org.example.events.ComidaPreparadaEvent;
import org.example.events.PedidoRealizadoEvent;

public class Cocina {

    private final EventBus eventBus;

    public Cocina(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void onPedidoRealizado(PedidoRealizadoEvent event) {
        for (String item : event.items()) {
            if (esComida(item)) {
                System.out.println("[COCINA] Cocinando plato: " + item);
                eventBus.publicar(new ComidaPreparadaEvent(event.pedidoId(), item));
            }
        }
    }

    private boolean esComida(String item) {
        return item.equalsIgnoreCase("hamburguesa")
                || item.equalsIgnoreCase("papas")
                || item.equalsIgnoreCase("pizza");
    }
}