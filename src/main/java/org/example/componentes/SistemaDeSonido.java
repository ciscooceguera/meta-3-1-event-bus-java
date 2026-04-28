package org.example.componentes;

import org.example.events.BandaTocandoEvent;

public class SistemaDeSonido {

    public void onBandaTocando(BandaTocandoEvent event) {
        System.out.println("[SISTEMA DE SONIDO] Ajustando ecualizador para: " + event.nombreCancion());
    }
}