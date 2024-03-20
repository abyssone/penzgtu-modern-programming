package org.example.ui.events;

import java.awt.event.ActionEvent;

public interface MessageListener {

    void onMessage(EventType eventType, ActionEvent event);
}
