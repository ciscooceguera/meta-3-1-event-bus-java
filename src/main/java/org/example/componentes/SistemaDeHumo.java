package org.example.componentes;

import org.example.events.BandaTocandoEvent;

public class SistemaDeHumo {

    public void onBandaTocando(BandaTocandoEvent event) {
        if (event.nombreCancion().equalsIgnoreCase("Through the Fire and Flames")) {
            System.out.println("[SISTEMA DE HUMO] Activando humo por canción épica: " + event.nombreCancion());
        }
    }
}