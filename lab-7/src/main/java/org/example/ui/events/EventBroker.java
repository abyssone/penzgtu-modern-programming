package org.example.ui.events;

import org.example.ui.events.listeners.AddRowListener;
import org.example.ui.events.listeners.DeleteRowListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventBroker implements EventHandler {

    private static EventBroker instance;

    private final Map<EventType, ActionListener> actionListeners = new HashMap<>();
    private final Map<EventType, Set<MessageListener>> messageListeners = new HashMap<>();

    public static synchronized EventBroker getInstance() {
        if (instance == null) {
            instance = new EventBroker();
        }
        return instance;
    }

    private EventBroker() {
        actionListeners.put(EventType.ADD_ROW, new AddRowListener(this));
        actionListeners.put(EventType.DELETE_ROW, new DeleteRowListener(this));
    }

    @Override
    public void handle(EventType eventType, ActionEvent event) {
        Set<MessageListener> listeners = messageListeners.get(eventType);

        if (listeners == null || listeners.isEmpty()) {
            System.out.println("Message listeners is null: event=" + event);
            return;
        }

        for (MessageListener listener : listeners) {
            listener.onMessage(eventType, event);
        }
    }

    public ActionListener getActionListener(EventType event) {
        return actionListeners.get(event);
    }

    public void subscribeToMessages(EventType event, MessageListener listener) {
        Set<MessageListener> listeners = messageListeners.get(event);

        if (listeners == null) {
            listeners = new HashSet<>();
            messageListeners.put(event, listeners);
        }

        listeners.add(listener);
    }
}
