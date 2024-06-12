package com.hotel.service;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private static List<EventListener> listeners = new ArrayList<>();

    public static void register(EventListener listener) {
        listeners.add(listener);
    }

    public static void publish(Event event) {
        for (EventListener listener : listeners) {
            listener.handle(event);
        }
    }

    public interface EventListener {
        void handle(Event event);
    }
}
