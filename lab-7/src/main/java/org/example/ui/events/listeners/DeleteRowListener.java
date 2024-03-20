package org.example.ui.events.listeners;

import org.example.ui.events.EventHandler;
import org.example.ui.events.EventType;

public class DeleteRowListener extends AbstractActionListener {

    public DeleteRowListener(EventHandler eventListener) {
        super(EventType.DELETE_ROW, eventListener);
    }
}
