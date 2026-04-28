package org.example;

import org.example.bus.EventBus;
import org.example.componentes.*;
import org.example.events.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();

        SistemaDePedidos sistemaDePedidos = new SistemaDePedidos(eventBus);
        Barra barra = new Barra(eventBus);
        Cocina cocina = new Cocina(eventBus);
        Banda banda = new Banda(eventBus);
        SistemaDeSonido sistemaDeSonido = new SistemaDeSonido();
        PanelLED panelLED = new PanelLED();
        SistemaDeHumo sistemaDeHumo = new SistemaDeHumo();

        eventBus.suscribir(PedidoRealizadoEvent.class, barra::onPedidoRealizado);
        eventBus.suscribir(PedidoRealizadoEvent.class, cocina::onPedidoRealizado);
        eventBus.suscribir(PedidoRealizadoEvent.class, panelLED::onPedidoRealizado);

        eventBus.suscribir(BebidaServidaEvent.class, panelLED::onBebidaServida);
        eventBus.suscribir(ComidaPreparadaEvent.class, panelLED::onComidaPreparada);

        eventBus.suscribir(BandaTocandoEvent.class, sistemaDeSonido::onBandaTocando);
        eventBus.suscribir(BandaTocandoEvent.class, panelLED::onBandaTocando);
        eventBus.suscribir(BandaTocandoEvent.class, sistemaDeHumo::onBandaTocando);

        sistemaDePedidos.realizarPedido(
                5,
                123,
                List.of("cerveza", "hamburguesa")
        );

        System.out.println();

        banda.tocarCancion(
                "Banda 1",
                "Cancion 1",
                180
        );

        System.out.println();

        banda.tocarCancion(
                "Banda 2",
                "Cancion 2",
                420
        );
    }
}