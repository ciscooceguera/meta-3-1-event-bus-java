package org.example.componentes;

import org.example.bus.EventBus;
import org.example.events.PedidoRealizadoEvent;

import java.util.List;

public class SistemaDePedidos {

    private final EventBus eventBus;

    public SistemaDePedidos(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void realizarPedido(int mesaId, int pedidoId, List<String> items) {
        System.out.println("[SISTEMA DE PEDIDOS] Pedido realizado: Mesa " + mesaId +
                ", Pedido " + pedidoId + ", Items: " + items);

        eventBus.publicar(new PedidoRealizadoEvent(mesaId, pedidoId, items));
    }
}