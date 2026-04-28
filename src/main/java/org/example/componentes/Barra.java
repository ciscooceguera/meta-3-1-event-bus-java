package org.example.componentes;

import org.example.bus.EventBus;
import org.example.events.BebidaServidaEvent;
import org.example.events.PedidoRealizadoEvent;

public class Barra {

    private final EventBus eventBus;

    public Barra(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void onPedidoRealizado(PedidoRealizadoEvent event) {
        for (String item : event.items()) {
            if (esBebida(item)) {
                System.out.println("[BARRA] Preparando bebida: " + item);
                eventBus.publicar(new BebidaServidaEvent(event.mesaId(), item));
            }
        }
    }

    private boolean esBebida(String item) {
        return item.equalsIgnoreCase("cerveza")
                || item.equalsIgnoreCase("refresco")
                || item.equalsIgnoreCase("agua");
    }
}