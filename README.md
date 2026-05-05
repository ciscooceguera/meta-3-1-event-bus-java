# Event Bus - Publisher/Subscriber Pattern

## Descripción

Este proyecto implementa el patrón arquitectónico **Publisher/Subscriber** mediante un **Event Bus** en Java.

Los componentes del sistema no se comunican directamente entre sí, sino que publican y consumen eventos a través de un bus central, logrando un sistema completamente desacoplado.

---

## Estructura del sistema

### Componentes:

* SistemaDePedidos
* Barra
* Cocina
* Banda
* SistemaDeSonido
* PanelLED
* SistemaDeHumo

### Eventos:

* PedidoRealizadoEvent
* BebidaServidaEvent
* ComidaPreparadaEvent
* BandaTocandoEvent

---

## Flujo de eventos

1. Se realiza un pedido
2. Barra y Cocina reaccionan al evento
3. Se generan eventos de bebida y comida
4. PanelLED muestra actualizaciones
5. La banda toca una canción
6. SistemaDeSonido, PanelLED y SistemaDeHumo reaccionan

---

## Ejecución

### Compilar:

```bash
javac -d out src/main/java/org/example/**/*.java
```

### Ejecutar:

```bash
java -cp out org.example.Main
```

---

## Desuscripción de eventos

Se demuestra el uso de `desuscribir()` removiendo dinámicamente el `SistemaDeHumo`, evitando que reaccione a futuros eventos.

---

## Extensibilidad

Se agregó el componente **SistemaDeHumo** sin modificar código existente, demostrando la extensibilidad del patrón.

---

## Autor

Francisco Oceguera
