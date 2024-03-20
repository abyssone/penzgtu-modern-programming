package org.example.ui.events;

import java.awt.event.ActionEvent;

public interface EventHandler {

    void handle(EventType eventType, ActionEvent event);
}
