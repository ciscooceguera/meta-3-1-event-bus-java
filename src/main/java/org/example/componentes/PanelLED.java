package org.example.componentes;

import org.example.events.BandaTocandoEvent;
import org.example.events.BebidaServidaEvent;
import org.example.events.ComidaPreparadaEvent;
import org.example.events.PedidoRealizadoEvent;

public class PanelLED {

    public void onPedidoRealizado(PedidoRealizadoEvent event) {
        System.out.println("[PANEL LED] Nuevo pedido registrado en Mesa " + event.mesaId());
    }

    public void onBebidaServida(BebidaServidaEvent event) {
        System.out.println("[PANEL LED] ¡Nueva bebida servida en la Mesa " + event.mesaId() + ": " + event.bebida() + "!");
    }

    public void onComidaPreparada(ComidaPreparadaEvent event) {
        System.out.println("[PANEL LED] ¡" + event.plato() + " listo para el Pedido " + event.pedidoId() + "!");
    }

    public void onBandaTocando(BandaTocandoEvent event) {
        System.out.println("[PANEL LED] " + event.nombreBanda() + " está tocando: " + event.nombreCancion());
    }
}