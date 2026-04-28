package org.example.events;

import java.util.List;

public record PedidoRealizadoEvent(
        int mesaId,
        int pedidoId,
        List<String> items
) implements Event {

}
