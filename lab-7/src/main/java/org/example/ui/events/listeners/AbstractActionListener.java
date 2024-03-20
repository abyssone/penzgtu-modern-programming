package org.example.ui.events.listeners;

import org.example.ui.events.EventHandler;
import org.example.ui.events.EventType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractActionListener implements ActionListener {

    protected final EventType eventType;
    protected final EventHandler eventHandler;

    public AbstractActionListener(EventType eventType, EventHandler eventHandler) {
        this.eventType = eventType;
        this.eventHandler = eventHandler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        eventHandler.handle(eventType, e);
    }
}
