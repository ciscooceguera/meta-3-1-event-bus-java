package org.example.bus;

import org.example.events.Event;

@FunctionalInterface
public interface EventSubscriber<T extends Event> {
    void onEvent(T event);
}