package org.example.ui.events.listeners;

import org.example.ui.events.EventHandler;
import org.example.ui.events.EventType;

public class AddRowListener extends AbstractActionListener {

    public AddRowListener(EventHandler eventListener) {
        super(EventType.ADD_ROW, eventListener);
    }
}
